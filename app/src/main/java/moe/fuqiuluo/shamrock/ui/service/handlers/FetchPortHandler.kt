package moe.fuqiuluo.shamrock.ui.service.handlers

import android.content.ContentValues
import android.content.Context
import moe.fuqiuluo.shamrock.ui.app.AppRuntime
import moe.fuqiuluo.shamrock.ui.service.DashboardInitializer

object FetchPortHandler: ModuleHandler() {
    override val cmd: String = "success"

    override fun onReceive(callbackId: Int, values: ContentValues, context: Context) {
        AppRuntime.state.supportVoice.value = values.getAsBoolean("voice")
        DashboardInitializer(context, values.getAsInteger("port"))
    }
}