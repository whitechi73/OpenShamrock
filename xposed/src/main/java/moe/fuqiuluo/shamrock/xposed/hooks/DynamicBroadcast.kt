package moe.fuqiuluo.shamrock.xposed.hooks

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import de.robv.android.xposed.XposedBridge
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.xposed.hooks.interacts.Init
import moe.fuqiuluo.shamrock.xposed.hooks.interacts.SwitchStatus
import moe.fuqiuluo.shamrock.xposed.hooks.interacts.UpdateConfig
import moe.fuqiuluo.symbols.Process
import moe.fuqiuluo.symbols.XposedHook
import mqq.app.MobileQQ

@XposedHook(priority = 1, process = Process.MAIN)
class DynamicBroadcast: IAction {
    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    override fun invoke(ctx: Context) {
        val intentFilter = IntentFilter()
        intentFilter.addAction("moe.fuqiuluo.onebot.dynamic")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            MobileQQ.getMobileQQ().registerReceiver(
                DynamicReceiver, intentFilter,
                Context.RECEIVER_EXPORTED
            )
        } else {
            MobileQQ.getMobileQQ().registerReceiver(DynamicReceiver, intentFilter)
        }
        LogCenter.log("Register Main::Broadcast successfully.")
    }

    private object DynamicReceiver: BroadcastReceiver() {
        private val handlers = mapOf(
            "init" to Init,
            "switch_status" to SwitchStatus,
            "push_config" to UpdateConfig
        )

        override fun onReceive(context: Context, intent: Intent) {
            val cmd = intent.getStringExtra("__cmd") ?: ""
            if (cmd.isBlank()) {
                LogCenter.log("DynamicReceiver.onReceive: cmd is blank", Level.ERROR)
                return
            }
            //LogCenter.log("DynamicReceiver.onReceive: cmd=$cmd")
            val handler = handlers[cmd]
            if (handler == null) {
                LogCenter.log("DynamicReceiver.onReceive: unknown cmd=$cmd", Level.ERROR)
            } else {
                handler(intent)
            }
        }
    }
}