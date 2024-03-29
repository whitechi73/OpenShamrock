package kritor.service

import android.util.Base64
import com.tencent.mobileqq.app.QQAppInterface
import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.kritor.core.*
import moe.fuqiuluo.shamrock.tools.ShamrockVersion
import moe.fuqiuluo.shamrock.utils.DownloadUtils
import moe.fuqiuluo.shamrock.utils.FileUtils
import moe.fuqiuluo.shamrock.utils.MD5
import mqq.app.MobileQQ
import qq.service.QQInterfaces.Companion.app
import qq.service.contact.ContactHelper
import java.io.File

internal object CoreService : CoreServiceGrpcKt.CoreServiceCoroutineImplBase() {
    @Grpc("CoreService", "GetVersion")
    override suspend fun getVersion(request: GetVersionRequest): GetVersionResponse {
        return GetVersionResponse.newBuilder().apply {
            this.version = ShamrockVersion
            this.appName = "Shamrock"
        }.build()
    }

    @Grpc("CoreService", "GetCurrentAccount")
    override suspend fun getCurrentAccount(request: GetCurrentAccountRequest): GetCurrentAccountResponse {
        return GetCurrentAccountResponse.newBuilder().apply {
            this.accountName = if (app is QQAppInterface) app.currentNickname else "unknown"
            this.accountUid = app.currentUid ?: ""
            this.accountUin = (app.currentUin ?: "0").toLong()
        }.build()
    }

    @Grpc("CoreService", "DownloadFile")
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
        } else if (request.hasUrl()) {
            if (!DownloadUtils.download(
                    urlAdr = request.url,
                    dest = tmp,
                    headers = headerMap,
                    threadCount = if (request.hasThreadCnt()) request.threadCnt else 3
                )
            ) {
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

        return DownloadFileResponse.newBuilder().apply {
            this.fileMd5 = MD5.genFileMd5Hex(tmp.absolutePath)
            this.fileAbsolutePath = tmp.absolutePath
        }.build()
    }

    @Grpc("CoreService", "SwitchAccount")
    override suspend fun switchAccount(request: SwitchAccountRequest): SwitchAccountResponse {
        val uin = when (request.accountCase!!) {
            SwitchAccountRequest.AccountCase.ACCOUNT_UID -> ContactHelper.getUinByUidAsync(request.accountUid)
            SwitchAccountRequest.AccountCase.ACCOUNT_UIN -> request.accountUin.toString()
            SwitchAccountRequest.AccountCase.ACCOUNT_NOT_SET -> throw StatusRuntimeException(
                Status.INVALID_ARGUMENT.withDescription(
                    "account not found"
                )
            )
        }
        val account = MobileQQ.getMobileQQ().allAccounts.firstOrNull { it.uin == uin }
            ?: throw StatusRuntimeException(Status.NOT_FOUND.withDescription("account not found"))
        runCatching {
            app.switchAccount(account, null)
        }.onFailure {
            throw StatusRuntimeException(Status.INTERNAL.withCause(it).withDescription("failed to switch account"))
        }
        return SwitchAccountResponse.newBuilder().build()
    }
}