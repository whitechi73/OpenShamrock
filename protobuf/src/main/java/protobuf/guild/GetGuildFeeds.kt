@file:OptIn(ExperimentalSerializationApi::class)

package protobuf.guild

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import protobuf.qweb.QWebExtInfo

@Serializable
data class GetGuildFeedsReq(
    @ProtoNumber(1) var count: Int,
    @ProtoNumber(2) var from: Int? = null,
    @ProtoNumber(3) var feedAttchInfo: ByteArray? = null,
    @ProtoNumber(4) var guildId: ULong? = null,
    @ProtoNumber(5) var getType: Int? = null,
    @ProtoNumber(6) var sortOption: Int? = null,
    @ProtoNumber(7) var u7: Int? = null,
    @ProtoNumber(8) var u8: Int? = null,
    @ProtoNumber(9) var u9: ByteArray? = null,
)

@Serializable
data class GetGuildFeedsRsp(
    @ProtoNumber(1) var vecFeed: List<StFeed>? = null,
    @ProtoNumber(2) var isFinish: Int = 0,
    //@ProtoNumber(3) var feedAttchInfo: ByteArray? = null,
    //@ProtoNumber(4) var traceId: String? = null,
)

@Serializable
data class StFeed(
    @SerialName("id") @ProtoNumber(1) var id: String,
    @SerialName("title") @ProtoNumber(2) var title: StRichText,
    @SerialName("poster") @ProtoNumber(4) var poster: StUser? = null,
    @SerialName("videos") @ProtoNumber(5) var videos: List<StVideo>? = null,
    @SerialName("contents") @ProtoNumber(6) var contents: StRichText? = null,
    @SerialName("create_time") @ProtoNumber(7) var createTime: ULong? = null,
    @SerialName("comment_count") @ProtoNumber(9) var commentCount: UInt? = null,

    @SerialName("comments") @ProtoNumber(10) var vecComment: List<StComment>? = null,
    @SerialName("share") @ProtoNumber(11) var share: StShare? = null,
    @SerialName("visitor_info") @ProtoNumber(12) var visitorInfo: StVisitor? = null,
    @SerialName("images") @ProtoNumber(13) var images: List<StImage>? = null,
    @SerialName("poi") @ProtoNumber(14) var poiInfo: StPoiInfoV2? = null,
    @SerialName("op_mask") @ProtoNumber(17) var opMask: List<Int>? = null,
    @SerialName("channel_info") @ProtoNumber(21) var channelInfo: StChannelInfo? = null,
    @SerialName("create_time_ns") @ProtoNumber(22) var createTimeNs: ULong? = null,
    @SerialName("update_time") @ProtoNumber(28) var updateTime: ULong? = null,
    @SerialName("total_like") @ProtoNumber(29) var totalLike: StTotalLike? = null,
    @SerialName("discussion_mum") @ProtoNumber(31) var discussionMum: UInt? = null,
    @SerialName("feed_type") @ProtoNumber(32) var feedType: UInt? = null,
    @SerialName("default_background_img") @ProtoNumber(34) var defaultBackgroundImg: String? = null,
    @SerialName("group_code") @ProtoNumber(35) var groupCode: ULong? = null,
)

@Serializable
data class StTotalLike (
    @SerialName("count") @ProtoNumber(1) var likeCount: UInt? = null,
    @SerialName("is_clicked") @ProtoNumber(2) var isClicked: UInt? = null,
)

@Serializable
data class StPoiInfoV2(
    @SerialName("poi_id") @ProtoNumber(1) var poiId: String? = null,
    @SerialName("name") @ProtoNumber(2) var name: String? = null,
    @SerialName("poi_type") @ProtoNumber(3) var poiType: Int? = null,
    @SerialName("type_name") @ProtoNumber(4) var typeName: String? = null,
    @SerialName("address") @ProtoNumber(5) var address: String? = null,
    @SerialName("district_code") @ProtoNumber(6) var districtCode: Int? = null,
    @SerialName("gps") @ProtoNumber(7) var gps: StGPSV2? = null,
    @SerialName("distance") @ProtoNumber(8) var distance: Int? = null,
    @SerialName("hot_value") @ProtoNumber(9) var hotValue: Int? = null,
    @SerialName("phone") @ProtoNumber(10) var phone: String? = null,
    @SerialName("country") @ProtoNumber(11) var country: String? = null,
    @SerialName("province") @ProtoNumber(12) var province: String? = null,
    @SerialName("city") @ProtoNumber(13) var city: String? = null,
    @SerialName("poi_num") @ProtoNumber(14) var poiNum: Int? = null,
    @SerialName("poi_order_type") @ProtoNumber(15) var poiOrderType: Int? = null,
    @SerialName("default_name") @ProtoNumber(16) var defaultName: String? = null,
    @SerialName("district") @ProtoNumber(17) var district: String? = null,
    @SerialName("dian_ping_id") @ProtoNumber(18) var dianPingId: String? = null,
    @SerialName("distance_text") @ProtoNumber(19) var distanceText: String? = null,
    @SerialName("display_name") @ProtoNumber(20) var displayName: String? = null,
)

@Serializable
data class StGPSV2(
    @SerialName("lat") @ProtoNumber(1) var latitude: Long? = null,
    @SerialName("lon") @ProtoNumber(2) var longitude: Long? = null,
)

@Serializable
data class StShare(
    @SerialName("title") @ProtoNumber(1) var title: String? = null,
    @SerialName("desc") @ProtoNumber(2) var desc: String? = null,
    @SerialName("type") @ProtoNumber(3) var type: UInt? = null,
    @SerialName("url") @ProtoNumber(4) var url: String? = null,
    @SerialName("author") @ProtoNumber(5) var author: StUser? = null,
    @SerialName("poster") @ProtoNumber(6) var poster: StUser? = null,
    @SerialName("videos") @ProtoNumber(7) var videos: List<StVideo>? = null,
    @SerialName("short_url") @ProtoNumber(8) var shorturl: String? = null,
    @SerialName("share_card_info") @ProtoNumber(9) var shareCardInfo: String? = null,
    //@ProtoNumber(10) var shareQzoneInfo: Any? = null,
    @SerialName("images") @ProtoNumber(11) var images: List<StImage>? = null,
    @SerialName("publish_total_user") @ProtoNumber(12) var publishTotalUser: UInt? = null,
    @SerialName("shared_count") @ProtoNumber(13) var sharedCount: UInt? = null,
    //@ProtoNumber(14) var channelShareInfo: Any? = null,
)

@Serializable
data class StVisitor(
    @SerialName("view_count")
    @ProtoNumber(1) val viewCount: UInt? = null,
    @SerialName("recome_count")
    @ProtoNumber(3) val recomeCount: UInt? = null,
    @SerialName("view_desc")
    @ProtoNumber(4) val viewDesc: String? = null,
)

@Serializable
data class StComment(
    @SerialName("id") @ProtoNumber(1) var id: String? = null,
    @SerialName("poster") @ProtoNumber(2) var postUser: StUser? = null,
    @SerialName("create_time") @ProtoNumber(3) var createTime: ULong? = null,
    @SerialName("content") @ProtoNumber(4) var content: String? = null,
    @SerialName("reply_count") @ProtoNumber(5) var replyCount: UInt? = null,
    @SerialName("replies") @ProtoNumber(6) var vecReply: List<StReply>? = null,
    //@ProtoNumber(7) var busiData: Any? = null,
    @SerialName("like_info") @ProtoNumber(8) var likeInfo: StLike? = null,
    @SerialName("type_flag") @ProtoNumber(9) var typeFlag: UInt? = null,
    @SerialName("at_uin_list") @ProtoNumber(10) var atUinList: List<String>? = null,
    @SerialName("type_flag2") @ProtoNumber(11) var typeFlag2: UInt? = null,
    @SerialName("create_time_ns") @ProtoNumber(12) var createTimeNs: ULong? = null,
    @SerialName("store_ext_info") @ProtoNumber(13) var storeExtInfo: List<QWebExtInfo>? = null,
    @SerialName("third_id") @ProtoNumber(14) var thirdId: String? = null,
    @SerialName("source_type") @ProtoNumber(15) var sourceType: UInt? = null,
    @SerialName("rich_contents") @ProtoNumber(16) var richContents: StRichText? = null,
    @SerialName("images") @ProtoNumber(17) var images: List<StImage>? = null,
    @SerialName("sequence") @ProtoNumber(18) var sequence: ULong? = null,
    @SerialName("next_page_reply") @ProtoNumber(19) var nextPageReply: Boolean? = null,
    @SerialName("attach_info") @ProtoNumber(20) var attachInfo: String? = null,
)

@Serializable
data class StReply(
    @SerialName("id") @ProtoNumber(1) var id: String? = null,
    @SerialName("poster") @ProtoNumber(2) var postUser: StUser? = null,
    @SerialName("create_time") @ProtoNumber(3) var createTime: ULong? = null,
    @SerialName("content") @ProtoNumber(4) var content: String? = null,
    @SerialName("target") @ProtoNumber(5) var targetUser: StUser? = null,
    //@ProtoNumber(6) var busiData: ByteArray? = null,
    @SerialName("like_info") @ProtoNumber(7) var likeInfo: StLike? = null,
    @SerialName("type_flag") @ProtoNumber(8) var typeFlag: UInt? = null,
    @SerialName("modify_flag") @ProtoNumber(9) var modifyflag: UInt? = null,
    @SerialName("at_uin_list") @ProtoNumber(10) var atUinList: List<String>? = null,
    @SerialName("type_flag2") @ProtoNumber(11) var typeFlag2: UInt? = null,
    @SerialName("create_time_ns") @ProtoNumber(12) var createTimeNs: ULong? = null,
    @SerialName("store_ext_info") @ProtoNumber(13) var storeExtInfo: List<QWebExtInfo>? = null,
    @SerialName("third_id") @ProtoNumber(14) var thirdId: String? = null,
    @SerialName("target_reply_id") @ProtoNumber(15) var targetReplyID: String? = null,
    @SerialName("source_type") @ProtoNumber(16) var sourceType: UInt? = null,
    @SerialName("rich_contents") @ProtoNumber(17) var richContents: StRichText? = null,
    @SerialName("images") @ProtoNumber(18) var images: List<StImage>? = null,
)

@Serializable
data class StLike(
    @SerialName("id")
    @ProtoNumber(1) var id: String? = null,
    @SerialName("count")
    @ProtoNumber(2) var count: UInt? = null,
    @SerialName("status")
    @ProtoNumber(3) var status: UInt? = null,
    @SerialName("like_uin_list")
    @ProtoNumber(4) var vecUser: List<StUser>? = null,
    @SerialName("poster")
    @ProtoNumber(6) var postUser: StUser? = null,
    @SerialName("has_liked_count")
    @ProtoNumber(7) var hasLikedCount: UInt? = null,
    @SerialName("owner_status")
    @ProtoNumber(8) var ownerStatus: UInt? = null,
    @SerialName("jump_url")
    @ProtoNumber(9) var jumpUrl: String? = null,
)

@Serializable
data class StVideo(
    @SerialName("file_id") @ProtoNumber(1) var fileId: String? = null,
    @SerialName("file_size") @ProtoNumber(2) var fileSize: UInt? = null,
    @SerialName("duration") @ProtoNumber(3) var duration: UInt? = null,
    @SerialName("width") @ProtoNumber(4) var width: UInt? = null,
    @SerialName("height") @ProtoNumber(5) var height: UInt? = null,
    @SerialName("play_url") @ProtoNumber(6) var playUrl: String? = null,
    @SerialName("trans_status") @ProtoNumber(7) var transStatus: UInt? = null,
    @SerialName("video_prior") @ProtoNumber(8) var videoPrior: UInt? = null,
    @SerialName("video_rate") @ProtoNumber(9) var videoRate: UInt? = null,
    //@ProtoNumber(10) var vecVideoUrl: String? = null,
    //@ProtoNumber(11) var busiData: Any? = null,
    @SerialName("approval_status") @ProtoNumber(12) var approvalStatus: UInt? = null,
    @SerialName("video_source") @ProtoNumber(13) var videoSource: UInt? = null,
    @SerialName("media_quality_rank") @ProtoNumber(14) var mediaQualityRank: UInt? = null,
    @SerialName("media_quality_score") @ProtoNumber(15) var mediaQualityScore: Float? = null,
    @SerialName("md5") @ProtoNumber(16) var videoMD5: String? = null,
    @SerialName("is_quic") @ProtoNumber(17) var isQuic: UInt? = null,
    @SerialName("orientation") @ProtoNumber(18) var orientation: Int? = null,
    @SerialName("cover") @ProtoNumber(19) var cover: StImage? = null,
    @SerialName("pattern_id") @ProtoNumber(20) var patternId: String? = null,
    @SerialName("display_index") @ProtoNumber(21) var displayIndex: UInt? = null,
)

@Serializable
data class StRichText(
    @SerialName("contents") @ProtoNumber(1) var contents: List<StRichTextContent>? = null,
    @SerialName("images") @ProtoNumber(2) var images: List<StImage>? = null,
)

@Serializable
data class StRichTextContent(
    @SerialName("type") @ProtoNumber(1) var type: Int? = null,
    @SerialName("pattern_id") @ProtoNumber(2) var patternId: String? = null,
    @SerialName("text") @ProtoNumber(3) var textContent: StRichTextTextContent? = null,
    @SerialName("at") @ProtoNumber(4) var atContent: StRichTextAtContent? = null,
    @SerialName("url") @ProtoNumber(5) var urlContent: StRichTextURLContent? = null,
    @SerialName("emoji") @ProtoNumber(6) var emojiContent: StRichTextEmojiContent? = null,
    @SerialName("channel") @ProtoNumber(7) var channelContent: StRichTextChannelContent? = null,
    @SerialName("guild") @ProtoNumber(8) var guildContent: StRichTextGuildContent? = null,
    @SerialName("icon") @ProtoNumber(9) var iconContent: StRichTextIconContent? = null,
)

@Serializable
data class StRichTextIconContent(
    @SerialName("url") @ProtoNumber(1) val url: String? = null
)
@Serializable
data class StRichTextGuildContent(
    @SerialName("channel_info") @ProtoNumber(1) val channelInfo: StChannelInfo? = null
)

@Serializable
data class StRichTextChannelContent(
    @SerialName("channel_info") @ProtoNumber(1) val channelInfo: StChannelInfo? = null
)

@Serializable
data class StChannelInfo(
    //@SerialName("sign") @ProtoNumber(1) var sign: String? = null,
    @SerialName("name")
    @ProtoNumber(2) var name: String? = null,
    @SerialName("icon_url")
    @ProtoNumber(3) var iconUrl: String? = null,
    @SerialName("type")
    @ProtoNumber(4) var privateType: Int? = null,
    @SerialName("guild_name")
    @ProtoNumber(5) var guildName: String? = null,
    @SerialName("hot_icon")
    @ProtoNumber(6) var hotIcon: String? = null,
    @SerialName("hot_index")
    @ProtoNumber(7) var hotIndex: UInt? = null,
)

@Serializable
data class StRichTextEmojiContent(
    @ProtoNumber(1) var id: String? = null,
    @ProtoNumber(2) var type: String? = null,
    @ProtoNumber(3) var name: String? = null,
    @ProtoNumber(4) var url: String? = null,
)

@Serializable
data class StRichTextURLContent(
    @ProtoNumber(1) var url: String? = null,
    @SerialName("display") @ProtoNumber(2) var displayText: String? = null,
    @ProtoNumber(3) var type: Int? = null,
    @SerialName("play_url") @ProtoNumber(4) var playUrl: String? = null,
    @SerialName("platform") @ProtoNumber(5) var thirdPlatform: ThirdPlatform? = null,
    @SerialName("third_video_info") @ProtoNumber(6) var thirdVideoInfo: CommThirdVideoInfo? = null,
)

@Serializable
data class CommThirdVideoInfo(
    @SerialName("cover") @ProtoNumber(1) val cover: String? = null,
    @SerialName("duration") @ProtoNumber(2) val duration: ULong? = null,
)

@Serializable
data class ThirdPlatform(
    @ProtoNumber(1) var icon: String? = null,
    @ProtoNumber(2) var name: String? = null,
)

@Serializable
data class StRichTextTextContent(
    @ProtoNumber(1) var text: String? = null
)

@Serializable
data class StRichTextAtContent(
    @ProtoNumber(1) var type: Int? = null,
    @SerialName("guild_info") @ProtoNumber(2) var guildInfo: GuildInfo? = null,
    @SerialName("role_info") @ProtoNumber(3) var roleGroupId: RoleGroupInfo? = null,
    @ProtoNumber(4) var user: StUser? = null,
)

@Serializable
data class StUser(
    @ProtoNumber(1) var id: String? = null,
    @ProtoNumber(2) var nick: String? = null,
    @ProtoNumber(3) var icon: StIconInfo? = null,
    @ProtoNumber(4) var desc: String? = null,
    @SerialName("follow_state") @ProtoNumber(5) var followState: UInt? = null,
    @ProtoNumber(6) var type: UInt? = null,
    @ProtoNumber(7) var sex: UInt? = null,
    @ProtoNumber(8) var birthday: ULong? = null,
    @ProtoNumber(9) var school: String? = null,
    @ProtoNumber(11) var location: String? = null,
    //@ProtoNumber(12) var busiData: ByteArray? = null,
    @SerialName("frd") @ProtoNumber(13) var frdState: UInt? = null,
    @SerialName("relation_state") @ProtoNumber(14) var relationState: UInt? = null,
    @SerialName("black_state") @ProtoNumber(15) var blackState: UInt? = null,
    @ProtoNumber(16) var medal: StTagMedalInfo? = null,
    @ProtoNumber(17) var constellation: Int? = null,
    @SerialName("jump_url") @ProtoNumber(18) var jumpUrl: String? = null,
    @SerialName("location_code") @ProtoNumber(19) var locationCode: String? = null,
    @SerialName("third_id") @ProtoNumber(20) var thirdId: String? = null,
    @ProtoNumber(21) var company: String? = null,
    @SerialName("certification_desc") @ProtoNumber(22) var certificationDesc: String? = null,
    @SerialName("desc_type") @ProtoNumber(23) var descType: UInt? = null,
    //@ProtoNumber(24) var channelUserInfo: Any? = null,
    //@SerialName("login_id") @ProtoNumber(25) var loginId: String? = null,
    @ProtoNumber(26) var uin: ULong? = null,
    @SerialName("nick_flag") @ProtoNumber(27) var nickFlag: UInt? = null,
    @SerialName("manage_tag") @ProtoNumber(28) var manageTag: CustomManageTag? = null,
    //@SerialName("personal_medal") @ProtoNumber(29) var personalMedal: PersonalMedal? = null,
)

@Serializable
data class PersonalMedal(
    @SerialName("start") @ProtoNumber(1) val startTime: ULong? = null,
    @SerialName("end") @ProtoNumber(2) val endTime: ULong? = null,
    @ProtoNumber(3) var url: String? = null,
)

@Serializable
data class StTagMedalInfo(
    @SerialName("id") @ProtoNumber(1) val tagId: ULong? = null,
    @SerialName("name") @ProtoNumber(2) val tagName: String? = null,
    @ProtoNumber(3) val rank: ULong? = null,
)

@Serializable
data class CustomManageTag(
    @ProtoNumber(3) val color: UInt? = null,
    @SerialName("name") @ProtoNumber(2) val tagName: String? = null,
)

@Serializable
data class StIconInfo(
    //@SerialName("url_40") @ProtoNumber(1) var iconUrl40: String? = null,
    //@SerialName("url_100") @ProtoNumber(2) var iconUrl100: String? = null,
    //@SerialName("url_140") @ProtoNumber(3) var iconUrl140: String? = null,
    //@SerialName("url_640") @ProtoNumber(4) var iconUrl640: String? = null,
    @SerialName("url") @ProtoNumber(5) var iconUrl: String? = null,
)

@Serializable
data class RoleGroupInfo(
    @SerialName("role") @ProtoNumber(1) var roleId: ULong? = null,
    @ProtoNumber(2) var name: String? = null,
    @ProtoNumber(3) var color: ULong? = null,
)

@Serializable
data class GuildInfo(
    @SerialName("guild_id") @ProtoNumber(1) var guildId: ULong? = null,
    @ProtoNumber(2) var name: String? = null,
    @SerialName("join_time") @ProtoNumber(3) var joinTime: ULong? = null,
)

@Serializable
data class StImage(
    @ProtoNumber(1) var width: UInt? = null,
    @ProtoNumber(2) var height: UInt? = null,
    @ProtoNumber(3) var picUrl: String? = null,
    @SerialName("image_urls") @ProtoNumber(4) var vecImageUrl: List<StImageUrl>? = null,
    @SerialName("id") @ProtoNumber(5) var picId: String? = null,
    //@ProtoNumber(6) var busiData: Any? = null,
    @SerialName("md5") @ProtoNumber(7) var imageMD5: String? = null,
    @SerialName("layer_pic_url") @ProtoNumber(8) var layerPicUrl: String? = null,
    @SerialName("pattern_id") @ProtoNumber(9) var patternId: String? = null,
    @SerialName("display_index") @ProtoNumber(10) var displayIndex: Int? = null,
    @SerialName("size") @ProtoNumber(11) var origSize: UInt? = null,
    @SerialName("is_original") @ProtoNumber(12) var isOrig: Boolean? = null,
    @SerialName("is_gif") @ProtoNumber(13) var isGif: Boolean? = null,
)

@Serializable
data class StImageUrl(
    @SerialName("level_type") @ProtoNumber(1) var levelType: UInt? = null,
    @ProtoNumber(2) var url: String? = null,
    @ProtoNumber(3) var width: UInt? = null,
    @ProtoNumber(4) var height: UInt? = null,
    //@ProtoNumber(5) var busiData: Any? = null,
)