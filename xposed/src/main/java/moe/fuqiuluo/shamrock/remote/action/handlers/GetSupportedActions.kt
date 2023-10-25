package moe.fuqiuluo.shamrock.remote.action.handlers

import moe.fuqiuluo.shamrock.remote.action.ActionManager
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.entries.Status
import moe.fuqiuluo.shamrock.remote.entries.resultToString

internal object GetSupportedActions: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        return resultToString(true, Status.Ok, ActionManager.actionMap.keys.toList(), echo = session.echo)
    }

    override fun path(): String = "get_supported_actions"
}