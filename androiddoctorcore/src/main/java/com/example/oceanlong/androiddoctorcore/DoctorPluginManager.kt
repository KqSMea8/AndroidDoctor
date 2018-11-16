package com.example.oceanlong.androiddoctorcore

import android.util.Log
import com.example.oceanlong.androiddoctorcore.plugins.IPlugin

/**
 * Created by oceanlong on 2018/11/16.
 */
class DoctorPluginManager{
    private val mPluginMap:MutableMap<String , IPlugin> = HashMap()


    fun installPlugin(cls: Class<*>){
        try {
            val className = cls.name
            val onwClass = Class.forName(className)
            val obj = onwClass.newInstance()
            if (obj is IPlugin) {
                mPluginMap.put(className , obj)
            }
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InstantiationException) {
            e.printStackTrace()
        }


    }

    fun uninstallPlugin(pluginName:String){
        mPluginMap.remove(pluginName)
    }



    fun <T: IPlugin> getPlugin(cls: Class<T>):T?{
        val className = cls.name
        val plugin = mPluginMap[className]
        if (plugin != null){
            return plugin as T
        }else{
            Log.e(AndroidDoctor.TAG , className + " is not installed")
        }
        return null
    }


}