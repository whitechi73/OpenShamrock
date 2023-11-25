package moe.fuqiuluo.proto

import com.google.protobuf.ByteString
import moe.fuqiuluo.proto.ProtoUtils.walkPairTags

fun <K, V> protobufOf(vararg pairs: Pair<K, V>): ProtoMap {
    val map = ProtoMap()
    pairs.forEach {
        val (k, v) = it
        when (k) {
            is Number -> map[k.toInt()] = ProtoUtils.any2proto(v!!)
            is Pair<*, *> -> {
                val tags = walkPairTags(k)
                map.set(*tags.toIntArray(), v = ProtoUtils.any2proto(v!!))
            }
            else -> error("Not support type for tag: ${k.toString()}")
        }
    }
    return map
}

fun protobufMapOf(struct: (ProtoMap) -> Unit): ProtoMap {
    val map = ProtoMap()
    struct.invoke(map)
    return map
}

val Number.proto: ProtoNumber
    get() = ProtoNumber(this)

val ByteString.proto: ProtoByteString
    get() = ProtoByteString(this)

val ByteArray.proto: ProtoByteString
    get() = ProtoByteString(ByteString.copyFrom(this))

val String.proto: ProtoByteString
    get() = ProtoByteString(ByteString.copyFromUtf8(this))

val ProtoValue.asString: ByteString
    get() = (this as ProtoByteString).value

val ProtoValue.asNumber: Number
    get() = (this as ProtoNumber).value

val ProtoValue.asInt: Int
    get() = (this as ProtoNumber).value.toInt()

val ProtoValue.asLong: Long
    get() = (this as ProtoNumber).value.toLong()

val ProtoValue.asULong: Long
    get() = (this as ProtoNumber).value.toLong() and Long.MAX_VALUE

val ProtoValue.asMap: ProtoMap
    get() = (this as ProtoMap)

val ProtoValue.asList: ProtoList
    get() = (this as ProtoList)

val ProtoValue.asByteArray: ByteArray
    get() = if (this is ProtoMap) {
        bytes?.toByteArray() ?: toByteArray()
    } else {
        (this as ProtoByteString).toByteArray()
    }

val ProtoValue.asUtf8String: String
    get() = asByteArray.decodeToString()
