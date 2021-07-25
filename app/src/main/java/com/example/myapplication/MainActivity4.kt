package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class MainActivity4 : AppCompatActivity(), View.OnClickListener {

    private lateinit var imageButton2: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        imageButton2 = findViewById(R.id.btn_home)
        imageButton2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.btn_home -> run{
                    val intentbiasa = Intent(this@MainActivity4, MainActivity3::class.java)
                    startActivity(intentbiasa)

                }
            }
        }
    }
}