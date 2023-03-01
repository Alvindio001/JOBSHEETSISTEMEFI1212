package com.MyApp.Aplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.MyApp.Aplication.R

class EmpAdapter(private val empList: ArrayList<EmployeeModel>) :
    RecyclerView.Adapter<EmpAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(clickListener: onItemClickListener){
        mListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.emp_list_item, parent, false)
        return ViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentEmp = empList[position]
//        nama no kelas
        holder.Name.text = currentEmp.nama
        holder.No.text = currentEmp.no
        holder.Kelas.text = currentEmp.kelas


    }

    override fun getItemCount(): Int {
        return empList.size
    }

    class ViewHolder(itemView: View, clickListener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        val Name : TextView = itemView.findViewById(R.id.nama)
        val No : TextView = itemView.findViewById(R.id.no)
        val Kelas : TextView = itemView.findViewById(R.id.kelas)

        init {
            itemView.setOnClickListener {
                clickListener.onItemClick(adapterPosition)
            }
        }

    }

}