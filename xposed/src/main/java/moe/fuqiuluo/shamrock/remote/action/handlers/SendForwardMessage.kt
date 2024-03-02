package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import kotlinx.serialization.json.*
import moe.fuqiuluo.qqinterface.servlet.MsgSvc
import moe.fuqiuluo.qqinterface.servlet.msg.toJson
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.helper.ParamsException
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.service.data.SendForwardMessageResult
import moe.fuqiuluo.shamrock.tools.*
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("send_forward_msg", ["send_forward_message"])
internal object SendForwardMessage : IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val detailType = session.getStringOrNull("detail_type") ?: session.getStringOrNull("message_type")
        try {
            val chatType = detailType?.let {
                MessageHelper.obtainMessageTypeByDetailType(it)
            } ?: run {
                if (session.has("user_id")) {
                    if (session.has("group_id")) {
                        MsgConstant.KCHATTYPETEMPC2CFROMGROUP
                    } else {
                        MsgConstant.KCHATTYPEC2C
                    }
                } else if (session.has("group_id")) {
                    MsgConstant.KCHATTYPEGROUP
                } else {
                    return noParam("detail_type/message_type", session.echo)
                }
            }
            val peerId = when (chatType) {
                MsgConstant.KCHATTYPEGROUP -> session.getStringOrNull("group_id")
                    ?: return noParam("group_id", session.echo)
                MsgConstant.KCHATTYPEC2C, MsgConstant.KCHATTYPETEMPC2CFROMGROUP -> session.getStringOrNull("user_id")
                    ?: return noParam("user_id", session.echo)
                else -> error("unknown chat type: $chatType")
            }
            val fromId = session.getStringOrNull("group_id")
            val retryCnt = session.getIntOrNull("retry_cnt") ?: 5
            return if (session.isArray("messages")) {
                val messages = session.getArray("messages")
                invoke(chatType, peerId, fromId ?: peerId, messages, retryCnt, session.echo)
            } else {
                logic("未知格式合并转发消息", session.echo)
            }
        } catch (e: ParamsException) {
            return noParam(e.message!!, session.echo)
        } catch (e: Throwable) {
            return logic(e.message ?: e.toString(), session.echo)
        }
    }

    suspend operator fun invoke(
        chatType: Int,
        peerId: String,
        fromId: String = peerId,
        messages: JsonArray,
        retryCnt: Int,
        echo: JsonElement = EmptyJsonString
    ): String {
        kotlin.runCatching {
            val message = MsgSvc.uploadMultiMsg(chatType, peerId, fromId, messages, retryCnt).onFailure {
                return error(it.message ?: it.stackTraceToString(), echo)
            }.getOrThrow()
            val result = MsgSvc.sendToAio(chatType, peerId, listOf(message).toJson(), fromId, retryCnt).onFailure {
                return error(it.message ?: it.stackTraceToString(), echo)
            }.getOrThrow()
            return ok(SendForwardMessageResult(
                msgId = result.msgHashId,
                resId = message.data["id"] as String
            ), echo = echo)
        }.onFailure {
            return error("合并转发消息失败: $it", echo)
        }
        return logic("合并转发消息失败(unknown error)", echo)
    }

    override val requiredParams: Array<String> = arrayOf("messages")
}