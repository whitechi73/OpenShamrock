package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.FileSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString

internal object DeleteGroupFile: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getString("group_id")
        val fileId = session.getString("file_id")
        val busid = session.getInt("busid")
        return invoke(groupId, fileId, busid, session.echo)
    }

    /*
        suspend operator fun invoke(
        groupId: String,
        fileId: String,
        bizId: Int,
        echo: JsonElement = EmptyJsonString
    ): String {
        val result = FileSvc.deleteGroupFile(groupId, bizId, fileId)
        if(result.isFailure) {
            return error(result.exceptionOrNull()?.message ?: "删除群文件失败", echo)
        }
        val commonResult = result.getOrThrow()
        if (commonResult.first != 0 || commonResult.second.retCode != 0) {
            return error(commonResult.second.clientWording, echo)
        }
        return ok("成功", echo)
    }
     */
    operator fun invoke(groupId: String, fileId: String, bizId: Int, echo: JsonElement = EmptyJsonString): String {
        FileSvc.deleteGroupFile(groupId, bizId, fileId)
        return ok("成功", echo)
    }

    override val requiredParams: Array<String> = arrayOf("group_id", "file_id", "busid")

    override fun path(): String = "delete_group_file"
}