package moe.fuqiuluo.shamrock.xposed.hooks.interacts

import android.content.Context
import android.content.Intent
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.remote.service.config.ShamrockConfig
import moe.fuqiuluo.shamrock.tools.toast
import moe.fuqiuluo.shamrock.xposed.hooks.PullConfig
import moe.fuqiuluo.shamrock.xposed.hooks.runServiceActions
import moe.fuqiuluo.shamrock.xposed.loader.NativeLoader
import mqq.app.MobileQQ

internal object Init: IInteract {
    override fun invoke(intent: Intent) {
        ShamrockConfig.updateConfig(intent)
        initAppService(MobileQQ.getMobileQQ())
    }

    private fun initAppService(ctx: Context) {
        LogCenter.log("载入依赖库...少女努力中...", toast = true)
        //NativeLoader.load("shamrock")
        //ctx.toast(PullConfig.testNativeLibrary())
        runServiceActions(ctx)
    }
}