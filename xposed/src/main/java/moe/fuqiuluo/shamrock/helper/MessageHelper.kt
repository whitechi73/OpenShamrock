package moe.fuqiuluo.shamrock.helper

import com.tencent.mobileqq.qroute.QRoute
import com.tencent.qqnt.kernel.nativeinterface.Contact
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import com.tencent.qqnt.msg.api.IMsgService
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject
import moe.fuqiuluo.qqinterface.servlet.MsgSvc
import moe.fuqiuluo.qqinterface.servlet.msg.MessageMaker
import moe.fuqiuluo.shamrock.helper.db.MessageDB
import moe.fuqiuluo.shamrock.helper.db.MessageMapping
import moe.fuqiuluo.shamrock.remote.structures.SendMsgResult
import moe.fuqiuluo.shamrock.tools.EmptyJsonObject
import moe.fuqiuluo.shamrock.tools.asJsonObject
import moe.fuqiuluo.shamrock.tools.asJsonObjectOrNull
import moe.fuqiuluo.shamrock.tools.asString
import moe.fuqiuluo.shamrock.tools.json
import moe.fuqiuluo.shamrock.tools.jsonArray
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlin.math.abs

internal object MessageHelper {
    suspend fun sendMessageWithoutMsgId(
        chatType: Int,
        peerId: String,
        message: String,
        callback: IOperateCallback,
        fromId: String = peerId
    ): SendMsgResult {
        val uniseq = generateMsgId(chatType)
        val msg = messageArrayToMessageElements(chatType, uniseq.qqMsgId, peerId, decodeCQCode(message)).also {
            if (it.second.isEmpty() && !it.first) {
                error("消息合成失败，请查看日志或者检查输入。")
            } else if (it.second.isEmpty()) {
                return uniseq.copy(msgHashId = 0, msgTime = System.currentTimeMillis())
            }
        }.second.filter {
            it.elementType != -1
        } as ArrayList<MsgElement>
        return sendMessageWithoutMsgId(chatType, peerId, msg, fromId, callback)
    }

    suspend fun resendMsg(chatType: Int, peerId: String, fromId: String, msgId: Long, retryCnt: Int, msgHashId: Int): Result<SendMsgResult> {
        val contact = generateContact(chatType, peerId, fromId)
        return resendMsg(contact, msgId, retryCnt, msgHashId)
    }

    suspend fun resendMsg(contact: Contact, msgId: Long, retryCnt: Int, msgHashId: Int): Result<SendMsgResult> {
        if (retryCnt < 0) return Result.failure(SendMsgException("消息发送超时次数过多"))
        val service = QRoute.api(IMsgService::class.java)
        val result = withTimeoutOrNull(15000) {
            if(suspendCancellableCoroutine {
                service.resendMsg(contact, msgId) { result, _ ->
                    it.resume(result)
                }
            } != 0) {
                resendMsg(contact, msgId, retryCnt - 1, msgHashId)
            } else {
                Result.success(SendMsgResult(msgHashId, msgId, System.currentTimeMillis()))
            }
        }
        return result ?: resendMsg(contact, msgId, retryCnt - 1, msgHashId)
    }

    @OptIn(DelicateCoroutinesApi::class)
    suspend fun sendMessageWithoutMsgId(
        chatType: Int,
        peerId: String,
        message: JsonArray,
        fromId: String = peerId,
        callback: IOperateCallback
    ): Result<SendMsgResult> {
        val uniseq = generateMsgId(chatType)
        val msg = messageArrayToMessageElements(chatType, uniseq.qqMsgId, peerId, message).also {
            if (it.second.isEmpty() && !it.first) error("消息合成失败，请查看日志或者检查输入。")
        }.second.filter {
            it.elementType != -1
        } as ArrayList<MsgElement>

        // ActionMsg No Care
        if (msg.isEmpty()) {
            return Result.success(uniseq.copy(msgTime = System.currentTimeMillis()))
        }

        val totalSize = msg.filter {
            it.elementType == MsgConstant.KELEMTYPEPIC ||
                    it.elementType == MsgConstant.KELEMTYPEPTT ||
                    it.elementType == MsgConstant.KELEMTYPEVIDEO
        }.map {
            (it.picElement?.fileSize ?: 0) + (it.pttElement?.fileSize
                ?: 0) + (it.videoElement?.fileSize ?: 0)
        }.reduceOrNull { a, b -> a + b } ?: 0
        val estimateTime = (totalSize / (300 * 1024)) * 1000 + 2000

        lateinit var sendResult: SendMsgResult // msgTime to msgHash
        val sendRet = withTimeoutOrNull<Pair<Int, String>>(estimateTime) {
            suspendCancellableCoroutine {
                GlobalScope.launch {
                    sendResult = sendMessageWithoutMsgId(chatType, peerId, msg, fromId) { code, message ->
                        callback.onResult(code, message)
                        it.resume(code to message)
                    }
                }
            }
        }

        if (sendRet?.first != 0) {
            //return Result.failure(SendMsgException(sendRet?.second ?: "发送消息超时"))
            return Result.success(uniseq.copy(isTimeout = true))
        }
        return Result.success(sendResult)
    }

    suspend fun sendMessageWithoutMsgId(
        chatType: Int,
        peerId: String,
        message: ArrayList<MsgElement>,
        fromId: String = peerId,
        callback: IOperateCallback
    ): SendMsgResult {
        return sendMessageWithoutMsgId(generateContact(chatType, peerId, fromId), message, callback)
    }

    fun sendMessageWithoutMsgId(
        contact: Contact,
        message: ArrayList<MsgElement>,
        callback: IOperateCallback
    ): SendMsgResult {
        val uniseq = generateMsgId(contact.chatType)
        val nonMsg: Boolean = message.isEmpty()
        return if (!nonMsg) {
            val service = QRoute.api(IMsgService::class.java)
            if (callback is MsgSvc.MessageCallback) {
                callback.msgHash = uniseq.msgHashId
            }

            service.sendMsg(
                contact,
                uniseq.qqMsgId,
                message,
                callback
            )

            uniseq.copy(msgTime = System.currentTimeMillis())
        } else {
            uniseq.copy(msgHashId = 0, msgTime = System.currentTimeMillis())
        }
    }

    suspend fun sendMessageWithMsgId(
        chatType: Int,
        peerId: String,
        message: JsonArray,
        callback: IOperateCallback,
        fromId: String = peerId
    ): SendMsgResult {
        val uniseq = generateMsgId(chatType)
        val msg = messageArrayToMessageElements(chatType, uniseq.qqMsgId, peerId, message).also {
            if (it.second.isEmpty() && !it.first) error("消息合成失败，请查看日志或者检查输入。")
        }.second.filter {
            it.elementType != -1
        } as ArrayList<MsgElement>
        val contact = generateContact(chatType, peerId, fromId)
        val nonMsg: Boolean = message.isEmpty()
        return if (!nonMsg) {
            val service = QRoute.api(IMsgService::class.java)
            if (callback is MsgSvc.MessageCallback) {
                callback.msgHash = uniseq.msgHashId
            }

            service.sendMsg(
                contact,
                uniseq.qqMsgId,
                msg,
                callback
            )
            uniseq.copy(msgTime = System.currentTimeMillis())
        } else {
            uniseq.copy(msgHashId = 0, msgTime = System.currentTimeMillis())
        }
    }

    fun sendMessageWithMsgId(
        contact: Contact,
        message: ArrayList<MsgElement>,
        callback: IOperateCallback
    ): SendMsgResult {
        val uniseq = generateMsgId(contact.chatType)
        val nonMsg: Boolean = message.isEmpty()
        return if (!nonMsg) {
            val service = QRoute.api(IMsgService::class.java)
            if (callback is MsgSvc.MessageCallback) {
                callback.msgHash = uniseq.msgHashId
            }

            service.sendMsg(
                contact,
                uniseq.qqMsgId,
                message,
                callback
            )

            uniseq.copy(msgTime = System.currentTimeMillis())
        } else {
            uniseq.copy(msgTime = 0, msgHashId = 0)
        }
    }

    suspend fun sendMessageNoCb(
        chatType: Int,
        peerId: String,
        message: JsonArray,
        fromId: String = peerId
    ): SendMsgResult {
        val uniseq = generateMsgId(chatType)
        val msg = messageArrayToMessageElements(chatType, uniseq.qqMsgId, peerId, message).also {
            if (it.second.isEmpty() && !it.first) error("消息合成失败，请查看日志或者检查输入。")
        }.second.filter {
            it.elementType != -1
        } as ArrayList<MsgElement>
        val contact = generateContact(chatType, peerId, fromId)
        return if (!message.isEmpty()) {
            val service = QRoute.api(IMsgService::class.java)
            return suspendCancellableCoroutine {
                service.sendMsg(contact, uniseq.qqMsgId, msg) { code, why ->
                    it.resume(uniseq.copy(msgTime = System.currentTimeMillis()))
                }
            }
        } else {
            uniseq.copy(msgHashId = 0, msgTime = 0)
        }
    }

    suspend fun generateContact(chatType: Int, id: String, subId: String = ""): Contact {
        val peerId = when(chatType) {
            MsgConstant.KCHATTYPEC2C, MsgConstant.KCHATTYPETEMPC2CFROMGROUP -> {
                ContactHelper.getUidByUinAsync(id.toLong())
            }
            else -> id
        }
        return if (chatType == MsgConstant.KCHATTYPEGUILD) {
            Contact(chatType, subId, peerId)
        } else {
            Contact(chatType, peerId, subId)
        }
    }

    fun obtainMessageTypeByDetailType(detailType: String): Int {
        return when (detailType) {
            "troop", "group" -> MsgConstant.KCHATTYPEGROUP
            "private" -> MsgConstant.KCHATTYPEC2C
            "less" -> MsgConstant.KCHATTYPETEMPC2CFROMUNKNOWN
            "guild" -> MsgConstant.KCHATTYPEGUILD
            else -> error("不支持的消息来源类型")
        }
    }

    fun obtainDetailTypeByMsgType(msgType: Int): String {
        return when (msgType) {
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
            val maker = MessageMaker[msg["type"].asString]
            if (maker != null) {
                try {
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
                } catch (e: Throwable) {
                    LogCenter.log(e.stackTraceToString(), Level.ERROR)
                }
            } else {
                LogCenter.log("不支持的消息类型: ${msg["type"].asString}", Level.ERROR)
                return false to arrayListOf()
            }
        }
        return hasActionMsg to msgList
    }

    fun generateMsgIdHash(chatType: Int, msgId: Long): Int {
        val key = when (chatType) {
            MsgConstant.KCHATTYPEGROUP -> "grp$msgId"
            MsgConstant.KCHATTYPEC2C -> "c2c$msgId"
            MsgConstant.KCHATTYPETEMPC2CFROMGROUP -> "tmpgrp$msgId"
            MsgConstant.KCHATTYPEGUILD -> "guild$msgId"
            else -> error("不支持的消息来源类型 | generateMsgIdHash: $chatType")
        }
        return abs(key.hashCode())
    }

    fun generateMsgId(chatType: Int): SendMsgResult {
        val msgId = createMessageUniseq(chatType, System.currentTimeMillis())
        val hashCode: Int = generateMsgIdHash(chatType, msgId)
        return SendMsgResult(hashCode, msgId, 0)
    }

    fun getMsgMappingByHash(hash: Int): MessageMapping? {
        val db = MessageDB.getInstance()
        return db.messageMappingDao().queryByMsgHashId(hash)
    }

    fun getMsgMappingBySeq(chatType: Int, peerId: String, msgSeq: Int): MessageMapping? {
        val db = MessageDB.getInstance()
        return db.messageMappingDao().queryByMsgSeq(chatType, peerId, msgSeq)
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
        subPeerId: String,
        msgSeq: Int,
        subChatType: Int = chatType
    ) {
        val database = MessageDB.getInstance()
        val mapping = MessageMapping(hash, qqMsgId, chatType, subChatType, peerId, time, msgSeq, subPeerId)
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