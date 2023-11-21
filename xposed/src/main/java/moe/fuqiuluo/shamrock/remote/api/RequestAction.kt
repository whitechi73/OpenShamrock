package moe.fuqiuluo.shamrock.remote.api

import io.ktor.http.ContentType
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import moe.fuqiuluo.shamrock.remote.action.handlers.SetFriendAddRequest
import moe.fuqiuluo.shamrock.remote.action.handlers.SetGroupAddRequest
import moe.fuqiuluo.shamrock.tools.fetchOrNull
import moe.fuqiuluo.shamrock.tools.fetchOrThrow
import moe.fuqiuluo.shamrock.tools.getOrPost

fun Routing.requestRouter() {
    getOrPost("/set_friend_add_request") {
        val flag = fetchOrThrow("flag")
        val approve = fetchOrNull("approve")?.toBooleanStrict() ?: true
        val remark = fetchOrNull("remark")
        val notSeen = fetchOrNull("not_seen")?.toBooleanStrict() ?: false

        call.respondText(
            SetFriendAddRequest(flag, approve, remark, notSeen),
            ContentType.Application.Json
        )
    }

    getOrPost("/set_group_add_request") {
        val flag = fetchOrThrow("flag")
        val approve = fetchOrNull("approve")?.toBooleanStrict() ?: true
        val remark = fetchOrNull("reason")
        val subType = fetchOrNull("sub_type")
        val notSeen = fetchOrNull("not_seen")?.toBooleanStrict() ?: false

        call.respondText(
            SetGroupAddRequest(flag, approve, subType ?: "add", remark, notSeen),
            ContentType.Application.Json
        )
    }

}