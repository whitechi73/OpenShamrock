package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.io.core.ByteReadPacket
import kotlinx.io.core.discardExact
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.proto.ProtoUtils
import moe.fuqiuluo.proto.asInt
import moe.fuqiuluo.proto.asList
import moe.fuqiuluo.proto.asLong
import moe.fuqiuluo.proto.asMap
import moe.fuqiuluo.proto.asULong
import moe.fuqiuluo.proto.asUtf8String
import moe.fuqiuluo.qqinterface.servlet.QFavSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.tools.toHexString
import moe.fuqiuluo.shamrock.utils.DeflateTools

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
        val pb = ProtoUtils.decodeFromByteArray(data)

        val itemList = arrayListOf<Item>()
        val rawItemList = pb[2, 20000, 1].asList
        rawItemList.value.forEach {
            val item = it.asMap
            val itemId = item[1].asUtf8String
            val authorType = item[4, 1].asInt
            val author = item[4, 2].asULong
            val authorName = item[4, 3].asUtf8String
            val groupName: String
            val groupId: Long
            if (authorType == 2) {
                groupName = item[4, 5].asUtf8String
                groupId = item[4, 4].asULong
            } else {
                groupName = ""
                groupId = 0L
            }
            val clientVersion = item[7].asUtf8String
            val time = item[9].asLong
            itemList.add(Item(
                id = itemId,
                authorType = authorType,
                author = author,
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

    override fun path(): String = "fav.get_item_list"

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