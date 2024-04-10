package kritor.service

import com.google.protobuf.ByteString
import com.tencent.mobileqq.fe.FEKit
import com.tencent.mobileqq.qsec.qsecdandelionsdk.Dandelion
import io.kritor.developer.*


internal object QsignService: QsignServiceGrpcKt.QsignServiceCoroutineImplBase() {
    @Grpc("QsignService", "Sign")
    override suspend fun sign(request: SignRequest): SignResponse {
        return SignResponse.newBuilder().apply {
            val result = FEKit.getInstance().getSign(request.command, request.buffer.toByteArray(), request.seq, request.uin)
            this.secSig = ByteString.copyFrom(result.sign)
            this.secDeviceToken = ByteString.copyFrom(result.token)
            this.secExtra = ByteString.copyFrom(result.extra)
        }.build()
    }

    @Grpc("QsignService", "Energy")
    override suspend fun energy(request: EnergyRequest): EnergyResponse {
        return EnergyResponse.newBuilder().apply {
            this.result = ByteString.copyFrom(Dandelion.getInstance().fly(request.data, request.salt.toByteArray()))
        }.build()
    }

    @Grpc("QsignService", "GetCmdWhitelist")
    override suspend fun getCmdWhitelist(request: GetCmdWhitelistRequest): GetCmdWhitelistResponse {
        return GetCmdWhitelistResponse.newBuilder().apply {
            addAllCommands(FEKit.getInstance().cmdWhiteList)
        }.build()
    }
}