package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.FriendSvc
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString

internal object SetFriendAddRequest: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val flag = session.getString("flag")
        val approve = session.getBoolean("approve")
        val remark = session.getStringOrNull("remark")
        val notSeen = session.getBoolean("notSeen")
        return invoke(flag, approve, remark, notSeen, session.echo)
    }

    operator fun invoke(flag: String, approve: Boolean? = true, remark: String? = "", notSeen: Boolean? = false, echo: JsonElement = EmptyJsonString): String {
        val flags = flag.split(";")
        val ts = flags[0].toLong()
//        val src = flags[1].toInt()
//        val subSrc = flags[2].toInt()
        val applier = flags[3].toLong()
        return try {
            FriendSvc.requestFriendRequest(ts, applier, remark ?: "", approve, notSeen)
            ok("成功", echo)
        } catch (err: Throwable) {
            err.printStackTrace()
            error("失败：${err.message}", echo)
        }

    }

    override fun path(): String = "set_friend_add_request"
}