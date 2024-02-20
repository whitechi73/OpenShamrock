package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.MsgSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.service.data.MessageDetail
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_forward_msg")
internal object GetForwardMsg : IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val id = session.getString("id")
        return invoke(id, session.echo)
    }

    suspend operator fun invoke(
        resId: String,
        echo: JsonElement = EmptyJsonString
    ): String {
        val result = MsgSvc.getMultiMsg(resId).getOrElse { return logic(it.toString(), echo) }
        return ok(data = GetForwardMsgResult(result), echo = echo)
    }

    @Serializable
    data class GetForwardMsgResult(
        @SerialName("messages") val msgs: List<MessageDetail>
    )

    override val requiredParams: Array<String> = arrayOf("id")
}