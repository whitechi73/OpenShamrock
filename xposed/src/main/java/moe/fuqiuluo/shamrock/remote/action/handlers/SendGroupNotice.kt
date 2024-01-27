package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.qqinterface.servlet.MsgSvc
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("send_group_notice", ["send_group_announcement"])
internal object SendGroupNotice: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getLong("group_id")
        val text = session.getString("content")
        val image = session.getStringOrNull("image")
        return invoke(groupId, text, image, session.echo)
    }

    suspend operator fun invoke(groupId: Long, text: String, image: String?, echo: JsonElement = EmptyJsonString): String {
        val groupAnnouncementMessageImage = if (image != null) {
            GroupSvc.uploadImageTroopNotice(image).onFailure {
                LogCenter.log("上传群公告图片失败：${it.message}", Level.WARN)
            }.getOrNull()
        } else null
        val announcements = GroupSvc.addQunNotice(groupId, text, groupAnnouncementMessageImage)
        if (announcements.isSuccess) {
            return ok(announcements.getOrNull(), echo)
        }
        return logic(announcements.exceptionOrNull()?.message ?: "", echo)

    }

    override val requiredParams: Array<String> = arrayOf("group_id", "content")
}