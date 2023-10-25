package moe.fuqiuluo.shamrock.tools

import android.content.Context
import android.content.Intent

/**
 * 指定向某个进程发送广播
 */
internal fun Context.broadcast(processName: String, intentBuilder: Intent.() -> Unit) {
    val intent = Intent()
    intent.action = "moe.fuqiuluo.$processName.dynamic"
    intent.intentBuilder()
    sendBroadcast(intent)
}