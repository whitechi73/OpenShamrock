package moe.fuqiuluo.shamrock.remote.service.config

import android.content.Intent
import com.tencent.mmkv.MMKV
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.tools.GlobalJson5
import moe.fuqiuluo.shamrock.utils.MMKVFetcher
import mqq.app.MobileQQ
import java.io.File

internal object ShamrockConfig {
    private val ConfigDir = MobileQQ.getContext().getExternalFilesDir(null)!!
        .parentFile!!.resolve("Tencent/Shamrock").also {
            if (it.exists()) it.delete()
            it.mkdirs()
        }
    private val Config = kotlin.runCatching {
        GlobalJson5.decodeFromString<ServiceConfig>(ConfigDir.resolve("config.json").also {
            if (!it.exists()) it.writeText("{}")
        }.readText())
    }.onFailure {
        LogCenter.log("您的配置文件出现错误: ${it.stackTraceToString()}", Level.ERROR)
    }.getOrElse {
        ServiceConfig()
    }

    fun isInit(): Boolean {
        val mmkv = MMKVFetcher.mmkvWithId("shamrock_config")
        return mmkv.getBoolean("isInit", false)
    }

    private fun updateConfig(config: ServiceConfig = Config) {
        ConfigDir.resolve("config.json").writeText(GlobalJson5.encodeToString(config))
    }

    fun updateConfig(intent: Intent) {
        val mmkv = MMKVFetcher.mmkvWithId("shamrock_config")
        mmkv.apply {
            putBoolean(  "tablet",     intent.getBooleanExtra("tablet", false))                 // 强制平板模式
            putInt(      "port",       intent.getIntExtra("port", 5700))                        // 主动HTTP端口
            putBoolean(  "ws",         intent.getBooleanExtra("ws", false))                     // 主动WS开关
            putBoolean(  "http",       intent.getBooleanExtra("http", false))                   // HTTP回调开关
            putString(   "http_addr",  intent.getStringExtra("http_addr"))                                // WebHook回调地址
            putBoolean(  "ws_client",  intent.getBooleanExtra("ws_client", false))              // 被动WS开关
            putBoolean(  "use_cqcode", intent.getBooleanExtra("use_cqcode", false))             // 使用CQ码
            putBoolean(  "inject_packet",    intent.getBooleanExtra("inject_packet", false))    // 拦截无用包
            putBoolean(  "debug",      intent.getBooleanExtra("debug", false))                  // 调试模式

            Config.defaultToken = intent.getStringExtra("token")
            Config.antiTrace = intent.getBooleanExtra("anti_qq_trace", true)

            val wsPort = intent.getIntExtra("ws_port", 5800)
            Config.activeWebSocket = if (Config.activeWebSocket == null) ConnectionConfig(
                address = "0.0.0.0",
                port = wsPort,
            ) else Config.activeWebSocket?.also {
                it.port = wsPort
            }

            Config.passiveWebSocket = intent.getStringExtra("ws_addr")?.split(",", "|", "，")?.filter { address ->
                address.isNotBlank() && (address.startsWith("ws://") || address.startsWith("wss://"))
            }?.map {
                ConnectionConfig(address = it)
            }?.toMutableList()

            putString(  "key_store",   intent.getStringExtra("key_store"))                                // 证书路径
            putString(  "ssl_pwd",     intent.getStringExtra("ssl_pwd"))                                  // 证书密码
            putString(  "ssl_private_pwd",   intent.getStringExtra("ssl_private_pwd"))                    // 证书私钥密码
            putString(  "ssl_alias",   intent.getStringExtra("ssl_alias"))                                // 证书别名
            putInt(     "ssl_port",    intent.getIntExtra("ssl_port", 5701))                    // 主动HTTP端口

            putBoolean("alive_reply",   intent.getBooleanExtra("alive_reply", false))             // 自回复测试

            putBoolean("enable_self_msg",    intent.getBooleanExtra("enable_self_msg", false))  // 推送自己发的消息
            putBoolean("shell",        intent.getBooleanExtra("shell", false))                  // 开启Shell接口
            putBoolean("enable_sync_msg_as_sent_msg", intent.getBooleanExtra("enable_sync_msg_as_sent_msg", false)) // 推送同步消息

            putBoolean("isInit", true)
        }
        updateConfig()
    }

    private val mmkv: MMKV
        get() = MMKVFetcher.mmkvWithId("shamrock_config")

    fun aliveReply(): Boolean {
        return mmkv.getBoolean("alive_reply", false)
    }

    fun allowTempSession(): Boolean {
        return Config.allowTempSession
    }

    fun getGroupMsgRule(): GroupRule? {
        return Config.rules?.groupRule
    }

    fun getPrivateRule(): PrivateRule? {
        return Config.rules?.privateRule
    }

    fun enableSyncMsgAsSentMsg(): Boolean {
        return mmkv.getBoolean("enable_sync_msg_as_sent_msg", false)
    }

    fun enableSelfMsg(): Boolean {
        return mmkv.getBoolean("enable_self_msg", false)
    }

    fun openWebSocketClient(): Boolean {
        return mmkv.getBoolean("ws_client", false)
    }

    fun getWebSocketClientAddress(): List<ConnectionConfig> {
        return Config.passiveWebSocket ?: emptyList()
    }

    fun openWebSocket(): Boolean {
        return mmkv.getBoolean("ws", false)
    }

    fun getActiveWebSocketConfig(): ConnectionConfig? {
        return Config.activeWebSocket
    }

    fun getToken(): String {
        return Config.defaultToken ?: ""
    }

    fun useCQ(): Boolean {
        return mmkv.getBoolean("use_cqcode", false)
    }

    fun allowWebHook(): Boolean {
        return mmkv.getBoolean("http", false)
    }

    fun getWebHookAddress(): String {
        return mmkv.getString("http_addr", "") ?: ""
    }

    fun forceTablet(): Boolean {
        return mmkv.getBoolean("tablet", true)
    }

    fun getPort(): Int {
        return mmkv.getInt("port", 5700)
    }

    fun isInjectPacket(): Boolean {
        return mmkv.getBoolean("inject_packet", false)
    }

    fun isDebug(): Boolean {
        return mmkv.getBoolean("debug", false)
    }

    fun ssl(): Boolean {
        return getKeyStorePath()?.exists() == true
    }

    fun getKeyStorePath(): File? {
        mmkv.getString("key_store", null)?.let {
            return File(it)
        }
        return null
    }

    fun sslPwd(): CharArray? {
        return mmkv.getString("ssl_pwd", null)?.toCharArray()
    }

    fun sslPrivatePwd(): String? {
        return mmkv.getString("ssl_private_pwd", null)
    }

    fun sslAlias(): String? {
        return mmkv.getString("ssl_alias", null)
    }

    fun getSslPort(): Int {
        return mmkv.getInt("ssl_port", getPort())
    }

    fun isDev(): Boolean {
        return mmkv.getBoolean("dev", false)
    }

    operator fun set(key: String, value: String) {
        mmkv.putString(key, value)
    }

    operator fun set(key: String, value: Boolean) {
        mmkv.putBoolean(key, value)
    }

    operator fun set(key: String, value: Int) {
        mmkv.putInt(key, value)
    }

    operator fun set(key: String, value: Long) {
        mmkv.putLong(key, value)
    }

    operator fun set(key: String, value: Float) {
        mmkv.putFloat(key, value)
    }

    fun isAntiTrace(): Boolean {
        return Config.antiTrace
    }

    fun allowShell(): Boolean {
        return mmkv.getBoolean("shell", false)
    }
}