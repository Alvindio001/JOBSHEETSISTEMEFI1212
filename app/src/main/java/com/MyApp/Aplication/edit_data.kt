package com.MyApp.Aplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_edit_data.*
import kotlinx.android.synthetic.main.activity_evaluasi.*
import kotlinx.android.synthetic.main.activity_evaluasi.btnSave

class edit_data : AppCompatActivity() {
    private lateinit var inputke1: EditText
    private lateinit var inputke2: EditText
    private lateinit var inputke3: EditText
    private lateinit var inputke4: EditText
    private lateinit var inputke5: EditText
    private lateinit var inputke6: EditText
    private lateinit var inputke7: EditText
    private lateinit var inputke8: EditText
    private lateinit var inputke9: EditText
    private lateinit var inputke10: EditText
    private lateinit var inputke11: EditText
    private lateinit var inputke12: EditText
    private lateinit var inputke13: EditText
    private lateinit var btnSafe: Button
    private lateinit var nama1: EditText
    private lateinit var no1: EditText
    private lateinit var kelas1: EditText
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {


//        btnSaveData = findViewById(R.id.)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_data)
        val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val savedInputs = sharedPreferences.getStringSet("userInputs", mutableSetOf())



/*
    inputke1.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            // Menambahkan inputting pengguna baru ke dalam set
            val newInput = s.toString()
            savedInputs?.add(newInput)

            // Menyimpan data input pengguna yang diperbarui ke dalam SharedPreferences
            with(sharedPreferences.edit()) {
                putStringSet("userInputs", savedInputs)
                apply()
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            // Tidak digunakan
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // Tidak digunakan
        }
    })
*/

// Menampilkan data input pengguna saat aplikasi dibuka
//    if (savedInputs != null) {
//        for (input in savedInputs) {
//            val inpute1 = EditText(this)
//            inputke1.setText(input)
//            linearLayout.addView(inpute1)
//        }
//    }
        nama1 = findViewById(R.id.Nama)
        no1 = findViewById(R.id.No)
        kelas1 = findViewById(R.id.kls)
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
        btnSafe = findViewById(R.id.btnSave)


//        val intent = intent
        val nama2 = intent.getStringExtra("Nama1")
        val no2 = intent.getStringExtra("No1")
        val kelas2 = intent.getStringExtra("Kelas1")
        val inputss1 = intent.getStringExtra("inp1")
        val inputss2 = intent.getStringExtra("inp2")
        val inputss3 = intent.getStringExtra("inp3")
        val inputss4 = intent.getStringExtra("inp4")
        val inputss5 = intent.getStringExtra("inp5")
        val inputss6 = intent.getStringExtra("inp6")
        val inputss7 = intent.getStringExtra("inp7")
        val inputss8 = intent.getStringExtra("inp8")
        val inputss9 = intent.getStringExtra("inp9")
        val inputss10 = intent.getStringExtra("inp10")
        val inputss11 = intent.getStringExtra("inp11")
        val inputss12 = intent.getStringExtra("inp12")
        val inputss13 = intent.getStringExtra("inp13")
        inputke1.setText(inputss1)
        inputke2.setText(inputss2)
        inputke3.setText(inputss3)
        inputke4.setText(inputss4)
        inputke5.setText(inputss5)
        inputke6.setText(inputss6)
        inputke7.setText(inputss7)
        inputke8.setText(inputss8)
        inputke9.setText(inputss9)
        inputke10.setText(inputss10)
        inputke11.setText(inputss11)
        inputke12.setText(inputss12)
        inputke13.setText(inputss13)
        nama1.setText(nama2)
        no1.setText(no2)
        kelas1.setText(kelas2)

    btnSave.setOnClickListener {


        val sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val uid = sharedPref.getString("userID", null)
        if (uid != null) {
            update(uid)
        }

        Toast.makeText(applicationContext, "Data Berhasil Di Update", Toast.LENGTH_LONG).show()
        val a = Intent(this@edit_data, evaluasi::class.java)
        startActivity(a)
        finish()
        //we are setting updated data to our textviews

    }
    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Keluar")
        builder.setMessage("Apakah Anda yakin ingin kembali?\n" + "(Progress Anda Akan Hilang)")
        builder.setPositiveButton("Ya") { dialog, which ->
            super.onBackPressed()
        }
        builder.setNegativeButton("Tidak") { dialog, which ->
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }

    private fun updateEmpData(
        empId: String,
        nama: String,
        no: String,
        kelas: String,
        input1: String,
        input2: String,
        input3: String,
        input4: String,
        input5: String,
        input6: String,
        input7: String,
        input8: String,
        input9: String,
        input10: String,
        input11: String,
        input12: String,
        input13: String,
    ) {
        val dbRef = FirebaseDatabase.getInstance().getReference("inputdata").child(empId)
        val empInfo = EmployeeModel(empId, nama, no, kelas, input1, input2, input3, input4, input5, input6, input7, input8, input9, input10, input11, input12, input13)
        dbRef.setValue(empInfo)
    }


    private fun update(empId: String) {
        updateEmpData(
            empId,
            nama1.text.toString(),
            no1.text.toString(),
            kelas1.text.toString(),
            inputke1.text.toString(),
            inputke2.text.toString(),
            inputke3.text.toString(),
            inputke4.text.toString(),
            inputke5.text.toString(),
            inputke6.text.toString(),
            inputke7.text.toString(),
            inputke8.text.toString(),
            inputke9.text.toString(),
            inputke10.text.toString(),
            inputke11.text.toString(),
            inputke12.text.toString(),
            inputke13.text.toString()
        )

    }


}