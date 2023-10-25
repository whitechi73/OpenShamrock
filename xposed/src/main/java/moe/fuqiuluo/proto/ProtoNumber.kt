package moe.fuqiuluo.proto

import com.google.protobuf.CodedOutputStream
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.tools.json

class ProtoNumber(
    val value: Number
): ProtoValue {
    override fun toJson(): JsonElement {
        return value.json
    }

    override fun computeSize(tag: Int): Int {
        return when (value) {
            is Int -> CodedOutputStream.computeInt32Size(tag, value)
            is Long -> CodedOutputStream.computeInt64Size(tag, value)
            is Float -> CodedOutputStream.computeFloatSize(tag, value)
            is Double -> CodedOutputStream.computeDoubleSize(tag, value)
            else -> error("ProcCodec not support number type: ${value::class.simpleName}")
        }
    }

    override fun writeTo(output: CodedOutputStream, tag: Int) {
        when (value) {
            is Int -> output.writeInt32(tag, value)
            is Long -> output.writeInt64(tag, value)
            is Float -> output.writeFloat(tag, value)
            is Double -> output.writeDouble(tag, value)
            else -> error("ProcCodec not support number type: ${value::class.simpleName}")
        }
    }

    override fun equals(other: Any?): Boolean {
        return this === other
    }

    override fun hashCode(): Int {
        return System.identityHashCode(this)
    }

    override fun toString(): String {
        return "Number($value)"
    }
}