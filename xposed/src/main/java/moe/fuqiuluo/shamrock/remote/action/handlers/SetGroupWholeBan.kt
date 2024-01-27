package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("set_group_whole_ban")
internal object SetGroupWholeBan: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getLong("group_id")
        val enable = session.getBoolean("enable")
        return invoke(groupId, enable, session.echo)
    }

    operator fun invoke(groupId: Long, enable: Boolean, echo: JsonElement = EmptyJsonString): String {
        GroupSvc.setGroupWholeBan(groupId, enable)
        return ok("成功", echo)
    }

    override val requiredParams: Array<String> = arrayOf()
}