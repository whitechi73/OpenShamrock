package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("set_group_remark", ["modify_group_remark"])
internal object ModifyTroopRemark: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getLong("group_id")
        val remark = session.getStringOrNull("remark") ?: ""
        return invoke(groupId, remark, session.echo)
    }

    operator fun invoke(groupId: Long, remark: String, echo: JsonElement = EmptyJsonString): String {
        return if(GroupSvc.modifyGroupRemark(groupId, remark))
            ok("成功", echo)
        else error("check if member or group exist", echo)
    }

    override val requiredParams: Array<String> = arrayOf("group_id")
}