package moe.fuqiuluo.shamrock.config

import android.content.Intent
import mqq.app.MobileQQ
import java.util.Properties

private val configDir = MobileQQ.getContext().getExternalFilesDir(null)!!
    .parentFile!!.resolve("Tencent/Shamrock").also {
        if (!it.exists()) it.mkdirs()
    }
private val configFile = configDir.resolve("config.prop")

private val configKeys = setOf(
    ActiveRPC,
    ForceTablet,
    PassiveRPC,
    ResourceGroup,
    RPCAddress,
    RPCPort,

)

internal object ShamrockConfig: Properties() {
    init {
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
                val value = intent.getStringExtra(key.name())
                if (value != null) setProperty(key.name(), value)
            }
            setProperty(IsInit.name(), "true")
        }
        configFile.outputStream().use {
            store(it, "Shamrock Config ${System.currentTimeMillis()}")
        }
    }

    private fun readResolve(): Any = ShamrockConfig
}