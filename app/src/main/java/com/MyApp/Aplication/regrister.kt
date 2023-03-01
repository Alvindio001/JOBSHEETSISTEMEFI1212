package com.MyApp.Aplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main2.*


class regrister : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPass: EditText
    private lateinit var btn: Button
    private lateinit var linklogin: TextView
    private lateinit var auth: FirebaseAuth

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regrister)
        linklogin = findViewById(R.id.tv_to_login)
        etEmail = findViewById(R.id.edt_email_register)
        etPass = findViewById(R.id.edt_password_register)
        btn = findViewById(R.id.btn_register)
        auth = FirebaseAuth.getInstance()

            linklogin.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }
            btn.setOnClickListener {
                    val email = etEmail.text.toString()
                    val pass = etPass.text.toString()

            //Validasi email
            if (etEmail.text.toString().isEmpty()) {
                etEmail.error = "Email Harus Diisi"
                return@setOnClickListener
            }

            //Validasi email tidak sesuai
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.error = "Email Tidak Valid"
                return@setOnClickListener
            }

            //Validasi password
            if (etPass.text.toString().isEmpty()) {
              etPass.error = "Password Harus Diisi"
                return@setOnClickListener
            }

            //Validasi panjang password
            if (etPass.length() < 6) {
              etPass.error = "Password Minimal 6 Karakter"
                return@setOnClickListener
            }

            RegisterFirebase(email, pass)
        }
    }

    private fun RegisterFirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Register Berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, login::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}




