@file:OptIn(ExperimentalSerializationApi::class)

package protobuf.oidb.cmd0x388

import com.google.protobuf.Internal.EMPTY_BYTE_ARRAY
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import moe.fuqiuluo.symbols.Protobuf

@Serializable
data class Cmd0x388RspBody(
    @ProtoNumber(1) var clientIp: UInt = 0u,
    @ProtoNumber(2) var subCmd: UInt = 0u,
    @ProtoNumber(3) var msgTryUpImgRsp: ArrayList<TryUpImgRsp>? = null,
    @ProtoNumber(5) var msgTryUpPttRsp: ArrayList<TryUpPttRsp>? = null,
): Protobuf<Cmd0x388RspBody>

@Serializable
data class TryUpPttRsp(
    @ProtoNumber(1) var fileId: Long = 0,
    @ProtoNumber(2) var result: Int = 0,
    @ProtoNumber(3) var failMsg: ByteArray = EMPTY_BYTE_ARRAY,
    @ProtoNumber(4) var fileExit: Boolean = false,
    @ProtoNumber(5) var upIp: List<Int>? = null,
    @ProtoNumber(6) var upPort: List<Int>? = null,
    @ProtoNumber(7) var upUkey: ByteArray = EMPTY_BYTE_ARRAY,
    @ProtoNumber(8) var fileid: Long = 0,
    @ProtoNumber(9) var upOffset: Long = 0,
    @ProtoNumber(10) var blockSize: Long = 0,
    @ProtoNumber(11) var fileKey: ByteArray = EMPTY_BYTE_ARRAY,
    @ProtoNumber(12) var channelType: Int = 0,
    @ProtoNumber(26) var msgUpIp6: ArrayList<IPv6Info>? = null,
    @ProtoNumber(27) var clientIp6: ByteArray = EMPTY_BYTE_ARRAY,
): Protobuf<TryUpPttRsp>

@Serializable
data class TryUpImgRsp(
    @ProtoNumber(1) var extFileId: ULong = 0u, // 没有实际作用
    @ProtoNumber(2) var result: UInt = 0u,
    @ProtoNumber(3) var faiMsg: ByteArray = EMPTY_BYTE_ARRAY,
    @ProtoNumber(4) var fileExist: Boolean = false,
    @ProtoNumber(5) var msgImgInfo: ImgInfo? = null, // 里面只是一堆垃圾
    @ProtoNumber(6) var upIp: ArrayList<Long>? = null,
    @ProtoNumber(7) var upPort: ArrayList<Int>? = null,
    @ProtoNumber(8) var ukey: ByteArray = EMPTY_BYTE_ARRAY,
    @ProtoNumber(9) var fileId: Long = 0,
    @ProtoNumber(10) var upOffset: ULong = 0u,
    @ProtoNumber(11) var blockSize: Long = 0,
    @ProtoNumber(12) var bool_new_big_chan: Boolean = false,
    @ProtoNumber(26) var rpt_msg_up_ip6: ArrayList<IPv6Info>? = null,
    @ProtoNumber(27) var client_ip6: ByteArray = EMPTY_BYTE_ARRAY,
    @ProtoNumber(1001) var msg_info4busi: TryUpInfo4Busi? = null,
)

@Serializable
data class TryUpInfo4Busi(
    @ProtoNumber(1) var down_domain: ByteArray = EMPTY_BYTE_ARRAY,
    @ProtoNumber(2) var thumb_down_url: ByteArray = EMPTY_BYTE_ARRAY,
    @ProtoNumber(3) var original_down_url: ByteArray = EMPTY_BYTE_ARRAY,
    @ProtoNumber(4) var big_down_url: ByteArray = EMPTY_BYTE_ARRAY,
    @ProtoNumber(5) var file_resid: ByteArray = EMPTY_BYTE_ARRAY,
)

@Serializable
data class IPv6Info(
    @ProtoNumber(1) var ip6: ByteArray = EMPTY_BYTE_ARRAY,
    @ProtoNumber(2) var port: UInt = 0u,
)

@Serializable
data class ImgInfo(
    @ProtoNumber(1) var file_md5: ByteArray = EMPTY_BYTE_ARRAY,
    @ProtoNumber(2) var file_type: UInt = 0u,
    @ProtoNumber(3) var file_size: ULong = 0u,
    @ProtoNumber(4) var file_width: UInt = 0u,
    @ProtoNumber(5) var file_height: UInt = 0u,
)