package moe.fuqiuluo.shamrock.config

data object RPCAddress: ConfigKey<String>() {
    override fun name(): String = "rpc_address"

    override fun default(): String = ""
}
