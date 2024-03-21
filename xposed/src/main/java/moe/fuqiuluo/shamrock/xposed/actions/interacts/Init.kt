package moe.fuqiuluo.shamrock.xposed.actions.interacts

import android.content.Context
import android.content.Intent
import moe.fuqiuluo.shamrock.config.ShamrockConfig
import moe.fuqiuluo.shamrock.tools.toast
import moe.fuqiuluo.shamrock.xposed.actions.runServiceActions
import moe.fuqiuluo.shamrock.xposed.loader.NativeLoader
import mqq.app.MobileQQ

internal object Init: IInteract {
    private external fun testNativeLibrary(): String

    override fun invoke(intent: Intent) {
        ShamrockConfig.updateConfig(intent)
        initAppService(MobileQQ.getMobileQQ())
    }

    private fun initAppService(ctx: Context) {
        NativeLoader.load("shamrock")
        ctx.toast(testNativeLibrary())
        runServiceActions(ctx)
    }
}