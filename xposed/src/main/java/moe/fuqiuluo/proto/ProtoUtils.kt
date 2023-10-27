package moe.fuqiuluo.proto

import com.google.protobuf.ByteString
import com.google.protobuf.CodedOutputStream
import com.google.protobuf.UnknownFieldSet

object ProtoUtils {
    fun decodeFromByteArray(data: ByteArray): ProtoMap {
        val unknownFieldSet = UnknownFieldSet.parseFrom(data)
        val dest = ProtoMap(hashMapOf(), ByteString.copyFrom(data))
        printUnknownFieldSet(unknownFieldSet, dest)
        return dest
    }

    fun encodeToByteArray(protoMap: ProtoMap): ByteArray {
        val size = protoMap.computeSizeDirectly()
        val dest = ByteArray(size)
        val output = CodedOutputStream.newInstance(dest)
        protoMap.value.forEach { (tag, proto) ->
            proto.writeTo(output, tag)
        }
        output.checkNoSpaceLeft()
        return dest
    }

    internal fun computeRawVarint32Size(size: Int): Int {
        if (size and -128 == 0) {
            return 1
        }
        if (size and -16384 == 0) {
            return 2
        }
        if (-2097152 and size == 0) {
            return 3
        }
        return if (size and -268435456 == 0) 4 else 5
    }

    internal fun any2proto(any: Any): ProtoValue {
        return when(any) {
            is Number -> any.proto
            is ByteArray -> any.proto
            is String -> any.proto
            is ByteString -> any.proto
            is Array<*> -> ProtoList(arrayListOf(*any.map { any2proto(it!!) }.toTypedArray()))
            is Collection<*> -> ProtoList(arrayListOf(*any.map { any2proto(it!!) }.toTypedArray()))
            is Map<*, *> -> ProtoMap().also {
                any.forEach { (k, v) ->
                    when (k) {
                        is Number -> it[k.toInt()] = any2proto(v!!)
                        is Pair<*, *> -> {
                            val tags = walkPairTags(k)
                            it.set(*tags.toIntArray(), v = any2proto(v!!))
                        }
                        else -> error("Not support type for tag: ${k.toString()}")
                    }
                }
            }
            is Pair<*, *> -> {
                val (tag, v) = any
                val value = any2proto(v!!)
                when (tag) {
                    is Pair<*, *> -> ProtoMap().apply {
                        val tags = walkPairTags(tag)
                        set(*tags.toIntArray(), v = value)
                    }
                    is Number -> ProtoMap(hashMapOf(tag.toInt() to value))
                    else -> error("Not support type for tag: ${tag.toString()}")
                }
            }
            else -> error("Not support type: ${any::class.simpleName}")
        }
    }

    fun walkPairTags(pair: Pair<*, *>, tags: MutableList<Int> = mutableListOf()): List<Int> {
        val (k, v) = pair
        if (k is Number) {
            tags.add(k.toInt())
        } else {
            walkPairTags(k as Pair<*, *>, tags)
        }
        tags.add(v as Int)
        return tags
    }

    private fun printUnknownFieldSet(set: UnknownFieldSet, dest: ProtoMap) {
        set.asMap().forEach { (tag, field) ->
            field.varintList.forEach {
                dest[tag] = it
            }
            field.fixed32List.forEach {
                dest[tag] = it
            }
            field.fixed64List.forEach {
                dest[tag] = it
            }
            field.lengthDelimitedList.forEach {
                try {
                    val unknownFieldSet = UnknownFieldSet.parseFrom(it)
                    val map = ProtoMap(hashMapOf(), it)
                    printUnknownFieldSet(unknownFieldSet, map)
                    dest[tag] = map
                } catch (e: Throwable) {
                    dest[tag] = it.proto
                }
            }
            field.groupList.forEach {
                val map = ProtoMap()
                printUnknownFieldSet(it, map)
                dest[tag] = map
            }
        }
    }
}

