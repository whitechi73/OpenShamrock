package protobuf.msg

import com.google.protobuf.Internal.EMPTY_BYTE_ARRAY
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class MsgBody(
    @ProtoNumber(1) var richText: RichText,
    //@ProtoNumber(2) var msgContent: ByteArray = EMPTY_BYTE_ARRAY,
    //@/ProtoNumber(3) var msgEncryptContent: ByteArray = EMPTY_BYTE_ARRAY,
)

@Serializable
data class RichText(
    //@ProtoNumber(1) var attr: Attr? = null,
    @ProtoNumber(2) var elems: ArrayList<Elem>? = null,
    //@ProtoNumber(3) var not_online_file: NotOnlineFile? = null,
    //@ProtoNumber(4) var ptt: Ptt? = null,
    //@ProtoNumber(5) var tmp_ptt: TmpPtt? = null,
    //@ProtoNumber(6) var trans_211_tmp_msg: Trans211TmpMsg? = null,
)

@Serializable
data class Elem(
    /*@ProtoNumber(1) var text: TextMsg? = null,
    @ProtoNumber(2) var face: FaceMsg? = null,
    @ProtoNumber(3) var online_image: OnlineImage? = null,
    @ProtoNumber(4) var not_online_image: NotOnlineImage? = null,
    @ProtoNumber(5) var trans_elem_info: TransElem? = null,
    @ProtoNumber(6) var market_face: MarketFace? = null,
    @ProtoNumber(7) var elem_flags: ElemFlags? = null,
    @ProtoNumber(8) var customFace: CustomFace? = null,
    @ProtoNumber(9) var elem_flags2: ElemFlags2? = null,
    @ProtoNumber(10) var fun_face: FunFace? = null,
    @ProtoNumber(11) var secret_file: SecretFileMsg? = null,
    @ProtoNumber(12) var rich_msg: RichMsg? = null,
    @ProtoNumber(13) var group_file: GroupFile? = null,
    @ProtoNumber(14) var pub_group: PubGroup? = null,
    @ProtoNumber(15) var market_trans: MarketTrans? = null,
    @ProtoNumber(16) var extra_info: ExtraInfo? = null,
    @ProtoNumber(17) var shake_window: ShakeWindow? = null,
    @ProtoNumber(18) var pub_account: PubAccount? = null,
    @ProtoNumber(19) var video_file: VideoFile? = null,
    @ProtoNumber(20) var tips_info: TipsInfo? = null,
    @ProtoNumber(21) var anon_group_msg: AnonymousGroupMsg? = null,
    @ProtoNumber(22) var qq_live_old: QQLiveOld? = null,
    @ProtoNumber(23) var life_online: LifeOnlineAccount? = null,
    @ProtoNumber(24) var qqwallet_msg: QQWalletMsg? = null,
    @ProtoNumber(25) var crm_elem: CrmElem? = null,
    @ProtoNumber(26) var conference_tips_info: ConferenceTipsInfo? = null,
    @ProtoNumber(27) var redbag_info: RedBagInfo? = null,
    @ProtoNumber(28) var low_version_tips: LowVersionTips? = null,
    @ProtoNumber(29) var bankcode_ctrl_info: ByteArray = EMPTY_BYTE_ARRAY,
    @ProtoNumber(30) var near_by_msg: NearByMessageType? = null,
    @ProtoNumber(31) var custom_elem: CustomElem? = null,
    @ProtoNumber(32) var location_info: LocationInfo? = null,
    @ProtoNumber(33) var pub_acc_info: PubAccInfo? = null,
    @ProtoNumber(34) var small_emoji: SmallEmoji? = null,
    @ProtoNumber(35) var fsj_msg_elem: FSJMessageElem? = null,
    @ProtoNumber(36) var ark_app: ArkAppElem? = null,
*/
    @ProtoNumber(37) var generalFlags: GeneralFlags? = null,
/*
    @ProtoNumber(38) var hc_flash_pic: CustomFace? = null,
    @ProtoNumber(39) var deliver_gift_msg: DeliverGiftMsg? = null,
    @ProtoNumber(40) var bitapp_msg: BitAppMsg? = null,
    @ProtoNumber(41) var open_qq_data: OpenQQData? = null,
    @ProtoNumber(42) var apollo_msg: ApolloActMsg? = null,
    @ProtoNumber(43) var group_pub_acc_info: GroupPubAccountInfo? = null,
    @ProtoNumber(44) var bless_msg: BlessingMessage? = null,
    @ProtoNumber(45) var src_msg: SourceMsg? = null,
    @ProtoNumber(46) var lola_msg: LolaMsg? = null,
    @ProtoNumber(47) var group_business_msg: GroupBusinessMsg? = null,
    @ProtoNumber(48) var msg_workflow_notify: WorkflowNotifyMsg? = null,
    @ProtoNumber(49) var pat_elem: PatsElem? = null,
    @ProtoNumber(50) var group_post_elem: GroupPostElem? = null,
    @ProtoNumber(51) var light_app: LightAppElem? = null,
    @ProtoNumber(52) var eim_info: EIMInfo? = null,
    @ProtoNumber(53) var commonElem: CommonElem? = null,*/
)

@Serializable
data class GeneralFlags(
    @ProtoNumber(1) var uint32_bubble_diy_text_id: UInt = 0u,
    @ProtoNumber(2) var uint32_group_flag_new: UInt = 0u,
    @ProtoNumber(3) var uint64_uin: ULong = 0u,
    @ProtoNumber(4) var bytes_rp_id: ByteArray = EMPTY_BYTE_ARRAY,
    @ProtoNumber(5) var uint32_prp_fold: UInt = 0u,
    @ProtoNumber(6) var long_text_flag: UInt = 0u,
    @ProtoNumber(7) var long_text_resid: ByteArray = EMPTY_BYTE_ARRAY,
    @ProtoNumber(8) var uint32_group_type: UInt = 0u,
    @ProtoNumber(9) var uint32_to_uin_flag: UInt = 0u,
    @ProtoNumber(10) var uint32_glamour_level: UInt = 0u,
    @ProtoNumber(11) var uint32_member_level: UInt = 0u,
    @ProtoNumber(12) var uint64_group_rank_seq: ULong = 0u,
    @ProtoNumber(13) var uint32_olympic_torch: UInt = 0u,
    @ProtoNumber(14) var babyq_guide_msg_cookie: ByteArray = EMPTY_BYTE_ARRAY,
    @ProtoNumber(15) var uin32_expert_flag: UInt = 0u,
    @ProtoNumber(16) var uint32_bubble_sub_id: UInt = 0u,
    @ProtoNumber(17) var pendantId: ULong = 0u,
    @ProtoNumber(18) var bytes_rp_index: ByteArray = EMPTY_BYTE_ARRAY,
    @ProtoNumber(19) var reserve: ByteArray = EMPTY_BYTE_ARRAY,
)