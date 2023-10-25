package moe.fuqiuluo.shamrock.ui.app

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import android.util.Log
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextAlign
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import moe.fuqiuluo.shamrock.ui.theme.GlobalColor
import java.util.Date

object AppRuntime {
    var isInit: Boolean = false

    @SuppressLint("SimpleDateFormat")
    private val format = SimpleDateFormat("[HH:mm:ss] ")

    lateinit var state: RuntimeState

    lateinit var logger: Logger
    internal var maxLogSize = Short.MAX_VALUE / 2

    lateinit var requestCount: MutableIntState

    private val lock = Mutex()

    object AccountInfo {
        lateinit var uin: MutableState<String>

        lateinit var nick: MutableState<String>
    }

    fun log(msg: String, level: Level = Level.INFO) {
        if (::logger.isInitialized) {
            GlobalScope.launch {
                lock.withLock {
                    val format = "%s%s %s".format(format.format(Date()), level.name, msg)
                    val buffer = logger.logCache
                    if (logger.size.intValue >= maxLogSize || buffer.length > 30000) {
                        buffer.setLength(0)
                        logger.logRanges = mutableListOf()
                        logger.size.intValue = 0
                    }

                    val start = buffer.length
                    val end = start + format.length

                    logger.size.intValue += format.length
                    buffer.append(format)
                    logger.logRanges.add(Logger.LogRange(start, end, level))

                    logger.logValue.value = AnnotatedString(
                        text = logger.logCache.toString(),
                        spanStyles = logger.logRanges.map {
                            AnnotatedString.Range(
                                SpanStyle(
                                    color = it.level.color ?: GlobalColor.NoticeBoxText
                                ), it.start, it.end
                            )
                        },
                        paragraphStyles = logger.logRanges.map {
                            AnnotatedString.Range(
                                ParagraphStyle(
                                    textAlign = TextAlign.Start
                                ), it.start, it.end
                            )
                        }
                    )
                }
            }
        } else {
            Log.e("AppRuntime", "logger is not initialized")
        }
    }
}

class RuntimeState(
    val isFined: MutableState<Boolean>,
    val coreVersion: MutableState<String>,
    val coreName: MutableState<String>,
    val supportVoice: MutableState<Boolean>
) {

}

enum class Level(
    val color: Color?,
    val id: Byte
) {
    DEBUG(Color(0xFF4CAF50), 0),
    INFO(null, 1),
    WARN(Color(0xFFFF9800), 2),
    ERROR(Color(0xFFE91E63), 3),
}

class Logger(
    val logCache: StringBuffer,
    val size: MutableIntState,
    var logRanges: MutableList<LogRange>,
    val logValue: MutableState<AnnotatedString>
) {
    data class LogRange(
        val start: Int,
        val end: Int,
        val level: Level
    )
}

