@file:OptIn(DelicateCoroutinesApi::class)

package moe.fuqiuluo.shamrock.remote.service

import com.tencent.qphone.base.remote.FromServiceMsg
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import moe.fuqiuluo.shamrock.tools.broadcast
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.xposed.helper.internal.DynamicReceiver
import moe.fuqiuluo.shamrock.xposed.helper.internal.IPCRequest
import mqq.app.MobileQQ

internal object PacketReceiver {
    private val allowCommandList: MutableSet<String> by lazy { mutableSetOf(
        "trpc.msg.olpush.OlPushService.MsgPush",

    ) } // 非动态注册，永久常驻的包
    private val HandlerByIpcSet = hashSetOf<String>()

    fun init() {
        DynamicReceiver.register("register_handler_cmd", IPCRequest {
            val cmd = it.getStringExtra("handler_cmd")!!
            LogCenter.log({ "RegisterHandler(cmd = $cmd)" }, Level.DEBUG)
            HandlerByIpcSet.add(cmd)
        })
        DynamicReceiver.register("unregister_handler_cmd", IPCRequest {
            val cmd = it.getStringExtra("handler_cmd")!!
            LogCenter.log({ "UnRegisterHandler(cmd = $cmd)" }, Level.DEBUG)
            HandlerByIpcSet.remove(cmd)
        })
        MobileQQ.getContext().broadcast("xqbot") {
            putExtra("__cmd", "msf_waiter")
            LogCenter.log("MSF Packet Receiver running!")
        }
    }

    private fun onReceive(from: FromServiceMsg) {
        if (HandlerByIpcSet.contains(from.serviceCmd)
            || allowCommandList.contains(from.serviceCmd)
        ) {
            LogCenter.log({ "ReceivePacket(cmd = ${from.serviceCmd})" }, Level.DEBUG)
            MobileQQ.getContext().broadcast("xqbot") {
                putExtra("__cmd", from.serviceCmd)
                putExtra("buffer", from.wupBuffer)
                putExtra("seq", from.requestSsoSeq)
            }
        } else {
            val seq = if (from.appSeq == -1) from.requestSsoSeq else from.appSeq
            val hash = (from.serviceCmd + seq).hashCode()
            LogCenter.log({ "ReceivePacket[$hash](cmd = ${from.serviceCmd}, seq = $seq)" }, Level.DEBUG)
            MobileQQ.getContext().broadcast("xqbot") {
                putExtra("__hash", hash)
                putExtra("buffer", from.wupBuffer)
                putExtra("seq", seq)
            }
        }
    }

    fun internalOnReceive(from: FromServiceMsg?) {
        if (from == null) return
        GlobalScope.launch(Dispatchers.Default) {
            onReceive(from)
        }
    }
}