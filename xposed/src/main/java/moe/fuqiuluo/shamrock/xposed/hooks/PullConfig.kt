@file:OptIn(DelicateCoroutinesApi::class)

package moe.fuqiuluo.shamrock.xposed.hooks

import android.content.Context
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import moe.fuqiuluo.shamrock.remote.service.config.ShamrockConfig
import moe.fuqiuluo.shamrock.tools.toast
import moe.fuqiuluo.shamrock.utils.PlatformUtils
import moe.fuqiuluo.shamrock.xposed.helper.AppTalker
import moe.fuqiuluo.symbols.Process
import moe.fuqiuluo.symbols.XposedHook
import kotlin.system.exitProcess
import kotlin.time.Duration.Companion.seconds

@XposedHook(Process.MAIN, priority = 1)
class PullConfig: IAction {
    companion object {
        external fun testNativeLibrary(): String
    }

    override fun invoke(ctx: Context) {
        if (!PlatformUtils.isMainProcess()) return

        val isInit = ShamrockConfig.isInit()
        AppTalker.talk("init", onFailure = {
            if (isInit) {
                ctx.toast("Shamrock主进程未启动，将不会同步配置！")
            } else {
                ctx.toast("Shamrock主进程未启动，初始化失败！")
                GlobalScope.launch {
                    delay(3.seconds)
                    exitProcess(1)
                }
            }
        })
        ctx.toast("同步配置中...")
    }
}