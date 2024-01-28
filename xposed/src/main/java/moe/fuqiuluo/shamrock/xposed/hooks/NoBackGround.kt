package moe.fuqiuluo.shamrock.xposed.hooks

import android.content.Context
import de.robv.android.xposed.XposedHelpers
import moe.fuqiuluo.shamrock.tools.hookMethod
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.xposed.loader.LuoClassloader
import moe.fuqiuluo.symbols.XposedHook
import mqq.app.MobileQQ

@XposedHook(priority = 10)
internal class NoBackGround: IAction {
    override fun invoke(ctx: Context) {
        kotlin.runCatching {
            XposedHelpers.findClass("com.tencent.mobileqq.activity.miniaio.MiniMsgUser", LuoClassloader)
        }.onSuccess {
            it.hookMethod("onBackground").before {
                it.result = null
            }
        }.onFailure {
            LogCenter.log("Keeping MiniMsgUser alive failed: ${it.message}", Level.WARN)
        }

        try {
            val application = MobileQQ.getMobileQQ()
            application.javaClass.hookMethod("onActivityFocusChanged").before {
                it.args[1] = true
            }
        } catch (e: Throwable) {
            LogCenter.log("Keeping MSF alive failed: ${e.message}", Level.WARN)
        }
    }
}