package moe.fuqiuluo.shamrock.remote.action.handlers

import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.entries.Status
import moe.fuqiuluo.shamrock.remote.entries.resultToString
import moe.fuqiuluo.shamrock.remote.service.data.BotStatus
import moe.fuqiuluo.shamrock.remote.service.data.Self
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import mqq.app.MobileQQ

internal object GetStatus: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val runtime = AppRuntimeFetcher.appRuntime
        val curUin = runtime.currentAccountUin
        return resultToString(true, Status.Ok, listOf(
            BotStatus(
                Self("qq", curUin.toLong()), runtime.isLogin, status = "正常", good = runtime.isLogin
            )
        ), echo = session.echo)
    }

    override fun path(): String = "get_status"
}