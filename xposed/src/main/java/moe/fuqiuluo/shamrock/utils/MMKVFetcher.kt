package moe.fuqiuluo.shamrock.utils

import android.content.Context
import com.tencent.mmkv.MMKV
import java.lang.reflect.Method
import java.lang.reflect.Modifier

internal object MMKVFetcher {
    private lateinit var METHOD_GET_MMKV: Method
    private lateinit var METHOD_GET_MMKV_WITH_ID: Method
    private lateinit var METHOD_INIT_MMKV: Method

    fun initMMKV(ctx: Context) {
        if (!MMKVFetcher::METHOD_INIT_MMKV.isInitialized) {
            METHOD_INIT_MMKV = MMKV::class.java.declaredMethods.first {
                Modifier.isStatic(it.modifiers) && it.parameterCount == 1 && it.parameterTypes[0] == Context::class.java
            }
            METHOD_INIT_MMKV.invoke(null, ctx)
        }
    }

    fun defaultMMKV(): MMKV {
        if (!MMKVFetcher::METHOD_GET_MMKV.isInitialized) {
            METHOD_GET_MMKV = MMKV::class.java.declaredMethods.first {
                Modifier.isStatic(it.modifiers) && it.parameterCount == 0 && it.returnType == MMKV::class.java
            }
        }
        return METHOD_GET_MMKV.invoke(null) as MMKV
    }

    fun mmkvWithId(id: String): MMKV {
        if (!MMKVFetcher::METHOD_GET_MMKV_WITH_ID.isInitialized) {
            METHOD_GET_MMKV_WITH_ID = MMKV::class.java.declaredMethods.first {
                Modifier.isStatic(it.modifiers)
                        && it.parameterCount == 2
                        && it.parameterTypes[0] == String::class.java
                        && it.parameterTypes[1] == Int::class.java
                        && it.returnType == MMKV::class.java
            }
        }
        return METHOD_GET_MMKV_WITH_ID.invoke(null, id, 2) as MMKV
    }
}