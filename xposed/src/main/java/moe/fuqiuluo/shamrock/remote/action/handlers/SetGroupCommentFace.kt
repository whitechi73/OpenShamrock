package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.ChatSvc
import moe.fuqiuluo.qqinterface.servlet.MsgSvc
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("set_group_comment_face")
internal object SetGroupCommentFace: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getLong("group_id")
        val msgId = session.getIntOrNull("msg_id") ?: session.getInt("message_id")
        val faceId = session.getInt("face_id")
        val isSet = session.getBooleanOrDefault("is_set", true)
        return invoke(groupId, msgId, faceId, isSet, session.echo)
    }

    operator fun invoke(groupId: Long, msgHash: Int, faceIndex: Int, isSet: Boolean, echo: JsonElement = EmptyJsonString): String {
        val mapping = MessageHelper.getMsgMappingByHash(msgHash)
            ?: return error("failed to locate message", echo = echo)
        ChatSvc.setGroupMessageCommentFace(groupId, mapping.msgSeq.toULong(), faceIndex.toString(), isSet)
        return ok("success", echo = echo)
    }

    override val requiredParams: Array<String> = arrayOf("group_id", "face_id")
}