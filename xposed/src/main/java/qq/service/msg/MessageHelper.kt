package qq.service.msg

import com.tencent.qqnt.kernel.api.IKernelService
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import qq.service.QQInterfaces
import qq.service.internals.msgService
import kotlin.coroutines.resume

internal object MessageHelper: QQInterfaces() {
    suspend fun getTempChatInfo(chatType: Int, uid: String): Result<TempChatInfo> {
        val msgService = app.getRuntimeService(IKernelService::class.java, "all").msgService
            ?: return Result.failure(Exception("获取消息服务失败"))
        val info: TempChatInfo = withTimeoutOrNull(5000) {
            suspendCancellableCoroutine {
                msgService.getTempChatInfo(chatType, uid) { code, msg, tempChatInfo ->
                    if (code == 0) {
                        it.resume(tempChatInfo)
                    } else {
                        LogCenter.log("获取临时会话信息失败: $code:$msg", Level.ERROR)
                        it.resume(null)
                    }
                }
            }
        } ?: return Result.failure(Exception("获取临时会话信息失败"))
        return Result.success(info)
    }
}