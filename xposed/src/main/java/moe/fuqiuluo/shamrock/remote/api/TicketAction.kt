package moe.fuqiuluo.shamrock.remote.api

import io.ktor.http.ContentType
import moe.fuqiuluo.qqinterface.servlet.TicketSvc
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.remote.action.handlers.*
import moe.fuqiuluo.shamrock.remote.service.config.ShamrockConfig
import moe.fuqiuluo.shamrock.remote.structures.Status
import moe.fuqiuluo.shamrock.tools.*

fun Routing.ticketActions() {
    getOrPost("/get_http_cookies") {
        val appid =fetchOrThrow("appid")
        val daid = fetchOrThrow("daid")
        val jumpurl = fetchOrThrow("jumpurl")
        call.respondText(GetHttpCookies(appid, daid, jumpurl), ContentType.Application.Json)
    }

    getOrPost("/get_credentials") {
        val domain = fetchOrNull("domain")
        if (domain != null) {
            call.respondText(GetCredentials(domain), ContentType.Application.Json)
        } else {
            call.respondText(GetCredentials(), ContentType.Application.Json)
        }
    }

    getOrPost("/get_cookies") {
        val domain = fetchOrNull("domain")
        if (domain != null) {
            call.respondText(GetCookies(domain = domain), ContentType.Application.Json)
        } else {
            call.respondText(GetCookies(), ContentType.Application.Json)
        }
    }

    getOrPost("/get_csrf_token") {
        val domain = fetchOrNull("domain")
        if (domain != null) {
            call.respondText(GetCSRF(domain), ContentType.Application.Json)
        } else {
            call.respondText(GetCSRF(), ContentType.Application.Json)
        }
    }

    fun getTicket(uin: String, id: Int, debug: Boolean = false) = TicketSvc.getTicket(uin, id)?.let {
        mutableMapOf(
            "sig" to (it._sig?.toHexString() ?: "null"),
            "key" to (it._sig_key?.toHexString() ?: "null")
        ).also { map ->
            if (debug)
                map["content"] = ((it._sig?.decodeToString() ?: "") + ":" + (it._sig_key?.decodeToString() ?: "null"))
        }.json.asJsonObject
    } ?: EmptyJsonObject

    getOrPost("/get_ticket") {
        val uin = fetchOrThrow("uin")
        val ticket = when(val id = fetchOrThrow("id").toInt()) {
            32 -> TicketSvc.getStWeb(uin)
            else -> {
                respond(true, Status.Ok, data = getTicket(uin, id))
                return@getOrPost
            }
        }
        respond(true, Status.Ok, data = ticket)
    }

    if (ShamrockConfig.isDev()) getOrPost("/get_all_ticket") {
        val uin = fetchOrThrow("uin")

        val ticketMap = mutableMapOf<Int, JsonElement>()
        TicketSvc.SigType.ALL_TICKET.forEach {
            ticketMap[it] = getTicket(uin, it, true)
        }

        respond(true, Status.Ok, data = ticketMap)
    }
}