package moe.fuqiuluo.proto

import com.google.protobuf.ByteString
import com.google.protobuf.CodedOutputStream
import com.google.protobuf.WireFormat
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.tools.jsonObject

class ProtoMap(
    val value: HashMap<Int, ProtoValue>,
    val bytes: ByteString?
): ProtoValue {
    constructor(): this(hashMapOf(), null)
    constructor(value: HashMap<Int, ProtoValue>): this(value, null)

    override fun has(vararg tags: Int): Boolean {
        var curMap: ProtoMap = this
        tags.forEachIndexed { index, tag ->
            if (tag !in curMap) {
                return false
            }
            if (index == tags.size - 1) {
                return true
            }
            curMap = curMap[tag].asMap
        }
        return true
    }

    override fun contains(tag: Int): Boolean {
        return value.containsKey(tag)
    }

    override fun set(tag: Int, v: ProtoValue) {
        if (!contains(tag)) {
            value[tag] = v
        } else {
            val oldValue = value[tag]!!
            if (oldValue is ProtoList) {
                oldValue.add(v)
            } else {
                value[tag] = ProtoList(arrayListOf(oldValue, v))
            }
        }
    }

    override fun set(tag: Int, v: Number) {
        if (!contains(tag)) {
            value[tag] = ProtoNumber(v)
        } else {
            val oldValue = value[tag]!!
            if (oldValue is ProtoList) {
                oldValue.add(v.proto)
            } else {
                value[tag] = ProtoList(arrayListOf(oldValue, v.proto))
            }
        }
    }

    override fun get(vararg tags: Int): ProtoValue {
        var curMap = value
        tags.forEachIndexed { index, tag ->
            if (index == tags.size - 1) {
                return curMap[tag] ?: error("Tag $tag not found")
            }
            curMap[tag]?.let { v ->
                if (v is ProtoMap) {
                    curMap = v.value
                } else {
                    return v
                }
            } ?: error("Tag $tag not found")
        }
        error("Instance is not ProtoMap for get(${tags.first()})")
    }

    override fun size(): Int {
        return value.size
    }

    operator fun set(vararg tags: Int, v: ProtoValue) {
        var curProtoMap: ProtoMap = this
        tags.forEachIndexed { index, tag ->
            if (index == tags.size - 1) {
                return@forEachIndexed
            }
            if (!curProtoMap.contains(tag)) {
                val tmp = ProtoMap()
                curProtoMap[tag] = tmp
                curProtoMap = tmp
            } else {
                curProtoMap = curProtoMap[tag].asMap
            }
        }
        curProtoMap[tags.last()] = v
    }

    operator fun set(vararg tags: Int, struct: (ProtoMap) -> Unit) {
        val map = ProtoMap()
        struct.invoke(map)
        set(*tags, v = map)
    }

    operator fun set(vararg tags: Int, v: String) {
        set(*tags, v = v.proto)
    }

    operator fun set(vararg tags: Int, v: ByteArray) {
        set(*tags, v = v.proto)
    }

    operator fun set(vararg tags: Int, v: Number) {
        set(*tags, v = v.proto)
    }

    operator fun set(vararg tags: Int, v: ByteString) {
        set(*tags, v = v.proto)
    }

    operator fun set(vararg tags: Int, v: Any) {
        set(*tags, v = ProtoUtils.any2proto(v))
    }

    override fun toJson(): JsonElement {
        val hashMap = hashMapOf<String, JsonElement>()
        value.forEach { (tag, field) ->
            hashMap[tag.toString()] = field.toJson()
        }
        return hashMap.jsonObject
    }

    override fun computeSize(tag: Int): Int {
        var size = CodedOutputStream.computeTagSize(tag)
        val dataSize = computeSizeDirectly()
        size += ProtoUtils.computeRawVarint32Size(dataSize)
        size += dataSize
        return size
    }

    override fun writeTo(output: CodedOutputStream, tag: Int) {
        output.writeTag(tag, WireFormat.WIRETYPE_LENGTH_DELIMITED)
        val dataSize = computeSizeDirectly()
        output.writeUInt32NoTag(dataSize)
        value.forEach { (tag, proto) ->
            proto.writeTo(output, tag)
        }
    }

    override fun computeSizeDirectly(): Int {
        var size = 0
        value.forEach { (tag, proto) ->
            size += proto.computeSize(tag)
        }
        return size
    }

    override fun toString(): String {
        return toJson().toString()
    }

    fun toByteArray(): ByteArray {
        return ProtoUtils.encodeToByteArray(this)
    }
}