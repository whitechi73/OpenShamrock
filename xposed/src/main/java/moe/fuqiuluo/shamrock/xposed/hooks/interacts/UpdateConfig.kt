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

internal object UpdateConfig: IInteract {
    override fun invoke(intent: Intent) {
        MobileQQ.getContext().toast("动态更新配置成功")
        ShamrockConfig.updateConfig(intent)
    }
}