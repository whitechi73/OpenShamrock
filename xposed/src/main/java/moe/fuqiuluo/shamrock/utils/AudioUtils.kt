package moe.fuqiuluo.shamrock.utils

import android.graphics.Bitmap
import android.media.MediaExtractor
import android.media.MediaFormat
import android.media.MediaMetadataRetriever
import com.arthenica.ffmpegkit.FFmpegKit
import com.arthenica.ffmpegkit.FFprobeKit
import com.arthenica.ffmpegkit.ReturnCode
import com.tencent.qqnt.kernel.nativeinterface.QQNTWrapperUtil
import moe.fuqiuluo.shamrock.helper.LocalCacheHelper
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import java.io.File
import java.io.FileOutputStream
import kotlin.math.roundToInt

enum class MediaType {
    Mp3,
    Amr,
    M4a,
    Pcm,
    Silk,
    Wav,
    Flac,
}

object AudioUtils {
    private val SampleRateMap = intArrayOf(8000, 12000, 16000, 24000, 36000, 44100, 48000)
    private val sampleRate: Int
        get() = SampleRateMap[3]

    fun getVideoTime(file: File): Int {
        val retriever = MediaMetadataRetriever()
        val durationMs: Int = try {
            retriever.setDataSource(file.absolutePath)
            val duration = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
            duration!!.toInt()
        } catch (e: Exception) {
            0
        } finally {
            retriever.release()
        }
        return (durationMs * 0.001).roundToInt()
    }

    fun obtainVideoCover(filePath: String, destPath: String) {
        if (destPath.isEmpty()) {
            error("short video thumbs path is empty")
        }
        if (!QQNTWrapperUtil.CppProxy.fileIsExist(destPath)) {
            File(destPath).createNewFile()
        }
        val output = FileOutputStream(destPath)
        output.use {
            val mediaMetadataRetriever = MediaMetadataRetriever()
            mediaMetadataRetriever.setDataSource(filePath)
            val frameAtTime = mediaMetadataRetriever.frameAtTime
            frameAtTime?.compress(Bitmap.CompressFormat.JPEG, 60, it)
            it.flush()
        }
    }

    internal fun audioToSilk(audio: File): Pair<Int, File> {
        val md5 = MD5.genFileMd5Hex(audio.absolutePath)

        val mmkv = MMKVFetcher.mmkvWithId("audio2silk")
        mmkv.getString(md5, null)?.let {
            val silkFile = LocalCacheHelper.getCachePttFile(it)
            if (silkFile.exists()) {
                return getDurationSec(audio) to silkFile
            }
        }

        lateinit var silkFile: File

        val pcmFile = audioToPcm(audio)
        var duration: Int
        pcmToSilk(pcmFile).let {
            val silkMd5 = MD5.genFileMd5Hex(it.first.absolutePath)
            mmkv.putString(md5, silkMd5)
            //LogCenter.log({ "音频转SILK完成：重命名${it.first} ==> $silkFile" }, Level.DEBUG)
            pcmFile.delete()
            silkFile = it.first
            duration = it.second
        }
        if (duration < 1000) {
            duration = 1000
        }

        if (!silkFile.exists()) {
            LogCenter.log("音频转SILK错误：$silkFile", Level.ERROR)
        }

        return duration to silkFile
    }

    internal fun pcmToSilk(file: File): Pair<File, Int> {
        val tmpFile = FileUtils.getTmpFile("silk", false)
        val time = pcmToSilk(sampleRate, 2, file.absolutePath, tmpFile.absolutePath)

        val silkMd5 = MD5.genFileMd5Hex(tmpFile.absolutePath)
        val silk = LocalCacheHelper.getCachePttFile(silkMd5)
        tmpFile.renameTo(silk)
        tmpFile.delete()

        when (time) {
            -1 -> error("input pcm file not found")
            -2 -> error("output silk file cannot open")
            -3 -> error("cannot create silk encoder")
            -4 -> error("cannot init silk encoder")
        }
        return silk to time
    }

    fun getAudioMediaMime(file: File): String? {
        val extractor = MediaExtractor()
        extractor.setDataSource(file.absolutePath)
        var audioFormat: String? = null
        for (i in 0 until extractor.trackCount) {
            val format = extractor.getTrackFormat(i)
            val mime = format.getString(MediaFormat.KEY_MIME)
            if (mime?.startsWith("audio/") == true) {
                audioFormat = mime
                break
            }
        }
        extractor.release()
        return audioFormat
    }

    fun audioToPcm(audio: File): File {
        try {
            val tmp = FileUtils.getTmpFile("pcm", false)
            //LogCenter.log("PcmTMP: $tmp", Level.DEBUG)
            val ffmpegCommand = "-y -i $audio -f s16le -acodec pcm_s16le -ac 1 -ar $sampleRate $tmp"

            //LogCenter.log("ExecStart: $tmp", Level.DEBUG)

            val session = FFmpegKit.execute(ffmpegCommand)
            if (!ReturnCode.isSuccess(session.returnCode)) {
                error("mp3 to pcm error: ${session.allLogsAsString}")
            }

            //LogCenter.log("KitSession: $session", Level.DEBUG)

            return tmp
        } catch (e: Throwable) {
            LogCenter.log(e.stackTraceToString(), Level.ERROR)
            throw e
        }
    }

    fun audioToAmr(silkFile: File, isSilk: Boolean): File {
        return if (isSilk) {
            val pcm = silkToPcm(silkFile)
            val tmp = FileUtils.getTmpFile("", false, ".amr")
            val ffmpegCommand = "-y -f s16le -acodec pcm_s16le -ac 1 -ar $sampleRate -i $pcm -ar 8000 $tmp"
            val session = FFmpegKit.execute(ffmpegCommand)
            if (!ReturnCode.isSuccess(session.returnCode)) {
                LogCenter.log("pcm to amr error: ${session.allLogsAsString}", Level.ERROR)
            }
            pcm.delete()
            FileUtils.renameByMd5(tmp)
        } else {
            silkFile
        }
    }

    fun audioToFlac(silkFile: File, isSilk: Boolean): File {
        return audioToFormat(silkFile, isSilk, "flac")
    }

    fun audioToOgg(silkFile: File, isSilk: Boolean): File {
        return audioToFormat(silkFile, isSilk, "ogg")
    }

    fun audioToWav(silkFile: File, isSilk: Boolean): File {
        return audioToFormat(silkFile, isSilk, "wav")
    }

    fun audioToSpx(silkFile: File, isSilk: Boolean): File {
        return audioToFormat(silkFile, isSilk, "spx")
    }

    fun audioToM4a(pttFile: File, silk: Boolean): File {
        return audioToFormat(pttFile, silk, "m4a")
    }

    fun audioToWma(pttFile: File, silk: Boolean): File {
        return audioToFormat(pttFile, silk, "wma")
    }

    fun audioToMp3(silkFile: File, isSilk: Boolean): File {
        return audioToFormat(silkFile, isSilk, "mp3")
    }

    fun audioToFormat(silkFile: File, isSilk: Boolean, format: String): File {
        val out = FileUtils.getTmpFile("", false, ".$format")
        var input: File = silkFile
        val ffmpegCommand = if (isSilk) {
            input = silkToPcm(input)
            "-y -f s16le -acodec pcm_s16le -ac 1 -ar $sampleRate -i $input $out"
        } else {
            "-y -i $input $out"
        }
        val session = FFmpegKit.execute(ffmpegCommand)
        if (!ReturnCode.isSuccess(session.returnCode)) {
            LogCenter.log("audio to $format error: ${session.allLogsAsString}", Level.ERROR)
        }
        input.delete()
        return FileUtils.renameByMd5(out)
    }

    fun getDurationSec(audio: File): Int {
        return getDuration(audio)
    }

    fun getDuration(audio: File): Int {
        val session = FFprobeKit.getMediaInformation(audio.absolutePath)
        val mediaInformation = session.mediaInformation
        val returnCode: ReturnCode = session.returnCode
        return if (ReturnCode.isSuccess(returnCode) && mediaInformation.duration != null) {
            mediaInformation.duration.split(".")[0].toInt()
        } else {
            1
        }
    }

    fun isSilk(file: File): Boolean {
        if (file.length() <= 7) {
            return false
        }

        val bytes = ByteArray(7)
        file.inputStream().use {
            it.read(bytes)
        }

        return bytes[1] == 0x23.toByte() && bytes[2] == 0x21.toByte() && bytes[3] == 0x53.toByte()
                && bytes[4] == 0x49.toByte() && bytes[5] == 0x4c.toByte() && bytes[6] == 0x4b.toByte()
    }

    fun getMediaType(file: File): MediaType {
        if(isSilk(file)) {
            return MediaType.Silk
        }

        val extractor = MediaExtractor()
        try {
            extractor.setDataSource(file.absolutePath)
            for (i in 0 until extractor.trackCount) {
                val format = extractor.getTrackFormat(i)
                when (val mime = format.getString(MediaFormat.KEY_MIME)) {
                    "audio/mp4a-latm" -> return MediaType.M4a
                    "audio/amr-wb", "audio/amr", "audio/3gpp" -> return MediaType.Amr
                    "audio/raw", "audio/wav" -> return MediaType.Wav
                    "audio/mpeg_L2", "audio/mpeg_L1", "audio/mpeg", "audio/mpeg2" -> return MediaType.Mp3
                    "audio/flac" -> return MediaType.Flac
                    else -> if (mime?.startsWith("audio/")== true) {
                        LogCenter.log("Unable to check audio: $mime", Level.WARN)
                    }
                }
            }
        } catch (e: Throwable) {
            LogCenter.log(e.stackTraceToString(), Level.WARN)
        } finally {
            extractor.release()
        }

        return MediaType.Pcm
    }

    fun silkToPcm(silkFile: File): File {
        val pcmFile = FileUtils.getTmpFile("pcm", false)
        if (silkToPcm(sampleRate, 2, pcmFile.absolutePath, silkFile.absolutePath) < 0) {
            error("silk to pcm error")
        }
        return pcmFile
    }

    private external fun pcmToSilk(rate: Int, type: Byte, pcmFile: String, silkFile: String): Int

    private external fun silkToPcm(rate: Int, type: Byte, pcmFile: String, silkFile: String): Int
}