package moe.fuqiuluo.shamrock.xposed.loader

import android.annotation.SuppressLint
import android.os.Build
import de.robv.android.xposed.XposedBridge
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.xposed.loader.LuoClassloader.moduleLoader
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

    private val isEmu: Boolean = runCatching {
        if (Build.SUPPORTED_ABIS.any { it.contains("x86") }) {
            XposedBridge.log("[Shamrock] 通过SUPPORTED_ABIS检测到 Android x86")
            return@runCatching true
        }
        val clazz = Class.forName("dalvik.system.VMRuntime")
        val method = clazz.getDeclaredMethod("getRuntime")
        val runtime = method.invoke(null)
        val field = clazz.getDeclaredField("vmInstructionSet")
        field.isAccessible = true
        val instructionSet = field.get(runtime) as String
        if (instructionSet.contains("x86") ) {
            XposedBridge.log("[Shamrock] 反射检测到 Android x86")
            true
        } else false
    }.onFailure {
        XposedBridge.log("[Shamrock] ${it.stackTraceToString()}")
    }.getOrElse { false }

    private fun getLibFilePath(name: String): String {
        return if (isEmu) "lib/x86_64/lib${name}.so" else "lib/arm64-v8a/lib$name.so"
    }

    /**
     * 使目标进程可以使用来自模块的库
     */
    fun load(name: String) {
        try {
            if (name == "shamrock"
                || (name == "clover" && isEmu)
                ) {
                onLoadByResource(name)
            } else if (!onLoadByAbsolutePath(name)) {
                onLoadByExternalFile(name)
            }
        } catch (e: Throwable) {
            XposedBridge.log(e)
        }
    }

    private fun onLoadByAbsolutePath(name: String): Boolean {
        val context = MobileQQ.getContext()
        val packageManager = context.packageManager
        val applicationInfo = packageManager.getApplicationInfo("moe.fuqiuluo.shamrock.hided", 0)
        val file = File(applicationInfo.nativeLibraryDir)
        LogCenter.log("LoadLibrary(name = $name)")
        loadLibrary(file.resolve("lib$name.so").also {
            if (!it.exists()) {
                LogCenter.log("LoadLibrary(name = $name) failed, file not exists.", level = Level.ERROR)
                return false
            }
        }.absolutePath, false)
        return true
    }

    private fun onLoadByExternalFile(name: String) {
        val sourceFile = externalLibPath.resolve("lib$name.so")
        val soFile = MobileQQ.getContext().filesDir.parentFile!!
            .resolve("txlib").resolve("lib$name.so")
        if (!soFile.exists()) {
            if (!sourceFile.exists()) {
                LogCenter.log("LoadExternalLibrary(name = $name) failed, file not exists.", level = Level.ERROR)
                return
            } else {
                sourceFile.copyTo(soFile)
            }
        }
        LogCenter.log("LoadExternalLibrary(name = $name)")
        loadLibrary(soFile.absolutePath)
    }

    private fun onLoadByResource(name: String) {
        val soDir = File(MobileQQ.getContext().filesDir, "SM_LIBS")
        if (soDir.isFile) soDir.delete()
        if (!soDir.exists()) soDir.mkdirs()
        val soPath = getLibFilePath(name)
        val soFile = File(soDir, name)
        fun reloadSo(tmp: File? = null) {
            LogCenter.log("SO文件大小不一致或不存在，正在重新加载", Level.INFO)
            soFile.delete()
            if (tmp == null) moduleLoader.getResourceAsStream(soPath).use { origin ->
                soFile.outputStream().use { origin.copyTo(it) }
            } else tmp.renameTo(soFile)
        }
        try {
            if (!soFile.exists()) {
                reloadSo()
            } else {
                val tmpSoFile = File(soDir, "$name.tmp").also {  file ->
                    if (file.exists()) file.delete()
                    file.outputStream().use {
                        moduleLoader.getResourceAsStream(soPath).use { origin ->
                            origin.copyTo(it)
                        }
                    }
                }
                if (soFile.length() != tmpSoFile.length() || MD5.getFileMD5(soFile).let {
                    it != MD5.getFileMD5(tmpSoFile)
                }) {
                    reloadSo(tmpSoFile)
                } else { tmpSoFile.delete() }
            }
            loadLibrary(soFile.absolutePath)
        } catch (e: Exception) {
            LogCenter.log(e.toString(), Level.ERROR)
            throw e
        }
    }

    @SuppressLint("UnsafeDynamicallyLoadedCode")
    private fun loadLibrary(path: String, autoChmod: Boolean = true) {
        if (autoChmod) Runtime.getRuntime()
            .exec("chmod 755 $path").waitFor()
        System.load(path)
        LogCenter.log({ "加载SO文件成功 -> $path" }, Level.DEBUG)
    }
}
