package moe.fuqiuluo.qqinterface.servlet.msg.convert

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import kotlinx.serialization.json.JsonElement
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

internal suspend fun List<MsgElement>.toSegments(chatType: Int, peerId: String): MessageSegmentList {
    return MessageConvert.convertMessageElementsToMsgSegment(chatType, this, peerId)
}

internal suspend fun List<MsgElement>.toCQCode(chatType: Int, peerId: String): String {
    return MessageConvert.convertMsgElementsToCQCode(this, chatType, peerId)
}


internal object MessageConvert {
    private val convertMap by lazy {
        mutableMapOf<Int, IMessageConvert>(
            MsgConstant.KELEMTYPETEXT to MessageElemConverter.TextConverter,
            MsgConstant.KELEMTYPEFACE to MessageElemConverter.FaceConverter,
            MsgConstant.KELEMTYPEPIC to MessageElemConverter.ImageConverter,
            MsgConstant.KELEMTYPEPTT to MessageElemConverter.VoiceConverter,
            MsgConstant.KELEMTYPEVIDEO to MessageElemConverter.VideoConverter,
            MsgConstant.KELEMTYPEMARKETFACE to MessageElemConverter.MarketFaceConverter,
            MsgConstant.KELEMTYPEARKSTRUCT to MessageElemConverter.StructJsonConverter,
            MsgConstant.KELEMTYPEREPLY to MessageElemConverter.ReplyConverter,
            MsgConstant.KELEMTYPEGRAYTIP to MessageElemConverter.GrayTipsConverter,
            MsgConstant.KELEMTYPEFILE to MessageElemConverter.FileConverter,
            MsgConstant.KELEMTYPEMARKDOWN to MessageElemConverter.MarkdownConverter,
            //MsgConstant.KELEMTYPEMULTIFORWARD to MessageElemConverter.XmlMultiMsgConverter,
            //MsgConstant.KELEMTYPESTRUCTLONGMSG to MessageElemConverter.XmlLongMsgConverter,
        )
    }

    suspend fun convertMessageElementsToMsgSegment(
        chatType: Int,
        elements: List<MsgElement>,
        peerId: String
    ): ArrayList<MessageSegment> {
        val messageData = arrayListOf<MessageSegment>()
        elements.forEach {
            kotlin.runCatching {
                val elementId = it.elementType
                val converter = convertMap[elementId]
                converter?.convert(chatType, peerId, it)
                    ?: throw UnsupportedOperationException("不支持的消息element类型：$elementId")
            }.onSuccess {
                messageData.add(it)
            }.onFailure {
                if (it is UnknownError) {
                    // 不处理的消息类型，抛出unknown error
                } else {
                    LogCenter.log("消息element转换错误：$it", Level.WARN)
                }
            }
        }
        return messageData
    }

    suspend fun convertMessageRecordToMsgSegment(record: MsgRecord, chatType: Int = record.chatType): ArrayList<MessageSegment> {
        return convertMessageElementsToMsgSegment(chatType, record.elements, record.peerUin.toString())
    }

    suspend fun convertMsgElementsToCQCode(
        elements: List<MsgElement>,
        chatType: Int,
        peerId: String
    ): String {
        if(elements.isEmpty()) {
            return ""
        }
        val msgList = convertMessageElementsToMsgSegment(chatType, elements, peerId).map {
            it.toJson()
        }
        return MessageHelper.encodeCQCode(msgList)
    }

    suspend fun convertMessageRecordToCQCode(record: MsgRecord, chatType: Int = record.chatType): String {
        return MessageHelper.encodeCQCode(
            convertMessageElementsToMsgSegment(
                chatType,
                record.elements,
                record.peerUin.toString()
            ).map { it.toJson() }
        )
    }
}

internal fun interface IMessageConvert {
    suspend fun convert(chatType: Int, peerId: String, element: MsgElement): MessageSegment
}

