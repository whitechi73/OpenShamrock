package moe.fuqiuluo.proto

import com.google.protobuf.ByteString
import com.google.protobuf.CodedOutputStream
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.tools.json
import moe.fuqiuluo.shamrock.tools.toHexString

class ProtoByteString(
    val value: ByteString
): ProtoValue, Iterable<Byte> by value {
    override fun toJson(): JsonElement {
        return toByteArray().toHexString().json
    }

    override fun computeSize(tag: Int): Int {
        return CodedOutputStream.computeBytesSize(tag, value)
    }

    override fun writeTo(output: CodedOutputStream, tag: Int) {
        output.writeBytes(tag, value)
    }

    fun toByteArray(): ByteArray {
        return value.toByteArray()
    }

    override fun equals(other: Any?): Boolean {
        return this === other
    }

    override fun hashCode(): Int {
        return System.identityHashCode(this)
    }

    fun toUtfString(): String {
        return value.toStringUtf8()
    }

    override fun toString(): String {
        return "ByteString(${value.toByteArray().toHexString()})"
    }
}