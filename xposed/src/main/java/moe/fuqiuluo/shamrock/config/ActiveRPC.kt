package moe.fuqiuluo.shamrock.config

data object ActiveRPC: ConfigKey<Boolean>() {
    override fun name(): String = "active_rpc"

    override fun default(): Boolean = false
}