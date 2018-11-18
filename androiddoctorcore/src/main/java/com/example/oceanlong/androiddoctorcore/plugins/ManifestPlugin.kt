package com.example.oceanlong.androiddoctorcore.plugins

import android.content.Context
import com.ocean.oceanlong.manifesthelper.MFHelper

/**
 * Created by oceanlong on 2018/11/16.
 */


class ManifestPlugin: IPlugin {

    override fun destroy() {
    }

    override fun init() {
    }

    fun getApplicationMetaData(context: Context, key:String):String{

        return MFHelper.getApplicationMetaData(context,key)
    }
}