package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import moe.fuqiuluo.symbols.OneBotHandler
import mqq.app.MobileQQ

@OneBotHandler("switch_account")
internal object SwitchAccount: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val userId = session.getString("user_id")
        return invoke(userId, session.echo)
    }

    operator fun invoke(
        userId: String,
        echo: JsonElement = EmptyJsonString
    ): String {
        val account = MobileQQ.getMobileQQ().allAccounts.firstOrNull { it.uin == userId }
            ?: return error("账号不存在", echo)
        val runtime = AppRuntimeFetcher.appRuntime
        val result = kotlin.runCatching {
            runtime.switchAccount(account, null)
        }
        if (result.isFailure) {
            return error(result.exceptionOrNull()?.message ?: "切换账号失败", echo)
        }
        return ok("切换成功", echo)
    }

    override val requiredParams: Array<String> = arrayOf("user_id")
}