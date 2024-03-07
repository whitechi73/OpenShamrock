package moe.fuqiuluo.shamrock.config

object AliveReply: ConfigKey<Boolean>() {
    override fun name() = "alive_reply"
    override fun default() = false
}