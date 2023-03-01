package com.MyApp.Aplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.MyApp.Aplication.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.core.view.View
import kotlinx.android.synthetic.main.activity_employee_details.*
import kotlinx.android.synthetic.main.activity_insertion.*


class EmployeeDetailsActivity : AppCompatActivity() {
    private lateinit var nama: TextView
    private lateinit var no: TextView
    private lateinit var kelas: TextView
    private lateinit var input1: TextView
    private lateinit var input2: TextView
    private lateinit var input3: TextView
    private lateinit var input4: TextView
    private lateinit var input5: TextView
    private lateinit var input6: TextView
    private lateinit var input7: TextView
    private lateinit var input8: TextView
    private lateinit var input9: TextView
    private lateinit var input10: TextView
    private lateinit var input11: TextView
    private lateinit var input12: TextView
    private lateinit var input13: TextView
//    private lateinit var layout1: lea
//    private lateinit var layout2: View
    private lateinit var btnChangeToLayout1: Button
    private lateinit var btnChangeToLayout2: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_details)
        initView()
        setValuesToViews()
//
//        layout1 = findViewById(R.id.cek1)
//        layout2 = findViewById(R.id.cek2)
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("intent", intent)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val savedIntent = savedInstanceState.getParcelable<Intent>("intent")
        if (savedIntent != null) {
            intent = savedIntent
        }
    }


    private fun initView() {
        nama = findViewById(R.id.nama)
        no = findViewById(R.id.nomorAb)
        kelas = findViewById(R.id.kelas)
        input1 = findViewById(R.id.inputk1)
        input2 = findViewById(R.id.inputk2)
        input3 = findViewById(R.id.inputk3)
        input4 = findViewById(R.id.inputk4)
        input5 = findViewById(R.id.inputk5)
        input6 = findViewById(R.id.inputk6)
        input7 = findViewById(R.id.inputk7)
        input8 = findViewById(R.id.inputk8)
        input9 = findViewById(R.id.inputk9)
        input10 = findViewById(R.id.inputk10)
        input11 = findViewById(R.id.inputk11)
        input12 = findViewById(R.id.inputk12)
        input13 = findViewById(R.id.inputk13)

    }

    private fun setValuesToViews() {
        nama.text = intent.getStringExtra("nama")
        no.text = intent.getStringExtra("nomor")
        kelas.text = intent.getStringExtra("kelas")
        inputk1.text = intent.getStringExtra("input1")
        inputk2.text = intent.getStringExtra("input2")
        inputk3.text = intent.getStringExtra("input3")
        inputk4.text = intent.getStringExtra("input4")
        inputk5.text = intent.getStringExtra("input5")
        inputk6.text = intent.getStringExtra("input6")
        inputk7.text = intent.getStringExtra("input7")
        inputk8.text = intent.getStringExtra("input8")
        inputk9.text = intent.getStringExtra("input9")
        inputk10.text = intent.getStringExtra("input10")
        inputk11.text = intent.getStringExtra("input11")
        inputk12.text = intent.getStringExtra("input12")
        inputk13.text = intent.getStringExtra("input13")


    }

}
