package kritor.service

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.kritor.event.MessageEvent
import io.kritor.message.*
import qq.service.contact.longPeer
import qq.service.msg.ForwardMessageHelper
import qq.service.msg.MessageHelper
import qq.service.msg.toKritorResponseMessages

internal object ForwardMessageService : ForwardMessageServiceGrpcKt.ForwardMessageServiceCoroutineImplBase() {
    @Grpc("ForwardMessageService", "UploadForwardMessage")
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
            contact.chatType,
            contact.longPeer().toString(),
            contact.guildId,
            request.messagesList
        ).onFailure {
            throw StatusRuntimeException(Status.INTERNAL.withCause(it))
        }.getOrThrow()

        return UploadForwardMessageResponse.newBuilder().apply {
            this.resId = forwardMessage.resId
        }.build()
    }

    @Grpc("ForwardMessageService", "DownloadForwardMessage")
    override suspend fun downloadForwardMessage(request: DownloadForwardMessageRequest): DownloadForwardMessageResponse {
        return DownloadForwardMessageResponse.newBuilder().apply {
            this.addAllMessages(
                MessageHelper.getForwardMsg(request.resId).onFailure {
                    throw StatusRuntimeException(Status.INTERNAL.withCause(it))
                }.getOrThrow().map { detail ->
                    MessageEvent.newBuilder().apply {
                        this.time = detail.time
                        this.messageId = detail.qqMsgId
                        this.messageSeq = detail.msgSeq
                        this.contact = Contact.newBuilder().apply {
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
                            com.tencent.qqnt.kernel.nativeinterface.Contact(
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
}