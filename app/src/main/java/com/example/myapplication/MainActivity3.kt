package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class MainActivity3 : AppCompatActivity(), View.OnClickListener {

    private lateinit var imageButton2: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        imageButton2 = findViewById(R.id.btn_obat)
        imageButton2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id) {
                R.id.btn_obat -> run {
                    val intentbiasa = Intent(this@MainActivity3, MainActivity4::class.java)
                    startActivity(intentbiasa)
                }
            }
        }
    }
}