package moe.fuqiuluo.shamrock.config

object EnableOldBDH: ConfigKey<Boolean>() {
    override fun name() = "enable_old_bdh"
    override fun default() = false
}