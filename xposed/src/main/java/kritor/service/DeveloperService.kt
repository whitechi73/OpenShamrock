package kritor.service

import com.google.protobuf.ByteString
import io.kritor.developer.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeoutOrNull
import moe.fuqiuluo.shamrock.utils.FileUtils
import moe.fuqiuluo.shamrock.utils.MMKVFetcher
import moe.fuqiuluo.shamrock.utils.PlatformUtils
import qq.service.QQInterfaces
import java.io.File

internal object DeveloperService: DeveloperServiceGrpcKt.DeveloperServiceCoroutineImplBase() {
    @Grpc("DeveloperService", "Shell")
    override suspend fun shell(request: ShellRequest): ShellResponse {
        if (request.commandList.isEmpty()) return ShellResponse.newBuilder().setIsSuccess(false).build()
        val runtime = Runtime.getRuntime()
        val result = withTimeoutOrNull(5000L) {
            withContext(Dispatchers.IO) {
                runtime.exec(request.commandList.toTypedArray(), null, File(request.directory)).apply { waitFor() }
            }
        }
        return ShellResponse.newBuilder().apply {
            if (result == null) {
                isSuccess = false
            } else {
                isSuccess = true
                result.inputStream.use {
                    data = it.readBytes().toString(Charsets.UTF_8)
                }
            }
        }.build()
    }

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