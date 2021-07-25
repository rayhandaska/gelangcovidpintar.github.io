package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.ui.UserApi
import com.example.myapplication.ui.login.login
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), View.OnClickListener {

        private lateinit var button5: Button
        private lateinit var button4: Button
        var txEmail: EditText? = null
        var txPassword: EditText? = null
        var email: String? = null
        var password: String? = null
        var apiInterface: UserApi? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button5 = findViewById(R.id.btn_signup)
        button5.setOnClickListener(this)
        button4 = findViewById(R.id.btn_login)
        button4.setOnClickListener(this)
        txEmail = findViewById(R.id.txEmail)
        txPassword = findViewById(R.id.txPassword)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_signup -> run {
                val intentbiasa = Intent(this@MainActivity, MainActivity2::class.java)
                startActivity(intentbiasa)
            }
        }
        when (v.id) {
            R.id.btn_login -> run {
                login()
            }
        }
    }

    fun login() {
        val request = UserRequest()
        request.email = txEmail?.text.toString().trim()
        request.password = txPassword?.text.toString().trim()

        val apiInterface = ApiClient().getClient().create(UserApi::class.java)
        apiInterface.loginresponse(request).enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                val user = response.body()
                Log.e("email", user!!.data?.email.toString())
                Log.e("password", user!!.data?.password.toString())
                val intentbiasa = Intent(this@MainActivity, MainActivity3::class.java)
                startActivity(intentbiasa)
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }

        })

    }
}