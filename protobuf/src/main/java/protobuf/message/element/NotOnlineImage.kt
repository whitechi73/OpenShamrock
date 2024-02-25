package protobuf.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class NotOnlineImage(
    @ProtoNumber(1) val filePath: String? = null,
    @ProtoNumber(2) val fileLen: UInt? = null,
    @ProtoNumber(3) val downloadPath: String? = null,
    @ProtoNumber(4) val oldVerSendFile: ByteArray? = null,
    @ProtoNumber(5) val imgType: UInt? = null,
    @ProtoNumber(6) val previewsImage: ByteArray? = null,
    @ProtoNumber(7) val picMd5: ByteArray? = null,
    @ProtoNumber(8) val picHeight: UInt? = null,
    @ProtoNumber(9) val picWidth: UInt? = null,
    @ProtoNumber(10) val resId: String? = null, // md5 + ".jpg"
    @ProtoNumber(11) val flag: ByteArray? = null,
    @ProtoNumber(12) val thumbUrl: String? = null,
    @ProtoNumber(13) val original: Boolean? = null,
    @ProtoNumber(14) val bigUrl: String? = null,
    @ProtoNumber(15) val origUrl: String? = null,
    @ProtoNumber(16) val bizType: UInt? = null,
    @ProtoNumber(17) val result: UInt? = null,
    @ProtoNumber(18) val index: UInt? = null,
    @ProtoNumber(19) val opFaceBuf: ByteArray? = null,
    @ProtoNumber(20) val oldPicMd5: Boolean = false,
    @ProtoNumber(21) val thumbWidth: UInt? = null,
    @ProtoNumber(22) val thumbHeight: UInt? = null,
    @ProtoNumber(23) val fileId: UInt? = null,
    @ProtoNumber(24) val showLen: UInt? = null,
    @ProtoNumber(25) val downloadLen: UInt? = null,
    @ProtoNumber(26) val url400: String? = null,
    @ProtoNumber(27) val width400: UInt? = null,
    @ProtoNumber(28) val height400: UInt? = null,
    @ProtoNumber(29) val pbReserve: PbReserve? = null,
) {
    companion object {
        @Serializable
        data class PbReserve(
            @ProtoNumber(1) var field1: Int? = null,
            @ProtoNumber(3) var field3: Int? = null,
            @ProtoNumber(4) var field4: Int? = null,
            @ProtoNumber(8) var field8: String? = null,
            @ProtoNumber(10) var field10: Int? = null,
            @ProtoNumber(20) var field20: Object1? = null,
            @ProtoNumber(30) var url: String? = null,
            @ProtoNumber(31) var md5Str: String? = null
        )

        @Serializable
        data class Object1(
            @ProtoNumber(1) var field1: Int? = null,
            @ProtoNumber(2) var field2: String? = null,
            @ProtoNumber(3) var field3: Int? = null,
            @ProtoNumber(4) var field4: Int? = null,
            @ProtoNumber(5) var field5: Int? = null,
            @ProtoNumber(7) var field7: String? = null
        )
    }
}