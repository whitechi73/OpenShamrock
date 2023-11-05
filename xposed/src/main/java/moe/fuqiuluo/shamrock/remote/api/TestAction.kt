package moe.fuqiuluo.shamrock.remote.api

import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import moe.fuqiuluo.shamrock.tools.fetch
import moe.fuqiuluo.shamrock.tools.fetchOrThrow
import moe.fuqiuluo.shamrock.xposed.helper.NTServiceFetcher

fun Routing.testAction() {

    get("/test/createUidFromTinyId") {
        val selfId = fetchOrThrow("selfId").toLong()
        val peerId = fetchOrThrow("peerId").toLong()
        call.respondText(NTServiceFetcher.kernelService.wrapperSession.msgService.createUidFromTinyId(selfId, peerId))
    }

}