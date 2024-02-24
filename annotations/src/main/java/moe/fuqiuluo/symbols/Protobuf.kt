package moe.fuqiuluo.symbols

import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.protobuf.ProtoBuf

import kotlin.reflect.KClass

interface Protobuf<T: Protobuf<T>>

inline fun <reified T: Protobuf<T>> ByteArray.decodeProtobuf(to: KClass<T>? = null): T {
    return ProtoBuf.decodeFromByteArray(this)
}
