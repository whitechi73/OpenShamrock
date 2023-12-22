package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.QFavSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString

internal object FavAddRichMediaMsg: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val uin = session.getLong("user_id")
        val nickName = session.getString("nick")
        val groupName = session.getStringOrNull("group_name") ?: ""
        val groupId = session.getLongOrNull("group_id") ?: 0L
        val time = session.getLongOrNull("time") ?: System.currentTimeMillis()
        val content = session.getString("content")
        return invoke(uin, nickName, time, content, groupName, groupId, session.echo)
    }

    suspend operator fun invoke(
        uin: Long,
        nickName: String,
        time: Long = System.currentTimeMillis(),
        content: String,
        groupName: String = "",
        groupId: Long = 0L,
        echo: JsonElement = EmptyJsonString
    ): String {
        QFavSvc.addRichMediaMsg(uin, nickName,
            time = time,
            content = content,
            groupName = groupName,
            groupId = groupId
        ).onSuccess {
            return if (it.mHttpCode == 200 && it.mResult == 0) {
                ok("成功", echo)
            } else {
                logic(it.mErrDesc, echo)
            }
        }
        return ok("请求已提交", echo)
    }

    override fun path(): String = "fav.add_rich_media_msg"

    override val requiredParams: Array<String> = arrayOf("user_id", "nick", "content")
}