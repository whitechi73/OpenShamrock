package moe.fuqiuluo.shamrock.xposed.actions

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Process
import moe.fuqiuluo.shamrock.helper.LogCenter
import kotlin.system.exitProcess

internal class ListenShamrockUpdate: IAction {
    override fun invoke(ctx: Context) {
        val intent = IntentFilter()
        intent.addAction("android.intent.action.PACKAGE_ADDED")
        intent.addAction("android.intent.action.PACKAGE_REMOVED")
        intent.addAction("android.intent.action.PACKAGE_REPLACED")
        intent.addDataScheme("package")

        ctx.registerReceiver(Companion, intent)
    }

    companion object: BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            when (intent.action) {
                "android.intent.action.PACKAGE_ADDED",
                "android.intent.action.PACKAGE_REMOVED",
                "android.intent.action.PACKAGE_REPLACED" -> {
                    val packageName = intent.data?.schemeSpecificPart
                    if (packageName == "moe.fuqiuluo.shamrock") {
                        LogCenter.log("Shamrock更新, QQ已经自我销毁。")
                        Process.killProcess(Process.myPid())
                        exitProcess(0)
                    }
                }
            }
        }
    }
}