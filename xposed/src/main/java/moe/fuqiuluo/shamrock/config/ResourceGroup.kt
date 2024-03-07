package moe.fuqiuluo.shamrock.config

data object ResourceGroup: ConfigKey<String>() {
    override fun name(): String = "resource_group"

    override fun default(): String = "883536416"
}