package moe.fuqiuluo.shamrock.xposed.loader.tmpnativehelper

import de.robv.android.xposed.XposedBridge
import kotlinx.serialization.decodeFromString
import moe.fuqiuluo.shamrock.remote.service.config.ConnectionConfig
import moe.fuqiuluo.shamrock.remote.service.config.ServiceConfig
import moe.fuqiuluo.shamrock.remote.service.config.ShamrockConfig
import moe.fuqiuluo.shamrock.tools.GlobalJson5
import moe.fuqiuluo.shamrock.utils.MMKVFetcher
import mqq.app.MobileQQ
import kotlin.concurrent.thread
import kotlin.system.exitProcess

class PutDefaultConfig {
    companion object {
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
            XposedBridge.log("[Shamrock] 配置文件有误: ${it.stackTraceToString()}")
        }.getOrElse {
            ServiceConfig()
        }

        fun putSettings() {
            val mmkv = MMKVFetcher.mmkvWithId("shamrock_config")
            if ((!ShamrockConfig.isInit()) && (!mmkv.getBoolean("isEmergencyInitBefore", false))){
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
    }
}