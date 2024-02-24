package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("poke")
internal object GroupPoke: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getLong("group_id")
        val userId = session.getLong("user_id")
        return invoke(groupId, userId, session.echo)
    }

    operator fun invoke(groupId: Long, userId: Long, echo: JsonElement = EmptyJsonString): String {
        GroupSvc.poke(groupId, userId)
        return ok("成功", echo)
    }

    override val requiredParams: Array<String> = arrayOf("group_id", "user_id")
}