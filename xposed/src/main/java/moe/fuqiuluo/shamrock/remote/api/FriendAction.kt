package moe.fuqiuluo.shamrock.remote.api

import com.tencent.mobileqq.profilecard.api.IProfileCardBlacklistApi
import com.tencent.mobileqq.qroute.QRoute
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import moe.fuqiuluo.shamrock.remote.action.handlers.GetFriendList
import moe.fuqiuluo.shamrock.remote.action.handlers.GetStrangerInfo
import moe.fuqiuluo.shamrock.remote.action.handlers.IsBlackListUin
import moe.fuqiuluo.shamrock.tools.fetchGetOrThrow
import moe.fuqiuluo.shamrock.tools.fetchOrNull
import moe.fuqiuluo.shamrock.tools.fetchOrThrow
import moe.fuqiuluo.shamrock.tools.getOrPost

fun Routing.friendAction() {
    getOrPost("/get_stranger_info") {
        val uin = fetchOrThrow("user_id")
        call.respondText(GetStrangerInfo(uin))
    }

    getOrPost("/get_friend_list") {
        val refresh = fetchOrNull("refresh")?.toBooleanStrictOrNull() ?: false
        call.respondText(GetFriendList(refresh))
    }

    getOrPost("/is_blacklist_uin") {
        val uin = fetchOrThrow("user_id")
        call.respondText(IsBlackListUin(uin))
    }
}