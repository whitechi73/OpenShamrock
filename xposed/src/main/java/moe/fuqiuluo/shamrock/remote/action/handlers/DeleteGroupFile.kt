package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.FileSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("delete_group_file")
internal object DeleteGroupFile: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getLong("group_id")
        val fileId = session.getString("file_id")
        val busid = session.getInt("busid")
        return invoke(groupId, fileId, busid, session.echo)
    }

    suspend operator fun invoke(groupId: Long, fileId: String, bizId: Int, echo: JsonElement = EmptyJsonString): String {
        if(!FileSvc.deleteGroupFile(groupId, bizId, fileId)) {
            return error("删除失败", echo = echo)
        }
        return ok("成功", echo)
    }

    override val requiredParams: Array<String> = arrayOf("group_id", "file_id", "busid")
}