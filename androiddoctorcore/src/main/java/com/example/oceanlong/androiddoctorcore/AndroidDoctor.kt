package com.example.oceanlong.androiddoctorcore

import com.example.oceanlong.androiddoctorcore.plugins.IPlugin

/**
 * Created by oceanlong on 2018/11/16.
 */
class AndroidDoctor{
    companion object {
        const val TAG = "AndroidDoctor"

        private val mPluginManager:DoctorPluginManager = DoctorPluginManager()

        fun installPlugin(cls: Class<*>){
            mPluginManager.installPlugin(cls)
        }

        fun uninstallPlugin(pluginName: String){
            mPluginManager.uninstallPlugin(pluginName)
        }

        fun <T: IPlugin> getPlugin(cls: Class<T>):T?{
            return mPluginManager.getPlugin(cls)
        }

    }
}