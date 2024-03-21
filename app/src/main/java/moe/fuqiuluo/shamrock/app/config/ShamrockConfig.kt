package moe.fuqiuluo.shamrock.app.config

import android.content.Context
import moe.fuqiuluo.shamrock.config.ConfigKey
import moe.fuqiuluo.shamrock.ui.service.internal.broadcastToModule

object ShamrockConfig {
    internal fun getConfigPref(ctx: Context) = ctx.getSharedPreferences("config", 0)

    internal inline operator fun <reified Type> get(ctx: Context, key: ConfigKey<Type>): Type {
        val preferences = getConfigPref(ctx)
        return when(Type::class) {
            Int::class -> preferences.getInt(key.name(), key.default() as Int) as Type
            Long::class -> preferences.getLong(key.name(), key.default() as Long) as Type
            String::class -> preferences.getString(key.name(), key.default() as String) as Type
            Boolean::class -> preferences.getBoolean(key.name(), key.default() as Boolean) as Type
            else -> throw IllegalArgumentException("Unsupported type")
        }
    }

    internal inline operator fun <reified Type> set(ctx: Context, key: ConfigKey<Type>, value: Type) {
        val preferences = getConfigPref(ctx)
        val editor = preferences.edit()
        when(Type::class) {
            Int::class -> editor.putInt(key.name(), value as Int)
            Long::class -> editor.putLong(key.name(), value as Long)
            String::class -> editor.putString(key.name(), value as String)
            Boolean::class -> editor.putBoolean(key.name(), value as Boolean)
            else -> throw IllegalArgumentException("Unsupported type")
        }
        editor.apply()
    }
}