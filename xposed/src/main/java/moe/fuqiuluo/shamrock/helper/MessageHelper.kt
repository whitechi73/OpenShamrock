package moe.fuqiuluo.shamrock.helper

import com.tencent.mobileqq.qroute.QRoute
import com.tencent.qqnt.kernel.nativeinterface.Contact
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import com.tencent.qqnt.msg.api.IMsgService
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject
import moe.fuqiuluo.qqinterface.servlet.MsgSvc
import moe.fuqiuluo.qqinterface.servlet.msg.MessageMaker
import moe.fuqiuluo.shamrock.helper.db.MessageDB
import moe.fuqiuluo.shamrock.helper.db.MessageMapping
import moe.fuqiuluo.shamrock.tools.EmptyJsonObject
import moe.fuqiuluo.shamrock.tools.asJsonObject
import moe.fuqiuluo.shamrock.tools.asJsonObjectOrNull
import moe.fuqiuluo.shamrock.tools.asString
import moe.fuqiuluo.shamrock.tools.json
import moe.fuqiuluo.shamrock.tools.jsonArray
import kotlin.math.abs

internal object MessageHelper {
    suspend fun sendMessageWithoutMsgId(
        chatType: Int,
        peerId: String,
        message: String,
        callback: IOperateCallback,
        fromId: String = peerId
    ): Pair<Long, Int> {
        val uniseq = generateMsgId(chatType)
        val msg = messageArrayToMessageElements(chatType, uniseq.second, peerId, decodeCQCode(message)).also {
            if (it.second.isEmpty() && !it.first) error("消息合成失败，请查看日志或者检查输入。")
        }.second.filter {
            it.elementType != -1
        } as ArrayList<MsgElement>
        return sendMessageWithoutMsgId(chatType, peerId, msg, callback, fromId)
    }

    suspend fun sendMessageWithoutMsgId(
        chatType: Int,
        peerId: String,
        message: JsonArray,
        callback: IOperateCallback,
        fromId: String = peerId
    ): Pair<Long, Int> {
        val uniseq = generateMsgId(chatType)
        val msg = messageArrayToMessageElements(chatType, uniseq.second, peerId, message).also {
            if (it.second.isEmpty() && !it.first) error("消息合成失败，请查看日志或者检查输入。")
        }.second.filter {
            it.elementType != -1
        } as ArrayList<MsgElement>
        return sendMessageWithoutMsgId(chatType, peerId, msg, callback, fromId)
    }

    suspend fun sendMessageWithoutMsgId(
        chatType: Int,
        peerId: String,
        message: ArrayList<MsgElement>,
        callback: IOperateCallback,
        fromId: String = peerId
    ): Pair<Long, Int> {
        return sendMessageWithoutMsgId(generateContact(chatType, peerId, fromId), message, callback)
    }

    fun sendMessageWithoutMsgId(
        contact: Contact,
        message: ArrayList<MsgElement>,
        callback: IOperateCallback
    ): Pair<Long, Int> {
        val uniseq = generateMsgId(contact.chatType)
        val nonMsg: Boolean = message.isEmpty()
        return if (!nonMsg) {
            val service = QRoute.api(IMsgService::class.java)
            if(callback is MsgSvc.MessageCallback) {
                callback.msgHash = uniseq.first
            }

            service.sendMsg(
                contact,
                uniseq.second,
                message,
                callback
            )
            System.currentTimeMillis() to uniseq.first
        } else {
            System.currentTimeMillis() to 0
        }
    }

    suspend fun sendMessageWithMsgId(
        chatType: Int,
        peerId: String,
        message: JsonArray,
        callback: IOperateCallback,
        fromId: String = peerId
    ): Pair<Long, Int> {
        val uniseq = generateMsgId(chatType)
        val msg = messageArrayToMessageElements(chatType, uniseq.second, peerId, message).also {
            if (it.second.isEmpty() && !it.first) error("消息合成失败，请查看日志或者检查输入。")
        }.second.filter {
            it.elementType != -1
        } as ArrayList<MsgElement>
        val contact = generateContact(chatType, peerId, fromId)
        val nonMsg: Boolean = message.isEmpty()
        return if (!nonMsg) {
            val service = QRoute.api(IMsgService::class.java)
            if(callback is MsgSvc.MessageCallback) {
                callback.msgHash = uniseq.first
            }

            service.sendMsg(
                contact,
                uniseq.second,
                msg,
                callback
            )
            uniseq.second to uniseq.first
        } else {
            uniseq.second to 0
        }
    }

    fun sendMessageWithMsgId(
        contact: Contact,
        message: ArrayList<MsgElement>,
        callback: IOperateCallback
    ): Pair<Long, Int> {
        val uniseq = generateMsgId(contact.chatType)
        val nonMsg: Boolean = message.isEmpty()
        return if (!nonMsg) {
            val service = QRoute.api(IMsgService::class.java)
            if(callback is MsgSvc.MessageCallback) {
                callback.msgHash = uniseq.first
            }

            service.sendMsg(
                contact,
                uniseq.second,
                message,
                callback
            )
            uniseq.second to uniseq.first
        } else {
            0L to 0
        }
    }

    suspend fun generateContact(chatType: Int, id: String, subId: String = ""): Contact {
        val peerId = if (MsgConstant.KCHATTYPEC2C == chatType || MsgConstant.KCHATTYPETEMPC2CFROMGROUP == chatType) {
            ContactHelper.getUidByUinAsync(id.toLong())
        } else id
        return Contact(chatType, peerId, subId)
    }

    fun obtainMessageTypeByDetailType(detailType: String): Int {
        return when(detailType) {
            "troop", "group" -> MsgConstant.KCHATTYPEGROUP
            "private" -> MsgConstant.KCHATTYPEC2C
            "less" -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
            "guild" -> MsgConstant.KCHATTYPEGUILD
            else -> error("不支持的消息来源类型")
        }
    }

    fun obtainDetailTypeByMsgType(msgType: Int): String {
        return when(msgType) {
            MsgConstant.KCHATTYPEGROUP -> "group"
            MsgConstant.KCHATTYPEC2C -> "private"
            MsgConstant.KCHATTYPEGUILD -> "guild"
            MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN -> "less"
            else -> error("不支持的消息来源类型")
        }
    }

    suspend fun messageArrayToMessageElements(chatType: Int, msgId: Long, targetUin: String, messageList: JsonArray): Pair<Boolean, ArrayList<MsgElement>> {
        val msgList = arrayListOf<MsgElement>()
        var hasActionMsg = false
        messageList.forEach {
            val msg = it.jsonObject
            try {
                val maker = MessageMaker[msg["type"].asString]
                if (maker != null) {
                    val data = msg["data"].asJsonObjectOrNull ?: EmptyJsonObject
                    maker(chatType, msgId, targetUin, data).onSuccess { msgElem ->
                        msgList.add(msgElem)
                    }.onFailure {
                        if (it.javaClass != ActionMsgException::class.java) {
                            throw it
                        } else {
                            hasActionMsg = true
                        }
                    }
                } else {
                    LogCenter.log("不支持的消息类型: ${msg["type"].asString}", Level.ERROR)
                }
            } catch (e: Throwable) {
                LogCenter.log(e.stackTraceToString(), Level.ERROR)
            }
        }
        return hasActionMsg to msgList
    }

    fun generateMsgIdHash(chatType: Int, msgId: Long): Int {
        val key =  when (chatType) {
            MsgConstant.KCHATTYPEGROUP -> "grp$msgId"
            MsgConstant.KCHATTYPEC2C -> "c2c$msgId"
            MsgConstant.KCHATTYPETEMPC2CFROMGROUP -> "tmpgrp$msgId"
            else -> error("不支持的消息来源类型 | generateMsgIdHash: $chatType")
        }
        return abs(key.hashCode())
    }

    fun generateMsgId(chatType: Int): Pair<Int, Long> {
        val msgId = createMessageUniseq(chatType, System.currentTimeMillis())
        val hashCode: Int = generateMsgIdHash(chatType, msgId)
        return hashCode to msgId
    }

    fun getMsgMappingByHash(hash: Int): MessageMapping? {
        val db = MessageDB.getInstance()
        return db.messageMappingDao().queryByMsgHashId(hash)
    }

    fun getMsgMappingBySeq(chatType: Int, msgSeq: Int): MessageMapping? {
        val db = MessageDB.getInstance()
        return db.messageMappingDao().queryByMsgSeq(chatType, msgSeq)
    }

    fun removeMsgByHashCode(hashCode: Int) {
        MessageDB.getInstance()
            .messageMappingDao()
            .deleteByMsgHash(hashCode)
    }

    fun saveMsgMapping(
        hash: Int,
        qqMsgId: Long,
        time: Long,
        chatType: Int,
        peerId: String,
        msgSeq: Int,
        subChatType: Int = chatType
    ) {
        val database = MessageDB.getInstance()
        val mapping = MessageMapping(hash, qqMsgId, chatType, subChatType, peerId, time, msgSeq)
        database.messageMappingDao().insert(mapping)
    }

    external fun createMessageUniseq(chatType: Int, time: Long): Long

    fun decodeCQCode(code: String): JsonArray {
        val arrayList = ArrayList<JsonElement>()
        val msgList = nativeDecodeCQCode(code)
        msgList.forEach {
            val params = hashMapOf<String, JsonElement>()
            it.forEach { (key, value) ->
                if (key != "_type") {
                    params[key] = value.json
                }
            }
            val data = hashMapOf(
                "type" to it["_type"]!!.json,
                "data" to JsonObject(params)
            )
            arrayList.add(JsonObject(data))
        }
        return arrayList.jsonArray
    }

    fun encodeCQCode(msg: List<Map<String, JsonElement>>): String {
        return nativeEncodeCQCode(msg.map {
            val params = hashMapOf<String, String>()
            it.forEach { (key, value) ->
                if (key != "type") {
                    value.asJsonObject.forEach { param, element ->
                        params[param] = element.asString
                    }
                } else {
                    params["_type"] = value.asString
                }
            }
            params
        })
    }

    private external fun nativeDecodeCQCode(code: String): List<Map<String, String>>
    private external fun nativeEncodeCQCode(segment: List<Map<String, String>>): String
}