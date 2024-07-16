package moe.fuqiuluo.shamrock.xposed.helper

import android.os.Bundle
import com.tencent.common.app.AppInterface
import com.tencent.mobileqq.pb.ByteStringMicro
import com.tencent.qphone.base.remote.FromServiceMsg
import com.tencent.qphone.base.remote.ToServiceMsg
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import moe.fuqiuluo.shamrock.utils.PlatformUtils
import mqq.app.MobileQQ
import protobuf.auto.toByteArray
import protobuf.oidb.TrpcOidb
import tencent.im.oidb.oidb_sso
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

abstract class QQInterfaces {
    companion object {
        val app = (if (PlatformUtils.isMqqPackage())
            MobileQQ.getMobileQQ().waitAppRuntime()
        else
            MobileQQ.getMobileQQ().waitAppRuntime(null)) as AppInterface

        val currentUin: String
            get() = app.currentAccountUin

        fun sendToServiceMsg(to: ToServiceMsg) {
            app.sendToService(to)
        }

        suspend fun sendToServiceMsgAW(
            to: ToServiceMsg,
            timeout: Duration = 30.seconds
        ): FromServiceMsg? {
            val seq = MSFHandler.nextSeq()
            to.addAttribute("shamrock_uid", seq)
            val resp: Pair<ToServiceMsg, FromServiceMsg>? = withTimeoutOrNull(timeout) {
                suspendCancellableCoroutine { continuation ->
                    GlobalScope.launch {
                        MSFHandler.registerResp(seq, continuation)
                        sendToServiceMsg(to)
                    }
                }
            }
            if (resp == null) {
                MSFHandler.unregisterResp(seq)
            }
            return resp?.second
        }

        fun sendExtra(cmd: String, builder: (Bundle) -> Unit) {
            val toServiceMsg = createToServiceMsg(cmd)
            builder(toServiceMsg.extraData)
            app.sendToService(toServiceMsg)
        }

        fun createToServiceMsg(cmd: String): ToServiceMsg {
            return ToServiceMsg("mobileqq.service", app.currentAccountUin, cmd)
        }

        fun sendOidb(cmd: String, command: Int, service: Int, data: ByteArray, trpc: Boolean = false) {
            val to = createToServiceMsg(cmd)
            if (trpc) {
                val oidb = TrpcOidb(
                    cmd = command,
                    service = service,
                    buffer = data,
                    flag = 1
                )
                to.putWupBuffer(oidb.toByteArray())
            } else {
                val oidb = oidb_sso.OIDBSSOPkg()
                oidb.uint32_command.set(command)
                oidb.uint32_service_type.set(service)
                oidb.bytes_bodybuffer.set(ByteStringMicro.copyFrom(data))
                oidb.str_client_version.set(PlatformUtils.getClientVersion(MobileQQ.getContext()))
                to.putWupBuffer(oidb.toByteArray())
            }
            to.addAttribute("req_pb_protocol_flag", true)
            to.addAttribute("im_shamrock", true)
            app.sendToService(to)
        }

        fun sendBuffer(
            cmd: String,
            isProto: Boolean,
            data: ByteArray,
        ) {
            val toServiceMsg = createToServiceMsg(cmd)
            toServiceMsg.putWupBuffer(data)
            toServiceMsg.addAttribute("req_pb_protocol_flag", isProto)
            toServiceMsg.addAttribute("im_shamrock", true)
            sendToServiceMsg(toServiceMsg)
        }

        @DelicateCoroutinesApi
        suspend fun sendBufferAW(
            cmd: String,
            isProto: Boolean,
            data: ByteArray,
            timeout: Duration = 30.seconds
        ): FromServiceMsg? {
            val toServiceMsg = createToServiceMsg(cmd)
            toServiceMsg.putWupBuffer(data)
            toServiceMsg.addAttribute("req_pb_protocol_flag", isProto)
            toServiceMsg.addAttribute("im_shamrock", true)
            return sendToServiceMsgAW(toServiceMsg, timeout)
        }

        @DelicateCoroutinesApi
        suspend fun sendOidbAW(
            cmd: String,
            command: Int,
            service: Int,
            data: ByteArray,
            trpc: Boolean = false,
            timeout: Duration = 30.seconds
        ): FromServiceMsg? {
            val to = createToServiceMsg(cmd)
            if (trpc) {
                val oidb = TrpcOidb(
                    cmd = command,
                    service = service,
                    buffer = data,
                    flag = 1
                )
                to.putWupBuffer(oidb.toByteArray())
            } else {
                val oidb = oidb_sso.OIDBSSOPkg()
                oidb.uint32_command.set(command)
                oidb.uint32_service_type.set(service)
                oidb.bytes_bodybuffer.set(ByteStringMicro.copyFrom(data))
                oidb.str_client_version.set(PlatformUtils.getClientVersion(MobileQQ.getContext()))
                to.putWupBuffer(oidb.toByteArray())
            }
            to.addAttribute("req_pb_protocol_flag", true)
            to.addAttribute("im_shamrock", true)
            return sendToServiceMsgAW(to, timeout)
        }
    }
}