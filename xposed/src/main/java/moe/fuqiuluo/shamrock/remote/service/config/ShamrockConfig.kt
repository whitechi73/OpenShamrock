package moe.fuqiuluo.shamrock.remote.service.config

import android.content.Intent
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
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
    private val Config: ServiceConfig by lazy {
        GlobalJson5.decodeFromString(ConfigDir.resolve("config.json").also {
            if (!it.exists()) it.writeText("{}")
        }.readText())
    }

    fun isInit(): Boolean {
        val mmkv = MMKVFetcher.mmkvWithId("shamrock_config")
        return mmkv.getBoolean("isInit", false)
    }

    fun updateConfig(config: ServiceConfig = Config) {
        ConfigDir.resolve("config.json").writeText(GlobalJson5.encodeToString(config))
    }

    fun updateConfig(intent: Intent) {
        val mmkv = MMKVFetcher.mmkvWithId("shamrock_config")
        mmkv.apply {
            putBoolean(  "tablet",     intent.getBooleanExtra("tablet", false))                 // 强制平板模式
            putInt(      "port",       intent.getIntExtra("port", 5700))                         // 主动HTTP端口
            putBoolean(  "ws",         intent.getBooleanExtra("ws", false))                     // 主动WS开关
            putBoolean(  "http",       intent.getBooleanExtra("http", false))                   // HTTP回调开关
            putString(   "http_addr",  intent.getStringExtra("http_addr"))                                  // WebHook回调地址
            putBoolean(  "ws_client",  intent.getBooleanExtra("ws_client", false))              // 被动WS开关
            putBoolean(  "use_cqcode", intent.getBooleanExtra("use_cqcode", false))             // 使用CQ码
            putBoolean(  "inject_packet",    intent.getBooleanExtra("inject_packet", false))    // 拦截无用包
            putBoolean(  "debug",    intent.getBooleanExtra("debug", false))    // 调试模式

            Config.defaultToken = intent.getStringExtra("token")

            val wsPort = intent.getIntExtra("ws_port", 5800)
            Config.activeWebSocket = if (Config.activeWebSocket == null) ConnectionConfig(
                address = "0.0.0.0",
                port = wsPort,
            ) else Config.activeWebSocket?.also {
                it.port = wsPort
            }

            Config.passiveWebSocket = intent.getStringExtra("ws_addr")?.split(",", "|", "，")?.filter { address ->
                Config.passiveWebSocket?.any {
                    it.address == address
                } != true
            }?.map {
                ConnectionConfig(address = it)
            }?.toMutableList()

            putString(   "key_store",      intent.getStringExtra("key_store"))  // 证书路径
            putString(   "ssl_pwd",      intent.getStringExtra("ssl_pwd"))  // 证书密码
            putString(   "ssl_private_pwd",      intent.getStringExtra("ssl_private_pwd"))  // 证书私钥密码
            putString(   "ssl_alias",      intent.getStringExtra("ssl_alias"))  // 证书别名
            putInt(      "ssl_port",    intent.getIntExtra("ssl_port", 5701))                         // 主动HTTP端口

            putBoolean("auto_clear", intent.getBooleanExtra("auto_clear", false)) // 自动清理

            putBoolean("enable_self_msg", intent.getBooleanExtra("enable_self_msg", false)) // 推送自己发的消息

            putBoolean("isInit", true)
        }
        updateConfig()
    }

    fun getGroupMsgRule(): GroupRule? {
        return Config.rules?.groupRule
    }

    fun getPrivateRule(): PrivateRule? {
        return Config.rules?.privateRule
    }

    fun enableSelfMsg(): Boolean {
        val mmkv = MMKVFetcher.mmkvWithId("shamrock_config")
        return mmkv.getBoolean("enable_self_msg", false)
    }

    fun openWebSocketClient(): Boolean {
        val mmkv = MMKVFetcher.mmkvWithId("shamrock_config")
        return mmkv.getBoolean("ws_client", false)
    }

    fun getWebSocketClientAddress(): List<ConnectionConfig> {
        return Config.passiveWebSocket ?: emptyList()
    }

    fun openWebSocket(): Boolean {
        val mmkv = MMKVFetcher.mmkvWithId("shamrock_config")
        return mmkv.getBoolean("ws", false)
    }

    fun getActiveWebSocketConfig(): ConnectionConfig? {
        return Config.activeWebSocket
    }

    fun getToken(): String {
        return Config.defaultToken ?: ""
    }

    fun useCQ(): Boolean {
        val mmkv = MMKVFetcher.mmkvWithId("shamrock_config")
        return mmkv.getBoolean("use_cqcode", false)
    }

    fun allowWebHook(): Boolean {
        val mmkv = MMKVFetcher.mmkvWithId("shamrock_config")
        return mmkv.getBoolean("http", false)
    }

    fun getWebHookAddress(): String {
        val mmkv = MMKVFetcher.mmkvWithId("shamrock_config")
        return mmkv.getString("http_addr", "") ?: ""
    }

    fun forceTablet(): Boolean {
        val mmkv = MMKVFetcher.mmkvWithId("shamrock_config")
        return mmkv.getBoolean("tablet", true)
    }

    fun getPort(): Int {
        val mmkv = MMKVFetcher.mmkvWithId("shamrock_config")
        return mmkv.getInt("port", 5700)
    }

    fun isInjectPacket(): Boolean {
        val mmkv = MMKVFetcher.mmkvWithId("shamrock_config")
        return mmkv.getBoolean("inject_packet", false)
    }

    fun isDebug(): Boolean {
        val mmkv = MMKVFetcher.mmkvWithId("shamrock_config")
        return mmkv.getBoolean("debug", false)
    }

    fun ssl(): Boolean {
        return getKeyStorePath()?.exists() == true
    }

    fun getKeyStorePath(): File? {
        val mmkv = MMKVFetcher.mmkvWithId("shamrock_config")
        mmkv.getString("key_store", null)?.let {
            return File(it)
        }
        return null
    }

    fun sslPwd(): CharArray? {
        val mmkv = MMKVFetcher.mmkvWithId("shamrock_config")
        return mmkv.getString("ssl_pwd", null)?.toCharArray()
    }

    fun sslPrivatePwd(): String? {
        val mmkv = MMKVFetcher.mmkvWithId("shamrock_config")
        return mmkv.getString("ssl_private_pwd", null)
    }

    fun sslAlias(): String? {
        val mmkv = MMKVFetcher.mmkvWithId("shamrock_config")
        return mmkv.getString("ssl_alias", null)
    }

    fun getSslPort(): Int {
        val mmkv = MMKVFetcher.mmkvWithId("shamrock_config")
        return mmkv.getInt("ssl_port", getPort())
    }

    fun isDev(): Boolean {
        val mmkv = MMKVFetcher.mmkvWithId("shamrock_config")
        return mmkv.getBoolean("dev", false)
    }
}