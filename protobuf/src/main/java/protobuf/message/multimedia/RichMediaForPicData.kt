@file:OptIn(ExperimentalSerializationApi::class)
package protobuf.message.multimedia

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import moe.fuqiuluo.symbols.Protobuf

@Serializable
data class RichMediaForPicData(
    @ProtoNumber(1) val info: MediaInfo?,
    @ProtoNumber(2) val display: DisplayMediaInfo?,
): Protobuf<RichMediaForPicData> {
    companion object {
        @Serializable
        data class MediaInfo(
            @ProtoNumber(1) val picture: Picture? = null,
        )

        @Serializable
        data class Picture(
            @ProtoNumber(1) val info: PictureInfo? = null,
            @ProtoNumber(2) val fileId: String? = null,
            @ProtoNumber(4) val time: ULong? = null,
        )

        @Serializable
        data class PictureInfo(
            @ProtoNumber(2) val md5Hex: String? = null,
            @ProtoNumber(3) val sha: String? = null,
            @ProtoNumber(4) val name: String? = null,
            @ProtoNumber(6) val width: Int? = null,
            @ProtoNumber(7) val height: Int? = null,
        )
    }
}

@Serializable
data class DisplayMediaInfo(
    @ProtoNumber(1) val show: Show? = null,
) {
    companion object {
        @Serializable
        data class Show(
            @ProtoNumber(2) val text: String? = null,
            @ProtoNumber(12) val download: Download? = null
        )

        @Serializable
        data class Download(
            @ProtoNumber(30) val url: String? = null,
        )
    }
}

