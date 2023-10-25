package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.mobileqq.app.QQAppInterface
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.entries.StdAccount
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import mqq.app.MobileQQ

internal object GetLoginInfo: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        return invoke(session.echo)
    }

    operator fun invoke(echo: JsonElement = EmptyJsonString): String {
        val accounts = MobileQQ.getMobileQQ().allAccounts
        val runtime = AppRuntimeFetcher.appRuntime
        val curUin = runtime.currentAccountUin
        val account = accounts.firstOrNull { it.uin == curUin }
        return if (account == null || !account.isLogined) {
            error("当前不处于已登录状态", echo = echo)
        } else {
            ok(StdAccount(
                curUin.toLong(),if (runtime is QQAppInterface) runtime.currentNickname else "unknown"
            ), echo = echo)
        }
    }

    override fun path(): String = "get_login_info"
}