package moe.fuqiuluo.shamrock.config

data object ForceTablet: ConfigKey<Boolean>() {
    override fun name(): String = "force_tablet"

    override fun default(): Boolean = false
}