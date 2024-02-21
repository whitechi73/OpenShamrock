@file:OptIn(DelicateCoroutinesApi::class)

package moe.fuqiuluo.shamrock.xposed.hooks

import android.content.Context
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import moe.fuqiuluo.shamrock.remote.service.WebSocketClientService
import moe.fuqiuluo.shamrock.remote.service.WebSocketService
import moe.fuqiuluo.shamrock.remote.service.config.ShamrockConfig
import moe.fuqiuluo.shamrock.utils.PlatformUtils
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.remote.HTTPServer
import moe.fuqiuluo.shamrock.remote.service.HttpService
import moe.fuqiuluo.shamrock.tools.ShamrockVersion
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import moe.fuqiuluo.symbols.Process
import moe.fuqiuluo.symbols.XposedHook
import mqq.app.MobileQQ
import kotlin.concurrent.timer
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

@XposedHook(Process.MAIN, priority = 10)
internal class InitRemoteService : IAction {
    override fun invoke(ctx: Context) {
        GlobalScope.launch {
            try {
                HTTPServer.start(ShamrockConfig.getPort())
            } catch (e: Throwable) {
                LogCenter.log(e.stackTraceToString(), Level.ERROR)
            }
        }

        if (!PlatformUtils.isMqqPackage()) return


        if (ShamrockConfig.allowWebHook()) {
            HttpService.init()
        }

        val runtime = AppRuntimeFetcher.appRuntime
        if (!runtime.isLogin) {
            LogCenter.log("未登录，不启动任何WebSocket服务，登录完成后，请重新启动QQ。", Level.WARN)
            return
        }
        if (ShamrockConfig.openWebSocket()) {
            startWebSocketServer()
        }

        if (ShamrockConfig.openWebSocketClient()) {
            val curUin = runtime.currentAccountUin
            val defaultToken = ShamrockConfig.getToken()
            ShamrockConfig.getWebSocketClientAddress().forEach { conn ->
                if (!conn.address.isNullOrBlank()) {
                    val token = conn.token ?: defaultToken
                    val wsHeaders = hashMapOf(
                        "X-Client-Role" to "Universal",
                        "X-Self-ID" to curUin,
                        "User-Agent" to "Shamrock/$ShamrockVersion",
                        "X-QQ-Version" to PlatformUtils.getClientVersion(MobileQQ.getContext()),
                        "X-OneBot-Version" to "11",
                        "X-Impl" to "Shamrock",
                        "Sec-WebSocket-Protocol" to "11.Shamrock"
                    )
                    if (token.isNotBlank()) {
                        wsHeaders["authorization"] = "bearer $token"
                    }
                    LogCenter.log("尝试连接WebSocketClient(url = ${conn.address})",Level.WARN)
                    startWebSocketClient(conn.address, conn.heartbeatInterval ?: 15000, wsHeaders)
                }
            }
        } else {
            LogCenter.log("未启用被动WebSocket，不会加载连接。")
        }
    }

    private fun startWebSocketServer() {
        GlobalScope.launch {
            try {
                val config = ShamrockConfig.getActiveWebSocketConfig() ?: return@launch
                config.address ?: kotlin.run {
                    LogCenter.log("WebSocketServer地址不合法", Level.ERROR)
                    return@launch
                }
                config.port ?: kotlin.run {
                    LogCenter.log("WebSocketServer端口不合法", Level.ERROR)
                    return@launch
                }
                require(config.port in 0 .. 65536) { "WebSocketServer端口不合法" }
                val server = WebSocketService(config.address, config.port!!, config.heartbeatInterval ?: (15 * 1000))
                server.isReuseAddr = true
                server.start()
            } catch (e: Throwable) {
                LogCenter.log(e.stackTraceToString(), Level.ERROR)
            }
        }
    }

    private fun startWebSocketClient(
        url: String,
        interval: Long,
        wsHeaders: HashMap<String, String>
    ) {
        GlobalScope.launch {
            try {
                if (url.startsWith("ws://") || url.startsWith("wss://")) {
                    val wsClient = WebSocketClientService(url, interval, wsHeaders)
                    wsClient.connect()
                    wsClient.launch {
                        while (true) {
                            delay(5.seconds)
                            if (wsClient.isClosed || wsClient.isClosing) {
                                wsClient.reconnect()
                            }
                        }
                    }
                } else {
                    LogCenter.log("被动WebSocket地址不合法: $url", Level.ERROR)
                }
            } catch (e: Throwable) {
                if (e is RuntimeException) {
                    LogCenter.log(e.message ?: e.stackTraceToString(), Level.ERROR)
                } else {
                    LogCenter.log(e.stackTraceToString(), Level.ERROR)
                }
            }
        }
    }
}
