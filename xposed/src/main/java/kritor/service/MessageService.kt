package kritor.service

import com.tencent.mobileqq.qroute.QRoute
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import com.tencent.qqnt.msg.api.IMsgService
import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.kritor.common.*
import io.kritor.message.*
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import protobuf.auto.toByteArray
import protobuf.message.*
import protobuf.message.element.GeneralFlags
import protobuf.message.routing.C2C
import protobuf.message.routing.Grp
import qq.service.QQInterfaces
import qq.service.contact.longPeer
import qq.service.internals.NTServiceFetcher
import qq.service.msg.*
import qq.service.msg.ForwardMessageHelper
import qq.service.msg.MessageHelper
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
            }.getOrThrow().toString()
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

    @Grpc("MessageService", "SetMessageReaded")
    override suspend fun setMessageReaded(request: SetMessageReadRequest): SetMessageReadResponse {
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
        service.clearMsgRecords(
            Contact(
                chatType,
                contact.peer,
                contact.subPeer
            ), null)
        return SetMessageReadResponse.newBuilder().build()
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
        service.recallMsg(contact, arrayListOf(request.messageId.toLong())) { code, msg ->
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
                service.getMsgsByMsgId(contact, arrayListOf(request.messageId.toLong())) { code, _, msgRecords ->
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
            this.message = PushMessageBody.newBuilder().apply {
                this.messageId = msg.msgId.toString()
                this.contact = request.contact
                this.sender = Sender.newBuilder().apply {
                    this.uid = msg.senderUid ?: ""
                    this.uin = msg.senderUin
                    this.nick = msg.sendNickName ?: ""
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
            this.message = PushMessageBody.newBuilder().apply {
                this.messageId = msg.msgId.toString()
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
                service.getMsgs(contact, request.startMessageId.toLong(), request.count, true) { code, _, msgRecords ->
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
                addMessages(PushMessageBody.newBuilder().apply {
                    this.messageId = it.msgId.toString()
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

    @Grpc("MessageService", "UploadForwardMessage")
    override suspend fun uploadForwardMessage(request: UploadForwardMessageRequest): UploadForwardMessageResponse {
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

        val forwardMessage = ForwardMessageHelper.uploadMultiMsg(
            contact,
            request.messagesList
        ).onFailure {
            throw StatusRuntimeException(Status.INTERNAL.withCause(it))
        }.getOrThrow()

        return UploadForwardMessageResponse.newBuilder().apply {
            this.resId = forwardMessage.resId
        }.build()
    }

    @Grpc("MessageService", "DownloadForwardMessage")
    override suspend fun downloadForwardMessage(request: DownloadForwardMessageRequest): DownloadForwardMessageResponse {
        return DownloadForwardMessageResponse.newBuilder().apply {
            this.addAllMessages(
                MessageHelper.getForwardMsg(request.resId).onFailure {
                    throw StatusRuntimeException(Status.INTERNAL.withCause(it))
                }.getOrThrow().map { detail ->
                    PushMessageBody.newBuilder().apply {
                        this.time = detail.time
                        this.messageId = detail.qqMsgId.toString()
                        this.messageSeq = detail.msgSeq
                        this.contact = io.kritor.common.Contact.newBuilder().apply {
                            this.scene = when (detail.msgType) {
                                MsgConstant.KCHATTYPEC2C -> Scene.FRIEND
                                MsgConstant.KCHATTYPEGROUP -> Scene.GROUP
                                MsgConstant.KCHATTYPEGUILD -> Scene.GUILD
                                MsgConstant.KCHATTYPETEMPC2CFROMGROUP -> Scene.STRANGER_FROM_GROUP
                                MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN -> Scene.NEARBY
                                else -> Scene.STRANGER
                            }
                            this.peer = detail.peerId.toString()
                        }.build()
                        this.sender = Sender.newBuilder().apply {
                            this.uin = detail.sender.userId
                            this.nick = detail.sender.nickName
                            this.uid = detail.sender.uid
                        }.build()
                        detail.message?.elements?.toKritorResponseMessages(
                            Contact(
                                detail.msgType,
                                detail.peerId.toString(),
                                null
                            )
                        )?.let {
                            this.addAllElements(it)
                        }
                    }.build()
                }
            )
        }.build()
    }

    @Grpc("MessageService", "DeleteEssenceMessage")
    override suspend fun deleteEssenceMessage(request: DeleteEssenceMessageRequest): DeleteEssenceMessageResponse {
        val contact = MessageHelper.generateContact(MsgConstant.KCHATTYPEGROUP, request.groupId.toString())
        val msg: MsgRecord = withTimeoutOrNull(5000) {
            val service = QRoute.api(IMsgService::class.java)
            suspendCancellableCoroutine { continuation ->
                service.getMsgsByMsgId(contact, arrayListOf(request.messageId.toLong())) { code, _, msgRecords ->
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
        return DeleteEssenceMessageResponse.newBuilder().build()
    }

    @Grpc("MessageService", "GetEssenceMessageList")
    override suspend fun getEssenceMessageList(request: GetEssenceMessageListRequest): GetEssenceMessageListResponse {
        val contact = MessageHelper.generateContact(MsgConstant.KCHATTYPEGROUP, request.groupId.toString())
        return GetEssenceMessageListResponse.newBuilder().apply {
            MessageHelper.getEssenceMessageList(request.groupId, request.page, request.pageSize).onFailure {
                throw StatusRuntimeException(Status.INTERNAL.withCause(it))
            }.getOrThrow().forEach {
                addMessages(EssenceMessageBody.newBuilder().apply {
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
                        this.messageId = it.msgId.toString()
                    }
                    this.messageSeq = it.messageSeq
                    this.messageTime = it.senderTime.toInt()
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
                service.getMsgsByMsgId(contact, arrayListOf(request.messageId.toLong())) { code, _, msgRecords ->
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

    @Grpc("MessageService", "ReactMessageWithEmoji")
    override suspend fun reactMessageWithEmoji(request: ReactMessageWithEmojiRequest): ReactMessageWithEmojiResponse {
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
                service.getMsgsByMsgId(contact, arrayListOf(request.messageId.toLong())) { code, _, msgRecords ->
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
            request.isSet
        )
        return ReactMessageWithEmojiResponse.newBuilder().build()
    }
}