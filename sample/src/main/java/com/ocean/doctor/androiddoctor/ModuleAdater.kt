package com.ocean.doctor.androiddoctor

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by oceanlong on 2018/11/15.
 */
class ModuleAdater(val context: Context, val dataList:List<ModuleBean>) : RecyclerView.Adapter<ButtonViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ButtonViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.module_button_layout , viewGroup , false)
        return ButtonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(viewHolder: ButtonViewHolder, position: Int) {
        val bean = dataList[position]
        viewHolder.renderData(bean)
        viewHolder.btnModule.setOnClickListener {
            val intent = Intent(context ,FunctionActivity::class.java)
            intent.putExtra("func" , bean.func)
            context.startActivity(intent)
        }
    }

}