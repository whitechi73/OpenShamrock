package protobuf.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class TextElement(
    @ProtoNumber(1) val text: String? = null,
    @ProtoNumber(2) val link: String? = null,
    @ProtoNumber(3) val attr6Buf: ByteArray? = null,
    @ProtoNumber(4) val attr7Buf: ByteArray? = null,
    @ProtoNumber(11) val buf: ByteArray? = null,
    @ProtoNumber(12) val pbReserve: TextResvAttr? = null,
) {
    companion object {
        @Serializable
        data class TextResvAttr(
            @ProtoNumber(1) val wording: ByteArray? = null,
            @ProtoNumber(2) val textAnalysisResult: Int? = null,
            @ProtoNumber(3) val atType: Int? = null,
            @ProtoNumber(4) val atMemberUin: Long? = null,
            @ProtoNumber(5) val atMemberTinyid: Long? = null,
            @ProtoNumber(6) val atChannelInfo: ExtChannelInfo? = null,
            @ProtoNumber(7) val atRoleInfo: ExtRoleInfo? = null,
        )

        @Serializable
        data class ExtChannelInfo(
            @ProtoNumber(1) val guildId: Long? = null,
            @ProtoNumber(2) val channelId: Long? = null,
        )

        @Serializable
        data class ExtRoleInfo(
            @ProtoNumber(1) val id: Long? = null,
            @ProtoNumber(2) val info: ByteArray? = null,
            @ProtoNumber(3) val flag: Int? = null,
        )
    }
}