package protobuf.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class TextMsg(
    @ProtoNumber(1) val str: String? = null,
    @ProtoNumber(2) val link: String? = null,
    @ProtoNumber(3) val attr6Buf: ByteArray? = null,
    @ProtoNumber(4) val attr7Buf: ByteArray? = null,
    @ProtoNumber(11) val buf: ByteArray? = null,
    @ProtoNumber(12) val pbReserve: PbReserve? = null,
){
    companion object {
        @Serializable
        data class PbReserve(
            @ProtoNumber(1) val field1: String? = null, // [打 call]] 请使用最新版手机 QQ 体验新功能
        )
    }
}