package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.io.core.ByteReadPacket
import kotlinx.io.core.discardExact
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.proto.ProtoUtils
import moe.fuqiuluo.proto.asUtf8String
import moe.fuqiuluo.qqinterface.servlet.QFavSvc
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.tools.toHexString
import moe.fuqiuluo.shamrock.utils.DeflateTools

internal object FavAddTextMsg: IActionHandler() {
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
                val readPacket = ByteReadPacket(DeflateTools.ungzip(it.mRespData))
                readPacket.discardExact(6)
                val allLength = readPacket.readInt()
                val dataLength = readPacket.readInt()
                val headLength = allLength - dataLength - 16
                readPacket.discardExact(2)
                ByteArray(headLength).also {
                    readPacket.readFully(it, 0, it.size)
                }
                val data = ByteArray(dataLength).also {
                    readPacket.readFully(it, 0, it.size)
                }
                val pb = ProtoUtils.decodeFromByteArray(data)

                ok(data = QFavItem(
                    pb[2, 20009, 1].asUtf8String
                ), echo)
            } else {
                logic(it.mErrDesc, echo)
            }
        }
        return ok("请求已提交", echo)
    }

    override fun path(): String = "fav.add_text_msg"

    override val requiredParams: Array<String> = arrayOf("user_id", "nick", "content")

    @Serializable
    private data class QFavItem(
        @SerialName("id") val id: String
    )
}