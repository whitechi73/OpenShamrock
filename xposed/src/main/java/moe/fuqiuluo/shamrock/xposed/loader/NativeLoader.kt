package moe.fuqiuluo.shamrock.xposed.loader

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import de.robv.android.xposed.XposedBridge
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.xposed.loader.tmpnativehelper.moduleClassLoader
import mqq.app.MobileQQ
import oicq.wlogin_sdk.tools.MD5
import java.io.File

internal object NativeLoader {
    private val externalLibPath = MobileQQ.getContext()
        .getExternalFilesDir(null)!!.parentFile!!.resolve("Tencent/Shamrock/lib")

    val isVoiceLoaded: Boolean
        get() {
            return externalLibPath.resolve("libffmpegkit.so").exists()
        }

    private val isEmu: Boolean
        get() {
            if (Build.SUPPORTED_ABIS.any { it.contains("x86") }) {
                XposedBridge.log("[Shamrock] 通过SUPPORTED_ABIS检测到 Android x86")
                return true
            }
            return try {
                val clazz = Class.forName("dalvik.system.VMRuntime")
                val method = clazz.getDeclaredMethod("getRuntime")
                val runtime = method.invoke(null)
                val field = clazz.getDeclaredField("vmInstructionSet")
                field.isAccessible = true
                val instructionSet = field.get(runtime) as String
                if ( instructionSet.contains("x86") ) {
                    XposedBridge.log("[Shamrock] 反射检测到 Android x86")
                    true
                } else false
            } catch (e: Exception) {
                XposedBridge.log("[Shamrock] $e")
                false
            }
        }

    private fun getLibFilePath(name: String): String {
        return if (isEmu) "lib/x86_64/lib${name}.so" else "lib/arm64-v8a/lib$name.so"
    }

    /**
     * 使目标进程可以使用来自模块的库
     */
    @SuppressLint("UnsafeDynamicallyLoadedCode")
    fun load(name: String) {
        try {
            if (name == "shamrock" || name == "clover") {
                onLoadByCopiedLibrary(name, getCtx())
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

    private inline fun getCtx() = MobileQQ.getContext()

    @SuppressLint("UnsafeDynamicallyLoadedCode")
    private fun onLoadByCopiedLibrary(name: String, context: Context) {
        val soDir = File(context.filesDir, "SM_LIBS")
        if (soDir.isFile) {
            soDir.delete()
        }
        if (!soDir.exists()) {
            soDir.mkdirs()
        }
        val soPath = getLibFilePath(name)
        val soFile = File(soDir, name)
        fun reloadSo(tmp: File? = null) {
            LogCenter.log("SO文件大小不一致或不存在，正在重新加载", Level.INFO)
            soFile.delete()
            if (tmp == null) moduleClassLoader.getResourceAsStream(soPath).use { origin ->
                soFile.outputStream().use { origin.copyTo(it) }
            } else tmp.renameTo(soFile)
        }
        try {
            if (!soFile.exists()) {
                reloadSo()
            } else {
                val tmpSoFile = soFile.resolve("$name.tmp").also {  file ->
                    if (file.exists()) file.delete()
                    file.outputStream().use {
                        moduleClassLoader.getResourceAsStream(soPath).use { origin ->
                            origin.copyTo(it)
                        }
                    }
                }
                if (soFile.length() != tmpSoFile.length() || MD5.getFileMD5(soFile).let {
                    it != MD5.getFileMD5(tmpSoFile)
                }) {
                    reloadSo(tmpSoFile)
                }
            }
            try {
                System.load(soFile.absolutePath)
                LogCenter.log("加载SO文件成功 -> ${soFile.path}", Level.INFO)
            } catch (e: Throwable) {
                LogCenter.log(e.toString(), Level.WARN)
                throw e
            }
        } catch (e: Exception) {
            LogCenter.log(e.toString(), Level.WARN)
            throw e
        }
    }
}
