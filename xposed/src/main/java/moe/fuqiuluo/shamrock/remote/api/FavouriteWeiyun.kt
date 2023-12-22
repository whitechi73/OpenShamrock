package moe.fuqiuluo.shamrock.remote.api

import io.ktor.http.ContentType
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import moe.fuqiuluo.shamrock.remote.action.handlers.FavAddImageMsg
import moe.fuqiuluo.shamrock.remote.action.handlers.FavAddRichMediaMsg
import moe.fuqiuluo.shamrock.remote.action.handlers.GetFriendList
import moe.fuqiuluo.shamrock.remote.action.handlers.GetFriendSystemMsg
import moe.fuqiuluo.shamrock.remote.action.handlers.GetStrangerInfo
import moe.fuqiuluo.shamrock.remote.action.handlers.IsBlackListUin
import moe.fuqiuluo.shamrock.tools.fetchOrNull
import moe.fuqiuluo.shamrock.tools.fetchOrThrow
import moe.fuqiuluo.shamrock.tools.getOrPost

// fav.add_rich_media_msg

fun Routing.fav() {
    getOrPost("/fav/add_rich_media_msg") {
        val uin = call.fetchOrThrow("user_id").toLong()
        val nickName = call.fetchOrThrow("nick")
        val time = call.fetchOrNull("time")?.toLong() ?: System.currentTimeMillis()
        val content = call.fetchOrThrow("content")
        val groupName = call.fetchOrNull("group_name") ?: ""
        val groupId = call.fetchOrNull("group_id")?.toLong() ?: 0L
        call.respondText(FavAddRichMediaMsg(uin, nickName, time, content, groupName, groupId), ContentType.Application.Json)
    }

    getOrPost("/fav/add_image_msg") {
        val uin = call.fetchOrThrow("user_id").toLong()
        val nickName = call.fetchOrThrow("nick")
        val file = call.fetchOrThrow("file")
        val groupName = call.fetchOrNull("groupName") ?: ""
        val groupId = call.fetchOrNull("group_id")?.toLong() ?: 0L
        call.respondText(FavAddImageMsg(uin, nickName, file, groupName, groupId), ContentType.Application.Json)
    }
}