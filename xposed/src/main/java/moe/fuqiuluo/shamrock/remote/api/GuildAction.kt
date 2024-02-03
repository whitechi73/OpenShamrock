package moe.fuqiuluo.shamrock.remote.api

import io.ktor.http.ContentType
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.remote.action.handlers.CreateGuildRole
import moe.fuqiuluo.shamrock.remote.action.handlers.DeleteGuildRole
import moe.fuqiuluo.shamrock.remote.action.handlers.GetGProChannelList
import moe.fuqiuluo.shamrock.remote.action.handlers.GetGuildFeeds
import moe.fuqiuluo.shamrock.remote.action.handlers.GetGuildList
import moe.fuqiuluo.shamrock.remote.action.handlers.GetGuildMemberList
import moe.fuqiuluo.shamrock.remote.action.handlers.GetGuildMemberProfile
import moe.fuqiuluo.shamrock.remote.action.handlers.GetGuildMetaByGuest
import moe.fuqiuluo.shamrock.remote.action.handlers.GetGuildRoles
import moe.fuqiuluo.shamrock.remote.action.handlers.GetGuildServiceProfile
import moe.fuqiuluo.shamrock.remote.action.handlers.SendGuildMessage
import moe.fuqiuluo.shamrock.remote.action.handlers.SendMessage
import moe.fuqiuluo.shamrock.remote.action.handlers.SetGuildMemberRole
import moe.fuqiuluo.shamrock.remote.action.handlers.UpdateGuildRole
import moe.fuqiuluo.shamrock.tools.fetchGetOrNull
import moe.fuqiuluo.shamrock.tools.fetchGetOrThrow
import moe.fuqiuluo.shamrock.tools.fetchOrNull
import moe.fuqiuluo.shamrock.tools.fetchOrThrow
import moe.fuqiuluo.shamrock.tools.fetchPostJsonArray
import moe.fuqiuluo.shamrock.tools.fetchPostJsonObject
import moe.fuqiuluo.shamrock.tools.fetchPostJsonString
import moe.fuqiuluo.shamrock.tools.fetchPostOrNull
import moe.fuqiuluo.shamrock.tools.fetchPostOrThrow
import moe.fuqiuluo.shamrock.tools.getOrPost
import moe.fuqiuluo.shamrock.tools.isJsonData
import moe.fuqiuluo.shamrock.tools.isJsonObject
import moe.fuqiuluo.shamrock.tools.isJsonString
import moe.fuqiuluo.shamrock.tools.jsonArray

fun Routing.guildAction() {
    getOrPost("/get_guild_service_profile") {
        call.respondText(GetGuildServiceProfile(), ContentType.Application.Json)
    }

    getOrPost("/get_guild_list") {
        val refresh = fetchGetOrNull("refresh") ?: fetchOrNull("no_cache")
        call.respondText(GetGuildList(refresh?.toBoolean() ?: false, false), ContentType.Application.Json)
    }

    getOrPost("/get_guild_member_list") {
        val guildId = fetchOrThrow("guild_id")
        val all = fetchGetOrNull("all")?.toBoolean() ?: false
        call.respondText(GetGuildMemberList(guildId.toULong(), all, fetchOrNull("next_token") ?: ""), ContentType.Application.Json)
    }

    getOrPost("/get_guild_meta_by_guest") {
        val guildId = fetchOrThrow("guild_id")
        call.respondText(GetGuildMetaByGuest(guildId.toULong()), ContentType.Application.Json)
    }

    getOrPost("/get_guild_channel_list") {
        val guildId = fetchOrThrow("guild_id")
        val refresh = fetchGetOrNull("refresh") ?: fetchOrNull("no_cache")
        call.respondText(GetGProChannelList(guildId.toULong(), refresh?.toBoolean() ?: false), ContentType.Application.Json)
    }

    getOrPost("/get_guild_member_profile") {
        val guildId = fetchOrThrow("guild_id")
        val userId = fetchOrThrow("user_id")
        call.respondText(GetGuildMemberProfile(guildId.toULong(), userId.toULong()), ContentType.Application.Json)
    }

    route("/(send_guild_channel_msg|send_guild_message|send_guild_msg)".toRegex()) {
        get {
            val guildId = fetchGetOrThrow("guild_id").toULong()
            val channelId = fetchGetOrThrow("channel_id").toULong()
            val message = fetchGetOrThrow("message")
            val autoEscape = fetchGetOrNull("auto_escape")?.toBoolean() ?: false
            val retryCnt = fetchGetOrNull("retry_cnt")?.toInt() ?: 3
            val recallDuration = fetchGetOrNull("recall_duration")?.toLong()
            call.respondText(SendGuildMessage(guildId, channelId, message, autoEscape, retryCnt, recallDuration), ContentType.Application.Json)
        }
        post {
            val retryCnt = fetchOrNull("retry_cnt")?.toInt() ?: 3
            val recallDuration = fetchOrNull("recall_duration")?.toLong()
            val guildId = fetchOrThrow("guild_id").toULong()
            val channelId = fetchOrThrow("channel_id").toULong()
            call.respondText(if (isJsonData() && !isJsonString("message")) {
                if (isJsonObject("message")) {
                    SendGuildMessage(
                        guildId = guildId,
                        channelId = channelId,
                        message = listOf(fetchPostJsonObject("message")).jsonArray,
                        retryCnt = retryCnt,
                        recallDuration = recallDuration
                    )
                } else {
                    SendGuildMessage(
                        guildId = guildId,
                        channelId = channelId,
                        message = fetchPostJsonArray("message"),
                        retryCnt = retryCnt,
                        recallDuration = recallDuration
                    )
                }
            } else {
                val autoEscape = fetchPostOrNull("auto_escape")?.toBooleanStrict() ?: false
                SendGuildMessage(
                    guildId = guildId,
                    channelId = channelId,
                    message = fetchOrThrow("message"),
                    autoEscape = autoEscape,
                    retryCnt = retryCnt,
                    recallDuration = recallDuration
                )
            }, ContentType.Application.Json)
        }
    }

    getOrPost("/get_guild_feeds") {
        val guildId = fetchOrThrow("guild_id").toULong()
        val channelId = fetchOrNull("channel_id")?.toULong() ?: 0uL
        val from = fetchOrNull("from")?.toInt() ?: 0
        call.respondText(GetGuildFeeds(guildId, channelId, from), ContentType.Application.Json)
    }

    getOrPost("/get_guild_roles") {
        val guildId = fetchOrThrow("guild_id").toULong()
        call.respondText(GetGuildRoles(guildId), ContentType.Application.Json)
    }

    getOrPost("/delete_guild_role") {
        val guildId = fetchOrThrow("guild_id").toULong()
        val roleId = fetchOrThrow("role_id").toULong()
        call.respondText(DeleteGuildRole(guildId, roleId), ContentType.Application.Json)
    }

    getOrPost("/set_guild_member_role") {
        val guildId = fetchOrThrow("guild_id").toULong()
        val roleId = fetchOrThrow("role_id").toULong()
        val set = fetchOrNull("set")?.toBoolean() ?: false
        val userId = fetchOrNull("user_id")?.toULong()
        val users = fetchOrNull("users")?.split(",")?.map { it.toULong() }
        call.respondText(
            if (userId != null) {
                SetGuildMemberRole(guildId, userId, roleId, set)
            } else if (users != null) {
                SetGuildMemberRole(guildId, users, roleId, set)
            } else {
                throw IllegalArgumentException("missing user_id or users")
            },
            ContentType.Application.Json
        )
    }

    getOrPost("/update_guild_role") {
        val guildId = fetchOrThrow("guild_id").toULong()
        val roleId = fetchOrThrow("role_id").toULong()
        val name = fetchOrThrow("name")
        val color = fetchOrThrow("color").toLong()
        call.respondText(UpdateGuildRole(guildId, roleId, name, color), ContentType.Application.Json)
    }

    getOrPost("/create_guild_role") {
        val guildId = fetchOrThrow("guild_id").toULong()
        val name = fetchOrThrow("name")
        val color = fetchOrThrow("color").toLong()
        val initialUsers = fetchOrThrow("initial_users").split(",").map { it.toULong() }
        call.respondText(CreateGuildRole(guildId, color, name, initialUsers), ContentType.Application.Json)
    }
}