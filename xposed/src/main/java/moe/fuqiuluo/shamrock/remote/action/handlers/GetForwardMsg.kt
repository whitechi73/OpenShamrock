package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.MsgSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.service.data.GetForwardMsgResult
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_forward_msg", ["get_forward_message"])
internal object GetForwardMsg : IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val id = session.getString("id")
        return invoke(id, session.echo)
    }

    suspend operator fun invoke(
        resId: String,
        echo: JsonElement = EmptyJsonString
    ): String {
        return ok(
            data = GetForwardMsgResult(
                msgs = MsgSvc.getForwardMsg(resId).getOrElse { return logic(it.toString(), echo = echo) }),
            echo = echo
        )
    }

    override val requiredParams: Array<String> = arrayOf("id")
}