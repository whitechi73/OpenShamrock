@file:OptIn(ExperimentalSerializationApi::class)

package protobuf.oidb.cmd0xf88

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import moe.fuqiuluo.symbols.Protobuf

@Serializable
data class Oidb0xf88Req(
    @ProtoNumber(1) val filter: GProFilter,
    @ProtoNumber(2) val memberId: ULong,
    @ProtoNumber(3) val tinyId: ULong,
    @ProtoNumber(4) val guildId: ULong,
): Protobuf<Oidb0xf88Req>

@Serializable
data class Oidb0xf88Rsp(
    @ProtoNumber(1) val userInfo: GProUserInfo?
): Protobuf<Oidb0xf88Rsp>

@Serializable
data class GProUserInfo(
    @ProtoNumber(1) var memberId: ULong = ULong.MIN_VALUE,
    @ProtoNumber(2) var memberTinyid: ULong = ULong.MIN_VALUE,
    @ProtoNumber(3) var nickName: String? = null,
    @ProtoNumber(4) var gender: UInt = UInt.MIN_VALUE,
    @ProtoNumber(5) var allow: UInt = UInt.MIN_VALUE,
    @ProtoNumber(6) var url: String? = null,
    @ProtoNumber(7) var birthday: String? = null,
    @ProtoNumber(8) var fullBirthday: String? = null,
    @ProtoNumber(9) var fullAge: String? = null,
    @ProtoNumber(10) var country: String? = null,
    @ProtoNumber(11) var province: String? = null,
    @ProtoNumber(12) var city: String? = null,
    @ProtoNumber(13) var cityId: String? = null,
    @ProtoNumber(14) var cityZoneId: UInt = UInt.MIN_VALUE,
    @ProtoNumber(15) var msgHeadInfo: GProHeadInfo? = null,
    @ProtoNumber(16) var joinTime: ULong = ULong.MIN_VALUE,
    @ProtoNumber(17) var memberRole: UInt = UInt.MIN_VALUE,
    @ProtoNumber(18) var memberType: UInt = UInt.MIN_VALUE,
    @ProtoNumber(19) var beAdminTime: ULong = ULong.MIN_VALUE,
    @ProtoNumber(20) var memberName: String? = null,
    //@ProtoNumber(21) var clientPresence: Any? = null,
    //@ProtoNumber(22) var client_archive: ArrayList<>? = null,
    //@ProtoNumber(23) var bind_client_account: ArrayList<>? = null,
    @ProtoNumber(24) var hasMoreArchive: Boolean = false,
    //@ProtoNumber(25) var firstArchiveArkData: Any? = null,
    @ProtoNumber(26) var directMsgBlackFlag: UInt = UInt.MIN_VALUE,
    @ProtoNumber(27) var setGroupProProfile: Boolean = false,
    @ProtoNumber(28) var joinGroupProTimestamp: ULong = ULong.MIN_VALUE,
    @ProtoNumber(29) var shutUpExpireTime: ULong = ULong.MIN_VALUE,
    @ProtoNumber(30) var avatarMeta: ByteArray? = null,
    @ProtoNumber(31) var memberNameFlag: UInt = UInt.MIN_VALUE,
    @ProtoNumber(32) var faceAuthStatus: UInt = UInt.MIN_VALUE,
    @ProtoNumber(33) var verifyUrl: String? = null,
    @ProtoNumber(34) var constellation: UInt = UInt.MIN_VALUE,
    @ProtoNumber(35) var personalSign: ByteArray? = null,
    //@ProtoNumber(36) var voice_live_info: Any? = null,
    @ProtoNumber(37) var avatarFlag: UInt = UInt.MIN_VALUE,
    //@ProtoNumber(38) var isQQFriend: Any? = null,
    //@ProtoNumber(39) var openid: Any? = null,
    //@ProtoNumber(40) var personalSignTemplate: Any? = null,
    //@ProtoNumber(41) var showVoiceLiveStatusSwitch: Any? = null,
    @ProtoNumber(99) var isMember: UInt = UInt.MIN_VALUE,
)

@Serializable
data class GProHeadInfo(
    @ProtoNumber(1) var timestamp: UInt = UInt.MIN_VALUE,
    @ProtoNumber(2) var faceFlag: UInt = UInt.MIN_VALUE,
    @ProtoNumber(3) var baseUrl: String? = null,
    @ProtoNumber(4) var type: UInt = UInt.MIN_VALUE
)

@Serializable
data class GProFilter(
    @ProtoNumber(3) val nickName: UInt = UInt.MIN_VALUE,
    @ProtoNumber(4) val gender: UInt = UInt.MIN_VALUE,
    @ProtoNumber(5) val allow: UInt = UInt.MIN_VALUE,
    @ProtoNumber(6) val url: UInt = UInt.MIN_VALUE,
    @ProtoNumber(7) val birthday: UInt = UInt.MIN_VALUE,
    @ProtoNumber(8) val fullBirthday: UInt = UInt.MIN_VALUE,
    @ProtoNumber(9) val fullAge: UInt = UInt.MIN_VALUE,
    @ProtoNumber(10) val country: UInt = UInt.MIN_VALUE,
    @ProtoNumber(11) val province: UInt = UInt.MIN_VALUE,
    @ProtoNumber(12) val city: UInt = UInt.MIN_VALUE,
    @ProtoNumber(13) val cityId: UInt = UInt.MIN_VALUE,
    @ProtoNumber(14) val cityZoneId: UInt = UInt.MIN_VALUE,
    @ProtoNumber(15) val headInfo: UInt = UInt.MIN_VALUE,
    @ProtoNumber(16) val joinTime: UInt = UInt.MIN_VALUE,
    @ProtoNumber(17) val memberRole: UInt = UInt.MIN_VALUE,
    @ProtoNumber(18) val memberType: UInt = UInt.MIN_VALUE,
    @ProtoNumber(19) val beAdminTime: UInt = UInt.MIN_VALUE,
    @ProtoNumber(20) val memberName: UInt = UInt.MIN_VALUE,
    @ProtoNumber(21) val clientPresence: UInt = UInt.MIN_VALUE,
    @ProtoNumber(22) val clientArchive: UInt = UInt.MIN_VALUE,
    @ProtoNumber(23) val bindClientAccount: UInt = UInt.MIN_VALUE,
    @ProtoNumber(24) val hasMoreArchive: UInt = UInt.MIN_VALUE,
    @ProtoNumber(25) val firstArchiveBaseInfo: UInt = UInt.MIN_VALUE,
    @ProtoNumber(26) val directMsgBlackFlag: UInt = UInt.MIN_VALUE,
    @ProtoNumber(27) val joinGroupProTimestamp: UInt = UInt.MIN_VALUE,
    @ProtoNumber(28) val shutupExpireTime: UInt = UInt.MIN_VALUE,
    @ProtoNumber(29) val faceAuthStatus: UInt = UInt.MIN_VALUE,
    @ProtoNumber(30) val constellation: UInt = UInt.MIN_VALUE,
    @ProtoNumber(31) val personalSign: UInt = UInt.MIN_VALUE,
    @ProtoNumber(32) val voiceLiveInfo: UInt = UInt.MIN_VALUE,
    @ProtoNumber(33) val isQQFriend: UInt = UInt.MIN_VALUE,
    @ProtoNumber(34) val personalSignTemplate: UInt = UInt.MIN_VALUE,
    @ProtoNumber(35) val showVoiceLiveStatusSwitch: UInt = UInt.MIN_VALUE,
    @ProtoNumber(36) val openid: UInt = UInt.MIN_VALUE,
    @ProtoNumber(37) val isMember: UInt = UInt.MIN_VALUE,
    @ProtoNumber(99) val needGroupProProfile: UInt = UInt.MIN_VALUE,
    @ProtoNumber(100) val avatarMeta: UInt = UInt.MIN_VALUE,
) {

}