package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.FriendSvc
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.service.data.push.NoticeSubType
import moe.fuqiuluo.shamrock.tools.EmptyJsonString

internal object SetGroupAddRequest: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val flag = session.getString("flag")
        val approve = session.getBoolean("approve")
        val remark = session.getStringOrNull("reason")
        val notSeen = session.getBoolean("notSeen")
        val subType = session.getString("sub_type")
        return invoke(flag, approve, subType, remark, notSeen, session.echo)
    }

    suspend operator fun invoke(flag: String, approve: Boolean? = true, subType: String, remark: String? = "", notSeen: Boolean? = false, echo: JsonElement = EmptyJsonString): String {
        val flags = flag.split(";")
        val ts = flags[0].toLong()
        val groupCode = flags[1].toLong()
        val applier = flags[2].toLong()
        return try {
            val result = GroupSvc.requestGroupRequest(ts, applier, groupCode, remark ?: "", approve, notSeen)
            if (result.isSuccess) {
                ok(result.getOrNull(), echo)
            } else {
                logic(result.getOrNull() ?: "", echo)
            }
        } catch (err: Throwable) {
            err.printStackTrace()
            error("失败：${err.message}", echo)
        }

    }

    override fun path(): String = "set_group_add_request"
}