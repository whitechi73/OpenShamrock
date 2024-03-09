package moe.fuqiuluo.shamrock.config

import android.content.Intent
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.xposed.loader.LuoClassloader.moduleLoader
import mqq.app.MobileQQ
import java.util.Properties

private val configDir = MobileQQ.getContext().getExternalFilesDir(null)!!
    .parentFile!!.resolve("Tencent/Shamrock").also {
        if (!it.exists()) it.mkdirs()
    }
private val configFile = configDir.resolve("config.prop")

private val configKeys = setOf(
    ActiveRPC,
    AntiJvmTrace,
    ForceTablet,
    PassiveRPC,
    ResourceGroup,
    RPCAddress,
    RPCPort,
)

internal object ShamrockConfig: Properties() {
    init {
        if (!configFile.exists()) {
            moduleLoader.getResourceAsStream("assets/config.properties")?.use {
                configDir.resolve("default.prop").outputStream().use { output ->
                    it.copyTo(output)
                }
            }
            moduleLoader.getResourceAsStream("assets/config.properties")?.use {
                configFile.outputStream().use { output ->
                    it.copyTo(output)
                }
            }
        }
        if (configFile.exists()) configFile.inputStream().use {
            load(it)
        }
    }

    internal inline operator fun <reified Type> get(key: ConfigKey<Type>): Type {
        return when(Type::class) {
            Int::class -> getProperty(key.name()).toInt() as Type ?: key.default()
            Long::class -> getProperty(key.name()).toLong() as Type ?: key.default()
            String::class -> getProperty(key.name()) as Type ?: key.default()
            Boolean::class -> getProperty(key.name()).toBoolean() as Type ?: key.default()
            else -> throw IllegalArgumentException("Unsupported type")
        }
    }

    fun updateConfig(intent: Intent? = null) {
        intent?.let {
            for (key in configKeys) {
                when (key.default()) {
                    is String -> {
                        val value = intent.getStringExtra(key.name())
                        if (value != null) setProperty(key.name(), value)
                    }
                    is Boolean -> {
                        val value = intent.getBooleanExtra(key.name(), key.default() as Boolean)
                        setProperty(key.name(), value.toString())
                    }
                    is Int -> {
                        val value = intent.getIntExtra(key.name(), key.default() as Int)
                        setProperty(key.name(), value.toString())
                    }
                    is Long -> {
                        val value = intent.getLongExtra(key.name(), key.default() as Long)
                        setProperty(key.name(), value.toString())
                    }
                }
            }

            if (getProperty(ActiveTicket.name()).isNullOrEmpty()) {
                setProperty(ActiveTicket.name(), "") // 初始化ticket
            }

            setProperty(IsInit.name(), "true")
        }
        configFile.outputStream().use {
            store(it, "Shamrock Config")
        }
    }

    private fun readResolve(): Any = ShamrockConfig
}