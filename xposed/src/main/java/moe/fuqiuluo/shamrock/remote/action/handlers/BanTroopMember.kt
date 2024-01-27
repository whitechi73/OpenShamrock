package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("set_group_ban")
internal object BanTroopMember: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getLong("group_id")
        val userId = session.getLong("user_id")
        val duration = session.getIntOrNull("duration") ?: (30 * 60)

        return invoke(groupId, userId, duration, session.echo)
    }

    operator fun invoke(
        groupId: Long,
        userId: Long,
        duration: Int = 30 * 60,
        echo: JsonElement = EmptyJsonString
    ): String {
        if (!GroupSvc.isAdmin(groupId.toString())) {
            return logic("You are not the administrator of the group.", echo)
        }
        GroupSvc.banMember(groupId, userId, duration)
        return ok("成功", echo)
    }

    override val requiredParams: Array<String> = arrayOf("group_id", "user_id")
}