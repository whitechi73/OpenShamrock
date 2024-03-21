package moe.fuqiuluo.shamrock.config

data object PassiveRPC: ConfigKey<Boolean>() {
    override fun name(): String = "passive_rpc"

    override fun default(): Boolean = false
}