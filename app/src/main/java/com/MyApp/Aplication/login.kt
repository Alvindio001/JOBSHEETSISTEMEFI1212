package com.MyApp.Aplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class login : AppCompatActivity() {
    private lateinit var databaseRef: DatabaseReference
    private lateinit var valueEventListener: ValueEventListener
    lateinit var etEmail: EditText
    private lateinit var etPass: EditText
    lateinit var btn: Button
    lateinit var btnregrister: TextView
    // Creating firebaseAuth object
    lateinit var auth: FirebaseAuth
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        // View Binding
        val email: String
        btn = findViewById(R.id.btn_login)
        btnregrister = findViewById(R.id.tv_to_register)
        etEmail = findViewById(R.id.edt_email_login)
        etPass = findViewById(R.id.edt_password_login)


        // initialising Firebase auth object
        auth = FirebaseAuth.getInstance()


        //sesion login
        if (auth.currentUser != null) {
            val intent = Intent(this@login, home::class.java)
            val userId = auth.currentUser!!.uid
            intent.putExtra("empId", userId)
            startActivityForResult(intent, REQUEST_CODE)
            val user = FirebaseAuth.getInstance().currentUser
            val uid = user?.uid // mengambil UID pengguna

            val sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("userID", uid)
            editor.apply()

            finish()

        }


        btnregrister.setOnClickListener(View.OnClickListener{
            val intent = Intent(this, regrister::class.java)
            startActivity(intent)
        })

        btn.setOnClickListener {
            val email = etEmail.text.toString()
            val pass = etPass.text.toString()


                if (etEmail.text.toString().isEmpty()) {
                etEmail.error = "Email Harus Diisi"
                return@setOnClickListener
            }

            //Validasi password
            if (etPass.text.toString().isEmpty()) {
                etPass.error = "Password Harus Diisi"
                return@setOnClickListener
            }

            //Validasi panjang password
           /* if (etPass.length() < 6) {
                etPass.error = "Password Minimal 6 Karakter"
                return@setOnClickListener
            }*/
            if (email == "admin" && pass == "123") {
                Toast.makeText(this, "Successfully LoggedIn", Toast.LENGTH_SHORT).show()
                val sharedPref = getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
                val isLogin = sharedPref.getBoolean("IS_LOGIN", false)

                if (!isLogin) {
                    val intent = Intent(this, login::class.java)
                    startActivity(intent)
                    finish()
                }
                else
                {
                    val intent = Intent(this, home_admin::class.java)
                    startActivity(intent)
                    finish()
                }

            }


            else{

                auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Successfully LoggedIn", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@login, home::class.java)
                        val value = etEmail.text.toString()
                        intent.putExtra("userkey1", value)
                        startActivityForResult(intent, REQUEST_CODE)

                        // using finish() to end the activity
                        finish()
                    }

                    else
                        Toast.makeText(this, "Log In failed ", Toast.LENGTH_SHORT).show()

                }

            }

            // calling signInWithEmailAndPassword(email, pass)
            // function using Firebase auth object
            // On successful response Display a Toast

        }

    }

    companion object {
        const val REQUEST_CODE = 10
    }

}
