package moe.fuqiuluo.qqinterface.servlet.msg

import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import java.util.Collections

internal object MessageTempHandler {
    // 通过MSG SEQ临时监听器
    private val tempMessageListenerMap = Collections.synchronizedMap(HashMap<Long, suspend MsgRecord.() -> Unit>())

    fun registerTemporaryMsgListener(
        msgSeq: Long,
        listener: suspend MsgRecord.() -> Unit
    ) {
        LogCenter.log({ "注册临时消息监听器: $msgSeq" }, Level.DEBUG)
        tempMessageListenerMap[msgSeq] = listener
    }

    fun unregisterTemporaryMsgListener(msgSeq: Long) {
        tempMessageListenerMap.remove(msgSeq)
    }

    suspend fun notify(record: MsgRecord): Boolean {
        tempMessageListenerMap.firstNotNullOfOrNull {
            if (it.key == record.msgSeq) it else null
        }?.let {
            it.value(record)
            tempMessageListenerMap.remove(it.key)
            return true
        }
        return false
    }
}