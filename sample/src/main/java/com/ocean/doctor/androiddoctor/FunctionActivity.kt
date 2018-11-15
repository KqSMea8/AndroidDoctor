package com.ocean.doctor.androiddoctor

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.function_activity_layout.*

/**
 * Created by oceanlong on 2018/11/15.
 */
class FunctionActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.function_activity_layout)
        initSpinner()
        btn_invoke_func.setOnClickListener {
            val funcName = spinner_func.selectedItem.toString()
            Toast.makeText(this , funcName , Toast.LENGTH_SHORT).show()

        }

    }

    fun initSpinner(){

        val funcNameList = ArrayList<String>()
        funcNameList.add("Get meta data")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, funcNameList)
        spinner_func.adapter = adapter

    }
}