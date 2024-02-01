package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.protobuf.ProtoNumber
import moe.fuqiuluo.qqinterface.servlet.GProSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_guild_meta_by_guest")
internal object GetGuildMetaByGuest: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val guildId = session.getString("guild_id").toULong()
        return invoke(guildId, session.echo)
    }

    suspend operator fun invoke(guildId: ULong, echo: JsonElement = EmptyJsonString): String {
        val result = GProSvc.getGuildInfo(guildId)
        result.onFailure {
            return error(it.message ?: "unable to fetch guild info", echo)
        }
        val info = result.getOrThrow()
        if (info.meta == null) {
            return error("unable to fetch guild meta", echo)
        }
        val meta = info.meta!!
        return ok(GetGuildMetaByGuestResponse(
            guildId = info.guildId,
            guildName = meta.name ?: "",
            guildProfile = meta.profile ?: "",
            createTime = meta.createTime,
            maxMemberCount = meta.maxMemberCount,
            maxRobotCount = meta.robotMaxNum,
            maxAdminCount = meta.adminMaxNum,
            memberCount = meta.memberCount,
            ownerId = meta.ownerId,
            guildDisplayId = meta.displayId ?: ""
        ), echo)
    }

    override val requiredParams: Array<String> = arrayOf("guild_id")

    @Serializable
    data class GetGuildMetaByGuestResponse(
        @SerialName("guild_id") val guildId: ULong,
        @SerialName("guild_name") val guildName: String,
        @SerialName("guild_profile") val guildProfile: String,
        @SerialName("create_time") val createTime: Long,
        @SerialName("max_member_count") val maxMemberCount: Long,
        @SerialName("max_robot_count") val maxRobotCount: Int,
        @SerialName("max_admin_count") val maxAdminCount: Int,
        @SerialName("member_count") val memberCount: Long,
        @SerialName("owner_id") val ownerId: ULong,
        @SerialName("guild_display_id") val guildDisplayId: String
    )
}