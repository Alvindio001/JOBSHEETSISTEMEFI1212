package com.MyApp.Aplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class keselamatan_kerja : AppCompatActivity() {
    var btn: Button? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keselamatan_kerja)

        btn = findViewById(R.id.btn3)

        btn!!.setOnClickListener(View.OnClickListener {
            val I = Intent(this, home::class.java)
            startActivity(I)

        })

    }
}