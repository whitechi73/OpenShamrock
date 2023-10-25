package moe.fuqiuluo.shamrock.xposed.helper

import moe.fuqiuluo.shamrock.utils.PlatformUtils
import mqq.app.AppRuntime
import mqq.app.MobileQQ

internal object AppRuntimeFetcher {
    val appRuntime: AppRuntime
        get() = if (PlatformUtils.isMqqPackage())
            MobileQQ.getMobileQQ().waitAppRuntime()
        else
            MobileQQ.getMobileQQ().waitAppRuntime(null)
}