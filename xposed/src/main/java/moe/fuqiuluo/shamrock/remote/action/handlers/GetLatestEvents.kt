package moe.fuqiuluo.shamrock.remote.action.handlers

import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.structures.EmptyObject
import moe.fuqiuluo.shamrock.remote.structures.Status
import moe.fuqiuluo.shamrock.remote.structures.resultToString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_latest_events")
internal object GetLatestEvents: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        return resultToString(
            true, Status.Ok, listOf<EmptyObject>(), echo = session.echo
        )
    }
}