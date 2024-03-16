package kritor.service

import com.tencent.mobileqq.qroute.QRoute
import com.tencent.qqnt.kernel.nativeinterface.Contact
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import com.tencent.qqnt.msg.api.IMsgService
import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.kritor.message.ClearMessagesRequest
import io.kritor.message.ClearMessagesResponse
import io.kritor.message.GetForwardMessagesRequest
import io.kritor.message.GetForwardMessagesResponse
import io.kritor.message.GetHistoryMessageRequest
import io.kritor.message.GetHistoryMessageResponse
import io.kritor.message.GetMessageBySeqRequest
import io.kritor.message.GetMessageBySeqResponse
import io.kritor.message.GetMessageRequest
import io.kritor.message.GetMessageResponse
import io.kritor.message.MessageServiceGrpcKt
import io.kritor.message.RecallMessageRequest
import io.kritor.message.RecallMessageResponse
import io.kritor.message.Scene
import io.kritor.message.SendMessageByResIdRequest
import io.kritor.message.SendMessageByResIdResponse
import io.kritor.message.SendMessageRequest
import io.kritor.message.SendMessageResponse
import io.kritor.message.clearMessagesResponse
import io.kritor.message.contact
import io.kritor.message.getForwardMessagesResponse
import io.kritor.message.getHistoryMessageResponse
import io.kritor.message.getMessageBySeqResponse
import io.kritor.message.getMessageResponse
import io.kritor.message.messageBody
import io.kritor.message.recallMessageResponse
import io.kritor.message.sendMessageByResIdResponse
import io.kritor.message.sendMessageResponse
import io.kritor.message.sender
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import protobuf.auto.toByteArray
import protobuf.message.ContentHead
import protobuf.message.Elem
import protobuf.message.MsgBody
import protobuf.message.PbSendMsgReq
import protobuf.message.RichText
import protobuf.message.RoutingHead
import protobuf.message.element.GeneralFlags
import protobuf.message.routing.C2C
import protobuf.message.routing.Grp
import qq.service.QQInterfaces
import qq.service.contact.longPeer
import qq.service.internals.NTServiceFetcher
import qq.service.msg.MessageHelper
import qq.service.msg.NtMsgConvertor
import qq.service.msg.toKritorEventMessages
import qq.service.msg.toKritorReqMessages
import qq.service.msg.toKritorResponseMessages
import kotlin.coroutines.resume
import kotlin.random.Random
import kotlin.random.nextUInt

internal object MessageService: MessageServiceGrpcKt.MessageServiceCoroutineImplBase() {
    override suspend fun sendMessage(request: SendMessageRequest): SendMessageResponse {
        val contact = request.contact.let {
            MessageHelper.generateContact(when(it.scene!!) {
                Scene.GROUP -> MsgConstant.KCHATTYPEGROUP
                Scene.FRIEND -> MsgConstant.KCHATTYPEC2C
                Scene.GUILD -> MsgConstant.KCHATTYPEGUILD
                Scene.STRANGER_FROM_GROUP -> MsgConstant.KCHATTYPETEMPC2CFROMGROUP
                Scene.NEARBY -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
                Scene.STRANGER -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
                Scene.UNRECOGNIZED -> throw StatusRuntimeException(Status.INVALID_ARGUMENT.withDescription("Unrecognized scene"))
            }, it.peer, it.subPeer)
        }

        val uniseq = MessageHelper.generateMsgId(contact.chatType)
        return sendMessageResponse {
            this.messageId = MessageHelper.sendMessage(contact, NtMsgConvertor.convertToNtMsgs(contact, uniseq, request.elementsList), request.retryCount, uniseq).onFailure {
                throw StatusRuntimeException(Status.INTERNAL.withCause(it))
            }.getOrThrow()
        }
    }

    override suspend fun sendMessageByResId(request: SendMessageByResIdRequest): SendMessageByResIdResponse {
        val contact = request.contact
        val req = PbSendMsgReq(
            routingHead = when (request.contact.scene) {
                Scene.GROUP -> RoutingHead(grp = Grp(contact.longPeer().toUInt()))
                Scene.FRIEND -> RoutingHead(c2c = C2C(contact.longPeer().toUInt()))
                else -> RoutingHead(grp = Grp(contact.longPeer().toUInt()))
            },
            contentHead = ContentHead(1, 0, 0, 0),
            msgBody = MsgBody(
                richText = RichText(
                    elements = arrayListOf(
                        Elem(
                            generalFlags = GeneralFlags(
                                longTextFlag = 1u,
                                longTextResid = request.resId
                            )
                        )
                    )
                )
            ),
            msgSeq = Random.nextUInt(),
            msgRand = Random.nextUInt(),
            msgVia = 0u
        )
        QQInterfaces.sendBuffer("MessageSvc.PbSendMsg", true, req.toByteArray())
        return sendMessageByResIdResponse {  }
    }

    override suspend fun clearMessages(request: ClearMessagesRequest): ClearMessagesResponse {
        val contact = request.contact
        val kernelService = NTServiceFetcher.kernelService
        val sessionService = kernelService.wrapperSession
        val service = sessionService.msgService
        val chatType = when(contact.scene!!) {
            Scene.GROUP -> MsgConstant.KCHATTYPEGROUP
            Scene.FRIEND -> MsgConstant.KCHATTYPEC2C
            Scene.GUILD -> MsgConstant.KCHATTYPEGUILD
            Scene.STRANGER_FROM_GROUP -> MsgConstant.KCHATTYPETEMPC2CFROMGROUP
            Scene.NEARBY -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
            Scene.STRANGER -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
            Scene.UNRECOGNIZED -> throw StatusRuntimeException(Status.INVALID_ARGUMENT.withDescription("Unrecognized scene"))
        }
        service.clearMsgRecords(Contact(chatType, contact.peer, contact.subPeer), null)
        return clearMessagesResponse {  }
    }

    override suspend fun recallMessage(request: RecallMessageRequest): RecallMessageResponse {
        val contact = request.contact.let {
            MessageHelper.generateContact(when(it.scene!!) {
                Scene.GROUP -> MsgConstant.KCHATTYPEGROUP
                Scene.FRIEND -> MsgConstant.KCHATTYPEC2C
                Scene.GUILD -> MsgConstant.KCHATTYPEGUILD
                Scene.STRANGER_FROM_GROUP -> MsgConstant.KCHATTYPETEMPC2CFROMGROUP
                Scene.NEARBY -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
                Scene.STRANGER -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
                Scene.UNRECOGNIZED -> throw StatusRuntimeException(Status.INVALID_ARGUMENT.withDescription("Unrecognized scene"))
            }, it.peer, it.subPeer)
        }
        val kernelService = NTServiceFetcher.kernelService
        val sessionService = kernelService.wrapperSession
        val service = sessionService.msgService
        service.recallMsg(contact, arrayListOf(request.messageId)) { code, msg ->
            if (code != 0) {
                LogCenter.log("消息撤回失败: $code:$msg", Level.WARN)
            }
        }

        return recallMessageResponse {}
    }

    override suspend fun getForwardMessages(request: GetForwardMessagesRequest): GetForwardMessagesResponse {
        return getForwardMessagesResponse {
            MessageHelper.getForwardMsg(request.resId).onFailure {
                throw StatusRuntimeException(Status.INTERNAL.withCause(it))
            }.getOrThrow().forEach { detail ->
                messages.add(messageBody {
                    val peer = when (scene) {
                        Scene.GROUP -> detail.groupId.toString()
                        Scene.FRIEND -> detail.sender.userId.toString()
                        else -> detail.peerId.toString()
                    }

                    this.time = detail.time
                    this.scene = when(detail.msgType) {
                        MsgConstant.KCHATTYPEC2C -> Scene.FRIEND
                        MsgConstant.KCHATTYPEGROUP -> Scene.GROUP
                        MsgConstant.KCHATTYPEGUILD -> Scene.GUILD
                        MsgConstant.KCHATTYPETEMPC2CFROMGROUP -> Scene.STRANGER_FROM_GROUP
                        MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN -> Scene.NEARBY
                        else -> Scene.STRANGER
                    }
                    this.messageId = detail.qqMsgId
                    this.messageSeq = detail.msgSeq
                    this.contact = contact {
                        this.scene = scene
                        this.peer = peer
                    }
                    this.sender = sender {
                        this.uin = detail.sender.userId
                        this.nick = detail.sender.nickName
                        this.uid = detail.sender.uid
                    }
                    detail.message?.elements?.toKritorResponseMessages(Contact(detail.msgType, peer, null))?.let {
                        this.elements.addAll(it)
                    }
                })
            }
        }
    }

    override suspend fun getMessage(request: GetMessageRequest): GetMessageResponse {
        val contact = request.contact.let {
            MessageHelper.generateContact(when(it.scene!!) {
                Scene.GROUP -> MsgConstant.KCHATTYPEGROUP
                Scene.FRIEND -> MsgConstant.KCHATTYPEC2C
                Scene.GUILD -> MsgConstant.KCHATTYPEGUILD
                Scene.STRANGER_FROM_GROUP -> MsgConstant.KCHATTYPETEMPC2CFROMGROUP
                Scene.NEARBY -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
                Scene.STRANGER -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
                Scene.UNRECOGNIZED -> throw StatusRuntimeException(Status.INVALID_ARGUMENT.withDescription("Unrecognized scene"))
            }, it.peer, it.subPeer)
        }
        val msg: MsgRecord = withTimeoutOrNull(5000) {
            val service = QRoute.api(IMsgService::class.java)
            suspendCancellableCoroutine { continuation ->
                service.getMsgsByMsgId(contact, arrayListOf(request.messageId)) { code, _, msgRecords ->
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
        } ?: throw StatusRuntimeException(Status.NOT_FOUND.withDescription("Message not found"))

        return getMessageResponse {
            this.message = messageBody {
                this.messageId = msg.msgId
                this.scene = request.contact.scene
                this.contact = request.contact
                this.sender = sender {
                    this.uin = msg.senderUin
                    this.nick = msg.sendNickName ?: ""
                    this.uid = msg.senderUid ?: ""
                }
                this.messageSeq = msg.msgSeq
                this.elements.addAll(msg.elements.toKritorReqMessages(contact))
            }
        }
    }

    override suspend fun getMessageBySeq(request: GetMessageBySeqRequest): GetMessageBySeqResponse {
        val contact = request.contact.let {
            MessageHelper.generateContact(when(it.scene!!) {
                Scene.GROUP -> MsgConstant.KCHATTYPEGROUP
                Scene.FRIEND -> MsgConstant.KCHATTYPEC2C
                Scene.GUILD -> MsgConstant.KCHATTYPEGUILD
                Scene.STRANGER_FROM_GROUP -> MsgConstant.KCHATTYPETEMPC2CFROMGROUP
                Scene.NEARBY -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
                Scene.STRANGER -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
                Scene.UNRECOGNIZED -> throw StatusRuntimeException(Status.INVALID_ARGUMENT.withDescription("Unrecognized scene"))
            }, it.peer, it.subPeer)
        }
        val msg: MsgRecord = withTimeoutOrNull(5000) {
            val service = QRoute.api(IMsgService::class.java)
            suspendCancellableCoroutine { continuation ->
                service.getMsgsBySeqAndCount(contact, request.messageSeq, 1, true) { code, _, msgRecords ->
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
        } ?: throw StatusRuntimeException(Status.NOT_FOUND.withDescription("Message not found"))

        return getMessageBySeqResponse {
            this.message = messageBody {
                this.messageId = msg.msgId
                this.scene = request.contact.scene
                this.contact = request.contact
                this.sender = sender {
                    this.uin = msg.senderUin
                    this.nick = msg.sendNickName ?: ""
                    this.uid = msg.senderUid ?: ""
                }
                this.messageSeq = msg.msgSeq
                this.elements.addAll(msg.elements.toKritorReqMessages(contact))
            }
        }
    }

    override suspend fun getHistoryMessage(request: GetHistoryMessageRequest): GetHistoryMessageResponse {
        val contact = request.contact.let {
            MessageHelper.generateContact(when(it.scene!!) {
                Scene.GROUP -> MsgConstant.KCHATTYPEGROUP
                Scene.FRIEND -> MsgConstant.KCHATTYPEC2C
                Scene.GUILD -> MsgConstant.KCHATTYPEGUILD
                Scene.STRANGER_FROM_GROUP -> MsgConstant.KCHATTYPETEMPC2CFROMGROUP
                Scene.NEARBY -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
                Scene.STRANGER -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
                Scene.UNRECOGNIZED -> throw StatusRuntimeException(Status.INVALID_ARGUMENT.withDescription("Unrecognized scene"))
            }, it.peer, it.subPeer)
        }
        val msgs: List<MsgRecord> = withTimeoutOrNull(5000) {
            val service = QRoute.api(IMsgService::class.java)
            suspendCancellableCoroutine { continuation ->
                service.getMsgs(contact, request.startMessageId, request.count, true) { code, _, msgRecords ->
                    if (code == 0 && msgRecords.isNotEmpty()) {
                        continuation.resume(msgRecords)
                    } else {
                        continuation.resume(null)
                    }
                }
                continuation.invokeOnCancellation {
                    continuation.resume(null)
                }
            }
        } ?: throw StatusRuntimeException(Status.NOT_FOUND.withDescription("Messages not found"))

        return getHistoryMessageResponse {
            msgs.forEach {
                messages.add(messageBody {
                    this.messageId = it.msgId
                    this.scene = request.contact.scene
                    this.contact = request.contact
                    this.sender = sender {
                        this.uin = it.senderUin
                        this.nick = it.sendNickName ?: ""
                        this.uid = it.senderUid ?: ""
                    }
                    this.messageSeq = it.msgSeq
                    this.elements.addAll(it.elements.toKritorReqMessages(contact))
                })
            }
        }
    }
}