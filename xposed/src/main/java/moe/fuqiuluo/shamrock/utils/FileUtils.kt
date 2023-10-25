package moe.fuqiuluo.shamrock.utils

import android.util.Base64
import io.ktor.util.cio.writeChannel
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.copyTo
import moe.fuqiuluo.shamrock.utils.MD5.genFileMd5Hex
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import mqq.app.MobileQQ
import java.io.ByteArrayInputStream
import java.io.File
import java.io.InputStream
import java.util.UUID

internal object FileUtils {
    private val CacheDir = MobileQQ.getContext().getExternalFilesDir(null)!!
        .parentFile!!.resolve("Tencent/Shamrock/tmpfiles").also {
            if (it.exists()) it.delete()
            it.mkdirs()
        }
    private val PicIdMap = hashMapOf(
        "jpg" to 1000,
        "bmp" to 1005,
        "gif" to 2000,
        "png" to 1001,
        "webp" to 1002,
        "sharpp" to 1004,
        "apng" to 2001,
    )

    suspend fun parseAndSave(file: String): File {
        return if (file.startsWith("base64://")) {
            saveFileToCache(ByteArrayInputStream(
                Base64.decode(file.substring(9), Base64.DEFAULT)
            ))
        } else if (file.startsWith("file:///")) {
            File(file.substring(8)).inputStream().use {
                saveFileToCache( it )
            }
        } else if (file.startsWith("http://") || file.startsWith("https://")) {
            kotlin.run {
                val tmp = getTmpFile()
                if(DownloadUtils.download(file, tmp)) {
                    tmp.inputStream().use {
                        saveFileToCache(it)
                    }.also {
                        tmp.delete()
                        LogCenter.log({ "文件下载完成: ${it.absolutePath}, 地址: $file" }, Level.DEBUG)
                    }
                } else {
                    tmp.delete()
                    error("文件下载失败: $file")
                }
            }
        } else error("不支持的文件地址: $file")
    }

    fun renameByMd5(file: File): File {
        val md5 = genFileMd5Hex(file.absolutePath)
        val dirName  = md5.substring(md5.length - 4)
        val newFile = CacheDir.resolve(dirName).also {
            if(!it.exists()) {
                it.mkdirs()
            }
        }.resolve(md5)
        file.renameTo(newFile)
        file.delete()
        return newFile
    }

    fun getTmpFile(
        prefix: String = "tmp",
        create: Boolean = true,
        end: String = ""
    ): File {
        if(!CacheDir.exists()) {
            CacheDir.mkdirs()
        }
        return CacheDir.resolve(prefix + "_" + UUID.randomUUID().toString() + end).also {
            if (create && !it.exists()) it.createNewFile()
        }
    }

    fun getFile(dir: String, name: String?): File {
        if (name == null) return getFile(dir)
        val file = CacheDir.resolve(dir)
        if (!file.exists()) {
            file.mkdirs()
        }
        return file.resolve(name)
    }

    fun getFile(name: String): File {
        if (name.length == 32) {
            // 使用md5获取值
            val dirName = name.substring(name.length - 4)
            val file = CacheDir.resolve("$dirName/$name")
            if (file.exists()) {
                return file
            }
        }
        return CacheDir.resolve(name)
    }

    fun getFileType(file: File): String {
        val bytes = ByteArray(2)
        file.inputStream().use {
            it.read(bytes)
        }
        return when ("${bytes[0].toUByte()}${bytes[1].toUByte()}".toInt()) {
            6677 -> "bmp"
            7173 -> "gif"
            7784 -> "midi"
            7790 -> "exe"
            8075 -> "zip"
            8273 -> "webp"
            8297 -> "rar"
            13780 -> "png"
            255216 -> "jpg"
            else -> "jpg"
        }
    }

    fun getPicType(file: File): Int {
        return PicIdMap[getFileType(file)] ?: 1000
    }

    suspend fun saveFileToCache(channel: ByteReadChannel): File {
        val tmpFile = getTmpFile()
        channel.copyTo(tmpFile.writeChannel())
        val md5Hex = genFileMd5Hex(tmpFile.absolutePath)
        val sourceFile = CacheDir.resolve(md5Hex)
        tmpFile.renameTo(sourceFile)
        return sourceFile
    }

    fun saveFileToCache(input: InputStream): File {
        val tmpFile = getTmpFile()
        tmpFile.outputStream().use {
            input.copyTo(it)
        }
        val md5Hex = genFileMd5Hex(tmpFile.absolutePath)
        val sourceFile = CacheDir.resolve(md5Hex)
        if (sourceFile.exists()) {
            sourceFile.delete()
        }
        tmpFile.renameTo(sourceFile)
        tmpFile.delete()
        return sourceFile
    }

    fun clearCache() {
        CacheDir.delete()
        CacheDir.mkdirs()
    }

}