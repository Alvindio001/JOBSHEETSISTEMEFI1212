package com.MyApp.Aplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.MotionEvent
import android.widget.*
import androidx.constraintlayout.helper.widget.MotionEffect.TAG
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_employee_details.*

class evaluasi : AppCompatActivity() {
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var nama: TextView
    private lateinit var no: TextView
    private lateinit var emID: TextView
    private lateinit var kelas: TextView
    private lateinit var inputke1: TextView
    private lateinit var inputke2: TextView
    private lateinit var inputke3: TextView
    private lateinit var inputke4: TextView
    private lateinit var inputke5: TextView
    private lateinit var inputke6: TextView
    private lateinit var inputke7: TextView
    private lateinit var inputke8: TextView
    private lateinit var inputke9: TextView
    private lateinit var inputke10: TextView
    private lateinit var inputke11: TextView
    private lateinit var inputke12: TextView
    private lateinit var inputke13: TextView
    private lateinit var btn: Button
    private lateinit var databaseRef: DatabaseReference
    private lateinit var valueListener: ValueEventListener

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_evaluasi)
        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout)
        nama = findViewById(R.id.nama)
        no = findViewById(R.id.no)
        kelas = findViewById(R.id.kelas)
        inputke1 = findViewById(R.id.input1)
        inputke2 = findViewById(R.id.input2)
        inputke3 = findViewById(R.id.input3)
        inputke4 = findViewById(R.id.input4)
        inputke5 = findViewById(R.id.input5)
        inputke6 = findViewById(R.id.input6)
        inputke7 = findViewById(R.id.input7)
        inputke8 = findViewById(R.id.input8)
        inputke9 = findViewById(R.id.input9)
        inputke10 = findViewById(R.id.input10)
        inputke11 = findViewById(R.id.input11)
        inputke12 = findViewById(R.id.input12)
        inputke13 = findViewById(R.id.input13)
        btn = findViewById(R.id.btnSave)


        databaseRef = FirebaseDatabase.getInstance().getReference("inputdata")

        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Mengambil nilai dari data snapshot
                val sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
                val id = sharedPref.getString("userID", null)
                val value = dataSnapshot.child(id.toString()).getValue(EmployeeModel::class.java)


                if (value != null) {

                    // Menampilkan nilai pada TextView
                    emID = findViewById<TextView>(R.id.id)
                    nama = findViewById(R.id.nama)
                    no = findViewById(R.id.no)
                    kelas = findViewById(R.id.kelas)
                    inputke1 = findViewById(R.id.input1)
                    inputke2 = findViewById(R.id.input2)
                    inputke3 = findViewById(R.id.input3)
                    inputke4 = findViewById(R.id.input4)
                    inputke5 = findViewById(R.id.input5)
                    inputke6 = findViewById(R.id.input6)
                    inputke7 = findViewById(R.id.input7)
                    inputke8 = findViewById(R.id.input8)
                    inputke9 = findViewById(R.id.input9)
                    inputke10 = findViewById(R.id.input10)
                    inputke11 = findViewById(R.id.input11)
                    inputke12 = findViewById(R.id.input12)
                    inputke13 = findViewById(R.id.input13)
                    emID.text = value.empId.toString()
                    nama.text = value.nama.toString()
                    no.text = value.no.toString()
                    kelas.text = value.kelas.toString()
                    inputke1.text = value.input1.toString()
                    inputke2.text = value.input2.toString()
                    inputke3.text = value.input3.toString()
                    inputke4.text = value.input4.toString()
                    inputke5.text = value.input5.toString()
                    inputke6.text = value.input6.toString()
                    inputke7.text = value.input7.toString()
                    inputke8.text = value.input8.toString()
                    inputke9.text = value.input9.toString()
                    inputke10.text = value.input10.toString()
                    inputke11.text = value.input11.toString()
                    inputke12.text = value.input12.toString()
                    inputke13.text = value.input13.toString()
                } else {
                    Toast.makeText(
                        this@evaluasi,
                        "Data Masih Ada Yang Kosong Silahkan Di Cek!",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }


            override fun onCancelled(databaseError: DatabaseError) {
                // Menampilkan error jika terjadi kesalahan
                Log.w(TAG, "Failed to read value.", databaseError.toException())
            }

        })


        swipeRefreshLayout.setOnRefreshListener {
            // Panggil metode untuk melakukan refresh data di aplikasi Anda
            refreshData()
        }


        btn.setOnClickListener {
            val intent = Intent(this@evaluasi, edit_data::class.java)
            intent.putExtra("Nama1", nama.text.toString())
            intent.putExtra("No1", no.text.toString())
            intent.putExtra("Kelas1", kelas.text.toString())
            intent.putExtra("inp1", inputke1.text.toString())
            intent.putExtra("inp2", inputke2.text.toString())
            intent.putExtra("inp3", inputke3.text.toString())
            intent.putExtra("inp4", inputke4.text.toString())
            intent.putExtra("inp5", inputke5.text.toString())
            intent.putExtra("inp6", inputke6.text.toString())
            intent.putExtra("inp7", inputke7.text.toString())
            intent.putExtra("inp8", inputke8.text.toString())
            intent.putExtra("inp9", inputke9.text.toString())
            intent.putExtra("inp10", inputke10.text.toString())
            intent.putExtra("inp11", inputke11.text.toString())
            intent.putExtra("inp12", inputke12.text.toString())
            intent.putExtra("inp13", inputke13.text.toString())
            startActivity(intent)
            finish()
        }


    }

    private fun refreshData() {
        databaseRef = FirebaseDatabase.getInstance().getReference("inputdata")

        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
                val id = sharedPref.getString("userID", null)
                val value = dataSnapshot.child(id.toString()).getValue(EmployeeModel::class.java)


                if (value != null) {

                    // Menampilkan nilai pada TextView
                    emID = findViewById<TextView>(R.id.id)
                    nama = findViewById(R.id.nama)
                    no = findViewById(R.id.no)
                    kelas = findViewById(R.id.kelas)
                    inputke1 = findViewById(R.id.input1)
                    inputke2 = findViewById(R.id.input2)
                    inputke3 = findViewById(R.id.input3)
                    inputke4 = findViewById(R.id.input4)
                    inputke5 = findViewById(R.id.input5)
                    inputke6 = findViewById(R.id.input6)
                    inputke7 = findViewById(R.id.input7)
                    inputke8 = findViewById(R.id.input8)
                    inputke9 = findViewById(R.id.input9)
                    inputke10 = findViewById(R.id.input10)
                    inputke11 = findViewById(R.id.input11)
                    inputke12 = findViewById(R.id.input12)
                    inputke13 = findViewById(R.id.input13)
                    emID.text = value.empId.toString()
                    nama.text = value.nama.toString()
                    no.text = value.no.toString()
                    kelas.text = value.kelas.toString()
                    inputke1.text = value.input1.toString()
                    inputke2.text = value.input2.toString()
                    inputke3.text = value.input3.toString()
                    inputke4.text = value.input4.toString()
                    inputke5.text = value.input5.toString()
                    inputke6.text = value.input6.toString()
                    inputke7.text = value.input7.toString()
                    inputke8.text = value.input8.toString()
                    inputke9.text = value.input9.toString()
                    inputke10.text = value.input10.toString()
                    inputke11.text = value.input11.toString()
                    inputke12.text = value.input12.toString()
                    inputke13.text = value.input13.toString()
                } else {
                    Toast.makeText(
                        this@evaluasi,
                        "Data Masih Ada Yang Kosong Silahkan Di Cek!",
                        Toast.LENGTH_LONG
                    ).show()
                }
                swipeRefreshLayout.isRefreshing = false
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Menampilkan error jika terjadi kesalahan
                Log.w(TAG, "Failed to read value.", databaseError.toException())
            }

            })

    }
}