package protobuf.oidb.cmd0x388

import com.google.protobuf.Internal.EMPTY_BYTE_ARRAY
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import moe.fuqiuluo.symbols.Protobuf

@Serializable
data class Cmd0x388ReqBody(
    @ProtoNumber(1) var netType: Int = 0,
    @ProtoNumber(2) var subCmd: Int = 0,
    @ProtoNumber(3) var msgTryUpImg: ArrayList<TryUpImgReq>? = null,
    // @ProtoNumber(4) var rpt_msg_getimg_url_req: ArrayList<GetImgUrlReq>? = null,
    @ProtoNumber(5) var msgTryUpPttReq: ArrayList<TryUpPttReq>? = null,
    // @ProtoNumber(6) var msgGetPttUrlReq: ArrayList<GetPttUrlReq>? = null,
    @ProtoNumber(7) var commandId: Int = 0,
    // @ProtoNumber(8) var rpt_msg_del_img_req: ArrayList<DelImgReq>? = null,
    @ProtoNumber(1001) var extension: ByteArray = EMPTY_BYTE_ARRAY,
): Protobuf<Cmd0x388ReqBody>

@Serializable
data class TryUpImgReq(
    @ProtoNumber(1) var groupCode: Long = 0,
    @ProtoNumber(2) var srcUin: Long = 0,
    @ProtoNumber(3) var fileId: Long? = null,
    @ProtoNumber(4) var fileMd5: ByteArray = EMPTY_BYTE_ARRAY,
    @ProtoNumber(5) var fileSize: Long = 0,
    @ProtoNumber(6) var fileName: String = "",
    @ProtoNumber(7) var srcTerm: Int = 0,
    @ProtoNumber(8) var platformType: Int = 0,
    @ProtoNumber(9) var buType: Int = 0,
    @ProtoNumber(10) var picWidth: Int = 0,
    @ProtoNumber(11) var picHeight: Int = 0,
    @ProtoNumber(12) var picType: Int = 0,
    @ProtoNumber(13) var buildVer: String = "",
    @ProtoNumber(14) var innerIp: Int = 0,
    @ProtoNumber(15) var appPicType: Int = 0,
    @ProtoNumber(16) var originalPic: Int = 0,
    @ProtoNumber(17) var fileIndex: ByteArray = EMPTY_BYTE_ARRAY,
    @ProtoNumber(18) var dstUin: Long = 0,
    @ProtoNumber(19) var srvUpload: Int? = null,
    @ProtoNumber(20) var transferUrl: ByteArray = EMPTY_BYTE_ARRAY,
)

@Serializable
data class TryUpPttReq(
    @ProtoNumber(1) var groupCode: Long = 0,
    @ProtoNumber(2) var srcUin: Long = 0,
    @ProtoNumber(3) var fileId: Long = 0,
    @ProtoNumber(4) var fileMd5: ByteArray = EMPTY_BYTE_ARRAY,
    @ProtoNumber(5) var fileSize: Long = 0,
    @ProtoNumber(6) var fileName: ByteArray = EMPTY_BYTE_ARRAY,
    @ProtoNumber(7) var srcTerm: Int = 0,
    @ProtoNumber(8) var platformType: Int = 0,
    @ProtoNumber(9) var buType: Int = 0,
    @ProtoNumber(10) var buildVer: ByteArray = EMPTY_BYTE_ARRAY,
    @ProtoNumber(11) var innerIp: Int = 0,
    @ProtoNumber(12) var voiceLength: Int = 0,
    @ProtoNumber(13) var newUpChan: Boolean = false,
    @ProtoNumber(14) var codec: Int = 0,
    @ProtoNumber(15) var voiceType: Int = 0,
    @ProtoNumber(16) var buId: Int = 0,
)
