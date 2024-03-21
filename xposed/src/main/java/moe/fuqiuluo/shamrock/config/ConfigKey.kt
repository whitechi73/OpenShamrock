package moe.fuqiuluo.shamrock.config

abstract class ConfigKey<T> {
    abstract fun name(): String

    abstract fun default(): T

    companion object {

    }
}

internal inline fun <reified Type, reified T: ConfigKey<Type>> T.get(): Type {
    return ShamrockConfig[this]
}
