@file:OptIn(DelicateCoroutinesApi::class)

package moe.fuqiuluo.shamrock.helper

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import moe.fuqiuluo.shamrock.remote.service.config.ShamrockConfig
import moe.fuqiuluo.shamrock.utils.FileUtils
import moe.fuqiuluo.shamrock.xposed.actions.toast
import moe.fuqiuluo.shamrock.xposed.helper.internal.DataRequester
import mqq.app.MobileQQ
import java.util.Date

internal enum class Level(
    val id: Byte
) {
    DEBUG(0),
    INFO(1),
    WARN(2),
    ERROR(3),
}

@SuppressLint("SimpleDateFormat")
internal object LogCenter {
    private val LogFile = MobileQQ.getContext().getExternalFilesDir(null)!!
        .parentFile!!.resolve("Tencent/Shamrock/log").also {
            if (it.exists()) it.delete()
            it.mkdirs()
        }
        .resolve(MobileQQ.getMobileQQ().qqProcessName.replace(":", ".") + "_${
            // 格式化时间 
            SimpleDateFormat("yyyy-MM-dd").format(Date())
        }_" + ".log")
    private val format = SimpleDateFormat("[HH:mm:ss] ")

    fun log(string: String, level: Level = Level.INFO, toast: Boolean = false) =
        log({ string }, level, toast)

    fun log(
        string: () -> String,
        level: Level = Level.INFO,
        toast: Boolean = false
    ) {
        if (!ShamrockConfig.isDebug() && level == Level.DEBUG) {
            return
        }

        val log = string()
        if (toast) {
            MobileQQ.getContext().toast(log)
        }
        // 把日志广播到主进程
        GlobalScope.launch(Dispatchers.Default) {
            DataRequester.request("send_message", bodyBuilder = {
                put("string", log)
                put("level", level.id)
            })
        }

        if (!LogFile.exists()) {
            LogFile.createNewFile()
        }
        val format = "%s%s %s\n".format(format.format(Date()), level.name, log)

        LogFile.appendText(format)
    }

//    fun getAllLog(): File {
//        return LogFile
//    }

    fun getLogLines(start: Int, recent: Boolean = false): List<String> {
        val logData = LogFile.readLines()
        val index = if(start > logData.size || start < 0) 0 else start
        return if(!recent) {
            logData.subList(index, logData.size)
        } else {
            logData.subList(logData.size - index, logData.size)
        }
    }
}