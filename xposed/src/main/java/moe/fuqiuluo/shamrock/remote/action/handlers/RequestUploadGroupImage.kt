package moe.fuqiuluo.shamrock.remote.action.handlers

import moe.fuqiuluo.qqinterface.servlet.transfile.NtV2RichMediaSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("request_upload_group_image")
internal object RequestUploadGroupImage: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val md5 = session.getString("md5").uppercase()
        val fileSize = session.getLong("file_size")
        val width = session.getInt("width")
        val height = session.getInt("height")
        val groupId = session.getString("group_id")
        NtV2RichMediaSvc.requestUploadGroupPic(
            groupId.toULong(),
            md5,
            fileSize.toULong(),
            width.toUInt(),
            height.toUInt()
        ).onSuccess {
            return ok(it, session.echo)
        }.onFailure {
            return error(it.message ?: it.toString(), session.echo)
        }
        return logic("request_upload_group_image failed", session.echo)
    }
}