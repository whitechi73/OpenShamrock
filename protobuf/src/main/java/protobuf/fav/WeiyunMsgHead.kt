@file:OptIn(ExperimentalSerializationApi::class)
@file:Suppress("ArrayInDataClass")

package protobuf.fav

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import moe.fuqiuluo.symbols.Protobuf

@Serializable
data class WeiyunMsgHead(
    @ProtoNumber(1) val uin: ULong = ULong.MIN_VALUE,
    @ProtoNumber(2) val seq: UInt = UInt.MIN_VALUE,
    @ProtoNumber(3) val type: UInt = UInt.MIN_VALUE,
    @ProtoNumber(4) val cmd: UInt = UInt.MIN_VALUE,
    @ProtoNumber(5) val appId: UInt = UInt.MIN_VALUE,
    @ProtoNumber(6) val version: UInt = UInt.MIN_VALUE,
    @ProtoNumber(7) val netType: UInt = UInt.MIN_VALUE,
    @ProtoNumber(8) val clientIp: String? = null,
    @ProtoNumber(9) val encrypt: UInt = UInt.MIN_VALUE,
    @ProtoNumber(10) val keyType: UInt = UInt.MIN_VALUE,
    @ProtoNumber(11) val key: ByteArray? = null,
    @ProtoNumber(14) val majorVersion: UInt = UInt.MIN_VALUE,
    @ProtoNumber(15) val minorVersion: UInt = UInt.MIN_VALUE,
    @ProtoNumber(101) val retCode: UInt = UInt.MIN_VALUE,
    @ProtoNumber(102) val retMsg: String? = null,
    @ProtoNumber(103) val promptMsg: String? = null,
    @ProtoNumber(111) val totalSpace: ULong = ULong.MIN_VALUE,
    @ProtoNumber(112) val usedSpace: ULong = ULong.MIN_VALUE,
): Protobuf<WeiyunMsgHead>

