package moe.fuqiuluo.shamrock.config

data object RPCPort: ConfigKey<Int>() {
    override fun name(): String = "rpc_port"

    override fun default(): Int = 5700
}

