package kritor.service

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.kritor.message.Element
import io.kritor.message.ElementType
import io.kritor.message.ForwardMessageRequest
import io.kritor.message.ForwardMessageResponse
import io.kritor.message.ForwardMessageServiceGrpcKt
import io.kritor.message.Scene
import io.kritor.message.element
import io.kritor.message.forwardMessageResponse
import qq.service.contact.longPeer
import qq.service.msg.ForwardMessageHelper
import qq.service.msg.MessageHelper
import qq.service.msg.NtMsgConvertor

internal object ForwardMessageService: ForwardMessageServiceGrpcKt.ForwardMessageServiceCoroutineImplBase() {
    @Grpc("ForwardMessageService", "ForwardMessage")
    override suspend fun forwardMessage(request: ForwardMessageRequest): ForwardMessageResponse {
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

        val forwardMessage = ForwardMessageHelper.uploadMultiMsg(contact.chatType, contact.longPeer().toString(), contact.guildId, request.messagesList).onFailure {
            throw StatusRuntimeException(Status.INTERNAL.withCause(it))
        }.getOrThrow()

        val uniseq = MessageHelper.generateMsgId(contact.chatType)
        return forwardMessageResponse {
            this.messageId = MessageHelper.sendMessage(contact, NtMsgConvertor.convertToNtMsgs(contact, uniseq, arrayListOf(element {
                this.type = ElementType.FORWARD
                this.forward = forwardMessage
            })), request.retryCount, uniseq).onFailure {
                throw StatusRuntimeException(Status.INTERNAL.withCause(it))
            }.getOrThrow()
            this.resId = forwardMessage.id
        }
    }
}