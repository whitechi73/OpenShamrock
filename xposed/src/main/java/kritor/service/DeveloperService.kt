package kritor.service

import com.google.protobuf.ByteString
import io.kritor.developer.*
import qq.service.QQInterfaces

internal object DeveloperService: DeveloperServiceGrpcKt.DeveloperServiceCoroutineImplBase() {
    @Grpc("DeveloperService", "SendPacket")
    override suspend fun sendPacket(request: SendPacketRequest): SendPacketResponse {
        return SendPacketResponse.newBuilder().apply {
            val fromServiceMsg = QQInterfaces.sendBufferAW(request.command, request.isProtobuf, request.requestBuffer.toByteArray())
            if (fromServiceMsg?.wupBuffer == null) {
                this.isSuccess = false
            } else {
                this.isSuccess = true
                this.responseBuffer = ByteString.copyFrom(fromServiceMsg.wupBuffer)
            }
        }.build()
    }
}