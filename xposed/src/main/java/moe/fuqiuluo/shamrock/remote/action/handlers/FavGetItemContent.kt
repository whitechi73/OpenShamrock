@file:OptIn(ExperimentalSerializationApi::class)

package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.io.core.ByteReadPacket
import kotlinx.io.core.discardExact
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.protobuf.ProtoBuf
import moe.fuqiuluo.qqinterface.servlet.QFavSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.utils.DeflateTools
import moe.fuqiuluo.symbols.OneBotHandler
import moe.whitechi73.protobuf.fav.WeiyunComm

@OneBotHandler("fav.get_item_content")
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

        val resp = ProtoBuf.decodeFromByteArray<WeiyunComm>(data).resp!!
        return ok(ItemContent(
            resp.getFavContentResp!!.content!!.joinToString("") {
                String(it.richMedia!!.rawData!!)
            }
        ))
    }

    override val requiredParams: Array<String> = arrayOf("id")

    @Serializable
    private data class ItemContent(
        @SerialName("content") val content: String
    )
}