package moe.fuqiuluo.shamrock.helper

import java.io.File
import java.io.IOException
import java.io.RandomAccessFile

internal object TransfileHelper {
    private val extensionMap = mapOf(
        ".mp3" to 1,
        ".3gpp" to 1,
        ".flac" to 1,
        ".ogg" to 1,
        ".wav" to 1,
        ".m4a" to 1,
        ".bmp" to 0,
        ".jpg" to 0,
        ".jpeg" to 0,
        ".png" to 0,
        ".icon" to 0,
        ".webp" to 0,
        ".psd" to 12,
        ".swf" to 2,
        ".mov" to 2,
        ".mp4" to 2,
        ".3gp" to 2,
        ".avi" to 2,
        ".rmvb" to 2,
        ".mpg" to 2,
        ".rm" to 2,
        ".asf" to 2,
        ".mpeg" to 2,
        ".mkv" to 2,
        ".wmv" to 2,
        ".flv" to 2,
        ".f4v" to 2,
        ".webm" to 2,
        ".mod" to 2,
        ".mpe" to 2,
        ".fla" to 2,
        ".m4r" to 2,
        ".m4u" to 2,
        ".m4v" to 2,
        ".vob" to 2,
        ".doc" to 3,
        ".docx" to 3,
        ".wps" to 3,
        ".pages" to 3,
        ".zip" to 4,
        ".rar" to 4,
        ".7z" to 4,
        ".tar" to 4,
        ".iso" to 4,
        ".gz" to 4,
        ".apk" to 5,
        ".apk.rename" to 5,
        ".xls" to 6,
        ".xlsx" to 6,
        ".csv" to 6,
        ".numbers" to 6,
        ".et" to 6,
        ".ppt" to 7,
        ".pptx" to 7,
        ".pps" to 7,
        ".dps" to 7,
        ".keynotes" to 7,
        ".htm" to 8,
        ".html" to 8,
        ".php" to 8,
        ".pdf" to 9,
        ".txt" to 10,
        ".epub" to 10,
        ".rtf" to 10,
        ".c" to 10,
        ".conf" to 10,
        ".cpp" to 10,
        ".h" to 10,
        ".java" to 10,
        ".log" to 10,
        ".prop" to 10,
        ".rc" to 10,
        ".sh" to 10,
        ".xml" to 10,
        ".ai" to 14,
        ".font" to 15,
        ".ipa" to 16,
        ".keynote" to 17,
        ".note" to 18,
        ".numbers" to 19,
        ".pages" to 20,
        ".sketch" to 21
    )

    fun getExtensionId(name: String): Int {
        val index = name.lastIndexOf(".")
        if (index == -1) return 0
        val extension = name.substring(index)
        return extensionMap[extension] ?: -1
    }

    fun isGifFile(picFile: File): Boolean {
        if (picFile.exists() && picFile.length() > 3) {
            return RandomAccessFile(picFile, "r").use {
                val bArr = ByteArray(3)
                it.read(bArr)
                if (bArr[0].toInt() == 71 && bArr[1].toInt() == 73 && bArr[2].toInt() == 70) { return true } else false
            }
        }
        return false
    }
}