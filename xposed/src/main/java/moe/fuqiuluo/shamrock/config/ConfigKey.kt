package moe.fuqiuluo.shamrock.config

abstract class ConfigKey<T> {
    abstract fun name(): String

    abstract fun default(): T

    companion object {

    }
}

