package moe.fuqiuluo.shamrock.remote.service.api

import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.remote.service.config.ShamrockConfig
import java.util.Collections

internal object GlobalPusher {
    private val cacheConn = Collections.synchronizedMap(mutableMapOf<String, BasePushServlet>())

    fun register(servlet: BasePushServlet){
        if (ShamrockConfig.isIgnoreAllEvent()) {
            return
        }
        LogCenter.log("推送器注册(id = ${servlet.id}): ${servlet.toString().split(".").last()}", Level.WARN)
        if (!cacheConn.containsKey(servlet.id) && !cacheConn.containsValue(servlet)) {
            cacheConn[servlet.id] = servlet
        }
    }

    fun unregister(servlet: BasePushServlet){
        LogCenter.log("推送器注销(id = ${servlet.id}): ${servlet.toString().split(".").last()}", Level.WARN)
        if (cacheConn.containsKey(servlet.id) || cacheConn.containsValue(servlet)) {
            cacheConn.remove(servlet.id)
        }
    }

    operator fun invoke(): List<BasePushServlet> {
        return cacheConn.map { it.value }
    }
}



