package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
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
import moe.fuqiuluo.symbols.OneBotHandler
import protobuf.message.*
import protobuf.message.longmsg.PushMsgBody
import java.util.*
import kotlin.random.Random

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
            val peerId = when (chatType) {
                MsgConstant.KCHATTYPEGROUP -> session.getStringOrNull("group_id") ?: return noParam(
                    "group_id",
                    session.echo
                )

                MsgConstant.KCHATTYPEC2C, MsgConstant.KCHATTYPETEMPC2CFROMGROUP -> session.getStringOrNull("user_id")
                    ?: return noParam("user_id", session.echo)

                else -> error("unknown chat type: $chatType")
            }
            val fromId = when (chatType) {
                MsgConstant.KCHATTYPEGROUP, MsgConstant.KCHATTYPETEMPC2CFROMGROUP -> session.getStringOrNull("group_id")
                    ?: return noParam("group_id", session.echo)

                MsgConstant.KCHATTYPEC2C -> session.getStringOrNull("user_id") ?: return noParam(
                    "user_id",
                    session.echo
                )

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
            var uid: String? = null
            var groupUin: String? = null

            var i = -1
            val desc = MutableList(messages.size) { "" }

            val msgs = messages.map { msg ->
                val data = msg.asJsonObject["data"].asJsonObject
                if (data.containsKey("id")) {
                    val record = MsgSvc.getMsg(data["id"].asInt).getOrElse {
                        LogCenter.log("合并转发消息节点消息(id = ${data["id"].asInt})获取失败：$it", Level.WARN)
                        return@map null
                    }
                    uid = record.peerUid
                    if (record.chatType == MsgConstant.KCHATTYPEGROUP) groupUin = record.peerUin.toString()
                    PushMsgBody(
                        head = MessageHead(
                            peerUid = record.senderUid,
                            groupInfo = if (record.chatType == MsgConstant.KCHATTYPEGROUP) GroupInfo(
                                groupCode = record.peerUin.toULong(),
                                memberCard = record.sendMemberName,
                                u1 = 2
                            ) else null
                        ),
                        content = MessageContent(
                            msgType = record.msgType,
                            msgViaRandom = record.msgId,
                            msgSeq = record.msgSeq,
                            msgTime = record.msgTime,
                            u2 = 1,
                            u6 = 0,
                            u7 = 0,
                            forwardHead = ForwardHead(
                                u1 = 0,
                                u2 = 0,
                                u3 = if (record.chatType == MsgConstant.KCHATTYPEGROUP) 0 else 2,
                                u4 = "",
                                Avatar = ""
                            )
                        ),
                        body = MessageBody(
                            rich = RichMessage(
                                elements = MessageHelper.messageArrayToMessageElements(
                                    record.chatType,
                                    record.msgId,
                                    record.peerUin.toString(),
                                    record.elements.toSegments(record.chatType, record.peerUin.toString(), "0").also {
                                        desc[++i] = record.peerName + ": "
                                    }.map {
                                        when (it.type) {
                                            "text" -> desc[i] += it.data["text"] as String

                                            "at" -> desc[i] += "@${it.data["name"] as String? ?: it.data["qq"] as String}"

                                            "face" -> desc[i] += "[表情]"

                                            "voice" -> desc[i] += "[语音]"

                                            "node" -> desc[i] += "[合并转发消息]"
                                        }

                                        it.toJson()
                                    }.json
                                ).also {
                                    if (it.second.isEmpty() && !it.first) error("消息合成失败，请查看日志或者检查输入。")
                                }.second
                            )
                        )
                    )
                } else if (data.containsKey("content")) {
                    PushMsgBody(
                        head = MessageHead(
                            peerUid = data["uid"]?.asString ?: TicketSvc.getUid()
                        ),
                        content = MessageContent(
                            msgType = 529,
                            msgViaRandom = 4,
                            msgSeq = data["seq"]?.asLong ?: 0,
                            msgTime = System.currentTimeMillis() / 1000,
                            u2 = 1,
                            u6 = 0,
                            u7 = 0,
                            forwardHead = ForwardHead(
                                u1 = 0,
                                u2 = 0,
                                u3 = 2,
                                u4 = "",
                                Avatar = ""
                            )
                        ),
                        body = MessageBody(
                            rich = RichMessage(
                                elements = MessageHelper.messageArrayToMessageElements(
                                    1,
                                    Random.nextLong(),
                                    data["uin"]?.asString ?: TicketSvc.getUin(),
                                    when (data["content"]) {
                                        is JsonObject -> listOf(data["content"] as JsonObject).json
                                        is JsonArray -> data["content"] as JsonArray
                                        else -> MessageHelper.decodeCQCode(data["content"].asString)
                                    }.also {
                                        desc[++i] = "${
                                            data["name"].asStringOrNull ?: data["uin"].asStringOrNull
                                            ?: TicketSvc.getNickname()
                                        }: "
                                    }.onEach {
                                        when (it.asJsonObject["type"].asString) {
                                            "text" -> desc[i] += it.asJsonObject["data"].asJsonObject["text"].asString

                                            "at" -> desc[i] += "@${it.asJsonObject["data"].asJsonObject["name"].asStringOrNull ?: it.asJsonObject["data"].asJsonObject["qq"].asString}"

                                            "face" -> desc[i] += "[表情]"

                                            "voice" -> desc[i] += "[语音]"

                                            "node" -> desc[i] += "[合并转发消息]"
                                        }
                                    }
                                ).also {
                                    if (it.second.isEmpty() && !it.first) error("消息合成失败，请查看日志或者检查输入。")
                                }.second
                            )
                        )
                    )
                } else {
                    LogCenter.log("消息节点缺少id或content字段", Level.WARN)
                    null
                }
            }.filterNotNull().ifEmpty { return logic("消息节点为空", echo) }


            val resid = MsgSvc.sendMultiMsg(uid ?: TicketSvc.getUid(), groupUin, msgs)
                .getOrElse { return logic(it.message ?: "", echo) }
            val uniseq = UUID.randomUUID().toString().uppercase()

            val result = MsgSvc.sendToAio(
                chatType, peerId,
                listOf(
                    hashMapOf(
                        "type" to "json", "data" to hashMapOf(
                            "data" to hashMapOf(
                                "app" to "com.tencent.multimsg",
                                "config" to hashMapOf(
                                    "autosize" to 1,
                                    "forward" to 1,
                                    "round" to 1,
                                    "type" to "normal",
                                    "width" to 300
                                ).json,
                                "desc" to "[聊天记录]",
                                "extra" to hashMapOf(
                                    "filename" to uniseq,
                                    "tsum" to 2
                                ).json.toString() + "\n",
                                "meta" to hashMapOf(
                                    "detail" to hashMapOf(
                                        "news" to desc.slice(0..if (i < 3) i else 3)
                                            .map { hashMapOf("text" to it).json }.json,
                                        "resid" to resid,
                                        "source" to "群聊的聊天记录",
                                        "summary" to "查看${msgs.size}条转发消息",
                                        "uniseq" to uniseq
                                    ).json
                                ).json,
                                "prompt" to "[聊天记录]",
                                "ver" to "0.0.0.5",
                                "view" to "contact"
                            ).json,
                            "resid" to resid
                        ).json
                    ).json
                ).json, fromId, 3
            ).getOrElse { return logic(it.message ?: "", echo) }

            return ok(
                ForwardMessageResult(
                    msgId = result.msgHashId,
                    forwardId = resid
                ), echo = echo
            )
        }.onFailure {
            return error("error: $it", echo)
        }
        return logic("合并转发消息失败(unknown error)", echo)
    }

    override val requiredParams: Array<String> = arrayOf("messages")
}