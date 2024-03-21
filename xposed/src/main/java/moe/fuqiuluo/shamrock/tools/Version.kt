package moe.fuqiuluo.shamrock.tools

import mqq.app.MobileQQ

val ShamrockVersion: String by lazy {
    MobileQQ.getContext().packageManager
        .getPackageInfo("moe.fuqiuluo.shamrock.hided", 0).versionName
}
