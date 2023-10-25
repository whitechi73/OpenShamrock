package moe.fuqiuluo.shamrock.xposed.helper

import moe.fuqiuluo.shamrock.tools.broadcast
import moe.fuqiuluo.shamrock.xposed.helper.internal.DynamicReceiver
import moe.fuqiuluo.shamrock.xposed.helper.internal.IPCRequest
import mqq.app.MobileQQ

internal object PacketHandler {
    /*
    MSF 进程包处理是否就绪
     */
    var isInit = false

    internal fun initPacketHandler() {
        DynamicReceiver.register("msf_waiter", IPCRequest {
            isInit = true
        })
    }

    /**
     * 注册常驻包处理器
     */
    fun register(cmd: String, callback: (Int, ByteArray) -> Unit) {
        // 在本地广播接收器注册对应处理器
        DynamicReceiver.register(cmd, IPCRequest {
            val buffer = it.getByteArrayExtra("buffer")!!
            val seq = it.getIntExtra("seq", 0)
            callback(seq, buffer)
        })
        if (!isInit) return
        // 向MSF进程广播要求添加处理器
        MobileQQ.getContext().broadcast("msf") {
            putExtra("__cmd", "register_handler_cmd")
            putExtra("handler_cmd", cmd)
        }
    }

    suspend fun registerLessHandler(cmd: String, seq: Int, callback: (Int, ByteArray) -> Unit): Int {
        DynamicReceiver.register(IPCRequest(cmd, seq) {
            val buffer = it.getByteArrayExtra("buffer")!!
            val currSeq = it.getIntExtra("seq", 0)
            callback(currSeq, buffer)
        })
        return seq
    }

    suspend fun unregisterLessHandler(seq: Int) {
        DynamicReceiver.unregister(seq)
    }

    fun unregister(cmd: String) {
        DynamicReceiver.unregister(cmd)
        if (!isInit) return
        MobileQQ.getContext().broadcast("msf") {
            putExtra("__cmd", "unregister_handler_cmd")
            putExtra("handler_cmd", cmd)
        }
    }
}