package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.guild.api.transfile.IGuildTransFileApi
import com.tencent.mobileqq.qroute.QRoute
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.TicketSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.service.data.BigDataTicket
import moe.fuqiuluo.shamrock.remote.service.data.Credentials
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_cookies", ["get_cookie"])
internal object GetCookies: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val domain = session.getStringOrNull("domain")
            ?: return invoke(session.echo)
        return invoke(domain, session.echo)
    }

    operator fun invoke(echo: JsonElement = EmptyJsonString): String {
        return ok(Credentials(
            cookie = TicketSvc.getCookie(),
            bigDataTicket = QRoute.api(IGuildTransFileApi::class.java).bigDataTicket?.let {
                BigDataTicket(it.sessionKey, it.sessionSig)
            }
        ), echo)
    }

    suspend operator fun invoke(domain: String, echo: JsonElement = EmptyJsonString): String {
        return ok(Credentials(
            cookie = TicketSvc.getCookie(domain),
            bigDataTicket = QRoute.api(IGuildTransFileApi::class.java).bigDataTicket?.let {
                BigDataTicket(it.sessionKey, it.sessionSig)
            }
        ), echo)
    }
}