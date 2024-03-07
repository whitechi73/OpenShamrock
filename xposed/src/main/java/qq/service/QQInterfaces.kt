package qq.service

import moe.fuqiuluo.shamrock.utils.PlatformUtils
import mqq.app.MobileQQ

abstract class QQInterfaces {


    companion object {
        val app = if (PlatformUtils.isMqqPackage())
            MobileQQ.getMobileQQ().waitAppRuntime()
        else
            MobileQQ.getMobileQQ().waitAppRuntime(null)
    }
}