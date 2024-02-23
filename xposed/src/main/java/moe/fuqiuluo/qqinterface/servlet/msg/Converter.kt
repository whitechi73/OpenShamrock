package moe.fuqiuluo.qqinterface.servlet.msg

import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import moe.fuqiuluo.qqinterface.servlet.msg.converter.MessageElementConverter
import moe.fuqiuluo.qqinterface.servlet.msg.converter.MsgElementConverter
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.helper.MessageHelper
import protobuf.message.Elem

@JvmName("elemListToSegments")
internal suspend fun List<Elem>.toSegments(
    chatType: Int,
    peerId: String,
    subPeer: String
): List<MessageSegment> {
    val messageData = arrayListOf<MessageSegment>()
    this.forEach { msg ->
        kotlin.runCatching {
            val elementType = if (msg.text != null) {
                1
            } else if (msg.face != null) {
                2
            } else if (msg.lightApp != null) {
                51
            } else if (msg.commonElem != null) {
                53
            } else
                throw UnsupportedOperationException("不支持的消息element类型：$msg")
            val converter = MessageElementConverter[elementType]
            converter?.invoke(chatType, peerId, subPeer, msg)
                ?: throw UnsupportedOperationException("不支持的消息element类型：$elementType")
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

@JvmName("msgElementListToSegments")
internal suspend fun List<MsgElement>.toSegments(chatType: Int, peerId: String, subPeer: String): List<MessageSegment> {
    val messageData = arrayListOf<MessageSegment>()
    this.forEach { msg ->
        kotlin.runCatching {
            val converter = MsgElementConverter[msg.elementType]
            converter?.invoke(chatType, peerId, subPeer, msg)
                ?: throw UnsupportedOperationException("不支持的消息element类型：${msg.elementType}")
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

internal suspend fun List<MsgElement>.toCQCode(chatType: Int, peerId: String, subPeer: String): String {
    if (this.isEmpty()) {
        return ""
    }
    return MessageHelper.nativeEncodeCQCode(this.toSegments(chatType, peerId, subPeer).map {
        val params = hashMapOf<String, String>()
        params["_type"] = it.type
        it.data.forEach { (key, value) ->
            params[key] = value.toString()
        }
        params
    })
}