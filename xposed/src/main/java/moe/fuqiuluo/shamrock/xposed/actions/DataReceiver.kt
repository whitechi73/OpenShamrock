@file:OptIn(DelicateCoroutinesApi::class)
package moe.fuqiuluo.shamrock.xposed.actions

import android.annotation.SuppressLint
import android.content.Context
import android.content.IntentFilter
import android.os.Build
import android.os.Handler
import android.widget.Toast
import de.robv.android.xposed.XposedBridge
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import moe.fuqiuluo.shamrock.utils.PlatformUtils
import moe.fuqiuluo.shamrock.xposed.helper.internal.DynamicReceiver
import mqq.app.MobileQQ

internal lateinit var GlobalUi: Handler

internal fun Context.toast(msg: String, flag: Int = Toast.LENGTH_SHORT) {
    XposedBridge.log(msg)
    if (!::GlobalUi.isInitialized) {
        return
    }
    GlobalUi.post { Toast.makeText(this, msg, flag).show() }
}

internal class DataReceiver: IAction {
    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    override fun invoke(ctx: Context) {
        kotlin.runCatching {
            MobileQQ.getMobileQQ().unregisterReceiver(DynamicReceiver)
        }

        if (PlatformUtils.isMainProcess()) {
            GlobalUi = Handler(ctx.mainLooper)
            GlobalScope.launch {
                val intentFilter = IntentFilter()
                intentFilter.addAction("moe.fuqiuluo.xqbot.dynamic")
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
        } else if (PlatformUtils.isMsfProcess()) {
            val intentFilter = IntentFilter()
            intentFilter.addAction("moe.fuqiuluo.msf.dynamic")

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                MobileQQ.getMobileQQ().registerReceiver(
                    DynamicReceiver, intentFilter,
                    Context.RECEIVER_EXPORTED
                )
            } else {
                MobileQQ.getMobileQQ().registerReceiver(DynamicReceiver, intentFilter)
            }
        }
    }
}

