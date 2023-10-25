package moe.fuqiuluo.shamrock.remote.api

import moe.fuqiuluo.qqinterface.servlet.TicketSvc
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import moe.fuqiuluo.shamrock.remote.action.handlers.*
import moe.fuqiuluo.shamrock.remote.entries.Status
import moe.fuqiuluo.shamrock.tools.*

fun Routing.ticketActions() {
    getOrPost("/get_http_cookies") {
        val appid =fetchOrThrow("appid")
        val daid = fetchOrThrow("daid")
        val jumpurl = fetchOrThrow("jumpurl")
        call.respondText(GetHttpCookies(appid, daid, jumpurl))
    }

    getOrPost("/get_credentials") {
        val domain = fetchOrNull("domain")
        if (domain != null) {
            call.respondText(GetCredentials(domain))
        } else {
            call.respondText(GetCredentials())
        }
    }

    getOrPost("/get_cookies") {
        val domain = fetchOrNull("domain")
        if (domain != null) {
            call.respondText(GetCookies(domain = domain))
        } else {
            call.respondText(GetCookies())
        }
    }

    getOrPost("/get_csrf_token") {
        val domain = fetchOrNull("domain")
        if (domain != null) {
            call.respondText(GetCSRF(domain))
        } else {
            call.respondText(GetCSRF())
        }
    }

    getOrPost("/get_ticket") {
        val uin = fetchOrThrow("uin")
        val ticket = when(val id = fetchOrThrow("id").toInt()) {
            32 -> TicketSvc.getStWeb(uin)
            else -> {
                respond(true, Status.Ok, data = TicketSvc.getTicket(uin, id)?.let {
                    mapOf(
                        "sig" to (it._sig?.toHexString() ?: "null"),
                        "key" to (it._sig_key?.toHexString() ?: "null")
                    ).json.asJsonObject
                } ?: EmptyJsonObject)
                return@getOrPost
            }
        }
        respond(true, Status.Ok, data = ticket)
    }
}