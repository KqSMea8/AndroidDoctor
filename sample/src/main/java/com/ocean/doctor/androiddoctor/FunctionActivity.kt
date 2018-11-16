package com.ocean.doctor.androiddoctor

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import com.example.oceanlong.androiddoctorcore.AndroidDoctor
import com.example.oceanlong.androiddoctorcore.plugins.ManifestPlugin
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
//            val v = AndroidDoctor.getApplicationMetaData(this , "test")
            val v = AndroidDoctor.getPlugin<ManifestPlugin>(ManifestPlugin::class.java)?.getApplicationMetaData(this, "test")
            tv_result.setText("result:\n"+v)

        }

    }

    fun initSpinner(){

        val funcNameList = ArrayList<String>()
        funcNameList.add("Get meta data")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, funcNameList)
        spinner_func.adapter = adapter

    }
}