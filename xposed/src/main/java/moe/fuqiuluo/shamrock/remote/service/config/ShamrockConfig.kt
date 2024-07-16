package moe.fuqiuluo.shamrock.remote.service.config

import android.content.Intent
import de.robv.android.xposed.XposedBridge
import kotlinx.serialization.decodeFromString
import moe.fuqiuluo.shamrock.tools.GlobalJson5
import moe.fuqiuluo.shamrock.xposed.loader.LuoClassloader.moduleLoader
import mqq.app.MobileQQ
import java.util.Properties

internal object ShamrockConfig: ShamrockConfigV0() {

}