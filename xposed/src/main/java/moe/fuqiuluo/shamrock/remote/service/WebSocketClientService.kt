package moe.fuqiuluo.shamrock.remote.service

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import moe.fuqiuluo.shamrock.remote.service.api.WebSocketClientServlet
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.remote.service.api.GlobalEventTransmitter.onMessageEvent
import moe.fuqiuluo.shamrock.remote.service.api.GlobalEventTransmitter.onNoticeEvent
import moe.fuqiuluo.shamrock.remote.service.api.GlobalEventTransmitter.onRequestEvent

internal class WebSocketClientService(
    override val address: String,
    heartbeatInterval: Long,
    wsHeaders: Map<String, String>
) : WebSocketClientServlet(address, heartbeatInterval, wsHeaders) {
    private val subscribes = mutableSetOf<Job>()

    init {
        startHeartbeatTimer()
    }

    override fun subscribe(job: Job) {
        subscribes.add(job)
    }

    override fun init() {
        subscribe(launch {
            onMessageEvent { (_, event) ->
                pushTo(event)
            }
        })
        subscribe(launch {
            onNoticeEvent { event ->
                pushTo(event)
            }
        })
        subscribe(launch {
            onRequestEvent { event ->
                pushTo(event)
            }
        })
        LogCenter.log("WebSocketClientService: 初始化服务", Level.WARN)
    }

    override fun unsubscribe() {
        subscribes.removeIf { job ->
            job.cancel()
            return@removeIf true
        }
        LogCenter.log("WebSocketClientService: 释放服务", Level.WARN)
    }
}