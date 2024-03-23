package kritor.service

import com.tencent.mobileqq.qroute.QRoute
import com.tencent.qqnt.kernel.nativeinterface.Contact
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import com.tencent.qqnt.msg.api.IMsgService
import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.kritor.event.MessageEvent
import io.kritor.message.*
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

internal object MessageService : MessageServiceGrpcKt.MessageServiceCoroutineImplBase() {
    @Grpc("MessageService", "SendMessage")
    override suspend fun sendMessage(request: SendMessageRequest): SendMessageResponse {
        val contact = request.contact.let {
            MessageHelper.generateContact(
                when (it.scene!!) {
                    Scene.GROUP -> MsgConstant.KCHATTYPEGROUP
                    Scene.FRIEND -> MsgConstant.KCHATTYPEC2C
                    Scene.GUILD -> MsgConstant.KCHATTYPEGUILD
                    Scene.STRANGER_FROM_GROUP -> MsgConstant.KCHATTYPETEMPC2CFROMGROUP
                    Scene.NEARBY -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
                    Scene.STRANGER -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
                    Scene.UNRECOGNIZED -> throw StatusRuntimeException(Status.INVALID_ARGUMENT.withDescription("Unrecognized scene"))
                }, it.peer, it.subPeer
            )
        }

        val uniseq = MessageHelper.generateMsgId(contact.chatType)
        return SendMessageResponse.newBuilder().apply {
            this.messageId = MessageHelper.sendMessage(
                contact,
                NtMsgConvertor.convertToNtMsgs(contact, uniseq, request.elementsList),
                request.retryCount,
                uniseq
            ).onFailure {
                throw StatusRuntimeException(Status.INTERNAL.withCause(it))
            }.getOrThrow()
        }.build()
    }

    @Grpc("MessageService", "SendMessageByResId")
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
        return SendMessageByResIdResponse.newBuilder().build()
    }

    @Grpc("MessageService", "ClearMessages")
    override suspend fun clearMessages(request: ClearMessagesRequest): ClearMessagesResponse {
        val contact = request.contact
        val kernelService = NTServiceFetcher.kernelService
        val sessionService = kernelService.wrapperSession
        val service = sessionService.msgService
        val chatType = when (contact.scene!!) {
            Scene.GROUP -> MsgConstant.KCHATTYPEGROUP
            Scene.FRIEND -> MsgConstant.KCHATTYPEC2C
            Scene.GUILD -> MsgConstant.KCHATTYPEGUILD
            Scene.STRANGER_FROM_GROUP -> MsgConstant.KCHATTYPETEMPC2CFROMGROUP
            Scene.NEARBY -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
            Scene.STRANGER -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
            Scene.UNRECOGNIZED -> throw StatusRuntimeException(Status.INVALID_ARGUMENT.withDescription("Unrecognized scene"))
        }
        service.clearMsgRecords(Contact(chatType, contact.peer, contact.subPeer), null)
        return ClearMessagesResponse.newBuilder().build()
    }

    @Grpc("MessageService", "RecallMessage")
    override suspend fun recallMessage(request: RecallMessageRequest): RecallMessageResponse {
        val contact = request.contact.let {
            MessageHelper.generateContact(
                when (it.scene!!) {
                    Scene.GROUP -> MsgConstant.KCHATTYPEGROUP
                    Scene.FRIEND -> MsgConstant.KCHATTYPEC2C
                    Scene.GUILD -> MsgConstant.KCHATTYPEGUILD
                    Scene.STRANGER_FROM_GROUP -> MsgConstant.KCHATTYPETEMPC2CFROMGROUP
                    Scene.NEARBY -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
                    Scene.STRANGER -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
                    Scene.UNRECOGNIZED -> throw StatusRuntimeException(Status.INVALID_ARGUMENT.withDescription("Unrecognized scene"))
                }, it.peer, it.subPeer
            )
        }
        val kernelService = NTServiceFetcher.kernelService
        val sessionService = kernelService.wrapperSession
        val service = sessionService.msgService
        service.recallMsg(contact, arrayListOf(request.messageId)) { code, msg ->
            if (code != 0) {
                LogCenter.log("消息撤回失败: $code:$msg", Level.WARN)
            }
        }

        return RecallMessageResponse.newBuilder().build()
    }

    @Grpc("MessageService", "GetMessage")
    override suspend fun getMessage(request: GetMessageRequest): GetMessageResponse {
        val contact = request.contact.let {
            MessageHelper.generateContact(
                when (it.scene!!) {
                    Scene.GROUP -> MsgConstant.KCHATTYPEGROUP
                    Scene.FRIEND -> MsgConstant.KCHATTYPEC2C
                    Scene.GUILD -> MsgConstant.KCHATTYPEGUILD
                    Scene.STRANGER_FROM_GROUP -> MsgConstant.KCHATTYPETEMPC2CFROMGROUP
                    Scene.NEARBY -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
                    Scene.STRANGER -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
                    Scene.UNRECOGNIZED -> throw StatusRuntimeException(Status.INVALID_ARGUMENT.withDescription("Unrecognized scene"))
                }, it.peer, it.subPeer
            )
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

        return GetMessageResponse.newBuilder().apply {
            this.message = MessageEvent.newBuilder().apply {
                this.messageId = msg.msgId
                this.contact = request.contact
                this.sender = Sender.newBuilder().apply {
                    this.uin = msg.senderUin
                    this.nick = msg.sendNickName ?: ""
                    this.uid = msg.senderUid ?: ""
                }.build()
                this.messageSeq = msg.msgSeq
                this.addAllElements(msg.elements.toKritorReqMessages(contact))
            }.build()
        }.build()
    }

    @Grpc("MessageService", "GetMessageBySeq")
    override suspend fun getMessageBySeq(request: GetMessageBySeqRequest): GetMessageBySeqResponse {
        val contact = request.contact.let {
            MessageHelper.generateContact(
                when (it.scene!!) {
                    Scene.GROUP -> MsgConstant.KCHATTYPEGROUP
                    Scene.FRIEND -> MsgConstant.KCHATTYPEC2C
                    Scene.GUILD -> MsgConstant.KCHATTYPEGUILD
                    Scene.STRANGER_FROM_GROUP -> MsgConstant.KCHATTYPETEMPC2CFROMGROUP
                    Scene.NEARBY -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
                    Scene.STRANGER -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
                    Scene.UNRECOGNIZED -> throw StatusRuntimeException(Status.INVALID_ARGUMENT.withDescription("Unrecognized scene"))
                }, it.peer, it.subPeer
            )
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

        return GetMessageBySeqResponse.newBuilder().apply {
            this.message = MessageEvent.newBuilder().apply {
                this.messageId = msg.msgId
                this.contact = request.contact
                this.sender = Sender.newBuilder().apply {
                    this.uin = msg.senderUin
                    this.nick = msg.sendNickName ?: ""
                    this.uid = msg.senderUid ?: ""
                }.build()
                this.messageSeq = msg.msgSeq
                this.addAllElements(msg.elements.toKritorReqMessages(contact))
            }.build()
        }.build()
    }

    @Grpc("MessageService", "GetHistoryMessage")
    override suspend fun getHistoryMessage(request: GetHistoryMessageRequest): GetHistoryMessageResponse {
        val contact = request.contact.let {
            MessageHelper.generateContact(
                when (it.scene!!) {
                    Scene.GROUP -> MsgConstant.KCHATTYPEGROUP
                    Scene.FRIEND -> MsgConstant.KCHATTYPEC2C
                    Scene.GUILD -> MsgConstant.KCHATTYPEGUILD
                    Scene.STRANGER_FROM_GROUP -> MsgConstant.KCHATTYPETEMPC2CFROMGROUP
                    Scene.NEARBY -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
                    Scene.STRANGER -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
                    Scene.UNRECOGNIZED -> throw StatusRuntimeException(Status.INVALID_ARGUMENT.withDescription("Unrecognized scene"))
                }, it.peer, it.subPeer
            )
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

        return GetHistoryMessageResponse.newBuilder().apply {
            msgs.forEach {
                addMessages(MessageEvent.newBuilder().apply {
                    this.messageId = it.msgId
                    this.contact = request.contact
                    this.sender = Sender.newBuilder().apply {
                        this.uin = it.senderUin
                        this.nick = it.sendNickName ?: ""
                        this.uid = it.senderUid ?: ""
                    }.build()
                    this.messageSeq = it.msgSeq
                    this.addAllElements(it.elements.toKritorReqMessages(contact))
                })
            }
        }.build()
    }

    @Grpc("MessageService", "DeleteEssenceMsg")
    override suspend fun deleteEssenceMsg(request: DeleteEssenceMsgRequest): DeleteEssenceMsgResponse {
        val contact = MessageHelper.generateContact(MsgConstant.KCHATTYPEGROUP, request.groupId.toString())
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
        if (MessageHelper.deleteEssenceMessage(request.groupId, msg.msgSeq, msg.msgRandom) == null)
            throw StatusRuntimeException(Status.NOT_FOUND.withDescription("delete essence message failed"))
        return DeleteEssenceMsgResponse.newBuilder().build()
    }

    @Grpc("MessageService", "GetEssenceMessages")
    override suspend fun getEssenceMessages(request: GetEssenceMessagesRequest): GetEssenceMessagesResponse {
        val contact = MessageHelper.generateContact(MsgConstant.KCHATTYPEGROUP, request.groupId.toString())
        return GetEssenceMessagesResponse.newBuilder().apply {
            MessageHelper.getEssenceMessageList(request.groupId, request.page, request.pageSize).onFailure {
                throw StatusRuntimeException(Status.INTERNAL.withCause(it))
            }.getOrThrow().forEach {
                addEssenceMessage(EssenceMessage.newBuilder().apply {
                    withTimeoutOrNull(5000) {
                        val service = QRoute.api(IMsgService::class.java)
                        suspendCancellableCoroutine { continuation ->
                            service.getMsgsBySeqAndCount(contact, it.messageSeq, 1, true) { code, _, msgRecords ->
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
                    }?.let {
                        this.messageId = it.msgId
                    }
                    this.messageSeq = it.messageSeq
                    this.msgTime = it.senderTime.toInt()
                    this.senderNick = it.senderNick
                    this.senderUin = it.senderId
                    this.operationTime = it.operatorTime.toInt()
                    this.operatorNick = it.operatorNick
                    this.operatorUin = it.operatorId
                    this.jsonElements = it.messageContent.toString()
                })
            }
        }.build()
    }

    @Grpc("MessageService", "SetEssenceMessage")
    override suspend fun setEssenceMessage(request: SetEssenceMessageRequest): SetEssenceMessageResponse {
        val contact = MessageHelper.generateContact(MsgConstant.KCHATTYPEGROUP, request.groupId.toString())
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
        if (MessageHelper.setEssenceMessage(request.groupId, msg.msgSeq, msg.msgRandom) == null) {
            throw StatusRuntimeException(Status.NOT_FOUND.withDescription("set essence message failed"))
        }
        return SetEssenceMessageResponse.newBuilder().build()
    }

    @Grpc("MessageService", "SetMessageCommentEmoji")
    override suspend fun setMessageCommentEmoji(request: SetMessageCommentEmojiRequest): SetMessageCommentEmojiResponse {
        val contact = request.contact.let {
            MessageHelper.generateContact(
                when (it.scene!!) {
                    Scene.GROUP -> MsgConstant.KCHATTYPEGROUP
                    Scene.FRIEND -> MsgConstant.KCHATTYPEC2C
                    Scene.GUILD -> MsgConstant.KCHATTYPEGUILD
                    Scene.STRANGER_FROM_GROUP -> MsgConstant.KCHATTYPETEMPC2CFROMGROUP
                    Scene.NEARBY -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
                    Scene.STRANGER -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
                    Scene.UNRECOGNIZED -> throw StatusRuntimeException(Status.INVALID_ARGUMENT.withDescription("Unrecognized scene"))
                }, it.peer, it.subPeer
            )
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
        MessageHelper.setGroupMessageCommentFace(
            request.contact.longPeer(),
            msg.msgSeq.toULong(),
            request.faceId.toString(),
            request.isComment
        )
        return SetMessageCommentEmojiResponse.newBuilder().build()
    }
}