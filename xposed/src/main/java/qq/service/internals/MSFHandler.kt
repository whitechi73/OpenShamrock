package qq.service.internals

import com.tencent.qphone.base.remote.FromServiceMsg
import com.tencent.qphone.base.remote.ToServiceMsg
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

typealias MsfPush = (FromServiceMsg) -> Unit
typealias MsfResp = (ToServiceMsg, FromServiceMsg) -> Unit

internal object MSFHandler {
    private val mPushHandlers = hashMapOf<String, MsfPush>()
    private val mRespHandler = hashMapOf<Int, MsfResp>()
    private val mPushLock = Mutex()
    private val mRespLock = Mutex()

    suspend fun registerPush(cmd: String, push: MsfPush) {
        mPushLock.withLock {
            mPushHandlers[cmd] = push
        }
    }

    suspend fun unregisterPush(cmd: String) {
        mPushLock.withLock {
            mPushHandlers.remove(cmd)
        }
    }

    suspend fun registerResp(cmd: Int, resp: MsfResp) {
        mRespLock.withLock {
            mRespHandler[cmd] = resp
        }
    }

    suspend fun unregisterResp(cmd: Int) {
        mRespLock.withLock {
            mRespHandler.remove(cmd)
        }
    }

    fun onPush(fromServiceMsg: FromServiceMsg) {
        val cmd = fromServiceMsg.serviceCmd
        val push = mPushHandlers[cmd]
        push?.invoke(fromServiceMsg)
    }

    fun onResp(toServiceMsg: ToServiceMsg, fromServiceMsg: FromServiceMsg) {
        val cmd = toServiceMsg.getAttribute("respkey") as Int
        val resp = mRespHandler[cmd]
        resp?.invoke(toServiceMsg, fromServiceMsg)
    }
}