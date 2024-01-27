package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("set_group_add_request")
internal object SetGroupAddRequest: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val flag = session.getString("flag")
        val approve = session.getBooleanOrDefault("approve", true)
        val remark = session.getStringOrNull("reason")
        val notSeen = session.getBooleanOrDefault("not_seen", false)
        val subType = session.getString("sub_type")
        return invoke(flag, approve, subType, remark, notSeen, session.echo)
    }

    suspend operator fun invoke(flag: String, approve: Boolean? = true, subType: String, remark: String? = "", notSeen: Boolean? = false, echo: JsonElement = EmptyJsonString): String {
        val flags = flag.split(";")
        var ts = flags[0].toLong()
        try {
            if (ts.toString().length < 13) {
                // time but not seq, query seq again
                var reqs = GroupSvc.requestGroupSystemMsgNew(20, 1)
                val riskReqs = GroupSvc.requestGroupSystemMsgNew(20, 2)
                reqs = reqs + riskReqs
                val req = reqs.firstOrNull {
                    it.msg_time.get() == ts
                }
                ts = req?.msg_seq?.get() ?: return error("失败：未找到该请求", echo)
            }
        } catch (err: Throwable) {
            LogCenter.log(err.stackTraceToString(), Level.WARN)
            return error("查找请求失败：${err.message}", echo)
        }
        val groupCode = flags[1].toLong()
        val uin = flags[2].toLong()
        return try {
            val result = GroupSvc.requestGroupRequest(ts, uin, groupCode, remark ?: "", approve, notSeen, subType)
            if (result.isSuccess) {
                ok(result.getOrNull(), echo)
            } else {
                logic(result.exceptionOrNull()?.message ?: "", echo)
            }
        } catch (err: Throwable) {
            err.printStackTrace()
            error("失败：${err.message}", echo)
        }
    }

    override val requiredParams: Array<String> = arrayOf("flag", "sub_type")
}