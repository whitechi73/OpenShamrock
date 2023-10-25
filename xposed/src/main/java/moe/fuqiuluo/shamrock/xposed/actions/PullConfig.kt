@file:OptIn(DelicateCoroutinesApi::class)

package moe.fuqiuluo.shamrock.xposed.actions

import android.content.Context
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import moe.fuqiuluo.shamrock.remote.HTTPServer
import moe.fuqiuluo.shamrock.remote.service.config.ShamrockConfig
import moe.fuqiuluo.shamrock.utils.PlatformUtils
import moe.fuqiuluo.shamrock.xposed.helper.internal.DataRequester
import moe.fuqiuluo.shamrock.xposed.helper.internal.DynamicReceiver
import moe.fuqiuluo.shamrock.xposed.helper.internal.IPCRequest
import moe.fuqiuluo.shamrock.xposed.loader.ActionLoader
import moe.fuqiuluo.shamrock.xposed.loader.NativeLoader
import mqq.app.MobileQQ
import kotlin.concurrent.thread
import kotlin.system.exitProcess

class PullConfig: IAction {
    companion object {
        @JvmStatic
        var isConfigOk = false
    }

    private external fun testNativeLibrary(): String

    override fun invoke(ctx: Context) {
        if (!PlatformUtils.isMainProcess()) return

        GlobalScope.launch(Dispatchers.Default) {
            DynamicReceiver.register("fetchPort", IPCRequest {
                DataRequester.request("success", values = mapOf(
                    "port" to HTTPServer.currServerPort,
                    "voice" to NativeLoader.isVoiceLoaded
                ))
            })
            DynamicReceiver.register("checkAndStartService", IPCRequest {
                if (HTTPServer.isServiceStarted) {
                    HTTPServer.isServiceStarted = false
                }
                initAppService(MobileQQ.getContext())
            })
            DynamicReceiver.register("push_config", IPCRequest {
                ctx.toast("动态推送配置文件成功。")
                ShamrockConfig.updateConfig(it)
            })
            DynamicReceiver.register("change_port", IPCRequest {
                when (it.getStringExtra("type")) {
                    "port" -> {
                        ctx.toast("动态修改HTTP端口成功。")
                        HTTPServer.changePort(it.getIntExtra("port", 5700))
                    }
                    "ws_port" -> {
                        ctx.toast("动态修改WS端口不支持。")
                    }
                    "restart" -> {
                        if(HTTPServer.isServiceStarted) {
                            ctx.toast("重启HTTPServer完成。")
                            HTTPServer.restart()
                        }
                    }
                }
            })

            DataRequester.request("init", onFailure = {
                if (!ShamrockConfig.isInit()) {
                    ctx.toast("请启动Shamrock主进程以初始化服务，进程将退出。")
                    thread {
                        Thread.sleep(3000)
                        exitProcess(1)
                    }
                } else {
                    ctx.toast("Shamrock进程未启动，不会推送配置文件。")
                    initAppService(ctx)
                }
            }, bodyBuilder = null) {
                isConfigOk = true
                ShamrockConfig.updateConfig(it)
                initAppService(ctx)
            }
        }
    }

    private fun initAppService(ctx: Context) {
        NativeLoader.load("shamrock")
        ctx.toast(testNativeLibrary())
        ActionLoader.runService(ctx)
    }
}