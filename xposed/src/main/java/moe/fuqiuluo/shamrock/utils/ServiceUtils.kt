package moe.fuqiuluo.shamrock.utils

import android.app.ActivityManager
import android.content.Context

import androidx.core.content.ContextCompat.getSystemService

object ServiceUtils {
    fun isServiceExisted(ctx: Context, process: String): Boolean {
        val am = getSystemService(ctx, ActivityManager::class.java)
        val serviceList = am!!.runningAppProcesses
        serviceList.forEach {
            //LogCenter.log(it.processName, Level.DEBUG)
            if (it.processName == process) return true
        }
        return false
    }
}