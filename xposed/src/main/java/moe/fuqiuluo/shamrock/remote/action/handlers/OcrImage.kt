package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.mobileqq.l0.b.c
import com.tencent.mobileqq.ocr.a.a
import com.tencent.mobileqq.ocr.api.IPicOcrService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.BaseSvc
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.utils.FileUtils
import moe.fuqiuluo.shamrock.utils.MD5
import moe.fuqiuluo.symbols.OneBotHandler
import java.io.File
import kotlin.coroutines.resume

@OneBotHandler("ocr_image")
internal object OcrImage: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val image = session.getString("image")
        return invoke(image, session.echo)
    }

    suspend operator fun invoke(image: String, echo: JsonElement = EmptyJsonString): String {
        val file = FileUtils.getFile(image).let {
            if (!it.exists()) {
                return@let FileUtils.parseAndSave(image)
            }
            it
        }
        LogCenter.log("对${file.absoluteFile.absolutePath}进行OCR", Level.DEBUG)
        val retryCount = 10
        val delayMillis = 1000L
        repeat(retryCount) {
            val result = getOcrResult(file)

            if (result.isSuccess) {
                return ok(result.getOrNull(), echo)
            } else if (result.isFailure && result.exceptionOrNull()?.message == "no cache") {
                withContext(Dispatchers.IO) {
                    Thread.sleep(delayMillis)
                }
            } else {
                return error(result.exceptionOrNull()?.message ?: "", echo)
            }
        }
        return error("ocr failed", echo)
    }

    private suspend fun getOcrResult(file: File): Result<OcrResult> {
        val ocrService = BaseSvc.app.getRuntimeService(IPicOcrService::class.java, "all")
            ?: return Result.failure(Error("获取OCR服务失败"))
        return withTimeoutOrNull(5000) {
            suspendCancellableCoroutine { continuation ->
                ocrService.requestOcr(
                    a().apply {
                        this.b = 1
                        this.c = file.absolutePath
                        this.f = MD5.genFileMd5Hex(file.absolutePath)
                    }, object : com.tencent.mobileqq.l0.b.a() {
                        override fun b() {
                            // call uploadOcrPic and then call b
                            continuation.resume(Result.failure(Error("no cache")))
                        }

                        override fun c(result: c?) {
                            continuation.resume(Result.success(OcrResult(
                                texts = result?.f?.map {
                                    TextDetection(
                                        text = it.a,
                                        confidence = it.b,
                                        coordinates = it.c.map {
                                            ArrayList<Int>().apply {
                                                add(it.x)
                                                add(it.y)
                                            }
                                        }
                                    )
                                }!!,
                                language = result.h[result.d] ?: result.d,
                                url = result.e
                            )))
                        }
                        override fun onUpdate(i2: Int, z: Boolean, obj: Any?) {
                            LogCenter.log("$i2, $z, ${obj.toString()}")
                            if (i2 == 100) {
                                val result = obj as c
                                continuation.resume(Result.success(OcrResult(
                                    texts = result.f.map {
                                        TextDetection(
                                            text = it.a,
                                            confidence = it.b,
                                            coordinates = it.c.map {
                                                ArrayList<Int>().apply {
                                                    add(it.x)
                                                    add(it.y)
                                                }
                                            }
                                        )
                                    },
                                    language = result.h[result.d] ?: result.d,
                                    url = result.e
                                )))
                            }
                        }
                    })

            }
        } ?: Result.failure(Exception("OCR timed out"))
    }

    override val requiredParams: Array<String> = arrayOf("group_id", "user_id")

    @Serializable
    data class OcrResult (
        val texts: List<TextDetection>,
        val language: String,
        val url: String
    )

    @Serializable
    data class TextDetection (
        val text: String,
        val confidence: Int,
        val coordinates: List<List<Int>>
    )
}