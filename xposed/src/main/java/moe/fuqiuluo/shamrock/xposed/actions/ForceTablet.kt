@file:Suppress("UNUSED_VARIABLE", "LocalVariableName")
package moe.fuqiuluo.shamrock.xposed.actions

import android.content.Context
import com.tencent.common.config.pad.DeviceType
import com.tencent.qqnt.kernel.nativeinterface.InitSessionConfig
import de.robv.android.xposed.XposedBridge
import moe.fuqiuluo.shamrock.config.ForceTablet
import moe.fuqiuluo.shamrock.config.ShamrockConfig
import moe.fuqiuluo.shamrock.tools.FuzzySearchClass
import moe.fuqiuluo.shamrock.utils.PlatformUtils
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.tools.afterHook
import moe.fuqiuluo.shamrock.tools.hookMethod
import moe.fuqiuluo.shamrock.xposed.loader.LuoClassloader
import moe.fuqiuluo.symbols.XposedHook

@XposedHook(priority = 0)
internal class ForceTablet: IAction {
    override fun invoke(ctx: Context) {
        if (ShamrockConfig[ForceTablet]) {
            if (PlatformUtils.isMainProcess()) {
                LogCenter.log("强制协议类型 (PAD)", toast = true)
            }

            val returnTablet = afterHook {
                it.result = DeviceType.TABLET
            }

            FuzzySearchClass.findAllClassByMethod(
                LuoClassloader.hostClassLoader, "com.tencent.common.config.pad"
            ) { _, method ->
                method.returnType == DeviceType::class.java
            }.forEach { clazz ->
                //log("Inject to tablet mode in ${clazz.name}")
                val method = clazz.declaredMethods.first { it.returnType == DeviceType::class.java }
                XposedBridge.hookMethod(method, returnTablet)
            }

            val PadUtil = LuoClassloader.load("com.tencent.common.config.pad.PadUtil")
            PadUtil?.declaredMethods?.filter {
                it.returnType == DeviceType::class.java
            }?.forEach {
                XposedBridge.hookMethod(it, returnTablet)
            }

            val deviceTypeField = InitSessionConfig::class.java.declaredFields.firstOrNull {
                it.type == com.tencent.qqnt.kernel.nativeinterface.DeviceType::class.java
            }
            if (deviceTypeField != null) {
                XposedBridge.hookAllConstructors(InitSessionConfig::class.java, afterHook {
                    if (!deviceTypeField.isAccessible) deviceTypeField.isAccessible = true
                    deviceTypeField.set(it.thisObject, com.tencent.qqnt.kernel.nativeinterface.DeviceType.KPAD)
                })
            }
            InitSessionConfig::class.java.hookMethod("getDeviceType").after {
                it.result = com.tencent.qqnt.kernel.nativeinterface.DeviceType.KPAD
            }
        }
    }
}