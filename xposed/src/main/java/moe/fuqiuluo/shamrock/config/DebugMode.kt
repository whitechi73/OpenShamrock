package moe.fuqiuluo.shamrock.config

object DebugMode: ConfigKey<Boolean>() {
    override fun name(): String = "debug"

    override fun default(): Boolean = false
}