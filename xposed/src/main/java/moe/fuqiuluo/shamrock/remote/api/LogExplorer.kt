package moe.fuqiuluo.shamrock.remote.api

import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import moe.fuqiuluo.shamrock.tools.fetchOrNull
import moe.fuqiuluo.shamrock.tools.getOrPost
import moe.fuqiuluo.shamrock.helper.LogCenter

fun Routing.showLog() {
    getOrPost("/log") {
        val start = fetchOrNull("start")?.toIntOrNull() ?: 0
        val recent =fetchOrNull("recent")?.toBooleanStrictOrNull() ?: false
        val log = LogCenter.getLogLines(start, recent)
        call.respondText(log.joinToString("\n"))
    }
}