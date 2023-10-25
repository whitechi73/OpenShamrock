package moe.fuqiuluo.shamrock.ui.app

import android.content.Context
import moe.fuqiuluo.shamrock.ui.service.internal.broadcastToModule

object ShamrockConfig {
    fun getSSLKeyPath(ctx: Context): String {
        val preferences = ctx.getSharedPreferences("config", 0)
        return preferences.getString("key_store", "")!!
    }

    fun setSSLKeyPath(ctx: Context, path: String) {
        val preferences = ctx.getSharedPreferences("config", 0)
        preferences.edit().putString("key_store", path).apply()
        pushUpdate(ctx)
    }

    fun getSSLPort(ctx: Context): Int {
        val preferences = ctx.getSharedPreferences("config", 0)
        return preferences.getInt("ssl_port", 5701)
    }

    fun setSSLPort(ctx: Context, port: Int) {
        val preferences = ctx.getSharedPreferences("config", 0)
        preferences.edit().putInt("ssl_port", port).apply()
        pushUpdate(ctx)
    }

    fun getSSLAlias(ctx: Context): String {
        val preferences = ctx.getSharedPreferences("config", 0)
        return preferences.getString("ssl_alias", "")!!
    }

    fun setSSLAlias(ctx: Context, alias: String) {
        val preferences = ctx.getSharedPreferences("config", 0)
        preferences.edit().putString("ssl_alias", alias).apply()
        pushUpdate(ctx)
    }

    fun getSSLPwd(ctx: Context): String {
        val preferences = ctx.getSharedPreferences("config", 0)
        return preferences.getString("ssl_pwd", "")!!
    }

    fun setSSLPwd(ctx: Context, alias: String) {
        val preferences = ctx.getSharedPreferences("config", 0)
        preferences.edit().putString("ssl_pwd", alias).apply()
        pushUpdate(ctx)
    }

    fun getSSLPrivatePwd(ctx: Context): String {
        val preferences = ctx.getSharedPreferences("config", 0)
        return preferences.getString("ssl_private_pwd", "")!!
    }

    fun setSSLPrivatePwd(ctx: Context, alias: String) {
        val preferences = ctx.getSharedPreferences("config", 0)
        preferences.edit().putString("ssl_private_pwd", alias).apply()
        pushUpdate(ctx)
    }

    fun getHttpAddr(ctx: Context): String {
        val preferences = ctx.getSharedPreferences("config", 0)
        return preferences.getString("http_addr", "")!!
    }

    fun setHttpAddr(ctx: Context, v: String) {
        val preferences = ctx.getSharedPreferences("config", 0)
        preferences.edit().putString("http_addr", v).apply()
        pushUpdate(ctx)
    }

    fun isPro(ctx: Context): Boolean {
        val preferences = ctx.getSharedPreferences("config", 0)
        return preferences.getBoolean("pro_api", false)
    }

    fun setPro(ctx: Context, v: Boolean) {
        val preferences = ctx.getSharedPreferences("config", 0)
        preferences.edit().putBoolean("pro_api", v).apply()
        ctx.broadcastToModule {
            putExtra("type", "restart")
            putExtra("__cmd", "change_port")
        }
        pushUpdate(ctx)
    }

    fun getToken(ctx: Context): String {
        val preferences = ctx.getSharedPreferences("config", 0)
        return preferences.getString("token", null) ?: ""
    }

    fun setToken(ctx: Context, v: String?) {
        val preferences = ctx.getSharedPreferences("config", 0)
        preferences.edit().putString("token", v).apply()
        pushUpdate(ctx)
    }

    fun isWs(ctx: Context): Boolean {
        val preferences = ctx.getSharedPreferences("config", 0)
        return preferences.getBoolean("ws", false)
    }

    fun setWs(ctx: Context, v: Boolean) {
        val preferences = ctx.getSharedPreferences("config", 0)
        preferences.edit().putBoolean("ws", v).apply()
        pushUpdate(ctx)
    }

    fun isWsClient(ctx: Context): Boolean {
        val preferences = ctx.getSharedPreferences("config", 0)
        return preferences.getBoolean("ws_client", false)
    }

    fun setWsClient(ctx: Context, v: Boolean) {
        val preferences = ctx.getSharedPreferences("config", 0)
        preferences.edit().putBoolean("ws_client", v).apply()
        pushUpdate(ctx)
    }

    fun isTablet(ctx: Context): Boolean {
        val preferences = ctx.getSharedPreferences("config", 0)
        return preferences.getBoolean("tablet", false)
    }

    fun setTablet(ctx: Context, v: Boolean) {
        val preferences = ctx.getSharedPreferences("config", 0)
        preferences.edit().putBoolean("tablet", v).apply()
        pushUpdate(ctx)
    }

    fun isUseCQCode(ctx: Context): Boolean {
        val preferences = ctx.getSharedPreferences("config", 0)
        return preferences.getBoolean("use_cqcode", false)
    }

    fun setUseCQCode(ctx: Context, v: Boolean) {
        val preferences = ctx.getSharedPreferences("config", 0)
        preferences.edit().putBoolean("use_cqcode", v).apply()
        pushUpdate(ctx)
    }

    fun isWebhook(ctx: Context): Boolean {
        val preferences = ctx.getSharedPreferences("config", 0)
        return preferences.getBoolean("webhook", false)
    }

    fun setWebhook(ctx: Context, v: Boolean) {
        val preferences = ctx.getSharedPreferences("config", 0)
        preferences.edit().putBoolean("webhook", v).apply()
        pushUpdate(ctx)
    }

    fun getWsAddr(ctx: Context): String {
        val preferences = ctx.getSharedPreferences("config", 0)
        return preferences.getString("ws_addr", "")!!
    }

    fun setWsAddr(ctx: Context, v: String) {
        val preferences = ctx.getSharedPreferences("config", 0)
        preferences.edit().putString("ws_addr", v).apply()
        pushUpdate(ctx)
    }

    fun getHttpPort(ctx: Context): Int {
        val preferences = ctx.getSharedPreferences("config", 0)
        return preferences.getInt("port", 5700)
    }

    fun setHttpPort(ctx: Context, v: Int) {
        val preferences = ctx.getSharedPreferences("config", 0)
        preferences.edit().putInt("port", v).apply()
        ctx.broadcastToModule {
            putExtra("type", "port")
            putExtra("port", v)
            putExtra("__cmd", "change_port")
        }
        pushUpdate(ctx)
    }

    fun getWsPort(ctx: Context): Int {
        val preferences = ctx.getSharedPreferences("config", 0)
        return preferences.getInt("ws_port", 5800)
    }

    fun setWsPort(ctx: Context, v: Int) {
        val preferences = ctx.getSharedPreferences("config", 0)
        preferences.edit().putInt("ws_port", v).apply()
        ctx.broadcastToModule {
            putExtra("type", "ws_port")
            putExtra("port", v)
            putExtra("__cmd", "change_port")
        }
        pushUpdate(ctx)
    }

    fun is2B(ctx: Context): Boolean {
        val preferences = ctx.getSharedPreferences("config", 0)
        return preferences.getBoolean("2B", false)
    }

    fun set2B(ctx: Context, v: Boolean) {
        val preferences = ctx.getSharedPreferences("config", 0)
        preferences.edit().putBoolean("2B", v).apply()
    }

    fun setAutoClean(ctx: Context, v: Boolean) {
        val preferences = ctx.getSharedPreferences("config", 0)
        preferences.edit().putBoolean("auto_clear", v).apply()
    }

    fun isAutoClean(ctx: Context): Boolean {
        val preferences = ctx.getSharedPreferences("config", 0)
        return preferences.getBoolean("auto_clear", false)
    }

    fun isDebug(ctx: Context): Boolean {
        val preferences = ctx.getSharedPreferences("config", 0)
        return preferences.getBoolean("debug", false)
    }

    fun setDebug(ctx: Context, v: Boolean) {
        val preferences = ctx.getSharedPreferences("config", 0)
        preferences.edit().putBoolean("debug", v).apply()
    }

    fun isInjectPacket(ctx: Context): Boolean {
        val preferences = ctx.getSharedPreferences("config", 0)
        return preferences.getBoolean("inject_packet", false)
    }

    fun setInjectPacket(ctx: Context, v: Boolean) {
        val preferences = ctx.getSharedPreferences("config", 0)
        preferences.edit().putBoolean("inject_packet", v).apply()
    }

    fun enableAutoStart(ctx: Context): Boolean {
        val preferences = ctx.getSharedPreferences("config", 0)
        return preferences.getBoolean("enable_auto_start", false)
    }

    fun setAutoStart(ctx: Context, v: Boolean) {
        val preferences = ctx.getSharedPreferences("config", 0)
        preferences.edit().putBoolean("enable_auto_start", v).apply()
    }

    fun enableSelfMsg(ctx: Context): Boolean {
        val preferences = ctx.getSharedPreferences("config", 0)
        return preferences.getBoolean("enable_self_msg", false)
    }

    fun setEnableSelfMsg(ctx: Context, v: Boolean) {
        val preferences = ctx.getSharedPreferences("config", 0)
        preferences.edit().putBoolean("enable_self_msg", v).apply()
    }

    fun isEchoNumber(ctx: Context): Boolean {
        val preferences = ctx.getSharedPreferences("config", 0)
        return preferences.getBoolean("echo_number", false)
    }

    fun setEchoNumber(ctx: Context, v: Boolean) {
        val preferences = ctx.getSharedPreferences("config", 0)
        preferences.edit().putBoolean("echo_number", v).apply()
    }

    fun getConfigMap(ctx: Context): Map<String, Any?> {
        val preferences = ctx.getSharedPreferences("config", 0)
        return mapOf(
            "tablet" to preferences.getBoolean("tablet", false),
            "port" to preferences.getInt("port", 5700),
            "ws" to preferences.getBoolean("ws", false),
            "ws_port" to preferences.getInt("ws_port", 5800),
            "ssl_port" to preferences.getInt("ssl_port", 5701),
            "http" to preferences.getBoolean("webhook", false),
            "http_addr" to preferences.getString("http_addr", ""),
            "ws_client" to preferences.getBoolean("ws_client", false),
            "use_cqcode" to preferences.getBoolean("use_cqcode", false),
            "ws_addr" to preferences.getString("ws_addr", ""),
            "ssl_alias" to preferences.getString("ssl_alias", ""),
            "pro_api" to preferences.getBoolean("pro_api", false),
            "token" to preferences.getString("token", null),
            "ssl_pwd" to preferences.getString("ssl_pwd", ""),
            "inject_packet" to preferences.getBoolean("inject_packet", false),
            "debug" to preferences.getBoolean("debug", false),
            "auto_clear" to preferences.getBoolean("auto_clear", false),
            "ssl_private_pwd" to preferences.getString("ssl_private_pwd", ""),
            "key_store" to preferences.getString("key_store", ""),
            "enable_self_msg" to preferences.getBoolean("enable_self_msg", false),
            "echo_number" to preferences.getBoolean("echo_number", false),
        )
    }

    fun pushUpdate(ctx: Context) {
        ctx.broadcastToModule {
            getConfigMap(ctx).forEach { (key, value) ->
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
            putExtra("__cmd", "push_config")
        }
    }
}