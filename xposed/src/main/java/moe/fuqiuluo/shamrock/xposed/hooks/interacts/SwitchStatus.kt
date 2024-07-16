package moe.fuqiuluo.shamrock.xposed.hooks.interacts

import android.content.Intent
import com.tencent.mobileqq.app.QQAppInterface
import moe.fuqiuluo.shamrock.tools.ShamrockVersion
import moe.fuqiuluo.shamrock.xposed.helper.AppTalker
import moe.fuqiuluo.shamrock.xposed.helper.QQInterfaces
import moe.fuqiuluo.shamrock.xposed.loader.NativeLoader

object SwitchStatus: IInteract, QQInterfaces() {
    override fun invoke(intent: Intent) {
        if (app.isLogin) {
            AppTalker.talk("switch_status") {
                put("account", app.currentAccountUin)
                put("nickname", if (app is QQAppInterface) (app.currentNickname ?: "unknown") else "unknown")
                put("voice", NativeLoader.isVoiceLoaded)
                put("core_version", ShamrockVersion)
            }
        }
    }
}