package moe.fuqiuluo.shamrock.ui.service.handlers

import android.content.ContentValues
import android.content.Context
import moe.fuqiuluo.shamrock.ui.app.AppRuntime
import moe.fuqiuluo.shamrock.ui.app.ShamrockConfig

internal object InitHandler: ModuleHandler() {
    override val cmd: String = "init"

    override fun onReceive(callbackId: Int, values: ContentValues, context: Context) {
        AppRuntime.log("推送QQ进程初始化设置数据包成功...")
        callback(context, callbackId, ShamrockConfig.getConfigMap(context))
    }
}