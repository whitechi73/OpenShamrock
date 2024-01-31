package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GProSvc
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_guild_service_profile")
internal object GetGuildServiceProfile : IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        return invoke(echo = session.echo)
    }

    suspend operator fun invoke(echo: JsonElement = EmptyJsonString): String {
        val result = GProSvc.getSelfGuildInfo()
        result.onFailure {
            return error(it.message ?: "unable to fetch self guild info", echo)
        }
        val info = result.getOrThrow()
        //LogCenter.log(info.toString())
        return ok(GuildServiceProfile(
            nickName = info.nickName ?: info.memberName ?: "",
            tinyId = info.memberTinyid,
            avatarUrl = info.url ?: ""
        ), echo = echo)
    }

    @Serializable
    data class GuildServiceProfile(
        @SerialName("nickname") val nickName: String,
        @SerialName("tiny_id") val tinyId: ULong,
        @SerialName("avatar_url") val avatarUrl: String,
    )
}