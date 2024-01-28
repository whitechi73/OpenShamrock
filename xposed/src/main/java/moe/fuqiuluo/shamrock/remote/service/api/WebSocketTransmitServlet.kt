@file:OptIn(DelicateCoroutinesApi::class)

package moe.fuqiuluo.shamrock.remote.service.api

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import moe.fuqiuluo.shamrock.remote.action.ActionManager
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.structures.EmptyObject
import moe.fuqiuluo.shamrock.remote.structures.Status
import moe.fuqiuluo.shamrock.remote.structures.resultToString
import moe.fuqiuluo.shamrock.remote.service.config.ShamrockConfig
import moe.fuqiuluo.shamrock.remote.service.data.BotStatus
import moe.fuqiuluo.shamrock.remote.service.data.Self
import moe.fuqiuluo.shamrock.remote.service.data.push.MetaEventType
import moe.fuqiuluo.shamrock.remote.service.data.push.MetaSubType
import moe.fuqiuluo.shamrock.remote.service.data.push.PostType
import moe.fuqiuluo.shamrock.remote.service.data.push.PushMetaEvent
import moe.fuqiuluo.shamrock.tools.GlobalJson
import moe.fuqiuluo.shamrock.tools.*
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import org.java_websocket.WebSocket
import org.java_websocket.server.WebSocketServer
import java.net.InetSocketAddress
import java.net.URI
import java.util.Collections
import kotlin.concurrent.timer

internal abstract class WebSocketTransmitServlet(
    host:String,
    port: Int,
    protected val heartbeatInterval: Long,
) : BaseTransmitServlet, WebSocketServer(InetSocketAddress(host, port)) {
    private val sendLock = Mutex()
    protected val eventReceivers: MutableList<WebSocket> = Collections.synchronizedList(mutableListOf<WebSocket>())

    override val address: String
        get() = "-"

     override fun allowTransmit(): Boolean {
         return ShamrockConfig.openWebSocket()
     }

    inline fun <reified T> broadcastAnyEvent(any: T) {
        broadcastTextEvent(GlobalJson.encodeToString(any))
    }

    fun broadcastTextEvent(text: String) {
        broadcast(text, eventReceivers)
    }

    init {
        if (heartbeatInterval > 0) {
            timer("heartbeat", true, 0, heartbeatInterval) {
                val runtime = AppRuntimeFetcher.appRuntime
                val curUin = runtime.currentAccountUin
                LogCenter.log("WebSocket心跳: $curUin", Level.DEBUG)
                broadcastAnyEvent(
                    PushMetaEvent(
                        time = System.currentTimeMillis() / 1000,
                        selfId = app.longAccountUin,
                        postType = PostType.Meta,
                        type = MetaEventType.Heartbeat,
                        subType = MetaSubType.Connect,
                        status = BotStatus(
                            Self("qq", curUin.toLong()),
                            runtime.isLogin,
                            status = "正常",
                            good = true
                        ),
                        interval = heartbeatInterval
                    )
                )
            }
        } else {
            LogCenter.log("主动WebSocket心跳间隔为0，不启动心跳", Level.WARN)
        }
    }

    override fun onClose(conn: WebSocket, code: Int, reason: String, remote: Boolean) {
        val path = URI.create(conn.resourceDescriptor).path
        if (path != "/api") {
            eventReceivers.remove(conn)
        }
        runCatching {
            conn.remoteSocketAddress.address.hostAddress to conn.remoteSocketAddress.port
        }.onSuccess {
            LogCenter.log({ "WSServer断开(${it.first}:${it.second}$path): $code,$reason,$remote" }, Level.WARN)
        }.onFailure {
            LogCenter.log({ "WSServer断开($path): $code,$reason,$remote" }, Level.WARN)
        }
    }

    override fun onMessage(conn: WebSocket, message: String) {
        val path = URI.create(conn.resourceDescriptor).path
        GlobalScope.launch {
            onHandleAction(conn, message, path)
        }
    }

    private suspend fun onHandleAction(conn: WebSocket, message: String, path: String) {
        val respond = kotlin.runCatching {
            val actionObject = Json.parseToJsonElement(message).asJsonObject
            if (actionObject["post_type"].asStringOrNull == "meta_event") {
                // 防止二比把元事件push回来
                return
            }
            val action = actionObject["action"].asString
            val echo = actionObject["echo"] ?: EmptyJsonString
            val params = actionObject["params"].asJsonObjectOrNull ?: EmptyJsonObject

            val handler = ActionManager[action]
            handler?.handle(ActionSession(params, echo))
                ?: resultToString(false, Status.UnsupportedAction, EmptyObject, "不支持的Action", echo = echo)
        }.getOrNull()
        respond?.let { conn.send(it) }
    }

    override fun onError(conn: WebSocket, ex: Exception?) {
        LogCenter.log("WSServer Error: " + ex?.stackTraceToString(), Level.ERROR)
        cancelFlowJobs()
    }

    override fun onStart() {
        LogCenter.log("WSServer start running on ws://${getAddress()}!")
        initTransmitter()
    }

    protected suspend inline fun <reified T> pushTo(body: T) {
        if(!allowTransmit()) return
        try {
            sendLock.withLock {
                broadcastTextEvent(GlobalJson.encodeToString(body))
            }
        } catch (e: Throwable) {
            LogCenter.log("WS推送失败: ${e.stackTraceToString()}", Level.ERROR)
        }
    }
 }