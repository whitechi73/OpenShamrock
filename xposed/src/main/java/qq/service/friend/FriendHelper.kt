package qq.service.friend

import com.tencent.mobileqq.data.Friends
import com.tencent.mobileqq.friend.api.IFriendDataService
import com.tencent.mobileqq.friend.api.IFriendHandlerService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import qq.service.QQInterfaces
import kotlin.coroutines.resume

internal object FriendHelper: QQInterfaces() {
    suspend fun getFriendList(refresh: Boolean): Result<List<Friends>> {
        val service = app.getRuntimeService(IFriendDataService::class.java, "all")
        if(refresh || !service.isInitFinished) {
            if(!requestFriendList(service)) {
                return Result.failure(Exception("获取好友列表失败"))
            }
        }
        return Result.success(service.allFriends)
    }

    private suspend fun requestFriendList(dataService: IFriendDataService): Boolean {
        val service = app.getRuntimeService(IFriendHandlerService::class.java, "all")
        service.requestFriendList(true, 0)
        return suspendCancellableCoroutine { continuation ->
            val waiter = GlobalScope.launch {
                while (!dataService.isInitFinished) {
                    delay(200)
                }
                continuation.resume(true)
            }
            continuation.invokeOnCancellation {
                waiter.cancel()
                continuation.resume(false)
            }
        }
    }
}