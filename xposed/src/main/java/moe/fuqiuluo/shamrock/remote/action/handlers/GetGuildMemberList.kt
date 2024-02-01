@file:OptIn(ExperimentalSerializationApi::class)

package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.protobuf.ProtoBuf
import moe.fuqiuluo.qqinterface.servlet.GProSvc
import moe.fuqiuluo.qqinterface.servlet.structures.GetGuildMemberListNextToken
import moe.fuqiuluo.qqinterface.servlet.structures.GuildMemberInfo
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.tools.hex2ByteArray
import moe.fuqiuluo.shamrock.tools.toHexString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_guild_member_list")
internal object GetGuildMemberList: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val guildId = session.getString("guild_id")
        val all = session.getBooleanOrDefault("all", false)
        return invoke(guildId.toULong(), all, session.getStringOrNull("next_token") ?: "", session.echo)
    }

    suspend operator fun invoke(guildId: ULong, all: Boolean, nextTokenStr: String, echo: JsonElement = EmptyJsonString): String {
        val curNextToken = if (nextTokenStr.isEmpty()) null else ProtoBuf.decodeFromByteArray<GetGuildMemberListNextToken>(nextTokenStr.hex2ByteArray())
        val result = GProSvc.getGuildMemberList(
            guildId = guildId,
            fetchAll = all,
            startIndex = curNextToken?.startIndex ?: 0,
            roleIndex = curNextToken?.roleIndex ?: 1,
            count = 50
        )
        result.onFailure {
            return error(it.message ?: "unable to fetch guild member list", echo)
        }
        val nextToken = result.getOrThrow().first
        val members = arrayListOf<GuildMemberInfo>()
        result.getOrThrow().second.forEach {
            it.members.forEach { user ->
                members.add(GuildMemberInfo(
                    tinyId = user.tinyId,
                    title = user.memberName,
                    nickname = user.nickName,
                    roleId = user.roleManagementTag.roleId,
                    roleName = user.roleManagementTag.tagName,
                    roleColor = user.roleManagementTag.color,
                    joinTime = user.joinTime,
                    robotType = user.robotType,
                    type = user.type,
                    inBlack = user.inBlack,
                    platform = user.platform
                ))
            }
        }
        return ok(GetGuildMemberListResult(
            members = members,
            finish = nextToken.finish,
            nextToken = ProtoBuf.encodeToByteArray(nextToken).toHexString(),
        ))
    }

    override val requiredParams: Array<String> = arrayOf("guild_id")

    @Serializable
    data class GetGuildMemberListResult(
        @SerialName("members") val members: List<GuildMemberInfo>,
        @SerialName("next_token") val nextToken: String,
        @SerialName("finished") val finish: Boolean
    )
}