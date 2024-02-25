package protobuf.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class CustomFace(
    @ProtoNumber(1) var guid: ByteArray? = null,
    @ProtoNumber(2) var filePath: String? = null,
    @ProtoNumber(3) var shortcut: String? = null,
    @ProtoNumber(4) var buffer: ByteArray? = null,
    @ProtoNumber(5) var flag: ByteArray? = null,
    @ProtoNumber(6) var oldData: ByteArray? = null,
    @ProtoNumber(7) var fileId: UInt? = null,
    @ProtoNumber(8) var serverIp: UInt? = null,
    @ProtoNumber(9) var serverPort: UInt? = null,
    @ProtoNumber(10) var fileType: UInt? = null, // 66
    @ProtoNumber(11) var signature: ByteArray? = null,
    @ProtoNumber(12) var useful: UInt? = null,
    @ProtoNumber(13) var md5: ByteArray? = null,
    @ProtoNumber(14) var thumbUrl: String? = null,
    @ProtoNumber(15) var bigUrl: String? = null,
    @ProtoNumber(16) var origUrl: String? = null,
    @ProtoNumber(17) var bizType: UInt? = null,
    @ProtoNumber(18) var repeatIndex: UInt? = null,
    @ProtoNumber(19) var repeatImage: UInt? = null,
    @ProtoNumber(20) var imageType: UInt? = null,
    @ProtoNumber(21) var index: UInt? = null,
    @ProtoNumber(22) var width: UInt? = null,
    @ProtoNumber(23) var height: UInt? = null,
    @ProtoNumber(24) var source: UInt? = null,
    @ProtoNumber(25) var size: UInt? = null,
    @ProtoNumber(26) var origin: Boolean? = null,
    @ProtoNumber(27) var thumbWidth: UInt? = null,
    @ProtoNumber(28) var thumbHeight: UInt? = null,
    @ProtoNumber(29) var showLen: UInt? = null,
    @ProtoNumber(30) var downloadLen: UInt? = null,
    @ProtoNumber(31) var url400: String? = null,
    @ProtoNumber(32) var width400: UInt? = null,
    @ProtoNumber(33) var height400: UInt? = null,
    @ProtoNumber(34) var pbReserve: PbReserve? = null,
) {
    companion object {
        @Serializable
        data class PbReserve(
            @ProtoNumber(1) var field1: Int? = null,
            @ProtoNumber(3) var field3: Int? = null,
            @ProtoNumber(4) var field4: Int? = null,
            @ProtoNumber(10) var field10: Int? = null,
            @ProtoNumber(21) var field21: Object1? = null,
            @ProtoNumber(31) var field31: String? = null
        )

        @Serializable
        data class Object1(
            @ProtoNumber(1) var field1: Int? = null,
            @ProtoNumber(2) var field2: String? = null,
            @ProtoNumber(3) var field3: Int? = null,
            @ProtoNumber(4) var field4: Int? = null,
            @ProtoNumber(5) var field5: Int? = null,
            @ProtoNumber(7) var md5Str: String? = null
        )
    }
}