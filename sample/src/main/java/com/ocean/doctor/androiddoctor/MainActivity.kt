package com.ocean.doctor.androiddoctor

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var moduleAdater: ModuleAdater;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initModules()
    }

    fun initModules(){
        val dataList = ModuleFactory.getModules()
        moduleAdater = ModuleAdater(this , dataList)
        val layoutManager = StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL)
        rv_module_list.layoutManager = layoutManager
        rv_module_list.adapter = moduleAdater
    }

}
