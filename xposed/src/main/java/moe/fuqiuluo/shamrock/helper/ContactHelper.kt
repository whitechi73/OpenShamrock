package moe.fuqiuluo.shamrock.helper

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import kotlinx.coroutines.suspendCancellableCoroutine
import moe.fuqiuluo.qqinterface.servlet.FriendSvc
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.shamrock.xposed.helper.NTServiceFetcher
import kotlin.coroutines.resume

internal object ContactHelper {
    suspend fun getUinByUidAsync(uid: String): String {
        if (uid.isBlank() || uid == "0") {
            return "0"
        }

        val kernelService = NTServiceFetcher.kernelService
        val sessionService = kernelService.wrapperSession

        return suspendCancellableCoroutine { continuation ->
            sessionService.uixConvertService.getUin(hashSetOf(uid)) {
                continuation.resume(it)
            }
        }[uid]?.toString() ?: "0"
    }

    suspend fun getUidByUinAsync(peerId: Long): String {
        val kernelService = NTServiceFetcher.kernelService
        val sessionService = kernelService.wrapperSession
        return suspendCancellableCoroutine { continuation ->
            sessionService.uixConvertService.getUid(hashSetOf(peerId)) {
                continuation.resume(it)
            }
        }[peerId]!!
    }

    /**
     * 检查联系人是否可用, 每次都刷新，性能有损耗
     */
    suspend fun checkContactAvailable(chatType: Int, peerId: String): Boolean {
        return when(chatType) {
            MsgConstant.KCHATTYPEGROUP -> {
                GroupSvc.getGroupList(true).getOrNull()?.find {
                    it.troopcode == peerId
                } != null
            }

            MsgConstant.KCHATTYPEC2C -> {
                FriendSvc.getFriendList(true).getOrNull()?.find {
                    it.uin == peerId
                } != null
            }
            else -> error("unknown chat type: $chatType")
        }
    }
}