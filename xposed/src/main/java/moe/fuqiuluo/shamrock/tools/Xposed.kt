package moe.fuqiuluo.shamrock.tools

import com.tencent.mobileqq.pb.MessageMicro
import com.tencent.mobileqq.pb.PBBoolField
import com.tencent.mobileqq.pb.PBBytesField
import com.tencent.mobileqq.pb.PBEnumField
import com.tencent.mobileqq.pb.PBInt32Field
import com.tencent.mobileqq.pb.PBInt64Field
import com.tencent.mobileqq.pb.PBStringField
import com.tencent.mobileqq.pb.PBUInt32Field
import com.tencent.mobileqq.pb.PBUInt64Field
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XC_MethodHook.MethodHookParam
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.callbacks.XCallback
import moe.fuqiuluo.shamrock.xposed.loader.LuoClassloader
import java.lang.reflect.Field
import java.lang.reflect.Method
import java.lang.reflect.Modifier


internal typealias MethodHooker = (MethodHookParam) -> Unit

internal class XCHook {
    var before = nullableOf<MethodHooker>()
    var after = nullableOf<MethodHooker>()

    fun after(after: MethodHooker): XCHook {
        this.after.set(after)
        return this
    }

    fun before(before: MethodHooker): XCHook {
        this.before.set(before)
        return this
    }
}

internal fun Class<*>.hookMethod(name: String): XCHook {
    return XCHook().also {
        XposedBridge.hookAllMethods(this, name, object : XC_MethodHook() {
            override fun beforeHookedMethod(param: MethodHookParam) {
                it.before.getOrNull()?.invoke(param)
            }

            override fun afterHookedMethod(param: MethodHookParam) {
                it.after.getOrNull()?.invoke(param)
            }
        })
    }
}

internal fun beforeHook(ver: Int = XCallback.PRIORITY_DEFAULT, block: (param: XC_MethodHook.MethodHookParam) -> Unit): XC_MethodHook {
    return object :XC_MethodHook(ver) {
        override fun afterHookedMethod(param: MethodHookParam) {
            block(param)
        }
    }
}

internal fun afterHook(ver: Int = XCallback.PRIORITY_DEFAULT, block: (param: XC_MethodHook.MethodHookParam) -> Unit): XC_MethodHook {
    return object :XC_MethodHook(ver) {
        override fun afterHookedMethod(param: MethodHookParam) {
            block(param)
        }
    }
}

object FuzzySearchClass {
    /**
     * QQ混淆字典
     */
    private val dic = arrayOf(
        "r" , "t", "o", "a", "b", "c", "e", "f", "d", "g", "h", "i", "j", "k", "l", "m", "n", "p", "q", "s", "t", "u", "v", "w", "x", "y", "z"
    )

    /**
     * 通过特殊字段寻找类
     */
    fun findClassByField(prefix: String, check: (Field) -> Boolean): Class<*>? {
        dic.forEach { className ->
            val clz = LuoClassloader.load("$prefix.$className")
            clz?.fields?.forEach {
                if (it.modifiers and Modifier.STATIC != 0
                    && !isBaseType(it.type)
                    && check(it)
                ) return clz
            }
        }
        return null
    }

    fun findAllClassByField(classLoader: ClassLoader, prefix: String, check: (String, Field) -> Boolean): List<Class<*>> {
        val list = arrayListOf<Class<*>>()
        dic.forEach { className ->
            kotlin.runCatching {
                val clz = classLoader.loadClass("$prefix.$className")
                clz.declaredFields.forEach {
                    if (!isBaseType(it.type) && check(className, it)) {
                        list.add(clz)
                    }
                }
            }
        }
        return list
    }

    fun findAllClassByMethod(classLoader: ClassLoader, prefix: String, check: (String, Method) -> Boolean): List<Class<*>> {
        val list = arrayListOf<Class<*>>()
        dic.forEach { className ->
            kotlin.runCatching {
                val clz = classLoader.loadClass("$prefix.$className")
                clz.declaredMethods.forEach {
                    if (check(className, it)) {
                        list.add(clz)
                    }
                }
            }
        }
        return list
    }

    fun findAllClassByField(prefix: String, check: (String, Field) -> Boolean): List<Class<*>> {
        val list = arrayListOf<Class<*>>()
        dic.forEach { className ->
            val clz = LuoClassloader.load("$prefix.$className")
            clz?.fields?.forEach {
                if (!isBaseType(it.type)
                    && check(className, it)
                ) list.add(clz)
            }
        }
        return list
    }

    fun findClassByMethod(prefix: String, check: (Class<*>, Method) -> Boolean): Class<*>? {
        dic.forEach { className ->
            val clz = LuoClassloader.load("$prefix.$className")
            clz?.methods?.forEach {
                if (check(clz, it)) return clz
            }
        }
        return null
    }

    private fun isBaseType(clz: Class<*>): Boolean {
        if (
            clz == Long::class.java ||
            clz == Double::class.java ||
            clz == Float::class.java ||
            clz == Int::class.java ||
            clz == Short::class.java ||
            clz == Char::class.java ||
            clz == Byte::class.java
        ) {
            return true
        }
        return false
    }
}

/**
 * 打印一个类的内部数据（调试）
 */
internal fun Any.toInnerValuesString(): String {
    val builder = StringBuilder()
    val clz = javaClass
    builder.append(clz.canonicalName)
    builder.append(" {\n")
    clz.declaredFields.forEach {
        if (!Modifier.isStatic(it.modifiers)) {
            if (!it.isAccessible) {
                it.isAccessible = true
            }
            builder.append(it.name)
            builder.append(" = ")
            when (val v = it.get(this)) {
                null -> builder.append("null")
                is ByteArray -> builder.append(v.toHexString())
                is Map<*, *> -> {
                    builder.append("{\n\t")
                    v.forEach { key, value ->
                        builder.append("\t")
                        builder.append(key)
                        builder.append(" = ")
                        builder.append(value)
                        builder.append("\n")
                    }
                    builder.append("}")
                }
                is List<*> -> {
                    builder.append("[\n\t")
                    v.forEach { value ->
                        builder.append("\t")
                        builder.append(value)
                        builder.append("\n")
                    }
                    builder.append("]")
                }
                is PBUInt32Field -> {
                    builder.append(v.get())
                }
                is PBUInt64Field -> {
                    builder.append(v.get())
                }
                is PBInt32Field -> {
                    builder.append(v.get())
                }
                is PBInt64Field -> {
                    builder.append(v.get())
                }
                is PBStringField -> {
                    builder.append(v.get())
                }
                is PBBytesField -> {
                    builder.append(v.get().toByteArray().toHexString())
                }
                is PBBoolField -> {
                    builder.append(v.get().toString())
                }
                is PBEnumField -> {
                    builder.append(v.get().toString())
                }
                is MessageMicro<*> -> {
                    builder.append(v.toInnerValuesString())
                }
                else -> builder.append(v)
            }
            builder.append("\n")
        }
    }
    builder.append("}\n")
    return builder.toString()
}

internal fun Any.toInnerValuesString(clz: Class<*>): String {
    val builder = StringBuilder()
    builder.append(clz.canonicalName)
    builder.append("========>\n")
    clz.declaredFields.forEach {
        if (!Modifier.isStatic(it.modifiers)) {
            if (!it.isAccessible) {
                it.isAccessible = true
            }
            builder.append(it.name)
            builder.append(" = ")
            when (val v = it.get(this)) {
                null -> builder.append("null")
                is ByteArray -> builder.append(v.toHexString())
                is Map<*, *> -> {
                    builder.append("{\n\t")
                    v.forEach { key, value ->
                        builder.append("\t")
                        builder.append(key)
                        builder.append(" = ")
                        builder.append(value)
                        builder.append("\n")
                    }
                    builder.append("}")
                }
                is List<*> -> {
                    builder.append("[\n\t")
                    v.forEach { value ->
                        builder.append("\t")
                        builder.append(value)
                        builder.append("\n")
                    }
                    builder.append("]")
                }
                else -> builder.append(v)
            }
            builder.append("\n")
        }
    }
    builder.append("=======================>\n")
    return builder.toString()
}
