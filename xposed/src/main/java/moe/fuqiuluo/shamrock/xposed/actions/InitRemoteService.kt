@file:OptIn(DelicateCoroutinesApi::class)

package moe.fuqiuluo.shamrock.xposed.actions

import android.content.Context
import kotlinx.coroutines.DelicateCoroutinesApi
import kritor.server.KritorServer
import moe.fuqiuluo.shamrock.config.ActiveRPC
import moe.fuqiuluo.shamrock.config.RPCPort
import moe.fuqiuluo.shamrock.config.ShamrockConfig
import moe.fuqiuluo.shamrock.config.get
import moe.fuqiuluo.symbols.Process
import moe.fuqiuluo.symbols.XposedHook

private lateinit var server: KritorServer

@XposedHook(Process.MAIN, priority = 10)
internal class InitRemoteService : IAction {
    override fun invoke(ctx: Context) {
        if (ActiveRPC.get() && !::server.isInitialized) {
            server = KritorServer(RPCPort.get())
            server.start()
        }

    }
}
