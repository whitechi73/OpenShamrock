package moe.fuqiuluo.qqinterface.servlet.msg.convert

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.msg.convert.MessageElemConverter.*
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.tools.json

internal typealias MessageSegmentList = ArrayList<MessageSegment>

internal data class MessageSegment(
    val type: String,
    val data: Map<String, Any> = emptyMap()
) {
    fun toJson(): Map<String, JsonElement> {
        return hashMapOf(
            "type" to type.json,
            "data" to data.json
        )
    }
}

internal suspend fun MsgRecord.toSegments(): ArrayList<MessageSegment> {
    return MessageConvert.convertMessageRecordToMsgSegment(this)
}

internal suspend fun MsgRecord.toCQCode(): String {
    return MessageConvert.convertMessageRecordToCQCode(this)
}

internal suspend fun List<MsgElement>.toSegments(chatType: Int, peerId: String, subPeer: String): MessageSegmentList {
    return MessageConvert.convertMessageElementsToMsgSegment(chatType, this, peerId, subPeer)
}

internal suspend fun List<MsgElement>.toCQCode(chatType: Int, peerId: String, subPeer: String): String {
    return MessageConvert.convertMsgElementsToCQCode(this, chatType, peerId, subPeer)
}


internal object MessageConvert {
    private val convertMap by lazy {
        mutableMapOf<Int, IMessageConvert>(
            MsgConstant.KELEMTYPETEXT to TextConverter,
            MsgConstant.KELEMTYPEFACE to FaceConverter,
            MsgConstant.KELEMTYPEPIC to ImageConverter,
            MsgConstant.KELEMTYPEPTT to VoiceConverter,
            MsgConstant.KELEMTYPEVIDEO to VideoConverter,
            MsgConstant.KELEMTYPEMARKETFACE to MarketFaceConverter,
            MsgConstant.KELEMTYPEARKSTRUCT to StructJsonConverter,
            MsgConstant.KELEMTYPEREPLY to ReplyConverter,
            MsgConstant.KELEMTYPEGRAYTIP to GrayTipsConverter,
            MsgConstant.KELEMTYPEFILE to FileConverter,
            MsgConstant.KELEMTYPEMARKDOWN to MarkdownConverter,
            //MsgConstant.KELEMTYPEMULTIFORWARD to XmlMultiMsgConverter,
            //MsgConstant.KELEMTYPESTRUCTLONGMSG to XmlLongMsgConverter,
            MsgConstant.KELEMTYPEFACEBUBBLE to BubbleFaceConverter,
        )
    }

    suspend fun convertMessageElementsToMsgSegment(
        chatType: Int,
        elements: List<MsgElement>,
        peerId: String,
        subPeer: String
    ): ArrayList<MessageSegment> {
        val messageData = arrayListOf<MessageSegment>()
        elements.forEach { msg ->
            kotlin.runCatching {
                val elementId = msg.elementType
                val converter = convertMap[elementId]
                converter?.convert(chatType, peerId, subPeer, msg)
                    ?: throw UnsupportedOperationException("不支持的消息element类型：$elementId")
            }.onSuccess {
                messageData.add(it)
            }.onFailure {
                if (it is UnknownError) {
                    // 不处理的消息类型，抛出unknown error
                } else {
                    LogCenter.log("消息element转换错误：$it, elementType: ${msg.elementType}", Level.WARN)
                }
            }
        }
        return messageData
    }

    suspend fun convertMessageRecordToMsgSegment(record: MsgRecord, chatType: Int = record.chatType): ArrayList<MessageSegment> {
        val peerId = when(chatType) {
            MsgConstant.KCHATTYPEGUILD -> record.guildId
            else -> record.peerUin.toString()
        }
        return convertMessageElementsToMsgSegment(chatType, record.elements, peerId, record.channelId ?: peerId)
    }

    suspend fun convertMsgElementsToCQCode(
        elements: List<MsgElement>,
        chatType: Int,
        peerId: String,
        subPeer: String
    ): String {
        if(elements.isEmpty()) {
            return ""
        }
        val msgList = convertMessageElementsToMsgSegment(chatType, elements, peerId, subPeer).map {
            it.toJson()
        }
        return MessageHelper.encodeCQCode(msgList)
    }

    suspend fun convertMessageRecordToCQCode(record: MsgRecord, chatType: Int = record.chatType): String {
        val peerId = when(chatType) {
            MsgConstant.KCHATTYPEGUILD -> record.guildId
            else -> record.peerUin.toString()
        }
        return MessageHelper.encodeCQCode(
            convertMessageElementsToMsgSegment(
                chatType,
                record.elements,
                peerId,
                record.channelId ?: peerId
            ).map { it.toJson() }
        )
    }
}

internal fun interface IMessageConvert {
    suspend fun convert(chatType: Int, peerId: String, subPeer: String, element: MsgElement): MessageSegment
}

