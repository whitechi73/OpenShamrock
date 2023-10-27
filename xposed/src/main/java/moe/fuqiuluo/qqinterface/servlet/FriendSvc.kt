@file:OptIn(DelicateCoroutinesApi::class)
package moe.fuqiuluo.qqinterface.servlet

import com.tencent.mobileqq.data.Friends
import com.tencent.mobileqq.friend.api.IFriendDataService
import com.tencent.mobileqq.friend.api.IFriendHandlerService
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import moe.fuqiuluo.qqinterface.servlet.BaseSvc
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import mqq.app.AppRuntime
import mqq.app.MobileQQ
import kotlin.coroutines.resume

internal object FriendSvc: BaseSvc() {

    suspend fun getFriendList(refresh: Boolean): Result<List<Friends>> {
        val runtime = AppRuntimeFetcher.appRuntime
        val service = runtime.getRuntimeService(IFriendDataService::class.java, "all")
        if(refresh || !service.isInitFinished) {
            if(!requestFriendList(runtime, service)) {
                return Result.failure(Exception("获取好友列表失败"))
            }
        }
        return Result.success(service.allFriends)
    }

    private suspend fun requestFriendList(runtime: AppRuntime, dataService: IFriendDataService): Boolean {
        val service = runtime.getRuntimeService(IFriendHandlerService::class.java, "all")
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