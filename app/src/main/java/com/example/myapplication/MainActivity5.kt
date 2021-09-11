package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import android.view.View
import com.example.myapplication.R
import com.firebase.client.DataSnapshot
import com.firebase.client.Firebase
import com.firebase.client.FirebaseError
import com.firebase.client.ValueEventListener

class MainActivity5 : AppCompatActivity() {
    private var nilai: TextView? = null
    private var mRef: Firebase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        nilai = findViewById<View>(R.id.nilai) as TextView
        mRef = Firebase("https://my-application-f87f9-default-rtdb.firebaseio.com/")
        mRef!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue(String::class.java)
                nilai!!.text = value
            }

            override fun onCancelled(firebaseError: FirebaseError) {}
        })
    }
}