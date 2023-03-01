package com.MyApp.Aplication
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.firebase.auth.FirebaseAuth


class home_admin : AppCompatActivity() {
    var username: TextView? = null
    var btn1: CardView? = null
    var btn2: CardView? = null
    var btn3: CardView? = null
    var  btn4: CardView? = null
    var  btn5: CardView? = null
    var  btn6: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_admin)
        btn1 = findViewById<CardView>(R.id.materi1) as CardView
        btn2 = findViewById<CardView>(R.id.tujuan) as CardView
        btn3 = findViewById<CardView>(R.id.list) as CardView
        btn4 = findViewById<CardView>(R.id.keselamatan) as CardView
        btn5 = findViewById<CardView>(R.id.alat_bahan) as CardView
        btn6 = findViewById(R.id.logout1)


        /*materi*/

        btn1!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, materi::class.java)
            startActivity(intent)


        })

        /*tujuan pembelajaran*/

        btn2!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, tujuan_pembelajaran::class.java)
            startActivity(intent)


        })

        /*langkah_kerja*/

        btn3!!.setOnClickListener(View.OnClickListener{
            val intent = Intent(this, FetchingActivity::class.java)
            startActivityForResult(intent, login.REQUEST_CODE)

        })

        /*keselamatan_kerja*/

        btn4!!.setOnClickListener(View.OnClickListener{
           val b = Intent(this, keselamatan_kerja::class.java)
           startActivity(b)

       })

       /*alat dan bahan*/

       btn5!!.setOnClickListener(View.OnClickListener {
           val c = Intent(this, alat::class.java)
           startActivity(c)

       })

        /*logout*/

        btn6!!.setOnClickListener(View.OnClickListener {
            val auth = FirebaseAuth.getInstance()
            auth.signOut()
            val intent = Intent(this, login::class.java)
            startActivity(intent)
            finish()
        })
    }
}
