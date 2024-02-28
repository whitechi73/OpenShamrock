@file:Suppress("UNCHECKED_CAST", "LocalVariableName")
package moe.fuqiuluo.shamrock.xposed.hooks

import android.content.ContentResolver
import android.content.Context
import android.content.pm.PackageManager
import android.content.pm.VersionedPackage
import android.os.Build
import android.os.Looper
import de.robv.android.xposed.XC_MethodReplacement
import de.robv.android.xposed.XSharedPreferences
import de.robv.android.xposed.XposedHelpers
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.remote.service.config.ShamrockConfig
import moe.fuqiuluo.shamrock.tools.MethodHooker
import moe.fuqiuluo.shamrock.tools.hookMethod
import moe.fuqiuluo.shamrock.xposed.XposedEntry
import moe.fuqiuluo.shamrock.xposed.loader.LuoClassloader
import moe.fuqiuluo.shamrock.xposed.loader.NativeLoader
import moe.fuqiuluo.symbols.XposedHook

@XposedHook(priority = 0)
class AntiDetection: IAction {
    private external fun antiNativeDetections(): Boolean

    override fun invoke(ctx: Context) {
        try {
            antiFindPackage(ctx)
        }catch(_:Throwable){ } //某个大聪明在外面隐藏了shamrock，导致这个代码抛出异常，俺不说是谁>_<
        antiGetPackageGidsDetection(ctx)
        antiProviderDetection()
        antiNativeDetection()
        if (ShamrockConfig.isAntiTrace())
            antiTrace()
        antiMemoryWalking()
    }

    // 虽然使用了getPackageGids来检测，但
    // 事实上除了这个还有getPackageUid，getPackageUidAsUser，等乱七八糟的接口都可以用于检测，任君选择~
    // 按这样来水检测，企鹅的工资可真好拿，每个接口都用来水一遍，这不得赢取白富美走向人生巅峰，俺也要来！>_<
    private fun antiGetPackageGidsDetection(ctx: Context) {
        //通过 android.content.pm.PackageManager->getPackageGids(Ljava/lang/String;)[I  扫 moe.fuqiuluo.shamrock
        ctx.packageManager::class.java.hookMethod("getPackageGids").before {
            val packageName = it.args[0] as String
            if (packageName == "moe.fuqiuluo.shamrock") {
                it.result = null
                it.throwable = PackageManager.NameNotFoundException(packageName)
                LogCenter.log("AntiDetection: 检测到对Shamrock的检测，欺骗GetPackageGids")
            }
        }
    }

    private fun antiProviderDetection() {
        ContentResolver::class.java.hookMethod("acquireContentProviderClient").before {
            val uri = it.args[0] as String
            if (uri == "moe.fuqiuluo.108.provider" || uri == "moe.fuqiuluo.xqbot.provider") {
                it.result = null
                LogCenter.log("AntiDetection: 检测到对Shamrock的检测，欺骗ContentResolver", Level.WARN)
            }
            //else {
            //    LogCenter.log(uri)
            //}
        }
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
            val pref = XSharedPreferences("moe.fuqiuluo.shamrock", "shared_config")
            if (!pref.file.canRead()) {
                LogCenter.log("[Shamrock] unable to load XSharedPreferences", Level.WARN)
                return
            } else if (!pref.getBoolean("super_anti", false)) {
                return
            }
            //System.loadLibrary("clover")
            NativeLoader.load("clover")
            val env = XposedEntry.hasEnv()
            val injected = XposedEntry.injected()
            if (!env || !injected) {
                LogCenter.log("[Shamrock] Shamrock反检测启动失败(env=$env, injected=$injected)", Level.ERROR)
            } else {
                XposedEntry.secStaticNativehookInited = true
                LogCenter.log("[Shamrock] Shamrock反检测启动成功: ${antiNativeDetections()}", Level.INFO)
            }
        } catch (e: Throwable) {
            LogCenter.log("[Shamrock] Shamrock反检测启动失败，请检查LSPosed版本使用大于100: ${e.message}", Level.ERROR)
        }
    }

    private fun antiFindPackage(context: Context) {
        if (isAntiFindPackage) return

        val packageManager = context.packageManager
        val applicationInfo = packageManager.getApplicationInfo("moe.fuqiuluo.shamrock", 0)
        val packageInfo = packageManager.getPackageInfo("moe.fuqiuluo.shamrock", 0)

        packageManager.javaClass.hookMethod("getApplicationInfo").before {
            val packageName = it.args[0] as String
            if(packageName == "moe.fuqiuluo.shamrock") {
                LogCenter.log("AntiDetection: 检测到对Shamrock的检测，欺骗PackageManager(GA)", Level.WARN)
                it.throwable = PackageManager.NameNotFoundException("Hided")
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

        isAntiFindPackage = true
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

        val stackTraceHooker: MethodHooker = {
            val result = it.result as Array<StackTraceElement>
            var zygote = false
            val newResult = result.filter {
                if (it.className == ZYGOTE_NAME) {
                    zygote = true
                }
                !it.isModuleStack()
            }.toTypedArray()
            if (!zygote && Thread.currentThread() == Looper.getMainLooper().thread) {
                it.result = arrayListOf(StackTraceElement(ZYGOTE_NAME, "main", ZYGOTE_NAME, 0), *newResult)
            } else {
                it.result = newResult
            }
        }

        Thread::class.java.hookMethod("getName").after {
            val result = it.result as String
            if (result.contains("fuqiuluo") || result.contains("shamrock") || result.contains("whitechi")) {
                it.result = "android"
            }
        }

        Thread::class.java.hookMethod("getStackTrace").after(stackTraceHooker)
        Throwable::class.java.hookMethod("getStackTrace").after(stackTraceHooker)
        Throwable::class.java.hookMethod("getOurStackTrace").after(stackTraceHooker)
    }

    companion object {
        @JvmStatic
        var isAntiFindPackage = false

        const val ZYGOTE_NAME = "com.android.internal.os.ZygoteInit"
    }
}