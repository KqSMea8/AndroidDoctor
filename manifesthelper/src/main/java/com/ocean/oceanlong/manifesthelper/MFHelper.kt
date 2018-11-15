package com.ocean.oceanlong.manifesthelper

import android.app.Activity
import android.app.Service
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager


/**
 * Created by oceanlong on 2018/11/15.
 */
class MFHelper{
    companion object {

        fun getApplicationMetaData(context:Context, key:String):String{
            val appInfo = context.packageManager
                    .getApplicationInfo(context.packageName, PackageManager.GET_META_DATA)
            return appInfo.metaData.getString(key)

        }

        fun getActivityMetaData(context: Context, activityClass: Class<Activity> , key:String):String{
            val componentName = ComponentName(context, activityClass)
            val info = context.packageManager
                    .getActivityInfo(componentName, PackageManager.GET_META_DATA)
            return info.metaData.getString(key)

        }

        fun getServiceMetaData(context: Context, serviceClass: Class<Service> , key:String):String{
            val componentName = ComponentName(context, serviceClass)
            val info = context.packageManager
                    .getServiceInfo(componentName, PackageManager.GET_META_DATA)
           return info.metaData.getString(key)
        }

        fun getReceiverMetaData(context: Context, receiverClass: Class<BroadcastReceiver> , key:String):String{
            val componentName = ComponentName(context,receiverClass)
            val info = context.packageManager
                    .getReceiverInfo(componentName, PackageManager.GET_META_DATA)
            return info.metaData.getString(key)
        }
    }
}