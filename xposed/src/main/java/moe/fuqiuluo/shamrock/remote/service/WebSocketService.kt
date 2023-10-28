@file:OptIn(DelicateCoroutinesApi::class)

package moe.fuqiuluo.shamrock.remote.service

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import moe.fuqiuluo.shamrock.helper.ErrorTokenException
import moe.fuqiuluo.shamrock.remote.service.api.WebSocketTransmitServlet
import moe.fuqiuluo.shamrock.remote.service.config.ShamrockConfig
import moe.fuqiuluo.shamrock.remote.service.data.BotStatus
import moe.fuqiuluo.shamrock.remote.service.data.Self
import moe.fuqiuluo.shamrock.remote.service.data.push.*
import moe.fuqiuluo.shamrock.tools.ifNullOrEmpty
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.remote.service.api.GlobalEventTransmitter
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import org.java_websocket.WebSocket
import org.java_websocket.handshake.ClientHandshake
import java.net.URI

internal class WebSocketService(port: Int): WebSocketTransmitServlet(port) {
    private val eventJobList = mutableSetOf<Job>()

    override fun submitFlowJob(job: Job) {
        eventJobList.add(job)
    }

    override fun initTransmitter() {
        submitFlowJob(GlobalScope.launch {
            GlobalEventTransmitter.onMessageEvent { (_, event) ->
                pushTo(event)
            }
        })
        submitFlowJob(GlobalScope.launch {
            GlobalEventTransmitter.onNoticeEvent { event ->
                pushTo(event)
            }
        })
        LogCenter.log("WebSocketService: 初始化服务", Level.WARN)
    }

    override fun cancelFlowJobs() {
        eventJobList.removeIf { job ->
            job.cancel()
            return@removeIf true
        }
        LogCenter.log("WebSocketService: 释放服务", Level.WARN)
    }

    override fun onOpen(conn: WebSocket, handshake: ClientHandshake) {
        val token = ShamrockConfig.getToken()
        if (token.isNotBlank()) {
            var accessToken = handshake.getFieldValue("access_token")
                .ifNullOrEmpty(handshake.getFieldValue("ticket"))
                .ifNullOrEmpty(handshake.getFieldValue("Authorization"))
                ?: throw ErrorTokenException
            if (accessToken.startsWith("Bearer ")) {
                accessToken = accessToken.substring(7)
            }
            if (token != accessToken) {
                conn.close()
                LogCenter.log({ "WSServer连接错误(${conn.remoteSocketAddress.address.hostAddress}:${conn.remoteSocketAddress.port}) 没有提供正确的token, $accessToken。" }, Level.ERROR)
                return
            }
        }
        val path = URI.create(handshake.resourceDescriptor).path
        if (path != "/api") {
            pushMetaLifecycle()
            eventReceivers.add(conn)
        }
        LogCenter.log({ "WSServer连接(${conn.remoteSocketAddress.address.hostAddress}:${conn.remoteSocketAddress.port}$path)" }, Level.WARN)
    }

    private fun pushMetaLifecycle() {
        GlobalScope.launch {
            val runtime = AppRuntimeFetcher.appRuntime
            val curUin = runtime.currentAccountUin
            pushTo(PushMetaEvent(
                time = System.currentTimeMillis() / 1000,
                selfId = app.longAccountUin,
                postType = PostType.Meta,
                type = MetaEventType.LifeCycle,
                subType = MetaSubType.Connect,
                status = BotStatus(
                    Self("qq", curUin.toLong()), runtime.isLogin, status = "正常", good = true
                ),
                interval = 15000
            ))
        }
    }
}