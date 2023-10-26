package moe.fuqiuluo.shamrock.remote

import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.engine.ApplicationEngine
import io.ktor.server.engine.ApplicationEngineEnvironmentBuilder
import io.ktor.server.engine.applicationEngineEnvironment
import io.ktor.server.engine.connector
import io.ktor.server.engine.embeddedServer
import io.ktor.server.engine.sslConnector
import io.ktor.server.netty.Netty
import io.ktor.server.routing.routing
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import moe.fuqiuluo.shamrock.remote.api.*
import moe.fuqiuluo.shamrock.remote.config.*
import moe.fuqiuluo.shamrock.remote.plugin.Auth
import moe.fuqiuluo.shamrock.remote.service.config.ShamrockConfig
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.xposed.helper.internal.DataRequester
import moe.fuqiuluo.shamrock.xposed.loader.NativeLoader
import org.slf4j.LoggerFactory
import java.security.KeyStore


internal object HTTPServer {
    @JvmStatic
    var isServiceStarted = false
    internal var startTime = 0L

    private val actionMutex = Mutex()
    private lateinit var server: ApplicationEngine
    internal var currServerPort: Int = 0

    private fun Application.configModule() {
        install(Auth).let {
            val token = ShamrockConfig.getToken()
            if (token.isBlank()) {
                LogCenter.log("未配置Token，将不进行鉴权。", Level.WARN)
            } else {
                LogCenter.log("配置Token: $token", Level.INFO)
            }
        }
        contentNegotiation()
        statusPages()
        routing {
            echoVersion()
            obtainFrameworkInfo()
            registerBDH()
            userAction()
            messageAction()
            troopAction()
            friendAction()
            ticketActions()
            fetchRes()
            showLog()
            profileRouter()
            weatherAction()
            otherAction()
            guildAction()
            if (ShamrockConfig.isDev()) {
                qsign()
                obtainProtocolData()
            }
        }
    }

    private fun ApplicationEngineEnvironmentBuilder.configSSL() {
        try {
            val keyStoreFile = ShamrockConfig.getKeyStorePath()
            val pwd = ShamrockConfig.sslPwd().also {
                if (it == null || it.isEmpty()) {
                    LogCenter.log("SSL 密码未填写。", Level.ERROR)
                    return
                }
            }
            val privatePwd = ShamrockConfig.sslPrivatePwd().also {
                if (it.isNullOrEmpty()) {
                    LogCenter.log("SSL Private密码未填写。", Level.ERROR)
                    return
                }
            }
            val keyAlias = ShamrockConfig.sslAlias().also {
                if (it.isNullOrEmpty()) {
                    LogCenter.log("SSL Alias未填写。", Level.ERROR)
                    return
                }
            }

            val keyStore = KeyStore.getInstance("BKS")
            keyStore.load(null, pwd)

            keyStoreFile?.inputStream().use {
                keyStore.load(it, pwd)
            }

            sslConnector(
                keyStore = keyStore,
                keyAlias = keyAlias!!,
                keyStorePassword = { pwd!! },
                privateKeyPassword = { privatePwd!!.toCharArray() }) {
                this.port = ShamrockConfig.getSslPort()
                this.keyStorePath = keyStoreFile
                LogCenter.log("SSL 配置成功，端口: ${this.port}", Level.INFO)
            }
        } catch (e: Exception) {
            LogCenter.log("SSL 配置错误: ${e.stackTraceToString()}", Level.ERROR)
        }
    }

    suspend fun start(port: Int) {
        if (isServiceStarted) return
        actionMutex.withLock {
            val environment = applicationEngineEnvironment {
                log = LoggerFactory.getLogger("ktor.application")
                connector {
                    this.port = port
                }
                if (ShamrockConfig.ssl())
                    configSSL()
                module { configModule() }
            }
            server = embeddedServer(Netty, environment)
            server.start(wait = false)
        }
        startTime = System.currentTimeMillis()
        isServiceStarted = true
        currServerPort = port
        LogCenter.log("Start HTTP Server: http://0.0.0.0:$currServerPort/")
        DataRequester.request("success", values = mapOf(
            "port" to currServerPort,
            "voice" to NativeLoader.isVoiceLoaded
        ))
    }

    fun isActive(): Boolean {
        return server.application.isActive
    }

    fun changePort(port: Int) {
        if (currServerPort == port && isServiceStarted) return
        GlobalScope.launch {
            stop()
            start(port)
        }
    }

    suspend fun stop() {
        actionMutex.withLock {
            server.stop()
            isServiceStarted = false
        }
    }
    
    fun restart() {
        if(!isServiceStarted) return
        val post = currServerPort
        GlobalScope.launch {
            stop()
            start(post)
        }
    }
}