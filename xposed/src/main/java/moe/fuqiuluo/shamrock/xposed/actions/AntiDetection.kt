@file:Suppress("UNCHECKED_CAST", "LocalVariableName")
package moe.fuqiuluo.shamrock.xposed.actions

import android.content.Context
import android.content.pm.PackageManager
import android.content.pm.VersionedPackage
import android.os.Build
import de.robv.android.xposed.XC_MethodReplacement
import de.robv.android.xposed.XSharedPreferences
import de.robv.android.xposed.XposedHelpers
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.remote.service.config.ShamrockConfig
import moe.fuqiuluo.shamrock.tools.hookMethod
import moe.fuqiuluo.shamrock.xposed.XposedEntry
import moe.fuqiuluo.shamrock.xposed.loader.LuoClassloader
import moe.fuqiuluo.shamrock.xposed.loader.NativeLoader

/**
 * 反检测
 */
class AntiDetection: IAction {
    external fun antiNativeDetections(): Boolean

    override fun invoke(ctx: Context) {
        antiFindPackage(ctx)
        antiNativeDetection()
        if (ShamrockConfig.isAntiTrace())
            antiTrace()
        antiMemoryWalking()
    }

    val isModuleStack = fun String.(): Boolean {
        return contains("fuqiuluo") || contains("shamrock") || contains("whitechi") || contains("lsposed") || contains("xposed")
    }

    private fun isModuleStack(): Boolean {
        Thread.currentThread().stackTrace.forEach {
            if (it.className.isModuleStack()) return true
        }
        return false
    }

    private fun antiNativeDetection() {
        try {
            //System.loadLibrary("clover")
            NativeLoader.load("clover")
            val env = XposedEntry.hasEnv()
            val injected = XposedEntry.injected()
            if (!env || !injected) {
                LogCenter.log("[Shamrock] Shamrock反检测启动失败(env=$env, injected=$injected)", Level.ERROR)
            } else {
                XposedEntry.sec_static_nativehook_inited = true
                val pref = XSharedPreferences("moe.fuqiuluo.shamrock", "shared_config")
                if (pref.file.canRead()) {
                    if (pref.getBoolean("super_anti", false)) {
                        LogCenter.log("[Shamrock] Shamrock反检测启动成功: ${antiNativeDetections()}", Level.INFO)
                    }
                } else {
                    LogCenter.log("[Shamrock] unable to load XSharedPreferences", Level.WARN)
                }
            }
        } catch (e: Throwable) {
            LogCenter.log("[Shamrock] Shamrock反检测启动失败，请检查LSPosed版本使用大于100: ${e.message}", Level.ERROR)
        }
    }

    private fun antiFindPackage(context: Context) {
        val packageManager = context.packageManager
        val applicationInfo = packageManager.getApplicationInfo("moe.fuqiuluo.shamrock", 0)
        val packageInfo = packageManager.getPackageInfo("moe.fuqiuluo.shamrock", 0)

        packageManager.javaClass.hookMethod("getApplicationInfo").before {
            val packageName = it.args[0] as String
            if(packageName == "moe.fuqiuluo.shamrock") {
                LogCenter.log("AntiDetection: 检测到对Shamrock的检测，欺骗PackageManager(GA)", Level.WARN)
                it.throwable = PackageManager.NameNotFoundException()
            } else if (packageName == "moe.fuqiuluo.shamrock.hided") {
                it.result = applicationInfo
            }
        }

        packageManager.javaClass.hookMethod("getPackageInfo").before {
            when(val packageName = it.args[0]) {
                is String -> {
                    if(packageName == "moe.fuqiuluo.shamrock") {
                        LogCenter.log("AntiDetection: 检测到对Shamrock的检测，欺骗PackageManager(GP)", Level.WARN)
                        it.throwable = PackageManager.NameNotFoundException()
                    } else if (packageName == "moe.fuqiuluo.shamrock.hided") {
                        it.result = packageInfo
                    }
                }
                else -> {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && packageName is VersionedPackage) {
                        if(packageName.packageName == "moe.fuqiuluo.shamrock") {
                            LogCenter.log("AntiDetection: 检测到对Shamrock的检测，欺骗PackageManager(GPV)", Level.WARN)
                            it.throwable = PackageManager.NameNotFoundException()
                        }
                    }
                }
            }
        }
    }

    private fun antiMemoryWalking() {
        val c = Class.forName("dalvik.system.VMDebug")
        //val startMethodTracingMethod = c.getDeclaredMethod(
        //    "startMethodTracing", String::class.java,
        //    Integer.TYPE, Integer.TYPE, java.lang.Boolean.TYPE, Integer.TYPE
        //)
        //val stopMethodTracingMethod = c.getDeclaredMethod("stopMethodTracing")
        //val getMethodTracingModeMethod = c.getDeclaredMethod("getMethodTracingMode")
        //val getRuntimeStatMethod = c.getDeclaredMethod("getRuntimeStat", String::class.java)
        //val getRuntimeStatsMethod = c.getDeclaredMethod("getRuntimeStats")
        val VMClassLoader = LuoClassloader.load("java/lang/VMClassLoader")
        if (VMClassLoader != null) {
            // ...
        }

        kotlin.runCatching {
            XposedHelpers.findAndHookMethod(XposedHelpers.findClass("com.tencent.bugly.agent.CrashReport", LuoClassloader.hostClassLoader),
                "initCrashReport", object: XC_MethodReplacement() {
                    override fun replaceHookedMethod(param: MethodHookParam): Any? {
                        return null
                    }
                })
        }

        c.hookMethod("countInstancesOfClass").before {
            val clz = it.args[0] as Class<*>
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                if(clz.packageName.isModuleStack()) {
                    it.result = 0L
                }
            } else {
                if(clz.canonicalName?.isModuleStack() == true) {
                    it.result = 0L
                }
            }
        }

        c.hookMethod("countInstancesOfClasses").before {
            val clzs = it.args[0] as Array<Class<*>>
            clzs.forEach {  clz ->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    if(clz.packageName.isModuleStack()) {
                        it.result = 0L
                        return@forEach
                    }
                } else {
                    if(clz.canonicalName?.isModuleStack() == true) {
                        it.result = 0L
                        return@forEach
                    }
                }
            }
        }

        c.hookMethod("getInstancesOfClasses").after {
            val clzs = it.args[0] as Array<Class<*>>
            clzs.forEachIndexed { _, clz ->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    if(clz.packageName.isModuleStack()) {
                        it.result = Array<Any>(0) {  }
                    }
                } else {
                    if(clz.canonicalName?.isModuleStack() == true) {
                        it.result = Array<Any>(0) {  }
                    }
                }
            }
        }
    }

    private fun antiTrace() {
        val isModuleStack = fun StackTraceElement.(): Boolean {
            return className.isModuleStack()
        }

        Thread::class.java.hookMethod("getName").after {
            val result = it.result as String
            if (result.contains("fuqiuluo") || result.contains("shamrock") || result.contains("whitechi")) {
                it.result = "android"
            }
        }

        Thread::class.java.hookMethod("getStackTrace").after {
            val result = it.result as Array<StackTraceElement>
            it.result = result.filter {
                !it.isModuleStack()
            }.toTypedArray()
        }

        Throwable::class.java.hookMethod("getStackTrace").after {
            val result = it.result as Array<StackTraceElement>
            it.result = result.filter {
                !it.isModuleStack()
            }.toTypedArray()
        }

        Throwable::class.java.hookMethod("getOurStackTrace").after {
            val result = it.result as Array<StackTraceElement>
            it.result = result.filter {
                !it.isModuleStack()
            }.toTypedArray()
        }
    }
}