package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.ark.ArkMsgSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("sign_ark_message")
internal object SignArkMessage: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val json = if(session.isString("json")) session.getString("json")
        else session.getJsonElement("json").toString()
        return invoke(json, session.echo)
    }

    suspend operator fun invoke(json: String, echo: JsonElement = EmptyJsonString): String {
        /*
        ArkMsgSvc.tryShareJsonMessage(json).onSuccess {
            return ok(SignArkMessageResult(it), echo = echo)
        }.onFailure {
            return error(it.message ?: it.toString(), echo)
        }*/
        return logic("logic error", echo)
    }

    @Serializable
    data class SignArkMessageResult(
        val result: String
    )
}