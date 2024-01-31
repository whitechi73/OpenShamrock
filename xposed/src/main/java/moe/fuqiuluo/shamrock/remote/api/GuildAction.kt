package moe.fuqiuluo.shamrock.remote.api

import io.ktor.http.ContentType
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import moe.fuqiuluo.shamrock.remote.action.handlers.GetGuildList
import moe.fuqiuluo.shamrock.remote.action.handlers.GetGuildMemberList
import moe.fuqiuluo.shamrock.remote.action.handlers.GetGuildMetaByGuest
import moe.fuqiuluo.shamrock.remote.action.handlers.GetGuildServiceProfile
import moe.fuqiuluo.shamrock.tools.fetchOrThrow
import moe.fuqiuluo.shamrock.tools.getOrPost

fun Routing.guildAction() {
    getOrPost("/get_guild_service_profile") {
        call.respondText(GetGuildServiceProfile(), ContentType.Application.Json)
    }

    getOrPost("/get_guild_list") {
        call.respondText(GetGuildList(), ContentType.Application.Json)
    }

    getOrPost("/get_guild_member_list") {
        val guildId = fetchOrThrow("guild_id")
        call.respondText(GetGuildMemberList(guildId.toULong()), ContentType.Application.Json)
    }

    getOrPost("/get_guild_meta_by_guest") {
        val guildId = fetchOrThrow("guild_id")
        call.respondText(GetGuildMetaByGuest(guildId.toULong()), ContentType.Application.Json)
    }
}