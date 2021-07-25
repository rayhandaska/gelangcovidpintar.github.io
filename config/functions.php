<?php
//-------------- mendaftarkan user -------------------//
function register_user($firstname, $lastname, $email, $password, $dateofbirth){
  global $link;
      
  //mencegah sql injection
  $namaawal = escape($firstname);
  $namaakhir = escape($lastname)
  $pass = escape($password);
  
  $hash = hashSSHA($pass); //mengencrypt password
  
  $encrypted_password = $hash["encrypted"]; //mengambil data password yang sudah di enkripsi untuk ditampung pada variabel encrypted_password
    
  $query = "INSERT INTO users(firstname, lastname, email, password, dateofbirth)
  VALUES ('$firstname', '$lastname', '$email', '$encrypted_password', '$dateofbirth')";
   
  $user_new = mysqli_query($link, $query);
  if( $user_new ) {
        $usr = "SELECT * FROM users WHERE firstname = '$namaawal'";
        $result = mysqli_query($link, $usr);
        $user = mysqli_fetch_assoc($result);
        return $user;
  }else{
        return NULL;
  }
}
//-------------- *** end *** -------------------//
  
//---- mencegah sql injection -----//
function escape($data){
    global $link;
    return mysqli_real_escape_string($link, $data);
}
//----------- *** end *** ---------//
  
//--- mengecek nama apakah sudah terdaftar atau belum ---//
function cek_nama($name){
    global $link;
    $query = "SELECT * FROM users WHERE user_username = '$name'";
    if( $result = mysqli_query($link, $query) ) return mysqli_num_rows($result);
}
//---------------- *** end ***-------------------------//
  
//------------ mengenkripsi password ----------------//
function hashSSHA($password) {
    $salt = sha1(rand());
    $salt = substr($salt, 0, 10);
    $encrypted = base64_encode(sha1($password . $salt, true) . $salt);
    $hash = array("salt" => $salt, "encrypted" => $encrypted);
    return $hash;
}
//------------ *** end *** -------------------------//
  
// -------- mengenkripsi password yang dimasukkan user saat login -->
public function checkhashSSHA($salt, $password) {
 
    $hash = base64_encode(sha1($password . $salt, true) . $salt);
 
    return $hash;
}
//------------ *** end *** -------------------------//
 
//----------------- cek data user dan validasi------------------//
function cek_data_user($name,$pass){
    global $link;
    //mencegah sql injection
    $nama = escape($name);
    $password = escape($pass);
     
    $query  = "SELECT * FROM users WHERE user_username = '$nama'";
    $result = mysqli_query($link, $query);
    $data = mysqli_fetch_assoc($result);
     
    $unique_id = $data['unique_id'];
    $encrypted_password = $data['user_password'];
    // mengencrypt password
    $hash = checkhashSSHA($unique_id, $password);
    //validasi password
    if($encrypted_password == $hash){
        return $data;
    }else{
        return false;
    }
}
//---------------------- *** end *** -------------------------//
?>