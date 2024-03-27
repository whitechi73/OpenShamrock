package kritor.service

import com.google.protobuf.ByteString
import io.kritor.developer.*
import moe.fuqiuluo.shamrock.utils.FileUtils
import moe.fuqiuluo.shamrock.utils.MMKVFetcher
import moe.fuqiuluo.shamrock.utils.PlatformUtils
import qq.service.QQInterfaces

internal object DeveloperService: DeveloperServiceGrpcKt.DeveloperServiceCoroutineImplBase() {
    @Grpc("DeveloperService", "ClearCache")
    override suspend fun clearCache(request: ClearCacheRequest): ClearCacheResponse {
        FileUtils.clearCache()
        MMKVFetcher.mmkvWithId("audio2silk")
            .clear()
        return ClearCacheResponse.newBuilder().build()
    }

    @Grpc("DeveloperService", "GetDeviceBattery")
    override suspend fun getDeviceBattery(request: GetDeviceBatteryRequest): GetDeviceBatteryResponse {
        return GetDeviceBatteryResponse.newBuilder().apply {
            PlatformUtils.getDeviceBattery().let {
                this.battery = it.battery
                this.scale = it.scale
                this.status = it.status
            }
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