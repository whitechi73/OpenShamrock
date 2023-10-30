@file:Suppress("UNCHECKED_CAST")
package moe.fuqiuluo.shamrock.xposed.actions

import android.content.Context
import moe.fuqiuluo.shamrock.tools.hookMethod
import java.lang.Exception

/**
 * 反检测
 */
class AntiDetection: IAction {
    override fun invoke(ctx: Context) {
        val isModuleStack = fun StackTraceElement.(): Boolean {
            return className.contains("fuqiuluo") || className.contains("shamrock") || className.contains("whitechi")
        }

        Thread::class.java.hookMethod("getStackTrace").after {
            val result = it.result as Array<StackTraceElement>
            it.result = result.filter {
                !it.isModuleStack()
            }.toTypedArray()
        }

        Throwable::class.java.hookMethod("getStackTrace").after {
            val result = it.result as Array<StackTraceElement>
            it.result = result.filter {
                !it.isModuleStack()
            }.toTypedArray()
        }

        Throwable::class.java.hookMethod("getOurStackTrace").after {
            val result = it.result as Array<StackTraceElement>
            it.result = result.filter {
                !it.isModuleStack()
            }.toTypedArray()
        }
    }
}