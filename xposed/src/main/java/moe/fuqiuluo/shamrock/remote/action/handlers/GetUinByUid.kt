package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.coroutines.suspendCancellableCoroutine
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.entries.Status
import moe.fuqiuluo.shamrock.remote.entries.resultToString
import moe.fuqiuluo.shamrock.tools.asString
import moe.fuqiuluo.shamrock.xposed.helper.NTServiceFetcher
import kotlin.coroutines.resume

internal object GetUinByUid: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val kernelService = NTServiceFetcher.kernelService
        val sessionService = kernelService.wrapperSession
        val uidList = session.getArray("uid_list").map {
            it.asString
        }
        val uinMap = suspendCancellableCoroutine { continuation ->
            sessionService.uixConvertService.getUin(uidList.toHashSet()) {
                continuation.resume(it)
            }
        }
        return resultToString(true, Status.Ok, uinMap, echo = session.echo)
    }

    override fun path(): String = "get_uin_by_uid"


}