@file:Suppress("UNCHECKED_CAST")
package moe.fuqiuluo.shamrock.xposed.actions

import android.content.Context
import android.os.Build
import moe.fuqiuluo.shamrock.tools.hookMethod

/**
 * 反检测
 */
class AntiDetection: IAction {
    override fun invoke(ctx: Context) {
        antiTrace()
        antiMemoryWalking()
    }

    val isModuleStack = fun String.(): Boolean {
        return contains("fuqiuluo") || contains("shamrock") || contains("whitechi") || contains("lsposed") || contains("xposed")
    }

    private fun antiMemoryWalking() {
        val c = Class.forName("dalvik.system.VMDebug")
        //val startMethodTracingMethod = c.getDeclaredMethod(
        //    "startMethodTracing", String::class.java,
        //    Integer.TYPE, Integer.TYPE, java.lang.Boolean.TYPE, Integer.TYPE
        //)
        //val stopMethodTracingMethod = c.getDeclaredMethod("stopMethodTracing")
        //val getMethodTracingModeMethod = c.getDeclaredMethod("getMethodTracingMode")
        //val getRuntimeStatMethod = c.getDeclaredMethod("getRuntimeStat", String::class.java)
        //val getRuntimeStatsMethod = c.getDeclaredMethod("getRuntimeStats")

        c.hookMethod("countInstancesOfClass").before {
            val clz = it.args[0] as Class<*>
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                if(clz.packageName.isModuleStack()) {
                    it.result = 0L
                }
            } else {
                if(clz.canonicalName?.isModuleStack() == true) {
                    it.result = 0L
                }
            }
        }

        c.hookMethod("countInstancesOfClasses").before {
            val clzs = it.args[0] as Array<Class<*>>
            clzs.forEach {  clz ->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    if(clz.packageName.isModuleStack()) {
                        it.result = 0L
                        return@forEach
                    }
                } else {
                    if(clz.canonicalName?.isModuleStack() == true) {
                        it.result = 0L
                        return@forEach
                    }
                }
            }
        }

        c.hookMethod("getInstancesOfClasses").after {
            val clzs = it.args[0] as Array<Class<*>>
            clzs.forEachIndexed { _, clz ->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    if(clz.packageName.isModuleStack()) {
                        it.result = Array<Any>(0) {  }
                    }
                } else {
                    if(clz.canonicalName?.isModuleStack() == true) {
                        it.result = Array<Any>(0) {  }
                    }
                }
            }
        }
    }

    private fun antiTrace() {
        val isModuleStack = fun StackTraceElement.(): Boolean {
            return className.isModuleStack()
        }

        Thread::class.java.hookMethod("getName").after {
            val result = it.result as String
            if (result.contains("fuqiuluo") || result.contains("shamrock") || result.contains("whitechi")) {
                it.result = "android"
            }
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