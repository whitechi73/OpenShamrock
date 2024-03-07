package moe.fuqiuluo.shamrock.config

object B2Mode: ConfigKey<Boolean>() {
    override fun name() = "b2_mode"
    override fun default() = false
}