package com.MyApp.Aplication
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main2.*


class home : AppCompatActivity() {
    private var username: TextView? = null
    private var btn1: CardView? = null
    private var btn2: CardView? = null
    private var btn3: CardView? = null
    private var  btn4: CardView? = null
    private var  btn5: CardView? = null
    private lateinit var btn9: CardView
    private var btn7: TextView? = null


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        btn1 = findViewById(R.id.materi1)
        btn2 = findViewById(R.id.tujuan)
        btn3 = findViewById(R.id.langkah_kerja)
        btn4 = findViewById(R.id.keselamatan)
        btn5 = findViewById(R.id.alat_bahan)
        btn9 = findViewById(R.id.evaluasi12)

        btn7 = findViewById(R.id.logout)


        val auth = FirebaseAuth.getInstance()
        val user = auth.currentUser
        val userEmail = user?.email

        val textView = findViewById<TextView>(R.id.username)
        textView.text = userEmail


        val extras1 = intent.extras
        var intent = extras1!!.getString("userkey12")
        username = findViewById<View>(R.id.username) as TextView
        if (intent != null) {
            username!!.text = intent
        }

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
            val a = Intent(this, InsertionActivity::class.java)
            startActivity(a)

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

        /*evaluasi*/
        btn9!!.setOnClickListener(View.OnClickListener {
           val intenttt = Intent(this, evaluasi::class.java)
            startActivity(intenttt)
//            finish()

        })

        /*logout*/

        btn7!!.setOnClickListener(View.OnClickListener {
            val auth = FirebaseAuth.getInstance()
            auth.signOut()
            val intent = Intent(this, login::class.java)
            startActivity(intent)
            finish()

        })
    }
    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Keluar")
        builder.setMessage("Apakah Anda yakin ingin kembali?")
        builder.setPositiveButton("Ya") { dialog, which ->
            super.onBackPressed()
        }
        builder.setNegativeButton("Tidak") { dialog, which ->
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }
}
