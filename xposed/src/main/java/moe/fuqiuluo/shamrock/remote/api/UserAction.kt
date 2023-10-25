package moe.fuqiuluo.shamrock.remote.api

import moe.fuqiuluo.shamrock.helper.LogicException
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import moe.fuqiuluo.shamrock.remote.action.ActionManager
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.handlers.*
import moe.fuqiuluo.shamrock.tools.*
import moe.fuqiuluo.shamrock.utils.PlatformUtils

fun Routing.userAction() {
    getOrPost("/set_group_leave") {
        val group = fetchOrThrow("group_id")
        call.respondText(LeaveTroop(group))
    }

    getOrPost("/_get_online_clients") {
        call.respondText(GetOnlineClients())
    }

    getOrPost("/_get_model_show") {
        val model = fetchOrThrow("model")
        call.respondText(GetModelShowList(model))
    }

    getOrPost("/_set_model_show") {
        val model = fetchOrThrow("model")
        val manu = fetchOrNull("manu") ?: fetchOrThrow("model_show")
        val modelshow = fetchOrNull("modelshow") ?: "Android"
        val imei = fetchOrNull("imei") ?: PlatformUtils.getAndroidID()
        val show = fetchOrNull("show")?.toBooleanStrictOrNull() ?: true
        call.respondText(SetModelShow(model, manu, modelshow, imei, show))
    }

    getOrPost("/get_model_show") {
        val uin = fetchOrNull("user_id")
        call.respondText(GetModelShow(uin?.toLong() ?: 0))
    }

    getOrPost("/send_like") {
        val uin = fetchOrThrow("user_id")
        val cnt = fetchOrThrow("times")
        call.respondText(SendLike(
            uin.toLong(),
            cnt.toInt()
        ))
    }
}