package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.io.core.ByteReadPacket
import kotlinx.io.core.discardExact
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.json.JsonElement

import moe.fuqiuluo.qqinterface.servlet.QFavSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.utils.DeflateTools
import moe.fuqiuluo.symbols.OneBotHandler
import moe.fuqiuluo.symbols.decodeProtobuf
import protobuf.fav.WeiyunComm

@OneBotHandler("fav.get_item_list")
internal object FavGetItemList: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val category = session.getInt("category")
        val startPos = session.getInt("start_pos")
        val pageSize = session.getInt("page_size")
        return invoke(category, startPos, pageSize, session.echo)
    }

    suspend operator fun invoke(
        category: Int,
        startPos: Int,
        pageSize: Int,
        echo: JsonElement = EmptyJsonString
    ): String {
        if (pageSize <= 1) {
            return logic("page_size must be greater than 1", echo)
        }

        val result = DeflateTools.ungzip(QFavSvc.getItemList(
            category = category,
            startPos = startPos,
            pageSize = pageSize
        ).onSuccess {
            if (it.mHttpCode != 200 || it.mResult != 0) {
                return logic("fav.get_item_list failed", echo)
            }
        }.getOrThrow().mRespData)
        val readPacket = ByteReadPacket(result)
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
        val resp = data.decodeProtobuf<WeiyunComm>().resp!!.getFavListResp!!

        val itemList = arrayListOf<Item>()
        val rawItemList = resp.collections!!
        rawItemList.forEach {
            val itemId = it.cid
            val author = it.author!!
            val authorType = author.type.toInt()
            val authorId = author.numId.toLong()
            val authorName = author.strId
            val groupName: String
            val groupId: Long
            if (authorType == 2) {
                groupName = author.groupName
                groupId = author.groupId.toLong()
            } else {
                groupName = ""
                groupId = 0L
            }
            val clientVersion = it.srcAppVer
            val time = it.createTime.toLong()
            itemList.add(Item(
                id = itemId,
                authorType = authorType,
                author = authorId,
                authorName = authorName,
                groupName = groupName,
                groupId = groupId,
                clientVersion = clientVersion,
                time = time
            ))
        }

        return ok(ItemList(itemList), echo)
    }

    override val requiredParams: Array<String> = arrayOf("category", "start_pos", "page_size")

    @Serializable
    private data class ItemList(
        val items: List<Item>
    )

    @Serializable
    private data class Item(
        @SerialName("id") val id: String,
        @SerialName("author_type") val authorType: Int,
        @SerialName("author") val author: Long,
        @SerialName("author_name") val authorName: String,
        @SerialName("group_name") val groupName: String,
        @SerialName("group_id") val groupId: Long,
        @SerialName("client_version") val clientVersion: String,
        @SerialName("time") val time: Long
    )
}