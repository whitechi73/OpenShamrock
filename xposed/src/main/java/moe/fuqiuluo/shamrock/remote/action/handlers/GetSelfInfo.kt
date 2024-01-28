package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.mobileqq.app.QQAppInterface
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.structures.Status
import moe.fuqiuluo.shamrock.remote.structures.resultToString
import moe.fuqiuluo.shamrock.remote.service.data.UserDetail
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_self_info")
internal object GetSelfInfo: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        //val accounts = MobileQQ.getMobileQQ().allAccounts
        val runtime = AppRuntimeFetcher.appRuntime as QQAppInterface
        val curUin = runtime.currentAccountUin
        //val account = accounts.firstOrNull { it.uin == curUin }

        return resultToString(true, Status.Ok, UserDetail(
            curUin.toLong(), runtime.currentNickname, runtime.currentNickname
        ), echo = session.echo)
    }
}