package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("set_group_special_title")
internal object SetGroupUnique: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getString("group_id")
        val userId = session.getString("user_id")
        val unique = session.getString("special_title")
        return invoke(groupId, userId, unique, session.echo)
    }

    suspend operator fun invoke(groupId: String, userId: String, unique: String, echo: JsonElement = EmptyJsonString): String {
        if (!GroupSvc.isOwner(groupId)) {
            return error("you are not owner", echo)
        }
        GroupSvc.setGroupUniqueTitle(groupId, userId, unique)
        return ok("成功", echo)
    }

    override val requiredParams: Array<String> = arrayOf("group_id", "user_id", "special_title")
}