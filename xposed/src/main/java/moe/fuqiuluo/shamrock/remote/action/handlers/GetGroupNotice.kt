package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.qqinterface.servlet.MsgSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString

internal object GetGroupNotice: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getLong("group_id")
        return invoke(groupId, session.echo)
    }

    suspend operator fun invoke(groupId: Long, echo: JsonElement = EmptyJsonString): String {
        val announcements = GroupSvc.getGroupAnnouncements(groupId)
        if (announcements.isSuccess) {
            return ok(announcements.getOrNull(), echo)
        }
        return logic(announcements.exceptionOrNull()?.message ?: "", echo)

    }

    override val alias: Array<String> = arrayOf("get_group_notice")
    override fun path(): String = "_get_group_notice"
}