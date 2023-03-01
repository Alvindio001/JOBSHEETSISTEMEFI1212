package com.MyApp.Aplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class tujuan_pembelajaran : AppCompatActivity() {
  var btn1: Button? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tujuan_pembelajaran)

        btn1 = findViewById(R.id.btn2)

        btn1!!.setOnClickListener(View.OnClickListener {
            val I = Intent(this, home::class.java)
            startActivity(I)

        })
    }
}