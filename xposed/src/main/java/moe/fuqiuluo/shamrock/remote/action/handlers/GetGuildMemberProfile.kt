package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GProSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.tools.ifNullOrEmpty
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_guild_member_profile")
internal object GetGuildMemberProfile: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val guildId = session.getString("guild_id").toULong()
        val userId = session.getString("user_id").toULong()
        return invoke(guildId, userId, session.echo)
    }

    suspend operator fun invoke(guildId: ULong, userId: ULong, echo: JsonElement = EmptyJsonString): String {
        val userResult = GProSvc.getUserGuildInfo(guildId, userId).onFailure {
            return error(it.message ?: "unable to fetch guild member info", echo)
        }.getOrThrow()
        val roles = GProSvc.fetchGuildMemberRoles(guildId, userId).onFailure {
            return error(it.message ?: "unable to fetch guild member roles", echo)
        }.getOrThrow()

        return ok(GetGuildMemberInfo(
            tinyId = userResult.memberTinyid,
            nickname = userResult.nickName ?: "",
            avatarUrl = userResult.url ?: "",
            joinTime = userResult.joinTime,
            roles = roles.map {
                RoleInfo(
                    roleId = it.roleId.toString(),
                    roleName = it.name.ifNullOrEmpty(it.levelDsc.ifNullOrEmpty(it.displayTagName ?: ""))!!,
                    color = it.color,
                    permission = it.rolePermissions.permissionList.map {
                        Permission(
                            rootId = it.rootId,
                            childIds = it.childIds ?: emptyList()
                        )
                    },
                    type = it.type,
                    displayName = it.displayTagName ?: ""
                )
            }
        ), echo = echo)
    }

    override val requiredParams: Array<String> = arrayOf("guild_id", "user_id")

    @Serializable
    data class GetGuildMemberInfo(
        @SerialName("tiny_id") val tinyId: ULong,
        @SerialName("nickname") val nickname: String,
        @SerialName("avatar_url") val avatarUrl: String,
        @SerialName("join_time") val joinTime: ULong,
        @SerialName("roles") val roles: List<RoleInfo>
    )

    @Serializable
    data class RoleInfo(
        @SerialName("role_id") val roleId: String,
        @SerialName("role_name") val roleName: String,
        @SerialName("color") val color: Long,
        @SerialName("permission") val permission: List<Permission>,
        @SerialName("type") val type: Int,
        @SerialName("display_name") val displayName: String
    )

    @Serializable
    data class Permission(
        @SerialName("root_id") val rootId: Int,
        @SerialName("child_ids") val childIds: List<Int>
    )
}