@file:Suppress("UNCHECKED_CAST", "UNUSED_VARIABLE", "LocalVariableName")
package moe.fuqiuluo.shamrock.xposed.actions

import android.content.Context
import com.tencent.common.app.AppInterface
import com.tencent.mobileqq.msf.sdk.MsfMessagePair
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.tools.hookMethod
import moe.fuqiuluo.shamrock.xposed.loader.LuoClassloader
import moe.fuqiuluo.symbols.XposedHook
import qq.service.QQInterfaces
import qq.service.internals.MSFHandler.onPush
import qq.service.internals.MSFHandler.onResp


@XposedHook(priority = 10)
class PatchMsfCore: IAction {
    override fun invoke(ctx: Context) {
        val app = QQInterfaces.app
        require(app is AppInterface) { "QQInterface.app must be AppInterface" }

        runCatching {
            val MSFRespHandleTask = LuoClassloader.load("mqq.app.msghandle.MSFRespHandleTask")
            if (MSFRespHandleTask == null) {
                LogCenter.log("无法注入MSFRespHandleTask！", Level.ERROR)
            } else {
                val msfPair = MSFRespHandleTask.declaredFields.first {
                    it.type == MsfMessagePair::class.java
                }
                msfPair.isAccessible = true
                MSFRespHandleTask.hookMethod("run").before {
                    val pair = msfPair.get(it.thisObject) as MsfMessagePair
                    if (pair.toServiceMsg == null) {
                        onPush(pair.fromServiceMsg)
                    } else {
                        onResp(pair.toServiceMsg, pair.fromServiceMsg)
                    }
                }
            }
        }.onFailure {
            LogCenter.log(it.stackTraceToString(), Level.ERROR)
        }
    }
}