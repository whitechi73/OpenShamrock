package protobuf.msg

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import moe.fuqiuluo.symbols.Protobuf

@Serializable
class PbSendMsgReq(
    @ProtoNumber(1)  var routingHead: RoutingHead,
    @ProtoNumber(2)  var contentHead: ContentHead,
    @ProtoNumber(3)  var msgBody: MsgBody,
    @ProtoNumber(4)  var msgSeq: ULong = 0u,
    @ProtoNumber(5)  var msgRand: UInt = 0u,
    //@ProtoNumber(6)  var sync_cookie: ByteArray = EMPTY_BYTE_ARRAY,
    //@ProtoNumber(7)  var app_share: AppShareInfo? = null,
    @ProtoNumber(8)  var msgVia: UInt = 0u,
    //@ProtoNumber(9)  var data_statist: UInt = 0u,
    //@ProtoNumber(10)  var multi_msg_assist: MultiMsgAssist? = null,
    //@ProtoNumber(11)  var input_notify_info: PbInputNotifyInfo? = null,
    //@ProtoNumber(12)  var msgCtrl: MsgCtrl? = null,
    //@ProtoNumber(13)  var receipt_req: ReceiptReq? = null,
    //@ProtoNumber(14)  var multi_send_seq: UInt = 0u,
): Protobuf<PbSendMsgReq>

@Serializable
data class ContentHead(
    @ProtoNumber(1) var pkg_num: UInt = 0u,
    @ProtoNumber(2) var pkg_index: UInt = 0u,
    @ProtoNumber(3) var div_seq: UInt = 0u,
    @ProtoNumber(4) var auto_reply: UInt = 0u,
)

@Serializable
class RoutingHead(
    @ProtoNumber(1) var c2c: C2C? = null,
    @ProtoNumber(2) var grp: Grp? = null,
    // @ProtoNumber(3) var grp_tmp: GrpTmp? = null,
    //@ProtoNumber(4) var dis: Dis? = null,
    // @ProtoNumber(5) var dis_tmp: DisTmp? = null,
    // @ProtoNumber(6) var wpa_tmp: WPATmp? = null,
    // @ProtoNumber(7) var secret_file: SecretFileHead? = null,
    // @ProtoNumber(8) var public_plat: PublicPlat? = null,
    /*@ProtoNumber(9) var trans_msg: TransMsg? = null,
    @ProtoNumber(10) var address_list: AddressListTmp? = null,
    @ProtoNumber(11) var rich_status_tmp: RichStatusTmp? = null,
    @ProtoNumber(12) var trans_cmd: TransCmd? = null,
    @ProtoNumber(13) var accost_tmp: AccostTmp? = null,
    @ProtoNumber(14) var pub_group_tmp: PubGroupTmp? = null,
    @ProtoNumber(15) var trans_0x211: Trans0x211? = null,
    @ProtoNumber(16) var business_wpa_tmp: BusinessWPATmp? = null,
    @ProtoNumber(17) var auth_tmp: AuthTmp? = null,
    @ProtoNumber(18) var bsns_tmp: BsnsTmp? = null,
    @ProtoNumber(19) var qq_querybusiness_tmp: QQQueryBusinessTmp? = null,
    @ProtoNumber(20) var nearby_dating_tmp: NearByDatingTmp? = null,
    @ProtoNumber(21) var nearby_assistant_tmp: NearByAssistantTmp? = null,
    @ProtoNumber(22) var comm_tmp: CommTmp? = null,*/
)

@Serializable
class C2C(
    @ProtoNumber(1) var to_uin: ULong = 0u,
)

@Serializable
class Grp(
    @ProtoNumber(1) var groupCode: ULong = 0u,
)