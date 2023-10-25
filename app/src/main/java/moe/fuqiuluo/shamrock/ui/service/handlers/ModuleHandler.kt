package moe.fuqiuluo.shamrock.ui.service.handlers

import android.content.ContentValues
import android.content.Context
import moe.fuqiuluo.shamrock.ui.service.internal.broadcastToModule

abstract class ModuleHandler {
    abstract val cmd: String

    abstract fun onReceive(callbackId: Int, values: ContentValues, context: Context)

    fun callback(context: Context, callbackId: Int, data: Map<String, Any?>) {
        context.broadcastToModule {
            data.forEach { (key, value) ->
                if (value == null) {
                    val v: String? = null
                    this.putExtra(key, v)
                } else {
                    when (value) {
                        is Int -> this.putExtra(key, value)
                        is Long -> this.putExtra(key, value)
                        is Short -> this.putExtra(key, value)
                        is Byte -> this.putExtra(key, value)
                        is String -> this.putExtra(key, value)
                        is ByteArray -> this.putExtra(key, value)
                        is Boolean -> this.putExtra(key, value)
                        is Float -> this.putExtra(key, value)
                        is Double -> this.putExtra(key, value)
                    }
                }
            }
            putExtra("__hash", callbackId)
        }
    }
}