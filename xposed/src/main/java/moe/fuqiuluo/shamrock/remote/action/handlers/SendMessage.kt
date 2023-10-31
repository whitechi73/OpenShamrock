package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.helper.ParamsException
import moe.fuqiuluo.qqinterface.servlet.MsgSvc
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.helper.ContactHelper
import moe.fuqiuluo.shamrock.remote.service.data.MessageResult
import moe.fuqiuluo.shamrock.tools.json
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.tools.EmptyJsonString

internal object SendMessage: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val detailType = session.getStringOrNull("detail_type") ?: session.getStringOrNull("message_type")
        try {
            var chatType = detailType?.let {
                MessageHelper.obtainMessageTypeByDetailType(it)
            } ?: run {
                if (session.has("user_id")) {
                    MsgConstant.KCHATTYPEC2C
                } else if (session.has("group_id")) {
                    MsgConstant.KCHATTYPEGROUP
                } else {
                    return noParam("detail_type/message_type", session.echo)
                }
            }
            val peerId = when(chatType) {
                MsgConstant.KCHATTYPEGROUP -> session.getStringOrNull("group_id") ?: return noParam("group_id", session.echo)
                MsgConstant.KCHATTYPEC2C -> session.getStringOrNull("user_id") ?: return noParam("user_id", session.echo)
                else -> error("unknown chat type: $chatType")
            }
            var fromId = peerId
            if (chatType == MsgConstant.KCHATTYPEC2C) {
                val groupId = session.getStringOrNull("group_id")
                if (groupId != null) {
                    chatType = MsgConstant.KCHATTYPETEMPC2CFROMGROUP
                    fromId = groupId
                }
            }
            return if (session.isString("message")) {
                val autoEscape = session.getBooleanOrDefault("auto_escape", false)
                val message = session.getString("message")
                invoke(chatType, peerId, message, autoEscape, echo = session.echo, fromId = fromId)
            } else {
                val message = session.getArray("message")
                invoke(chatType, peerId, message, session.echo, fromId = fromId)
            }
        } catch (e: ParamsException) {
            return noParam(e.message!!, session.echo)
        } catch (e: Throwable) {
            return logic(e.message ?: e.toString(), session.echo)
        }
    }

    // 发送文本格式/CQ码类型消息
    suspend operator fun invoke(
        chatType: Int,
        peerId: String,
        message: String,
        autoEscape: Boolean,
        fromId: String = peerId,
        echo: JsonElement = EmptyJsonString
    ): String {
        //if (!ContactHelper.checkContactAvailable(chatType, peerId)) {
        //    return logic("contact is not found", echo = echo)
        //}
        val result = if (autoEscape) {
            MsgSvc.sendToAio(chatType, peerId, arrayListOf(message).json, fromId = fromId)
        } else {
            val msg = MessageHelper.decodeCQCode(message)
            if (msg.isEmpty()) {
                LogCenter.log("CQ码不合法", Level.WARN)
                return logic("CQCode is illegal", echo)
            } else {
                MsgSvc.sendToAio(chatType, peerId, msg, fromId = fromId)
            }
        }
        return ok(MessageResult(
            msgId = result.second,
            time = result.first * 0.001
        ), echo)
    }

    // 消息段格式消息
    suspend operator fun invoke(
        chatType: Int, peerId: String, message: JsonArray, echo: JsonElement = EmptyJsonString, fromId: String = peerId
    ): String {
        //if (!ContactHelper.checkContactAvailable(chatType, peerId)) {
        //    return logic("contact is not found", echo = echo)
        //}
        val result = MsgSvc.sendToAio(chatType, peerId, message, fromId = fromId)
        return ok(MessageResult(
            msgId = result.second,
            time = result.first * 0.001
        ), echo)
    }

    override val requiredParams: Array<String> = arrayOf("message")

    override fun path(): String = "send_message"

    override val alias: Array<String> = arrayOf("send_msg")
}