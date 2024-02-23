package protobuf.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class MarketFace(
    @ProtoNumber(1) var faceName: String? = null,
    @ProtoNumber(2) var itemType: Int? = null,
    @ProtoNumber(3) var faceInfo: Int? = null,
    @ProtoNumber(4) var faceId: String? = null,
    @ProtoNumber(5) var tabId: Int? = null,
    @ProtoNumber(6) var subType: Int? = null,
    @ProtoNumber(7) var key: ByteArray? = null,
    @ProtoNumber(8) var param: ByteArray? = null,
    @ProtoNumber(9) var mediaType: Int? = null,
    @ProtoNumber(10) var imageWidth: Int? = null,
    @ProtoNumber(11) var imageHeight: Int? = null,
    @ProtoNumber(12) var mobileparam: ByteArray? = null,
    @ProtoNumber(13) var pbReserve: ByteArray? = null,
)