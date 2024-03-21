package moe.fuqiuluo.symbols

import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.protobuf.ProtoBuf

import kotlin.reflect.KClass

val EMPTY_BYTE_ARRAY = ByteArray(0)

interface Protobuf<T: Protobuf<T>>

inline fun <reified T: Protobuf<T>> ByteArray.decodeProtobuf(to: KClass<T>? = null): T {
    return ProtoBuf.decodeFromByteArray(this)
}
