package com.MyApp.Aplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.MyApp.Aplication.R
import com.google.firebase.database.*

class FetchingActivity : AppCompatActivity() {
    private lateinit var empRecyclerView: RecyclerView
    private lateinit var tvLoadingData: TextView
    private lateinit var empList: ArrayList<EmployeeModel>
    private lateinit var dbRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetching)
        empRecyclerView = findViewById(R.id.rvEmp)
        empRecyclerView.layoutManager = LinearLayoutManager(this)
        empRecyclerView.setHasFixedSize(true)
        tvLoadingData = findViewById(R.id.tvLoadingData)

        empList = arrayListOf<EmployeeModel>()

        getEmployeesData()

    }

    private fun getEmployeesData() {

        empRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE

        dbRef = FirebaseDatabase.getInstance().getReference("inputdata")

        dbRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                empList.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(EmployeeModel::class.java)
                        empList.add(empData!!)
                    }
                    val mAdapter = EmpAdapter(empList)
                    empRecyclerView.adapter = mAdapter

                    mAdapter.setOnItemClickListener(object : EmpAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {

                            val intent = Intent(this@FetchingActivity, EmployeeDetailsActivity::class.java)

                            //put extras
                            intent.putExtra("nama", empList[position].nama)
                            intent.putExtra("nomor", empList[position].no)
                            intent.putExtra("kelas", empList[position].kelas)
                            intent.putExtra("input1", empList[position].input1)
                            intent.putExtra("input2", empList[position].input2)
                            intent.putExtra("input3", empList[position].input3)
                            intent.putExtra("input4", empList[position].input4)
                            intent.putExtra("input5", empList[position].input5)
                            intent.putExtra("input6", empList[position].input6)
                            intent.putExtra("input7", empList[position].input7)
                            intent.putExtra("input8", empList[position].input8)
                            intent.putExtra("input9", empList[position].input9)
                            intent.putExtra("input10", empList[position].input10)
                            intent.putExtra("input11", empList[position].input11)
                            intent.putExtra("input12", empList[position].input12)
                            intent.putExtra("input13", empList[position].input13)

                            startActivity(intent)
                        }

                    })

                    empRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
            }

            /**
             * This method will be triggered in the event that this listener either failed at the server, or
             * is removed as a result of the security and Firebase Database rules. For more information on
             * securing your data, see: [ Security
 * Quickstart](https://firebase.google.com/docs/database/security/quickstart)
             *
             * @param error A description of the error that occurred
             */
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

}