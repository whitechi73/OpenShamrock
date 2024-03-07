package moe.fuqiuluo.shamrock.ui.service.handlers

import android.content.ContentValues
import android.content.Context
import android.widget.Toast
import moe.fuqiuluo.shamrock.tools.GlobalUi
import moe.fuqiuluo.shamrock.ui.app.AppRuntime
import java.util.Timer
import kotlin.concurrent.timer
import kotlin.concurrent.timerTask

object SwitchStatus: ModuleHandler() {
    override val cmd: String
        get() = "switch_status"

    private var lastActiveTime = 0L
    private var timer: Timer? = null

    override fun onReceive(callbackId: Int, values: ContentValues, context: Context) {
        val voiceSwitch = values.getAsBoolean("voice")
        val nickname = values.getAsString("nickname")
        val account = values.getAsString("account")
        if (lastActiveTime == 0L) GlobalUi.post {
            Toast.makeText(context, "激活成功", Toast.LENGTH_SHORT).show()
        }
        AppRuntime.state.apply {
            isFined.value = true
            coreVersion.value = values.getAsString("core_version")
            coreName.value = "LSPosed"
            supportVoice.value = voiceSwitch
        }
        AppRuntime.AccountInfo.apply {
            uin.value = account
            nick.value = nickname
        }
        lastActiveTime = System.currentTimeMillis()
        startTimer()
    }

    private fun startTimer() {
        timer?.cancel()
        timer = timer("SwitchStatus", true, 0, 5_000) {
            if (lastActiveTime != 0L && System.currentTimeMillis() - lastActiveTime > 30 * 1000) {
                AppRuntime.state.isFined.value = false
                lastActiveTime = 0
            }
        }
    }
}