package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MultiMsgInfo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.MsgSvc
import moe.fuqiuluo.qqinterface.servlet.TicketSvc
import moe.fuqiuluo.qqinterface.servlet.msg.convert.toSegments
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.helper.ParamsException
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.service.data.ForwardMessageResult
import moe.fuqiuluo.shamrock.tools.*
import moe.fuqiuluo.shamrock.xposed.helper.NTServiceFetcher
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

sealed interface ForwardMsgNode {
    class MessageIdNode(
        val id: Int
    ) : ForwardMsgNode

    open class MessageNode(
        val name: String,
        val content: JsonElement?
    ) : ForwardMsgNode

    object EmptyNode : MessageNode("", null)
}

internal object SendForwardMessage : IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val detailType = session.getStringOrNull("detail_type") ?: session.getStringOrNull("message_type")
        try {
            val chatType = detailType?.let {
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
            val peerId = when (chatType) {
                MsgConstant.KCHATTYPEGROUP -> session.getStringOrNull("group_id") ?: return noParam(
                    "group_id",
                    session.echo
                )

                MsgConstant.KCHATTYPEC2C -> session.getStringOrNull("user_id") ?: return noParam(
                    "user_id",
                    session.echo
                )

                else -> error("unknown chat type: $chatType")
            }
            if (session.isArray("messages")) {
                val messages = session.getArray("messages")
                invoke(chatType, peerId, messages, echo = session.echo)
            }
            return logic("未知格式合并转发消息", session.echo)
        } catch (e: ParamsException) {
            return noParam(e.message!!, session.echo)
        } catch (e: Throwable) {
            return logic(e.message ?: e.toString(), session.echo)
        }
    }

    suspend operator fun invoke(
        chatType: Int,
        peerId: String,
        message: JsonArray,
        echo: JsonElement = EmptyJsonString
    ): String {
        kotlin.runCatching {
            val kernelService = NTServiceFetcher.kernelService
            val sessionService = kernelService.wrapperSession
            val msgService = sessionService.msgService
            val selfUin = TicketSvc.getUin()

            val msgs = message.map {
                if (it.asJsonObject["type"].asStringOrNull != "node") return@map ForwardMsgNode.EmptyNode // 过滤非node类型消息段
                it.asJsonObject["data"].asJsonObject.let { data ->
                    if (data.containsKey("content")) {
                        if (data["content"] is JsonArray) {
                            data["content"].asJsonArray.forEach { msg ->
                                if (msg.asJsonObject["type"].asStringOrNull == "node") {
                                    LogCenter.log("合并转发消息不支持嵌套", Level.ERROR)
                                    return@map ForwardMsgNode.EmptyNode
                                }
                            }
                        }
                        ForwardMsgNode.MessageNode(
                            name = data["name"].asStringOrNull ?: "",
                            content = data["content"]
                        )
                    } else ForwardMsgNode.MessageIdNode(data["id"].asInt)
                }
            }.map {
                if (it is ForwardMsgNode.MessageIdNode) {
                    val recordResult = MsgSvc.getMsg(it.id)
                    if (!recordResult.isFailure) {
                        ForwardMsgNode.EmptyNode
                    } else {
                        val record = recordResult.getOrThrow()
                        ForwardMsgNode.MessageNode(
                            name = record.sendMemberName
                                .ifBlank { record.sendNickName }
                                .ifBlank { record.sendRemarkName }
                                .ifBlank { record.peerName },
                            content = record.toSegments().map { segment ->
                                segment.toJson()
                            }.json
                        )
                    }
                } else {
                    it as ForwardMsgNode.MessageNode
                }
            }.filter {
                it.content != null
            }

            val multiNodes = msgs.map { node ->
                suspendCoroutine {
                    GlobalScope.launch {
                        var msgId: Long = 0
                        msgId = MessageHelper.sendMessageWithMsgId(MsgConstant.KCHATTYPEC2C,
                            selfUin,
                            node.content!!.let { msg ->
                                if (msg is JsonArray) msg else MessageHelper.decodeCQCode(msg.asString)
                            },
                            { code, why ->
                                if (code != 0) {
                                    error("合并转发消息节点消息发送失败：$code($why)")
                                }
                                it.resume(node.name to msgId)
                            }).first
                    }
                }
            }

            val from = MessageHelper.generateContact(MsgConstant.KCHATTYPEC2C, selfUin)
            val to = MessageHelper.generateContact(chatType, peerId)

            val uniseq = MessageHelper.generateMsgId(chatType)
            msgService.multiForwardMsg(ArrayList<MultiMsgInfo>().apply {
                multiNodes.forEach { add(MultiMsgInfo(it.second, it.first)) }
            }.also { it.reverse() }, from, to, MsgSvc.MessageCallback(peerId, uniseq.first))

            return ok(
                ForwardMessageResult(
                    msgId = uniseq.first,
                    forwardId = ""
                ), echo = echo
            )
        }.onFailure {
            return error("error: $it", echo)
        }
        return logic("合并转发消息失败(unknown error)", echo)
    }

    override val requiredParams: Array<String> = arrayOf("message")

    override fun path(): String = "send_forward_msg"
}