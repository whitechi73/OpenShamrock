@file:OptIn(DelicateCoroutinesApi::class)

package moe.fuqiuluo.shamrock.xposed.actions

import android.content.Context
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
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
import mqq.app.MobileQQ
import kotlin.concurrent.timer

internal class InitRemoteService : IAction {
    override fun invoke(ctx: Context) {
        if (!PlatformUtils.isMainProcess()) return

        GlobalScope.launch {
            try {
                HTTPServer.start(ShamrockConfig.getPort())
            } catch (e: Throwable) {
                LogCenter.log(e.stackTraceToString(), Level.ERROR)
            }
        }

        if (!PlatformUtils.isMqqPackage()) return

        if (ShamrockConfig.allowWebHook()) {
            HttpService.initTransmitter()
        }

        if (ShamrockConfig.openWebSocket()) {
            startWebSocketServer()
        }

        if (ShamrockConfig.openWebSocketClient()) {
            val runtime = AppRuntimeFetcher.appRuntime
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
                    LogCenter.log("尝试链接WebSocketClient(url = ${conn.address})",Level.WARN)
                    startWebSocketClient(conn.address, conn.heartbeatInterval ?: 15000, wsHeaders)
                }
            }
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
                    timer(initialDelay = 5000L, period = 5000L) {
                        if (wsClient.isClosed || wsClient.isClosing) {
                            wsClient.reconnect()
                        }
                    }
                } else {
                    LogCenter.log("被动WebSocket地址不合法: $url", Level.ERROR)
                }
            } catch (e: Throwable) {
                LogCenter.log(e.stackTraceToString(), Level.ERROR)
            }
        }
    }
}
