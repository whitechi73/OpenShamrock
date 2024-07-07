package qq.service.msg

import com.tencent.mobileqq.qroute.QRoute
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import com.tencent.qqnt.msg.api.IMsgService
import io.kritor.common.ForwardElement
import io.kritor.common.ForwardMessageBody
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.tools.slice
import moe.fuqiuluo.shamrock.utils.DeflateTools
import moe.fuqiuluo.symbols.decodeProtobuf
import protobuf.auto.toByteArray
import protobuf.message.*
import protobuf.message.longmsg.*
import qq.service.QQInterfaces
import qq.service.msg.MessageHelper.getMultiMsg
import qq.service.ticket.TicketHelper
import java.util.*
import kotlin.coroutines.resume
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

internal object ForwardMessageHelper : QQInterfaces() {
    suspend fun uploadMultiMsg(
        contact: Contact,
        messages: List<ForwardMessageBody>,
    ): Result<ForwardElement> {
        var i = -1
        val desc = MutableList(messages.size) { "" }
        val forwardMsg = mutableMapOf<String, String>()

        val msgs = messages.mapNotNull { msg ->
            kotlin.runCatching {
                when (msg.forwardMessageCase) {
                    ForwardMessageBody.ForwardMessageCase.MESSAGE_ID -> {
                        val record: MsgRecord = withTimeoutOrNull(5000) {
                            val service = QRoute.api(IMsgService::class.java)
                            suspendCancellableCoroutine { continuation ->
                                service.getMsgsByMsgId(
                                    contact,
                                    arrayListOf(msg.messageId.toLong())
                                ) { code, _, msgRecords ->
                                    if (code == 0 && msgRecords.isNotEmpty()) {
                                        continuation.resume(msgRecords.first())
                                    } else {
                                        continuation.resume(null)
                                    }
                                }
                                continuation.invokeOnCancellation {
                                    continuation.resume(null)
                                }
                            }
                        } ?: error("合并转发消息节点消息(id = ${msg.messageId})获取失败")
                        PushMsgBody(
                            msgHead = ResponseHead(
                                peerUid = record.senderUid,
                                receiverUid = record.peerUid,
                                forward = ResponseForward(
                                    friendName = record.sendNickName
                                ),
                                responseGrp = if (record.chatType == MsgConstant.KCHATTYPEGROUP) ResponseGrp(
                                    groupCode = record.peerUin.toULong(),
                                    memberCard = record.sendMemberName,
                                    u1 = 2
                                ) else null
                            ),
                            contentHead = ContentHead(
                                msgType = when (record.chatType) {
                                    MsgConstant.KCHATTYPEC2C -> 9
                                    MsgConstant.KCHATTYPEGROUP -> 82
                                    else -> throw UnsupportedOperationException("Unsupported chatType: ${contact.chatType}")
                                },
                                msgSubType = if (record.chatType == MsgConstant.KCHATTYPEC2C) 175 else null,
                                divSeq = if (record.chatType == MsgConstant.KCHATTYPEC2C) 175 else null,
                                msgViaRandom = record.msgId,
                                sequence = record.msgSeq, // idk what this is(i++)
                                msgTime = record.msgTime,
                                u2 = 1,
                                u6 = 0,
                                u7 = 0,
                                msgSeq = if (record.chatType == MsgConstant.KCHATTYPEC2C) record.msgSeq else null, // seq for dm
                                forwardHead = ForwardHead(
                                    u1 = 0,
                                    u2 = 0,
                                    u3 = 0,
                                    ub641 = "",
                                    avatar = ""
                                )
                            ),
                            body = MsgBody(
                                richText = record.elements.toKritorReqMessages(contact).toRichText(contact).onFailure {
                                    error("消息合成失败: ${it.stackTraceToString()}")
                                }.onSuccess {
                                    desc[++i] = record.sendMemberName.ifEmpty { record.sendNickName } + ": " + it.first
                                }.getOrThrow().second
                            )
                        )
                    }

                    ForwardMessageBody.ForwardMessageCase.MESSAGE -> {
                        val _msg = msg.message
                        PushMsgBody(
                            msgHead = if (_msg.hasSender()) ResponseHead(
                                peer = if (_msg.sender.hasUin()) _msg.sender.uin else TicketHelper.getUin().toLong(),
                                peerUid = _msg.sender.uid,
                                receiverUid = TicketHelper.getUid(),
                                forward = ResponseForward(
                                    friendName = if (_msg.sender.hasNick()) _msg.sender.nick else TicketHelper.getNickname()
                                )
                            ) else ResponseHead(
                                peer = TicketHelper.getUin().toLong(),
                                peerUid = TicketHelper.getUid(),
                                receiverUid = TicketHelper.getUid(),
                                forward = ResponseForward(
                                    friendName = TicketHelper.getNickname()
                                )
                            ),
                            contentHead = ContentHead(
                                msgType = 9,
                                msgSubType = 175,
                                divSeq = 175,
                                msgViaRandom = Random.nextLong(),
                                sequence = _msg.messageSeq,
                                msgTime = _msg.time.toLong(),
                                u2 = 1,
                                u6 = 0,
                                u7 = 0,
                                msgSeq = _msg.messageSeq,
                                forwardHead = ForwardHead(
                                    u1 = 0,
                                    u2 = 0,
                                    u3 = 2,
                                    ub641 = "",
                                    avatar = ""
                                )
                            ),
                            body = MsgBody(
                                richText = _msg.elementsList.toRichText(contact).onSuccess {
                                    desc[++i] =
                                        (if (_msg.hasSender() && _msg.sender.hasNick()) _msg.sender.nick else TicketHelper.getNickname()) + ": " + it.first
                                }.onFailure {
                                    error("消息合成失败: ${it.stackTraceToString()}")
                                }.getOrThrow().second
                            )
                        )
                    }

                    else -> null
                }
            }.onFailure {
                LogCenter.log("消息节点解析失败：${it.stackTraceToString()}", Level.WARN)
            }.getOrNull()
        }.ifEmpty {
            return Result.failure(Exception("消息节点为空"))
        }

        val payload = LongMsgPayload(
            action = mutableListOf(
                LongMsgAction(
                    command = "MultiMsg",
                    data = LongMsgContent(
                        body = msgs
                    )
                )
            ).apply {
                forwardMsg.map { msg ->
                    addAll(getMultiMsg(msg.value).getOrElse { return Result.failure(Exception("无法获取嵌套转发消息: $it")) }
                        .map { action ->
                            if (action.command == "MultiMsg") LongMsgAction(
                                command = msg.key,
                                data = action.data
                            ) else action
                        })
                }
            }
        )

        val req = LongMsgReq(
            sendInfo = when (contact.chatType) {
                MsgConstant.KCHATTYPEC2C -> SendLongMsgInfo(
                    type = 1,
                    uid = LongMsgUid(contact.peerUid),
                    payload = DeflateTools.gzip(payload.toByteArray())
                )

                MsgConstant.KCHATTYPEGROUP -> SendLongMsgInfo(
                    type = 3,
                    uid = LongMsgUid(contact.peerUid),
                    groupUin = contact.peerUid.toULong(),
                    payload = DeflateTools.gzip(payload.toByteArray())
                )

                else -> throw UnsupportedOperationException("Unsupported chatType: ${contact.chatType}")
            },
            setting = LongMsgSettings(
                field1 = 4,
                field2 = 2,
                field3 = 9,
                field4 = 0
            )
        ).toByteArray()

        val fromServiceMsg =
            sendBufferAW("trpc.group.long_msg_interface.MsgService.SsoSendLongMsg", true, req, timeout = 60.seconds)
                ?: return Result.failure(Exception("unable to upload multi message, response timeout"))
        val rsp = runCatching {
            fromServiceMsg.wupBuffer.slice(4).decodeProtobuf<LongMsgRsp>()
        }.getOrElse {
            fromServiceMsg.wupBuffer.decodeProtobuf<LongMsgRsp>()
        }
        val resId = rsp.sendResult?.resId ?: return Result.failure(Exception("unable to upload multi message"))

        return Result.success(ForwardElement.newBuilder().apply {
            this.resId = resId
            this.summary = summary
            this.uniseq = UUID.randomUUID().toString()
            this.description = desc.slice(0..if (i < 3) i else 3).joinToString("\n")
        }.build())
    }
}