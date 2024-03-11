package kritor.service

import android.util.Base64
import com.tencent.mobileqq.app.QQAppInterface
import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.kritor.core.ClearCacheRequest
import io.kritor.core.ClearCacheResponse
import io.kritor.core.DownloadFileRequest
import io.kritor.core.DownloadFileResponse
import io.kritor.core.GetCurrentAccountRequest
import io.kritor.core.GetCurrentAccountResponse
import io.kritor.core.GetVersionRequest
import io.kritor.core.GetVersionResponse
import io.kritor.core.KritorServiceGrpcKt
import io.kritor.core.SwitchAccountRequest
import io.kritor.core.SwitchAccountResponse
import io.kritor.core.clearCacheResponse
import io.kritor.core.downloadFileResponse
import io.kritor.core.getCurrentAccountResponse
import io.kritor.core.getVersionResponse
import io.kritor.core.switchAccountResponse
import moe.fuqiuluo.shamrock.tools.ShamrockVersion
import moe.fuqiuluo.shamrock.utils.DownloadUtils
import moe.fuqiuluo.shamrock.utils.FileUtils
import moe.fuqiuluo.shamrock.utils.MD5
import moe.fuqiuluo.shamrock.utils.MMKVFetcher
import mqq.app.MobileQQ
import qq.service.QQInterfaces
import qq.service.QQInterfaces.Companion.app
import qq.service.contact.ContactHelper
import java.io.File

object KritorService: KritorServiceGrpcKt.KritorServiceCoroutineImplBase() {
    @Grpc("KritorService", "GetVersion")
    override suspend fun getVersion(request: GetVersionRequest): GetVersionResponse {
        return getVersionResponse {
            this.version = ShamrockVersion
            this.appName = "Shamrock"
        }
    }

    @Grpc("KritorService", "ClearCache")
    override suspend fun clearCache(request: ClearCacheRequest): ClearCacheResponse {
        FileUtils.clearCache()
        MMKVFetcher.mmkvWithId("audio2silk")
            .clear()
        return clearCacheResponse {}
    }

    @Grpc("KritorService", "GetCurrentAccount")
    override suspend fun getCurrentAccount(request: GetCurrentAccountRequest): GetCurrentAccountResponse {
        return getCurrentAccountResponse {
            this.accountName = if (app is QQAppInterface) app.currentNickname else "unknown"
            this.accountUid = app.currentUid ?: ""
            this.accountUin = (app.currentUin ?: "0").toLong()
        }
    }

    @Grpc("KritorService", "DownloadFile")
    override suspend fun downloadFile(request: DownloadFileRequest): DownloadFileResponse {
        val headerMap = mutableMapOf(
            "User-Agent" to "Shamrock"
        )
        if (request.hasHeaders()) {
            request.headers.split("[\r\n]").forEach {
                val pair = it.split("=")
                if (pair.size >= 2) {
                    val (k, v) = pair
                    headerMap[k] = v
                }
            }
        }

        var tmp = FileUtils.getTmpFile("cache")
        if (request.hasBase64()) {
            val bytes = Base64.decode(request.base64, Base64.DEFAULT)
            tmp.writeBytes(bytes)
        } else if(request.hasUrl()) {
            if(!DownloadUtils.download(
                    urlAdr = request.url,
                    dest = tmp,
                    headers = headerMap,
                    threadCount = if (request.hasThreadCnt()) request.threadCnt else 3
            )) {
                throw StatusRuntimeException(Status.INTERNAL.withDescription("download failed"))
            }
        }
        tmp = if (!request.hasFileName()) FileUtils.renameByMd5(tmp)
        else tmp.parentFile!!.resolve(request.fileName).also {
            tmp.renameTo(it)
        }
        if (request.hasRootPath()) {
            tmp = File(request.rootPath).resolve(tmp.name).also {
                tmp.renameTo(it)
            }
        }

        return downloadFileResponse {
            this.fileMd5 = MD5.genFileMd5Hex(tmp.absolutePath)
            this.fileAbsolutePath = tmp.absolutePath
        }
    }

    @Grpc("KritorService", "SwitchAccount")
    override suspend fun switchAccount(request: SwitchAccountRequest): SwitchAccountResponse {
        val uin = if (request.hasAccountUin()) request.accountUin.toString()
        else ContactHelper.getUinByUidAsync(request.accountUid)
        val account = MobileQQ.getMobileQQ().allAccounts.firstOrNull { it.uin == uin }
            ?: throw StatusRuntimeException(Status.NOT_FOUND.withDescription("account not found"))
        runCatching {
            app.switchAccount(account, null)
        }.onFailure {
            throw StatusRuntimeException(Status.INTERNAL.withCause(it).withDescription("failed to switch account"))
        }
        return switchAccountResponse {  }
    }
}