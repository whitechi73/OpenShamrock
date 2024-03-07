package moe.fuqiuluo.shamrock.config

object EnableSelfMessage: ConfigKey<Boolean>() {
    override fun name() = "enable_self_message"
    override fun default() = false
}