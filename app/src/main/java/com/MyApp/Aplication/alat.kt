package com.MyApp.Aplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class alat : AppCompatActivity() {
    var btn: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alat)

        btn = findViewById(R.id.btn1)

        btn!!.setOnClickListener(View.OnClickListener {
            val I = Intent(this, home::class.java)
            startActivity(I)

        })
    }
}