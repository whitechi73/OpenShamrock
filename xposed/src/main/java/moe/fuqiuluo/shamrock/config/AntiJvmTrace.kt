package moe.fuqiuluo.shamrock.config

object AntiJvmTrace: ConfigKey<Boolean>() {
    override fun default() = false

    override fun name() = "anti_jvm_trace"
}