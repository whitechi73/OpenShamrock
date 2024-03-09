package moe.fuqiuluo.shamrock.config

object IsInit: ConfigKey<Boolean>() {
    override fun name(): String = "is_init"

    override fun default(): Boolean = false
}