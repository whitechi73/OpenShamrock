package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.MsgSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString

internal object DeleteMessage: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val hashCode = session.getString("message_id").toInt()
        return invoke(hashCode, session.echo)
    }

    suspend operator fun invoke(msgHash: Int, echo: JsonElement = EmptyJsonString): String {
        MsgSvc.recallMsg(msgHash)
        return ok("成功", echo)
    }

    override fun path(): String = "delete_message"

    override val alias: Array<String> = arrayOf("delete_msg")

    override val requiredParams: Array<String> = arrayOf("message_id")
}