package moe.fuqiuluo.shamrock.xposed.helper

import android.content.ContentValues
import android.net.Uri
import mqq.app.MobileQQ

internal object AppTalker {
    private const val uriName = "content://moe.fuqiuluo.108.provider" // 你是真的闲，这都上个检测
    private val URI = Uri.parse(uriName)

    fun talk(values: ContentValues, onFailure: ((Throwable) -> Unit)? = null) {
        val ctx = MobileQQ.getContext()
        try {
            ctx.contentResolver.insert(URI, values)
        } catch (e: Throwable) {
            onFailure?.invoke(e)
        }
    }

    fun talk(action: String, bodyBuilder: ContentValues.() -> Unit) {
        val values = ContentValues()
        values.put("__cmd", action)
        values.put("__hash", 0)
        bodyBuilder.invoke(values)
        talk(values)
    }

    fun talk(action: String, onFailure: ((Throwable) -> Unit)? = null, bodyBuilder: ContentValues.() -> Unit = {}) {
        val values = ContentValues()
        values.put("__cmd", action)
        values.put("__hash", 0)
        bodyBuilder.invoke(values)
        talk(values, onFailure)
    }
}