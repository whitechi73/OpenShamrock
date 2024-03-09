package moe.fuqiuluo.shamrock.xposed.actions

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import de.robv.android.xposed.XposedBridge
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.xposed.actions.interacts.SwitchStatus
import moe.fuqiuluo.shamrock.xposed.actions.interacts.Init
import moe.fuqiuluo.symbols.Process
import moe.fuqiuluo.symbols.XposedHook
import mqq.app.MobileQQ

@XposedHook(priority = 1, process = Process.MAIN)
class DynamicBroadcast: IAction {
    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    override fun invoke(ctx: Context) {
        val intentFilter = IntentFilter()
        intentFilter.addAction("moe.fuqiuluo.kritor.dynamic")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            MobileQQ.getMobileQQ().registerReceiver(
                DynamicReceiver, intentFilter,
                Context.RECEIVER_EXPORTED
            )
        } else {
            MobileQQ.getMobileQQ().registerReceiver(DynamicReceiver, intentFilter)
        }
        XposedBridge.log("Register Main::Broadcast successfully.")
    }

    private object DynamicReceiver: BroadcastReceiver() {
        private val handlers = mapOf(
            "init" to Init,
            "switch_status" to SwitchStatus
        )

        override fun onReceive(context: Context, intent: Intent) {
            val cmd = intent.getStringExtra("__cmd") ?: ""
            val handler = handlers[cmd]
            if (handler == null) {
                LogCenter.log("DynamicReceiver.onReceive: unknown cmd=$cmd", Level.ERROR)
            } else {
                handler(intent)
            }
        }
    }
}