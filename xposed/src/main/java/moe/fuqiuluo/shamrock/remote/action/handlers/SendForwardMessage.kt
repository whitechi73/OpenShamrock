package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MultiMsgInfo
import kotlinx.serialization.json.*
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
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("send_forward_msg")
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
            val peerId = when(chatType) {
                MsgConstant.KCHATTYPEGROUP -> session.getStringOrNull("group_id") ?: return noParam("group_id", session.echo)
                MsgConstant.KCHATTYPEC2C, MsgConstant.KCHATTYPETEMPC2CFROMGROUP -> session.getStringOrNull("user_id") ?: return noParam("user_id", session.echo)
                else -> error("unknown chat type: $chatType")
            }
            val fromId = when(chatType) {
                MsgConstant.KCHATTYPEGROUP, MsgConstant.KCHATTYPETEMPC2CFROMGROUP -> session.getStringOrNull("group_id") ?: return noParam("group_id", session.echo)
                MsgConstant.KCHATTYPEC2C -> session.getStringOrNull("user_id") ?: return noParam("user_id", session.echo)
                else -> error("unknown chat type: $chatType")
            }
            return if (session.isArray("messages")) {
                val messages = session.getArray("messages")
                invoke(chatType, peerId, messages, fromId, echo = session.echo)
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
        messages: JsonArray,
        fromId: String = peerId,
        echo: JsonElement = EmptyJsonString
    ): String {
        kotlin.runCatching {
            val kernelService = NTServiceFetcher.kernelService
            val sessionService = kernelService.wrapperSession
            val msgService = sessionService.msgService
            val selfUin = TicketSvc.getUin()

            val multiNodes = messages.map {
                if (it.asJsonObject["type"].asStringOrNull != "node") {
                    LogCenter.log("包含非node类型节点", Level.WARN)
                    return@map null
                }
                if (it.asJsonObject["data"] !is JsonObject) {
                    LogCenter.log("data字段错误", Level.WARN)
                    return@map null
                }
                it.asJsonObject["data"].asJsonObject.let { data ->
                    if (data.containsKey("id")) {
                        val record = MsgSvc.getMsg(data["id"].asInt).getOrNull()
                        if (record == null) {
                            LogCenter.log("合并转发消息节点消息获取失败：${data["id"]}", Level.WARN)
                            return@map null
                        } else {
                            record.peerName to record.toSegments().map { segment ->
                                segment.toJson()
                            }.json
                        }
                    } else if (data.containsKey("content")) {
                        (data["name"].asStringOrNull ?: "Anno") to when (val raw = data["content"]) {
                            is JsonObject -> raw.asJsonArray
                            is JsonArray -> raw.asJsonArray
                            else -> MessageHelper.decodeCQCode(raw.asString)
                        }
                    } else {
                        LogCenter.log("消息节点缺少id或content字段", Level.WARN)
                        return@map null
                    }
                }.let { node ->
                    val content = node.second.map { msg ->
                        when (msg.asJsonObject["type"].asStringOrNull ?: "text") {
                            "at" -> {
                                buildJsonObject {
                                    put("type", "text")
                                    putJsonObject("data") {
                                        put(
                                            "text", "@${
                                                msg.asJsonObject["data"].asJsonObject["name"].asStringOrNull.ifNullOrEmpty(
                                                    msg.asJsonObject["data"].asJsonObject["qq"].asString
                                                )
                                            }"
                                        )
                                    }
                                }
                            }

                            "voice" -> {
                                buildJsonObject {
                                    put("type", "text")
                                    putJsonObject("data") {
                                        put("text", "[语音]")
                                    }
                                }
                            }

                            "node" -> {
                                LogCenter.log("合并转发消息暂时不支持嵌套", Level.WARN)
                                buildJsonObject {
                                    put("type", "text")
                                    putJsonObject("data") {
                                        put("text", "[合并转发消息]")
                                    }
                                }
                            }

                            else -> msg
                        }
                    }.json

                    val result = MessageHelper.sendMessageNoCb(MsgConstant.KCHATTYPEC2C, selfUin, content)
                    if (result.qqMsgId == 0L) {
                        LogCenter.log("合并转发消息节点消息发送失败", Level.WARN)
                        return@map null
                    }
                    result.qqMsgId to node.first
                }
            }.filterNotNull()

            val from = MessageHelper.generateContact(MsgConstant.KCHATTYPEC2C, selfUin)
            val to = MessageHelper.generateContact(chatType, peerId, fromId)

            val uniseq = MessageHelper.generateMsgId(chatType)
            msgService.multiForwardMsg(ArrayList<MultiMsgInfo>().apply {
                multiNodes.forEach { add(MultiMsgInfo(it.first, it.second)) }
            }.also { it.reverse() }, from, to, MsgSvc.MessageCallback(peerId, uniseq.msgHashId))

            return ok(
                ForwardMessageResult(
                    msgId = uniseq.msgHashId,
                    forwardId = ""
                ), echo = echo
            )
        }.onFailure {
            return error("error: $it", echo)
        }
        return logic("合并转发消息失败(unknown error)", echo)
    }

    override val requiredParams: Array<String> = arrayOf("messages")
}