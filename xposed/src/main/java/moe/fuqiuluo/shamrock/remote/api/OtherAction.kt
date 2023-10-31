package moe.fuqiuluo.shamrock.remote.api

import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import moe.fuqiuluo.shamrock.remote.action.handlers.CleanCache
import moe.fuqiuluo.shamrock.remote.action.handlers.DownloadFile
import moe.fuqiuluo.shamrock.remote.action.handlers.GetDeviceBattery
import moe.fuqiuluo.shamrock.remote.action.handlers.GetVersionInfo
import moe.fuqiuluo.shamrock.remote.action.handlers.RestartMe
import moe.fuqiuluo.shamrock.remote.entries.Status
import moe.fuqiuluo.shamrock.remote.service.config.ShamrockConfig
import moe.fuqiuluo.shamrock.tools.fetchOrNull
import moe.fuqiuluo.shamrock.tools.fetchOrThrow
import moe.fuqiuluo.shamrock.tools.getOrPost
import moe.fuqiuluo.shamrock.tools.respond

fun Routing.otherAction() {

    getOrPost("/get_version_info") {
        call.respondText(GetVersionInfo())
    }

    getOrPost("/get_device_battery") {
        call.respondText(GetDeviceBattery())
    }

    getOrPost("/clean_cache") {
        call.respondText(CleanCache())
    }

    getOrPost("/set_restart") {
        call.respondText(RestartMe(2000))
    }

    getOrPost("/download_file") {
        val url = fetchOrThrow("url")
        val threadCnt = fetchOrNull("thread_cnt")?.toInt() ?: 0
        val headers = fetchOrNull("headers") ?: ""
        call.respondText(DownloadFile(url, threadCnt, headers.split("\r\n")))
    }

    getOrPost("/config/set_boolean") {
        val key = fetchOrThrow("key")
        val value = fetchOrThrow("value").toBooleanStrict()
        ShamrockConfig[key] = value
        respond(true, Status.Ok, "success")
    }

    getOrPost("/config/set_int") {
        val key = fetchOrThrow("key")
        val value = fetchOrThrow("value").toInt()
        ShamrockConfig[key] = value
        respond(true, Status.Ok, "success")
    }

    getOrPost("/config/set_string") {
        val key = fetchOrThrow("key")
        val value = fetchOrThrow("value")
        ShamrockConfig[key] = value
        respond(true, Status.Ok, "success")
    }
}