package moe.fuqiuluo.shamrock.remote.service.config

import android.content.Intent
import com.tencent.mmkv.MMKV
import de.robv.android.xposed.XposedBridge
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.tools.GlobalJson5
import moe.fuqiuluo.shamrock.tools.toast
import moe.fuqiuluo.shamrock.utils.MMKVFetcher
import mqq.app.MobileQQ
import java.io.File

internal abstract class ShamrockConfigV0 {
    private val configDir = MobileQQ.getContext().getExternalFilesDir(null)!!
        .parentFile!!.resolve("Tencent/Shamrock").also {
            if (it.exists()) it.delete()
            it.mkdirs()
        }
    private val config = kotlin.runCatching {
        GlobalJson5.decodeFromString<ServiceConfig>(configDir.resolve("config.json").also {
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

    private fun updateConfig(config: ServiceConfig = this.config) {
        configDir.resolve("config.json").writeText(GlobalJson5.encodeToString(config))
    }

    fun updateConfig(intent: Intent) {
        MobileQQ.getContext().toast("同步配置数据解析中...")
        mmkv.apply {
            if (!intent.getBooleanExtra("disable_auto_sync_setting", false)) {
                putBoolean("tablet", intent.getBooleanExtra("tablet", false))                 // 强制平板模式
                putInt("port", intent.getIntExtra("port", 5700))                        // 主动HTTP端口
                putBoolean("ws", intent.getBooleanExtra("ws", false))                     // 主动WS开关
                putBoolean("http", intent.getBooleanExtra("http", false))                   // HTTP回调开关
                putString("http_addr", intent.getStringExtra("http_addr"))                                // WebHook回调地址
                putBoolean("ws_client", intent.getBooleanExtra("ws_client", false))              // 被动WS开关
                putBoolean("use_cqcode", intent.getBooleanExtra("use_cqcode", false))             // 使用CQ码
                putBoolean("inject_packet", intent.getBooleanExtra("inject_packet", false))    // 拦截无用包
                putBoolean("debug", intent.getBooleanExtra("debug", false))                  // 调试模式
                putString(  "key_store",   intent.getStringExtra("key_store"))                                // 证书路径
                putString(  "ssl_pwd",     intent.getStringExtra("ssl_pwd"))                                  // 证书密码
                putString(  "ssl_private_pwd",   intent.getStringExtra("ssl_private_pwd"))                    // 证书私钥密码
                putString(  "ssl_alias",   intent.getStringExtra("ssl_alias"))                                // 证书别名
                putInt(     "ssl_port",    intent.getIntExtra("ssl_port", 5701))                    // 主动HTTP端口
                putBoolean("alive_reply",   intent.getBooleanExtra("alive_reply", false))             // 自回复测试
                putBoolean("enable_self_msg",    intent.getBooleanExtra("enable_self_msg", false))  // 推送自己发的消息
                putBoolean("shell",        intent.getBooleanExtra("shell", false))                  // 开启Shell接口
                putBoolean("enable_sync_msg_as_sent_msg", intent.getBooleanExtra("enable_sync_msg_as_sent_msg", false)) // 推送同步消息
                putBoolean("forbid_useless_process", intent.getBooleanExtra("forbid_useless_process", false)) // 禁用QQ生成无用进程
                putBoolean("enable_old_bdh", intent.getBooleanExtra("enable_old_bdh", false)) // 启用旧版BDH
                intent.getStringExtra("up_res_group")?.let { putString("up_res_group", it) }
            } else {
                XposedBridge.log("[Shamrock] 已禁用自动同步配置")
            }
            config.defaultToken = intent.getStringExtra("token")
            config.antiTrace = intent.getBooleanExtra("anti_qq_trace", true)
            val wsPort = intent.getIntExtra("ws_port", 5800)
            config.activeWebSocket = if (config.activeWebSocket == null) ConnectionConfig(
                address = "0.0.0.0",
                port = wsPort,
            ) else config.activeWebSocket?.also {
                it.port = wsPort
            }
            config.passiveWebSocket = intent.getStringExtra("ws_addr")?.split(",", "|", "，")?.filter { address ->
                address.isNotBlank() && (address.startsWith("ws://") || address.startsWith("wss://"))
            }?.map {
                ConnectionConfig(address = it)
            }?.toMutableList()
            putBoolean("isInit", true)
        }
        if (!intent.getBooleanExtra("disable_auto_sync_setting", false)) {
            updateConfig()
        }
    }

    fun putDefaultSettings() {
        val mmkv = MMKVFetcher.mmkvWithId("shamrock_config")
        if ((!isInit()) && (!mmkv.getBoolean("isEmergencyInitBefore", false))){
            mmkv.apply {
                putBoolean("tablet", false)    // 强制平板模式
                putInt("port", 5700)            // 主动HTTP端口
                putBoolean("ws", false)        // 主动WS开关
                putBoolean("http", false)      // HTTP回调开关
                putString("http_addr", null)  // WebHook回调地址
                putBoolean("ws_client", false) // 被动WS开关
                putBoolean("use_cqcode", false) // 使用CQ码
                putBoolean("inject_packet", false)    // 拦截无用包
                putBoolean("debug", false)      // 调试模式
                putString("key_store", null) // 证书路径
                putString("ssl_pwd", null) // 证书密码
                putString("ssl_private_pwd", null) // 证书私钥密码
                putString("ssl_alias", null) // 证书别名
                putInt("ssl_port", 5701) // 主动HTTP端口
                putBoolean("alive_reply", true) // 自回复测试
                putBoolean("enable_self_msg", false) // 推送自己发的消息
                putBoolean("shell", false) // 开启Shell接口
                putBoolean("enable_sync_msg_as_sent_msg", true) // 推送同步消息
                putBoolean("forbid_useless_process", false) // 禁用QQ生成无用进程
                putBoolean("enable_old_bdh", false) // 启用旧版BDH
                putBoolean("antiTrace", false)
                putBoolean("super_anti", true)
                putString("up_res_group", "")

                config.defaultToken = null
                // config.antiTrace = true
                val wsPort = 5800
                config.activeWebSocket =
                    if (config.activeWebSocket == null) ConnectionConfig(
                        address = "0.0.0.0",
                        port = wsPort,
                    ) else config.activeWebSocket?.also {
                        it.port = wsPort
                    }
                config.passiveWebSocket = null
                putBoolean("isInit", true)
                putBoolean("isEmergencyInitBefore", true)
            }
            XposedBridge.log("[Shamrock] 强制初始化配置完成,请重新打开QQ")
        } else {
            XposedBridge.log("[Shamrock] 程序逻辑错误或错误地多次强制初始化")
            mmkv.putBoolean("isEmergencyInitBefore", false)
            XposedBridge.log("[Shamrock] 如果执意要再次强制初始化,请重新执行程序")
        }
    }

    protected val mmkv: MMKV
        get() = MMKVFetcher.mmkvWithId("shamrock_config")

    fun getUpResGroup(): String {
        return mmkv.getString("up_res_group", "") ?: ""
    }

    fun aliveReply(): Boolean {
        return mmkv.getBoolean("alive_reply", false)
    }

    fun allowTempSession(): Boolean {
        return config.allowTempSession
    }

    fun getGroupMsgRule(): GroupRule? {
        return config.rules?.groupRule
    }

    fun getPrivateRule(): PrivateRule? {
        return config.rules?.privateRule
    }

    fun enableSyncMsgAsSentMsg(): Boolean {
        return mmkv.getBoolean("enable_sync_msg_as_sent_msg", false)
    }

    fun enableSelfMsg(): Boolean {
        return mmkv.getBoolean("enable_self_msg", false)
    }

    fun forbidUselessProcess(): Boolean {
        return mmkv.getBoolean("forbid_useless_process", false)
    }

    fun openWebSocketClient(): Boolean {
        return mmkv.getBoolean("ws_client", false)
    }

    fun getWebSocketClientAddress(): List<ConnectionConfig> {
        return config.passiveWebSocket ?: emptyList()
    }

    fun openWebSocket(): Boolean {
        return mmkv.getBoolean("ws", false)
    }

    fun getActiveWebSocketConfig(): ConnectionConfig? {
        return config.activeWebSocket
    }

    fun getToken(): String {
        return config.defaultToken ?: ""
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

    fun enableOldBDH(): Boolean {
        return mmkv.getBoolean("enable_old_bdh", false)
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
        return config.antiTrace
    }

    fun allowShell(): Boolean {
        return mmkv.getBoolean("shell", false)
    }
}