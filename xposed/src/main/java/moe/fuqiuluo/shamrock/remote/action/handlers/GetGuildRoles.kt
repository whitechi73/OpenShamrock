package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GProSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.action.handlers.GetGuildMemberProfile.Permission
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_guild_roles")
internal object GetGuildRoles: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val guildId = session.getString("guild_id").toULong()
        return invoke(guildId, session.echo)
    }

    suspend operator fun invoke(guildId: ULong, echo: JsonElement = EmptyJsonString): String {
        val result = GProSvc.getGuildRoles(guildId).onFailure {
            return error(it.message ?: "unable to fetch guild roles", echo)
        }.getOrThrow()
        return ok(GetGuildRolesResult(result.map {
            GuildRole(
                color = it.color,
                disabled = it.bHoist,
                independent = it.isChannelRole,
                maxCount = it.memberLimit,
                memberCount = it.count,
                owned = it.isNotSort,
                roleId = it.roleId,
                roleName = it.name,
                permission = it.rolePermissions.permissionList.map {
                    Permission(it.rootId, it.childIds)
                },
            )
        }), echo = echo)
    }

    override val requiredParams: Array<String> = arrayOf("guild_id")

    @Serializable
    data class GetGuildRolesResult(
        @SerialName("roles") val roles: List<GuildRole>
    )

    @Serializable
    data class GuildRole(
        @SerialName("argb_color") val color: Long,
        @SerialName("disabled") val disabled: Boolean,
        @SerialName("independent") val independent: Boolean,
        @SerialName("max_count") val maxCount: Int,
        @SerialName("member_count") val memberCount: Int,
        @SerialName("owned") val owned: Boolean,
        @SerialName("role_id") val roleId: Long,
        @SerialName("role_name") val roleName: String,
        @SerialName("permission") val permission: List<Permission>,
    )

}