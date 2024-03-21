package moe.fuqiuluo.shamrock.ui.service.handlers

import android.content.ContentValues
import android.content.Context
import moe.fuqiuluo.shamrock.ui.app.AppRuntime
import moe.fuqiuluo.shamrock.app.config.ShamrockConfig
import moe.fuqiuluo.shamrock.config.*

internal object InitHandler: ModuleHandler() {
    override val cmd: String = "init"

    override fun onReceive(callbackId: Int, values: ContentValues, context: Context) {
        update(context)
    }

    fun update(context: Context) {
        AppRuntime.log("推送QQ进程初始化设置数据包成功...")

        val maps = hashMapOf<String, Any?>()

        ActiveRPC.update(context, maps)
        AliveReply.update(context, maps)
        AntiJvmTrace.update(context, maps)
        DebugMode.update(context, maps)
        EnableOldBDH.update(context, maps)
        EnableSelfMessage.update(context, maps)
        ForceTablet.update(context, maps)
        PassiveRPC.update(context, maps)
        ResourceGroup.update(context, maps)
        RPCAddress.update(context, maps)
        RPCPort.update(context, maps)

        callback(context, 1, maps)
    }

    private inline fun <reified T> ConfigKey<T>.update(context: Context, map: HashMap<String, Any?>) {
        map[name()] = ShamrockConfig[context, this]
    }
}