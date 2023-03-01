package com.MyApp.Aplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toolbar

class materi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi)
        var btn = findViewById<ImageButton>(R.id.btn_exit)
        btn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, home::class.java)
            startActivity(intent)

        })
    }
}