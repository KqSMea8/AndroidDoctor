package com.ocean.doctor.androiddoctor

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button

/**
 * Created by oceanlong on 2018/11/15.
 */
class ButtonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    lateinit var btnModule:Button
    fun renderData(bean: ModuleBean){
        btnModule = itemView.findViewById<Button>(R.id.btn_module_name)
        btnModule.setText(bean.name)

    }
}