@file:OptIn(ExperimentalSerializationApi::class)

package moe.whitechi73.protobuf.oidb.cmx0xf57

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class Oidb0xf57Req(
    @ProtoNumber(1) val filter: Oidb0xf57Filter,
    @ProtoNumber(2) val guildInfo: Oidb0xf57GuildInfo,
)

@Serializable
data class Oidb0xf57Rsp(
    @ProtoNumber(1) val metaInfo: Oidb0xf57MetaInfo,
)

@Serializable
data class Oidb0xf57MetaInfo(
    @ProtoNumber(3) val guildId: ULong = ULong.MIN_VALUE,
    @ProtoNumber(4) val meta: Oidb0xf57Meta? = null,
)

@Serializable
data class Oidb0xf57Meta(
    @ProtoNumber(2) val guildCode: ULong = ULong.MIN_VALUE,
    @ProtoNumber(4) val createTime: Long = Long.MIN_VALUE,
    @ProtoNumber(5) val maxMemberCount: Long = Long.MIN_VALUE,
    @ProtoNumber(6) val memberCount: Long = Long.MIN_VALUE,
    @ProtoNumber(8) val name: String? = null,
    @ProtoNumber(11) val robotMaxNum: Int = Int.MIN_VALUE,
    @ProtoNumber(12) val adminMaxNum: Int = Int.MIN_VALUE,
    @ProtoNumber(13) val profile: String? = null,
    @ProtoNumber(14) val avatarSeq: Long = Long.MIN_VALUE,
    @ProtoNumber(18) val ownerId: ULong = ULong.MIN_VALUE,
    @ProtoNumber(19) val coverSeq: Long = Long.MIN_VALUE,
    @ProtoNumber(20) val clientId: Int = Int.MIN_VALUE,
)

@Serializable
data class Oidb0xf57GuildInfo(
    @ProtoNumber(1) val guildId: ULong = ULong.MIN_VALUE
)

@Serializable
data class Oidb0xf57Filter(
    @ProtoNumber(1) val u1: Oidb0xf57U1,
    @ProtoNumber(2) val u2: Oidb0xf57U2,
)

@Serializable
data class Oidb0xf57U1(
    @ProtoNumber(2) val u1: UInt = UInt.MIN_VALUE,
    @ProtoNumber(4) val u2: UInt = UInt.MIN_VALUE,
    @ProtoNumber(5) val u3: UInt = UInt.MIN_VALUE,
    @ProtoNumber(6) val u4: UInt = UInt.MIN_VALUE,
    @ProtoNumber(7) val u5: UInt = UInt.MIN_VALUE,
    @ProtoNumber(8) val u6: UInt = UInt.MIN_VALUE,
    @ProtoNumber(11) val u7: UInt = UInt.MIN_VALUE,
    @ProtoNumber(12) val u8: UInt = UInt.MIN_VALUE,
    @ProtoNumber(13) val u9: UInt = UInt.MIN_VALUE,
    @ProtoNumber(14) val u10: UInt = UInt.MIN_VALUE,
    @ProtoNumber(45) val u11: UInt = UInt.MIN_VALUE,
    @ProtoNumber(18) val u12: UInt = UInt.MIN_VALUE,
    @ProtoNumber(19) val u13: UInt = UInt.MIN_VALUE,
    @ProtoNumber(20) val u14: UInt = UInt.MIN_VALUE,
    @ProtoNumber(22) val u15: UInt = UInt.MIN_VALUE,
    @ProtoNumber(23) val u16: UInt = UInt.MIN_VALUE,
    @ProtoNumber(5002) val u17: UInt = UInt.MIN_VALUE,
    @ProtoNumber(5003) val u18: UInt = UInt.MIN_VALUE,
    @ProtoNumber(5004) val u19: UInt = UInt.MIN_VALUE,
    @ProtoNumber(5005) val u20: UInt = UInt.MIN_VALUE,
    @ProtoNumber(10007) val u21: UInt = UInt.MIN_VALUE,
)

@Serializable
data class Oidb0xf57U2(
    @ProtoNumber(3) val u1: UInt = UInt.MIN_VALUE,
    @ProtoNumber(4) val u2: UInt = UInt.MIN_VALUE,
    @ProtoNumber(6) val u3: UInt = UInt.MIN_VALUE,
    @ProtoNumber(11) val u4: UInt = UInt.MIN_VALUE,
    @ProtoNumber(14) val u5: UInt = UInt.MIN_VALUE,
    @ProtoNumber(15) val u6: UInt = UInt.MIN_VALUE,
    @ProtoNumber(16) val u7: UInt = UInt.MIN_VALUE,
    @ProtoNumber(17) val u8: UInt = UInt.MIN_VALUE,
)
