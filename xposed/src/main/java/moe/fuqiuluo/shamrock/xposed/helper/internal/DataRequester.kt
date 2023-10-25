@file:OptIn(DelicateCoroutinesApi::class)

package moe.fuqiuluo.shamrock.xposed.helper.internal

import android.content.ContentValues
import android.content.Intent
import kotlinx.atomicfu.atomic
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import moe.fuqiuluo.shamrock.xposed.helper.AppTalker
import java.util.Timer
import kotlin.concurrent.timer

/**
 * 数据请求中心
 * 支持应用内数据传递，以及外部向内部传入
 */
object DataRequester {
    private val seqFactory = atomic(0)
    private val seq: Int
        get() {
            if (seqFactory.value > 1000000) {
                seqFactory.lazySet(0)
            }
            return seqFactory.incrementAndGet()
        }

    suspend fun request(
        cmd: String,
        currSeq: Int = seq,
        values: Map<String, Any>? = null,
        onFailure: ((Throwable) -> Unit)? = null,
        callback: ICallback? = null
    ): Int {
        return request(cmd, currSeq, bodyBuilder = {
            values?.forEach { (key, value) ->
                when (value) {
                    is Int -> this.put(key, value)
                    is Long -> this.put(key, value)
                    is Short -> this.put(key, value)
                    is Byte -> this.put(key, value)
                    is String -> this.put(key, value)
                    is ByteArray -> this.put(key, value)
                    is Boolean -> this.put(key, value)
                    is Float -> this.put(key, value)
                    is Double -> this.put(key, value)
                }
            }
        }, onFailure, callback)
    }

    suspend fun request(
        cmd: String,
        currentSeq: Int = seq,
        bodyBuilder: (ContentValues.() -> Unit)? = null,
        onFailure: ((Throwable) -> Unit)? = null,
        callback: ICallback? = null
    ): Int {
        val values = ContentValues()
        bodyBuilder?.invoke(values)
        values.put("__hash", (cmd + currentSeq).hashCode())
        values.put("__cmd", cmd)
        AppTalker.talk(values, onFailure)
        if (callback != null) {
            val timer: Timer = timer(initialDelay = 3000L, period = 5000L) {
                GlobalScope.launch(Dispatchers.Default) {
                    DynamicReceiver.unregister(currentSeq)
                    cancel()
                }
            }
            val request = IPCRequest(cmd, currentSeq, values) {
                try {
                    timer.cancel()
                } finally {
                    callback.handle(it)
                }
            }
            DynamicReceiver.register(request)
        }
        return currentSeq
    }
}

fun interface ICallback {
    suspend fun handle(intent: Intent)
}

data class IPCRequest(
    val cmd: String = "",
    val seq: Int = -1,
    val values: ContentValues? = null,
    var callback: ICallback? = null,
) {
    override fun hashCode(): Int {
        return (cmd + seq).hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as IPCRequest

        if (cmd != other.cmd) return false
        if (seq != other.seq) return false
        if (values != other.values) return false
        if (callback != other.callback) return false

        return true
    }
}