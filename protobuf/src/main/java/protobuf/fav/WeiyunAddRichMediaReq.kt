@file:OptIn(ExperimentalSerializationApi::class)
@file:Suppress("ArrayInDataClass")

package protobuf.fav

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class WeiyunAddRichMediaReq(
    @ProtoNumber(1) val commInfo: WeiyunCollectCommInfo? = null,
    @ProtoNumber(2) val summary: WeiyunRichMediaSummary? = null,
    @ProtoNumber(3) val richMediaContent: List<WeiyunRichMediaContent>? = null,
    @ProtoNumber(4) val needShareUrl: Boolean = false,
)

@Serializable
data class WeiyunRichMediaSummary(
    @ProtoNumber(1) val title: String? = null,
    @ProtoNumber(2) val subTitle: String = "",
    @ProtoNumber(3) val brief: String = "",
    @ProtoNumber(4) val picList: List<WeiyunPicInfo>? = null,
    @ProtoNumber(5) val contentType: UInt = UInt.MIN_VALUE,
    @ProtoNumber(6) val originalUri: String = "",
    @ProtoNumber(7) val publisher: String = "",
    @ProtoNumber(8) val richMediaVersion: UInt = UInt.MIN_VALUE,
)

@Serializable
data class WeiyunRichMediaContent(
    @ProtoNumber(1) val richMedia: WeiyunRichMedia? = null,
    @ProtoNumber(2) val rawData: ByteArray? = null,
    @ProtoNumber(3) val bizDataList: List<ByteArray>? = null,
    @ProtoNumber(4) val picList: List<WeiyunPicInfo>? = null,
    @ProtoNumber(5) val fileList: List<WeiyunFileInfo>? = null,
)

@Serializable
data class WeiyunFileInfo(
    @ProtoNumber(1) val src: UInt = UInt.MIN_VALUE,
    @ProtoNumber(2) val uid: ULong = ULong.MIN_VALUE,
    @ProtoNumber(3) val bid: UInt = UInt.MIN_VALUE,
    @ProtoNumber(4) val fid: String = "",
    @ProtoNumber(5) val name: String = "",
    @ProtoNumber(6) val size: ULong = ULong.MIN_VALUE,
    @ProtoNumber(7) val md5: ByteArray? = null,
    @ProtoNumber(8) val sha1: ByteArray? = null,
    @ProtoNumber(9) val category: UInt = UInt.MIN_VALUE,
)

@Serializable
data class WeiyunRichMedia(
    @ProtoNumber(1) val sections: List<WeiyunSection>? = null
)

@Serializable
data class WeiyunSection(
    @ProtoNumber(1) val items: List<WeiyunItem>? = null
)

@Serializable
data class WeiyunItem(
    @ProtoNumber(1) val itemType: UInt = UInt.MIN_VALUE,
    @ProtoNumber(2) val paragraph: WeiyunParagraph? = null,
    @ProtoNumber(3) val anchor: WeiyunAnchor? = null,
    @ProtoNumber(4) val picInfo: WeiyunPicInfo? = null,
)

@Serializable
data class WeiyunPicInfo(
    @ProtoNumber(1) val uri: String = "",
    @ProtoNumber(2) val md5: ByteArray? = null,
    @ProtoNumber(3) val sha1: ByteArray? = null,
    @ProtoNumber(4) val name: String = "",
    @ProtoNumber(5) val note: String = "",
    @ProtoNumber(6) val width: UInt = UInt.MIN_VALUE,
    @ProtoNumber(7) val height: UInt = UInt.MIN_VALUE,
    @ProtoNumber(8) val size: ULong = ULong.MIN_VALUE,
    @ProtoNumber(9) val type: UInt = UInt.MIN_VALUE,
    @ProtoNumber(10) val owner: WeiyunAuthor? = null,
    @ProtoNumber(11) val picId: String = "",
)

@Serializable
data class WeiyunAnchor(
    @ProtoNumber(1) val url: String = "",
    @ProtoNumber(2) val desc: String = "",
)

@Serializable
data class WeiyunParagraph(
    @ProtoNumber(1) val content: String = "",
    @ProtoNumber(2) val style: WeiyunStyle? = null,
)

@Serializable
data class WeiyunStyle(
    @ProtoNumber(1) val color: String = "#FFFFFF",
    @ProtoNumber(2) val fontFamily: String = "",
    @ProtoNumber(3) val fontWeight: String = "normal",
    @ProtoNumber(4) val fontSize: String = "",
)

@Serializable
data class WeiyunCollectCommInfo(
    @ProtoNumber(1) val bid: UInt = UInt.MIN_VALUE,
    @ProtoNumber(2) val category: UInt = UInt.MIN_VALUE,
    @ProtoNumber(3) val author: WeiyunAuthor? = null,
    @ProtoNumber(4) val createTime: ULong = ULong.MIN_VALUE,
    @ProtoNumber(5) val seq: ULong = ULong.MIN_VALUE,
    @ProtoNumber(6) val bizKey: String = "",
    @ProtoNumber(7) val bizDataList: List<ByteArray>? = null,
    @ProtoNumber(8) val shareUrl: String = "",
    @ProtoNumber(9) val originalAppId: UInt = UInt.MIN_VALUE,
    @ProtoNumber(10) val customGroupId: UInt = UInt.MIN_VALUE,
    @ProtoNumber(11) val modifyTime: ULong = ULong.MIN_VALUE,
    @ProtoNumber(12) val qzoneUgcKey: String = "",
)

@Serializable
data class WeiyunAuthor(
    @ProtoNumber(1) val type: UInt = UInt.MIN_VALUE,
    @ProtoNumber(2) val numId: ULong = ULong.MIN_VALUE,
    @ProtoNumber(3) val strId: String = "",
    @ProtoNumber(4) val groupId: ULong = ULong.MIN_VALUE,
    @ProtoNumber(5) val groupName: String = "",
)