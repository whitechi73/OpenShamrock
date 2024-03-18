@file:OptIn(DelicateCoroutinesApi::class)

package moe.fuqiuluo.shamrock.xposed.actions

import android.content.Context
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kritor.client.KritorClient
import kritor.server.KritorServer
import moe.fuqiuluo.shamrock.config.ActiveRPC
import moe.fuqiuluo.shamrock.config.PassiveRPC
import moe.fuqiuluo.shamrock.config.RPCAddress
import moe.fuqiuluo.shamrock.config.RPCPort
import moe.fuqiuluo.shamrock.config.ShamrockConfig
import moe.fuqiuluo.shamrock.config.get
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.symbols.Process
import moe.fuqiuluo.symbols.XposedHook

private lateinit var server: KritorServer
private lateinit var client: KritorClient

@XposedHook(Process.MAIN, priority = 10)
internal class InitRemoteService : IAction {
    override fun invoke(ctx: Context) {
        GlobalScope.launch {
            runCatching {
                if (ActiveRPC.get()) {
                    if (!::server.isInitialized) {
                        server = KritorServer(RPCPort.get())
                        server.start()
                    }
                } else {
                    LogCenter.log("ActiveRPC is disabled, KritorServer will not be started.")
                }

                if (PassiveRPC.get()) {
                    if (!::client.isInitialized) {
                        val hostAndPort = RPCAddress.get().split(":").let {
                            it.first() to it.last().toInt()
                        }
                        LogCenter.log("Connect RPC to ${hostAndPort.first}:${hostAndPort.second}")
                        client = KritorClient(hostAndPort.first, hostAndPort.second)
                        client.start()
                        client.listen()

                    }
                } else {
                    LogCenter.log("PassiveRPC is disabled, KritorServer will not be started.")
                }


            }.onFailure {
                LogCenter.log("Start RPC failed: ${it.message}", Level.ERROR)
            }
        }
    }
}
