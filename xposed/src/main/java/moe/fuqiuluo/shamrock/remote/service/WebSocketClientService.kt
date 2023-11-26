@file:OptIn(DelicateCoroutinesApi::class)

package moe.fuqiuluo.shamrock.remote.service

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import moe.fuqiuluo.shamrock.remote.service.api.WebSocketClientServlet
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.remote.service.api.GlobalEventTransmitter

internal class WebSocketClientService(
    override val address: String,
    heartbeatInterval: Long,
    wsHeaders: Map<String, String>
) : WebSocketClientServlet(address, heartbeatInterval, wsHeaders) {
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
        submitFlowJob(GlobalScope.launch {
            GlobalEventTransmitter.onRequestEvent { event ->
                pushTo(event)
            }
        })
        LogCenter.log("WebSocketClientService: 初始化服务", Level.WARN)
    }

    override fun cancelFlowJobs() {
        eventJobList.removeIf { job ->
            job.cancel()
            return@removeIf true
        }
        LogCenter.log("WebSocketClientService: 释放服务", Level.WARN)
    }
}