package moe.fuqiuluo.shamrock.remote.api

import com.tencent.mobileqq.profilecard.api.IProfileCardBlacklistApi
import com.tencent.mobileqq.qroute.QRoute
import io.ktor.http.ContentType
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import moe.fuqiuluo.shamrock.remote.action.handlers.GetFriendList
import moe.fuqiuluo.shamrock.remote.action.handlers.GetFriendSystemMsg
import moe.fuqiuluo.shamrock.remote.action.handlers.GetStrangerInfo
import moe.fuqiuluo.shamrock.remote.action.handlers.IsBlackListUin
import moe.fuqiuluo.shamrock.tools.fetchGetOrThrow
import moe.fuqiuluo.shamrock.tools.fetchOrNull
import moe.fuqiuluo.shamrock.tools.fetchOrThrow
import moe.fuqiuluo.shamrock.tools.getOrPost

fun Routing.friendAction() {
    getOrPost("/get_stranger_info") {
        val userId = fetchOrThrow("user_id").toLong()
        call.respondText(GetStrangerInfo(userId), ContentType.Application.Json)
    }

    getOrPost("/get_friend_list") {
        val refresh = fetchOrNull("no_cache")?.toBooleanStrict()
            ?: fetchOrNull("refresh")?.toBooleanStrict() ?: false
        call.respondText(GetFriendList(refresh), ContentType.Application.Json)
    }

    getOrPost("/is_blacklist_uin") {
        val userId = fetchOrThrow("user_id").toLong()
        call.respondText(IsBlackListUin(userId), ContentType.Application.Json)
    }

    getOrPost("/get_friend_system_msg") {
        call.respondText(GetFriendSystemMsg(), ContentType.Application.Json)
    }

}