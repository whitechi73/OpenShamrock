package kritor.service

import com.google.protobuf.ByteString
import com.tencent.mobileqq.fe.FEKit
import com.tencent.mobileqq.qsec.qsecdandelionsdk.Dandelion
import io.kritor.developer.*
import qq.service.QQInterfaces

internal object DeveloperService: DeveloperServiceGrpcKt.DeveloperServiceCoroutineImplBase() {
    @Grpc("DeveloperService", "Sign")
    override suspend fun sign(request: SignRequest): SignResponse {
        return SignResponse.newBuilder().apply {
            val result = FEKit.getInstance().getSign(request.command, request.buffer.toByteArray(), request.seq, request.uin)
            this.sign = ByteString.copyFrom(result.sign)
            this.token = ByteString.copyFrom(result.token)
            this.extra = ByteString.copyFrom(result.extra)
        }.build()
    }

    @Grpc("DeveloperService", "Energy")
    override suspend fun energy(request: EnergyRequest): EnergyResponse {
        return EnergyResponse.newBuilder().apply {
            this.result = ByteString.copyFrom(Dandelion.getInstance().fly(request.data, request.salt.toByteArray()))
        }.build()
    }


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