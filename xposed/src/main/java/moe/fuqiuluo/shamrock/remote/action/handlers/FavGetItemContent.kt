package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.io.core.ByteReadPacket
import kotlinx.io.core.discardExact
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.proto.ProtoUtils
import moe.fuqiuluo.proto.asUtf8String
import moe.fuqiuluo.qqinterface.servlet.QFavSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.tools.toHexString
import moe.fuqiuluo.shamrock.utils.DeflateTools

internal object FavGetItemContent: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val id = session.getString("id")
        return invoke(id, session.echo)
    }

    suspend operator fun invoke(
        id: String,
        echo: JsonElement = EmptyJsonString
    ): String {
        val respData = DeflateTools.ungzip(QFavSvc.getItemContent(id).onSuccess {
            if (it.mHttpCode != 200 || it.mResult != 0) {
                return logic(it.mErrDesc, echo)
            }
        }.getOrThrow().mRespData)
        val readPacket = ByteReadPacket(respData)
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

        return ok(ItemContent(pb[2, 20001, 1, 8, 2].asUtf8String))
    }

    override fun path(): String = "fav.get_item_content"

    override val requiredParams: Array<String> = arrayOf("id")

    @Serializable
    private data class ItemContent(
        @SerialName("content") val content: String
    )
}