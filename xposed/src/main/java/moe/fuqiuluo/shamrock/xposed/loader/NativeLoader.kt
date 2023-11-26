package moe.fuqiuluo.shamrock.xposed.loader

import android.annotation.SuppressLint
import de.robv.android.xposed.XposedBridge
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.xposed.XposedEntry
import mqq.app.MobileQQ
import java.io.File

internal object NativeLoader {
    private val externalLibPath = MobileQQ.getContext()
        .getExternalFilesDir(null)!!.parentFile!!.resolve("Tencent/Shamrock/lib")

    val isVoiceLoaded: Boolean
        get() {
            return externalLibPath.resolve("libffmpegkit.so").exists()
        }

    /**
     * 使目标进程可以使用来自模块的库
     */
    @SuppressLint("UnsafeDynamicallyLoadedCode")
    fun load(name: String) {
        try {
            if (name == "shamrock" || name == "clover") {
                val context = MobileQQ.getContext()
                val packageManager = context.packageManager
                val applicationInfo = packageManager.getApplicationInfo("moe.fuqiuluo.shamrock.hided", 0)
                val file = File(applicationInfo.nativeLibraryDir)
                LogCenter.log("LoadLibrary(name = $name)")
                System.load(file.resolve("lib$name.so").absolutePath)
            } else {
                val sourceFile = externalLibPath.resolve("lib$name.so")
                val soFile = MobileQQ.getContext().filesDir.parentFile!!.resolve("txlib").resolve("lib$name.so")
                if (!soFile.exists()) {
                    if (!sourceFile.exists()) {
                        LogCenter.log("LoadExternalLibrary(name = $name) failed, file not exists.", level = Level.ERROR)
                        return
                    } else {
                        sourceFile.copyTo(soFile)
                        Runtime.getRuntime().exec("chmod 755 ${soFile.absolutePath}").waitFor()
                    }
                }
                LogCenter.log("LoadExternalLibrary(name = $name)")
                System.load(soFile.absolutePath)
            }
        } catch (e: Throwable) {
            XposedBridge.log(e)
        }
    }
}