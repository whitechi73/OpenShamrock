package moe.fuqiuluo.shamrock.xposed.ipc

import android.os.IBinder
import moe.fuqiuluo.shamrock.utils.PlatformUtils
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withTimeoutOrNull
import moe.fuqiuluo.shamrock.tools.broadcast
import moe.fuqiuluo.shamrock.xposed.helper.internal.DynamicReceiver
import moe.fuqiuluo.shamrock.xposed.helper.internal.IPCRequest
import moe.fuqiuluo.shamrock.xposed.ipc.bytedata.ByteDataCreator
import moe.fuqiuluo.shamrock.xposed.ipc.qsign.QSignGenerator
import mqq.app.MobileQQ
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

internal object ShamrockIpc {
    const val IPC_QSIGN = "qsign"
    const val IPC_BYTEDATA = "bytedata"

    private val IpcChannel = hashMapOf<String, IBinder>(
        IPC_QSIGN to QSignGenerator,
        IPC_BYTEDATA to ByteDataCreator
    )

    suspend fun get(name: String?): IBinder? {
        return if (PlatformUtils.isMsfProcess()) {
            IpcChannel[name]
        } else {
            withTimeoutOrNull(3000) {
                suspendCoroutine { continuation ->
                    DynamicReceiver.register("ipc_callback", IPCRequest {
                        val bundle = it.getBundleExtra("ipc")!!
                        val binder = bundle.getBinder("binder")
                        continuation.resume(binder)
                    })
                    MobileQQ.getContext().broadcast("msf") {
                        putExtra("__cmd", "fetch_ipc")
                        putExtra("ipc_name", name)
                    }
                }
            }
        }
    }
}