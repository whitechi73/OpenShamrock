package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.xposed.helper.NTServiceFetcher

internal object ClearMsgs: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val msgType = session.getString("message_type")
        val peerId = session.getString(if (msgType == "group") "group_id" else "user_id")
        return invoke(msgType, peerId, session.echo)
    }

    suspend operator fun invoke(
        msgType: String,
        peerId: String,
        echo: JsonElement = EmptyJsonString
    ): String {
        val chatType = MessageHelper.obtainMessageTypeByDetailType(msgType)
        val contact = MessageHelper.generateContact(chatType, peerId, "")
        NTServiceFetcher.kernelService.wrapperSession.msgService.clearMsgRecords(contact, null)
        return ok(echo = echo)
    }

    override val requiredParams: Array<String>
        get() = arrayOf("message_type")

    override fun path(): String = "clear_msgs"
}