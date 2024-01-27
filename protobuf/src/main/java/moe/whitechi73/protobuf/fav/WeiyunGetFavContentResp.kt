@file:OptIn(ExperimentalSerializationApi::class)
package moe.whitechi73.protobuf.fav

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class WeiyunGetFavContentResp(
    @ProtoNumber(1) val content: List<WeiyunContent>? = null
)

@Serializable
data class WeiyunContent(
    @ProtoNumber(1) val text: WeiyunTextContent? = null,
    @ProtoNumber(2) val link: WeiyunLinkContent? = null,
    @ProtoNumber(3) val galley: WeiyunGalleyContent? = null,
    @ProtoNumber(4) val audio: WeiyunAudioContent? = null,
    @ProtoNumber(5) val video: WeiyunVideoContent? = null,
    @ProtoNumber(6) val file: WeiyunFileContent? = null,
    @ProtoNumber(7) val location: WeiyunLocationContent? = null,
    @ProtoNumber(8) val richMedia: WeiyunRichMediaContent? = null,
)

@Serializable
data class WeiyunTextContent(
    @ProtoNumber(1) val data: String,
    @ProtoNumber(2) val hasEmoji: Boolean = false
)

@Serializable
class WeiyunLinkContent

@Serializable
class WeiyunGalleyContent

@Serializable
data class WeiyunAudioContent(
    @ProtoNumber(1) val data: ByteArray,
)

@Serializable
class WeiyunVideoContent

@Serializable
class WeiyunFileContent

@Serializable
class WeiyunLocationContent

