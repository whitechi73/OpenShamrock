package moe.fuqiuluo.shamrock.xposed.helper

import android.content.ContentValues
import android.net.Uri
import mqq.app.MobileQQ
import kotlin.random.Random

internal object AppTalker {
    val uriName = "content://moe.fuqiuluo.108.provider" // 你是真的闲，这都上个检测
    val URI = Uri.parse(uriName)

    fun talk(values: ContentValues, onFailure: ((Throwable) -> Unit)? = null) {
        val ctx = MobileQQ.getContext()
        try {
            ctx.contentResolver.insert(URI, values)
        } catch (e: Throwable) {
            onFailure?.invoke(e)
        }
    }
}