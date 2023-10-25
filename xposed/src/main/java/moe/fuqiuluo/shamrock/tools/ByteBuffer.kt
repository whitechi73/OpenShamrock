package moe.fuqiuluo.shamrock.tools

import kotlinx.io.core.ByteReadPacket
import java.nio.ByteBuffer

fun ByteBuffer.putBuf32Long(value: Long) {
    val bArr = byteArrayOf(
        (value shr 24 and 255L).toByte(),
        (value shr 16 and 255L).toByte(),
        (value shr 8 and 255L).toByte(),
        (value and 255L).toByte()
    )
    put(bArr)
}


fun ByteReadPacket.readBuf32Long(): Long {
    return readInt().toLong() and 0xFFFFFFFFL
}