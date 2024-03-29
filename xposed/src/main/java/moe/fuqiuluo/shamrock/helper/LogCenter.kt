@file:OptIn(DelicateCoroutinesApi::class)

package moe.fuqiuluo.shamrock.helper

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import moe.fuqiuluo.shamrock.config.DebugMode
import moe.fuqiuluo.shamrock.config.ShamrockConfig
import moe.fuqiuluo.shamrock.tools.toast
import moe.fuqiuluo.shamrock.xposed.helper.AppTalker
import mqq.app.MobileQQ
import java.io.File
import java.util.Calendar
import java.util.Date
import java.util.Timer
import java.util.TimerTask

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
    private val logFileBaseName = MobileQQ.getMobileQQ().qqProcessName.replace(":", ".") + "_${
        // 格式化时间 
        SimpleDateFormat("yyyy-MM-dd").format(Date())
    }_"
    private var LogFile = generateLogFile()

    private val format = SimpleDateFormat("[HH:mm:ss] ")
    private val timer = Timer()

    init {
        val now = Calendar.getInstance()
        val tomorrowMidnight = Calendar.getInstance().apply {
            add(Calendar.DAY_OF_YEAR, 1)
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
        val delay = tomorrowMidnight.timeInMillis - now.timeInMillis
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                LogFile = generateLogFile()
            }
        }, delay, 24 * 60 * 60 * 1000)
    }

    private fun generateLogFile() = MobileQQ.getContext().getExternalFilesDir(null)!!
        .parentFile!!.resolve("Tencent/Shamrock/log").also {
            if (it.exists()) it.delete()
            it.mkdirs()
        }.let {
            var i = 1
            lateinit var result: File
            while (true) {
                result = it.resolve("$logFileBaseName$i.log")
                if (result.exists()) {
                    i++
                } else {
                    break
                }
            }
            return@let result
        }

    fun log(string: String, level: Level = Level.INFO, toast: Boolean = false) {
        if (!ShamrockConfig[DebugMode] && level == Level.DEBUG) {
            return
        }

        if (toast) {
            MobileQQ.getContext().toast(string)
        }
        GlobalScope.launch(Dispatchers.Default) {
            AppTalker.talk("send_message") {
                put("string", string)
                put("level", level.id)
            }
        }

        if (!LogFile.exists()) {
            LogFile.createNewFile()
        }
        val format = "%s%s %s\n".format(format.format(Date()), level.name, string)

        LogFile.appendText(format)
    }

    fun log(
        string: () -> String,
        level: Level = Level.INFO,
        toast: Boolean = false
    ) {
        if (!ShamrockConfig[DebugMode] && level == Level.DEBUG) {
            return
        }

        val log = string()
        if (toast) {
            MobileQQ.getContext().toast(log)
        }
        // 把日志广播到主进程
        GlobalScope.launch(Dispatchers.Default) {
            AppTalker.talk("send_message") {
                put("string", log)
                put("level", level.id)
            }
        }

        if (!LogFile.exists()) {
            LogFile.createNewFile()
        }
        val format = "%s%s %s\n".format(format.format(Date()), level.name, log)

        LogFile.appendText(format)
    }

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