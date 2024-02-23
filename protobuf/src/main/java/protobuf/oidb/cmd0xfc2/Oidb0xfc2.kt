@file:OptIn(ExperimentalSerializationApi::class)
package protobuf.oidb.cmd0xfc2

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import moe.fuqiuluo.symbols.Protobuf

@Serializable
data class Oidb0xfc2ReqBody(
    @ProtoNumber(1) var msgCmd: Int? = null,
    @ProtoNumber(3) var msgBusType: Int? = null,
    @ProtoNumber(4) var msgChannelInfo: Oidb0xfc2ChannelInfo? = null,
    @ProtoNumber(5) var msgTerminalType: Int? = null,
    //@ProtoNumber(100) var msg_apply_upload_req: Any? = null,
    //@ProtoNumber(200) var msg_upload_completed_req: Any? = null,
    @ProtoNumber(300) var msgApplyDownloadReq: Oidb0xfc2MsgApplyDownloadReq? = null,
    //@ProtoNumber(400) var msg_apply_preview_req: Any? = null,
    //@ProtoNumber(500) var msg_apply_security_strike_req: Any? = null,
): Protobuf<Oidb0xfc2ReqBody>

@Serializable
data class Oidb0xfc2RspBody(
    @ProtoNumber(1) var msgCmd: Int? = null,
    @ProtoNumber(5) var msgBusType: Int? = null,
    //@ProtoNumber(110) var msg_apply_upload_rsp: Any? = null,
    //@ProtoNumber(210) var msg_upload_completed_rsp: Any? = null,
    @ProtoNumber(310) var msgApplyDownloadRsp: Oidb0xfc2MsgApplyDownloadRsp? = null,
    //@ProtoNumber(410) var msg_apply_preview_rsp: Any? = null,
    //@ProtoNumber(510) var msg_apply_security_strike_rsp: Any? = null,
): Protobuf<Oidb0xfc2RspBody>

@Serializable
data class Oidb0xfc2MsgApplyDownloadRsp(
    @ProtoNumber(1) var msgDownloadInfo: Oidb0xfc2MsgDownloadInfo? = null,
    //@ProtoNumber(2) var msgFileInfo: Any? = null,
    //@ProtoNumber(3) var msgChacha20Param: Any? = null,
    //@ProtoNumber(4) var useEncrypt: UInt = UInt.MIN_VALUE,
)

@Serializable
data class Oidb0xfc2MsgDownloadInfo(
    @ProtoNumber(1) var downloadKey: ByteArray? = null,
    //@ProtoNumber(2) var msg_out_addr: Any? = null,
    //@ProtoNumber(3) var msg_inner_addr: Any? = null,
    //@ProtoNumber(4) var msg_out_addr_ipv6: Any? = null,
    @ProtoNumber(5) var downloadDomain: String? = null,
    @ProtoNumber(6) var downloadUrl: String? = null,
    //@ProtoNumber(7) var str_cookie: Any? = null,
)

@Serializable
data class Oidb0xfc2MsgApplyDownloadReq(
    @ProtoNumber(1) val fieldId: String,
    @ProtoNumber(2) val supportEncrypt: Int,
)

@Serializable
data class Oidb0xfc2ChannelInfo(
    @ProtoNumber(3) val guildId: ULong,
    @ProtoNumber(4) val channelId: ULong,
)