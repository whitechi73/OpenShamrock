package moe.fuqiuluo.shamrock.remote.api

import io.ktor.http.ContentType
import moe.fuqiuluo.shamrock.helper.LogicException
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import moe.fuqiuluo.shamrock.remote.action.ActionManager
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.handlers.*
import moe.fuqiuluo.shamrock.tools.fetchOrNull
import moe.fuqiuluo.shamrock.tools.fetchOrThrow
import moe.fuqiuluo.shamrock.tools.getOrPost

fun Routing.troopAction() {
    getOrPost("/get_prohibited_member_list") {
        val groupId = fetchOrThrow("group_id").toLong()
        call.respondText(GetProhibitedMemberList(groupId), ContentType.Application.Json)
    }

    getOrPost("/group_touch") {
        val groupId = fetchOrThrow("group_id")
        val userId = fetchOrThrow("user_id")
        call.respondText(GroupPoke(groupId, userId), ContentType.Application.Json)
    }

    getOrPost("/get_group_honor_info") {
        val groupId = fetchOrThrow("group_id")
        val refresh = fetchOrNull("no_cache")?.toBooleanStrict()
            ?: fetchOrNull("refresh")?.toBooleanStrict() ?: false
        call.respondText(GetTroopHonor(groupId, refresh), ContentType.Application.Json)
    }

    getOrPost("/get_group_member_list") {
        val groupId = fetchOrThrow("group_id")
        val refresh = fetchOrNull("no_cache")?.toBooleanStrict()
            ?: fetchOrNull("refresh")?.toBooleanStrict() ?: false
        call.respondText(GetTroopMemberList(groupId, refresh), ContentType.Application.Json)
    }

    getOrPost("/get_group_member_info") {
        val groupId = fetchOrThrow("group_id")
        val userId = fetchOrThrow("user_id")
        val refresh = fetchOrNull("no_cache")?.toBooleanStrict()
            ?: fetchOrNull("refresh")?.toBooleanStrict() ?: false
        call.respondText(GetTroopMemberInfo(groupId, userId, refresh), ContentType.Application.Json)
    }

    getOrPost("/get_group_list") {
        val refresh = fetchOrNull("refresh")?.toBooleanStrict()
            ?: fetchOrNull("refresh")?.toBooleanStrict() ?: true
        call.respondText(GetTroopList(refresh), ContentType.Application.Json)
    }

    getOrPost("/get_group_info") {
        val groupId = fetchOrThrow("group_id")
        val refresh = fetchOrNull("no_cache")?.toBooleanStrict()
            ?: fetchOrNull("refresh")?.toBooleanStrict() ?: false
        call.respondText(GetTroopInfo(groupId, refresh), ContentType.Application.Json)
    }

    getOrPost("/set_group_special_title") {
        val groupId = fetchOrThrow("group_id")
        val userId = fetchOrThrow("user_id")
        val title = fetchOrThrow("special_title")
        call.respondText(SetGroupUnique(groupId, userId, title), ContentType.Application.Json)
    }

    getOrPost("/set_group_name") {
        val groupId = fetchOrThrow("group_id")
        val card = fetchOrThrow("group_name")
        call.respondText(ModifyTroopName(groupId, card), ContentType.Application.Json)
    }

    getOrPost("/set_group_card") {
        val groupId = fetchOrThrow("group_id")
        val userId = fetchOrThrow("user_id")
        val card = fetchOrNull("card") ?: ""
        call.respondText(ModifyTroopMemberName(groupId, userId, card), ContentType.Application.Json)
    }

    getOrPost("/set_group_admin") {
        val groupId = fetchOrThrow("group_id") .toLong()
        val userId = fetchOrThrow("user_id") .toLong()
        val enable = fetchOrThrow("enable").toBooleanStrict()
        call.respondText(SetGroupAdmin(groupId, userId, enable), ContentType.Application.Json)
    }

    getOrPost("/set_group_whole_ban") {
        val groupId = fetchOrThrow("group_id") .toLong()
        val enable = fetchOrThrow("enable").toBooleanStrict()
        call.respondText(SetGroupWholeBan(groupId, enable), ContentType.Application.Json)
    }

    getOrPost("/set_group_ban") {
        val groupId = fetchOrThrow("group_id") .toLong()
        val userId = fetchOrThrow("user_id") .toLong()
        val duration = fetchOrNull("duration")?.toInt() ?: (30 * 60)

        call.respondText(BanTroopMember(groupId, userId, duration), ContentType.Application.Json)
    }

    getOrPost("/set_group_kick") {
        val userId = fetchOrThrow("user_id").toLong()
        val groupId = fetchOrThrow("group_id").toLong()
        call.respondText(KickTroopMember(groupId, userId), ContentType.Application.Json)
    }

    getOrPost("/set_essence_msg") {
        val messageId = fetchOrThrow("message_id").toInt()
        call.respondText(SetEssenceMessage(messageId), ContentType.Application.Json)
    }

    getOrPost("/delete_essence_msg") {
        val messageId = fetchOrThrow("message_id").toInt()
        call.respondText(DeleteEssenceMessage(messageId), ContentType.Application.Json)
    }

    getOrPost("/get_group_system_msg") {
        call.respondText(GetGroupSystemMsg(), ContentType.Application.Json)
    }

}