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
        val approve = session.getBooleanOrDefault("approve", true)
        val remark = session.getStringOrNull("remark")
        val notSeen = session.getBooleanOrDefault("notSeen", false)
        return invoke(flag, approve, remark, notSeen, session.echo)
    }

    suspend operator fun invoke(flag: String, approve: Boolean? = true, remark: String? = "", notSeen: Boolean? = false, echo: JsonElement = EmptyJsonString): String {
        val flags = flag.split(";")
        var ts = flags[0].toLong()
//        val src = flags[1].toInt()
//        val subSrc = flags[2].toInt()
        val applier = flags[3].toLong()
        if (ts.toString().length < 13) {
            // time but not seq, query seq again
            val reqs = FriendSvc.requestFriendSystemMsgNew(20, 0, 0, 1)
            val req = reqs?.firstOrNull {
                it.msg_time.get() == ts
            }
            // 好友请求seq貌似就是time*1000，查不到直接*1000
            ts = req?.msg_seq?.get() ?: (ts * 1000)
        }
        return try {
            FriendSvc.requestFriendRequest(ts, applier, remark ?: "", approve, notSeen)
            ok("成功", echo)
        } catch (err: Throwable) {
            err.printStackTrace()
            error("失败：${err.message}", echo)
        }

    }

    override fun path(): String = "set_friend_add_request"

    override val requiredParams: Array<String> = arrayOf("flag")
}