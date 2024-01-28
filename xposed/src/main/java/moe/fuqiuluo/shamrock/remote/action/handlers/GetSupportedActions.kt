package moe.fuqiuluo.shamrock.remote.action.handlers

import moe.fuqiuluo.shamrock.remote.action.ActionManager
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.structures.Status
import moe.fuqiuluo.shamrock.remote.structures.resultToString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_supported_actions")
internal object GetSupportedActions: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        return resultToString(true, Status.Ok, ActionManager.actionMap.keys.toList(), echo = session.echo)
    }
}