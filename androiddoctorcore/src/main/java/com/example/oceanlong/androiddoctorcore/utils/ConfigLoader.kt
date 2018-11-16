package com.example.oceanlong.androiddoctorcore.utils

/**
 * Created by oceanlong on 2018/11/16.
 */
import android.content.Context
import com.example.oceanlong.androiddoctorcore.R
import java.io.IOException
import java.util.*

/**
 *
 * @author Ananti
 */
class ConfigLoader {

    private val configuration: Properties

    init {
        configuration = Properties()
    }

    fun load(context: Context): Boolean {
        var retval = false

        try {
            val inputStream = context.resources.openRawResource(R.raw.plugin_map)
            configuration.load(inputStream)
            retval = true
        } catch (e: IOException) {
            println("Configuration error: " + e.message)
        }

        return retval
    }

    operator fun set(key: String, value: String) {
        configuration.setProperty(key, value)
    }

    operator fun get(key: String): String {
        return configuration.getProperty(key)
    }
}