package protobuf.message

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class Ptt(
    @ProtoNumber(1) var fileType: UInt?=null,
    @ProtoNumber(2) var srcUin: ULong?=null,
    @ProtoNumber(3) var fileUuid: ByteArray?=null,
    @ProtoNumber(4) var fileMd5: ByteArray?=null,
    @ProtoNumber(5) var fileName: ByteArray?=null,
    @ProtoNumber(6) var fileSize: UInt?=null,
    @ProtoNumber(7) var reserve: ByteArray?=null,
    @ProtoNumber(8) var fileId: UInt?=null,
    @ProtoNumber(9) var serverIp: UInt?=null,
    @ProtoNumber(10) var serverPort: UInt?=null,
    @ProtoNumber(11) var boolValid: Boolean = false,
    @ProtoNumber(12) var signature: ByteArray?=null,
    @ProtoNumber(13) var shortcut: ByteArray?=null,
    @ProtoNumber(14) var fileKey: ByteArray?=null,
    @ProtoNumber(15) var magicPttIndex: UInt?=null,
    @ProtoNumber(16) var voiceSwitch: UInt?=null,
    @ProtoNumber(17) var pttUrl: ByteArray?=null,
    @ProtoNumber(18) var groupFileKey: ByteArray?=null,
    @ProtoNumber(19) var time: UInt?=null,
    @ProtoNumber(20) var downPara: ByteArray?=null,
    @ProtoNumber(29) var format: UInt?=null,
    @ProtoNumber(30) var pbReserve: ByteArray?=null,
    @ProtoNumber(31) var rptPttUrls: List<String>? = null,
    @ProtoNumber(32) var downloadFlag: UInt?=null,
)