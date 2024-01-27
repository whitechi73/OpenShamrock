package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class structmsg {
    public static class  ReqSystemMsgAction extends MessageMicro< ReqSystemMsgAction> {
        static final FieldMap __fieldMap__;

        public  SystemMsgActionInfo action_info = new  SystemMsgActionInfo();

        public final PBUInt32Field group_msg_type = PBField.initUInt32(0);

        public final PBUInt32Field language = PBField.initUInt32(0);

        public final PBUInt64Field msg_seq = PBField.initUInt64(0L);

        public final PBEnumField msg_type = PBField.initEnum(1);

        public final PBUInt64Field req_uin = PBField.initUInt64(0L);

        public final PBUInt32Field src_id = PBField.initUInt32(0);

        public final PBUInt32Field sub_src_id = PBField.initUInt32(0);

        public final PBUInt32Field sub_type = PBField.initUInt32(0);

        static {
            Integer integer = Integer.valueOf(0);
            Long long_ = Long.valueOf(0L);
            __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 72 }, new String[] {
                    "msg_type", "msg_seq", "req_uin", "sub_type", "src_id", "sub_src_id", "group_msg_type", "action_info", "language"
            }, new Object[] { Integer.valueOf(1), long_, long_, integer, integer, integer, integer, null, integer },  ReqSystemMsgAction.class);
        }
    }
    
    public static class AddFrdSNInfo extends MessageMicro<AddFrdSNInfo> {
        static final FieldMap __fieldMap__;

        public final PBUInt32Field uint32_not_see_dynamic = PBField.initUInt32(0);

        public final PBUInt32Field uint32_set_sn = PBField.initUInt32(0);

        static {
            Integer integer = Integer.valueOf(0);
            __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_not_see_dynamic", "uint32_set_sn" }, new Object[] { integer, integer },  AddFrdSNInfo.class);
        }
    }

    public static class FlagInfo extends MessageMicro< FlagInfo> {
        static final FieldMap __fieldMap__;

        public final PBUInt32Field FrdMsg_Discuss2ManyChat = PBField.initUInt32(0);

        public final PBUInt32Field FrdMsg_GetBusiCard = PBField.initUInt32(0);

        public final PBUInt32Field FrdMsg_NeedWaitingMsg = PBField.initUInt32(0);

        public final PBUInt32Field FrdMsg_uint32_need_all_unread_msg = PBField.initUInt32(0);

        public final PBUInt32Field GrpMsg_GetC2cInviteJoinGroup = PBField.initUInt32(0);

        public final PBUInt32Field GrpMsg_GetDisbandedByAdmin = PBField.initUInt32(0);

        public final PBUInt32Field GrpMsg_GetOfficialAccount = PBField.initUInt32(0);

        public final PBUInt32Field GrpMsg_GetPayInGroup = PBField.initUInt32(0);

        public final PBUInt32Field GrpMsg_HiddenGrp = PBField.initUInt32(0);

        public final PBUInt32Field GrpMsg_Kick_Admin = PBField.initUInt32(0);

        public final PBUInt32Field GrpMsg_NeedAutoAdminWording = PBField.initUInt32(0);

        public final PBUInt32Field GrpMsg_NotAllowJoinGrp_InviteNotFrd = PBField.initUInt32(0);

        public final PBUInt32Field GrpMsg_WordingDown = PBField.initUInt32(0);

        public final PBUInt32Field GrpMsg_get_quit_pay_group_msg_flag = PBField.initUInt32(0);

        public final PBUInt32Field GrpMsg_get_transfer_group_msg_flag = PBField.initUInt32(0);

        public final PBUInt32Field GrpMsg_mask_invite_auto_join = PBField.initUInt32(0);

        public final PBUInt32Field GrpMsg_support_invite_auto_join = PBField.initUInt32(0);

        static {
            Integer integer = Integer.valueOf(0);
            __fieldMap__ = MessageMicro.initFieldMap(new int[] {
                    8, 16, 24, 32, 40, 48, 56, 64, 72, 80,
                    88, 96, 104, 112, 120, 128, 136 }, new String[] {
                    "GrpMsg_Kick_Admin", "GrpMsg_HiddenGrp", "GrpMsg_WordingDown", "FrdMsg_GetBusiCard", "GrpMsg_GetOfficialAccount", "GrpMsg_GetPayInGroup", "FrdMsg_Discuss2ManyChat", "GrpMsg_NotAllowJoinGrp_InviteNotFrd", "FrdMsg_NeedWaitingMsg", "FrdMsg_uint32_need_all_unread_msg",
                    "GrpMsg_NeedAutoAdminWording", "GrpMsg_get_transfer_group_msg_flag", "GrpMsg_get_quit_pay_group_msg_flag", "GrpMsg_support_invite_auto_join", "GrpMsg_mask_invite_auto_join", "GrpMsg_GetDisbandedByAdmin", "GrpMsg_GetC2cInviteJoinGroup" }, new Object[] {
                    integer, integer, integer, integer, integer, integer, integer, integer, integer, integer,
                    integer, integer, integer, integer, integer, integer, integer },  FlagInfo.class);
        }
    }

    public static class FriendInfo extends MessageMicro< FriendInfo> {
        static final FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_joint_friend", "msg_blacklist" }, new Object[] { "", "" },  FriendInfo.class);

        public final PBStringField msg_blacklist = PBField.initString("");

        public final PBStringField msg_joint_friend = PBField.initString("");
    }

    public static class GroupInfo extends MessageMicro< GroupInfo> {
        static final FieldMap __fieldMap__;

        public final PBUInt32Field display_action = PBField.initUInt32(0);

        public final PBUInt32Field group_auth_type = PBField.initUInt32(0);

        public final PBStringField msg_alert = PBField.initString("");

        public final PBStringField msg_detail_alert = PBField.initString("");

        public final PBStringField msg_other_admin_done = PBField.initString("");

        public final PBUInt32Field uint32_app_privilege_flag = PBField.initUInt32(0);

        static {
            Integer integer = Integer.valueOf(0);
            __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48 }, new String[] { "group_auth_type", "display_action", "msg_alert", "msg_detail_alert", "msg_other_admin_done", "uint32_app_privilege_flag" }, new Object[] { integer, integer, "", "", "", integer },  GroupInfo.class);
        }
    }

    public static class MsgInviteExt extends MessageMicro< MsgInviteExt> {
        static final FieldMap __fieldMap__;

        public final PBUInt32Field uint32_src_type = PBField.initUInt32(0);

        public final PBUInt32Field uint32_wait_state = PBField.initUInt32(0);

        public final PBUInt64Field uint64_src_code = PBField.initUInt64(0L);

        static {
            Integer integer = Integer.valueOf(0);
            __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_src_type", "uint64_src_code", "uint32_wait_state" }, new Object[] { integer, Long.valueOf(0L), integer },  MsgInviteExt.class);
        }
    }

    public static class MsgPayGroupExt extends MessageMicro< MsgPayGroupExt> {
        static final FieldMap __fieldMap__;

        public final PBUInt64Field uint64_join_grp_time = PBField.initUInt64(0L);

        public final PBUInt64Field uint64_quit_grp_time = PBField.initUInt64(0L);

        static {
            Long long_ = Long.valueOf(0L);
            __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_join_grp_time", "uint64_quit_grp_time" }, new Object[] { long_, long_ },  MsgPayGroupExt.class);
        }
    }

    public static class ReqNextSystemMsg extends MessageMicro< ReqNextSystemMsg> {
        static final FieldMap __fieldMap__;

        public final PBEnumField checktype = PBField.initEnum(1);

        public  FlagInfo flag = new  FlagInfo();

        public final PBUInt64Field following_friend_seq = PBField.initUInt64(0L);

        public final PBUInt64Field following_group_seq = PBField.initUInt64(0L);

        public final PBUInt64Field friend_msg_type_flag = PBField.initUInt64(0L);

        public final PBUInt32Field language = PBField.initUInt32(0);

        public final PBUInt32Field msg_num = PBField.initUInt32(0);

        public final PBUInt32Field uint32_need_uid = PBField.initUInt32(0);

        public final PBUInt32Field uint32_req_msg_type = PBField.initUInt32(0);

        public final PBUInt32Field version = PBField.initUInt32(0);

        static {
            Integer integer = Integer.valueOf(0);
            Long long_ = Long.valueOf(0L);
            __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 64, 72, 128 }, new String[] { "msg_num", "following_friend_seq", "following_group_seq", "checktype", "flag", "language", "version", "friend_msg_type_flag", "uint32_req_msg_type", "uint32_need_uid" }, new Object[] { integer, long_, long_, Integer.valueOf(1), null, integer, integer, long_, integer, integer },  ReqNextSystemMsg.class);
        }
    }

    public static class ReqSystemMsgNew extends MessageMicro< ReqSystemMsgNew> {
        static final FieldMap __fieldMap__;

        public final PBEnumField checktype = PBField.initEnum(1);

        public  FlagInfo flag = new  FlagInfo();

        public final PBUInt64Field friend_msg_type_flag = PBField.initUInt64(0L);

        public final PBBoolField is_get_frd_ribbon = PBField.initBool(true);

        public final PBBoolField is_get_grp_ribbon = PBField.initBool(true);

        public final PBUInt32Field language = PBField.initUInt32(0);

        public final PBUInt64Field latest_friend_seq = PBField.initUInt64(0L);

        public final PBUInt64Field latest_group_seq = PBField.initUInt64(0L);

        public final PBUInt32Field msg_num = PBField.initUInt32(0);

        public final PBUInt32Field uint32_need_uid = PBField.initUInt32(0);

        public final PBUInt32Field uint32_req_msg_type = PBField.initUInt32(0);

        public final PBUInt32Field version = PBField.initUInt32(0);

        static {
            Integer integer = Integer.valueOf(0);
            Long long_ = Long.valueOf(0L);
            Boolean bool = Boolean.TRUE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[] {
                    8, 16, 24, 32, 40, 50, 56, 64, 72, 80,
                    88, 128 }, new String[] {
                    "msg_num", "latest_friend_seq", "latest_group_seq", "version", "checktype", "flag", "language", "is_get_frd_ribbon", "is_get_grp_ribbon", "friend_msg_type_flag",
                    "uint32_req_msg_type", "uint32_need_uid" }, new Object[] {
                    integer, long_, long_, integer, Integer.valueOf(1), null, integer, bool, bool, long_,
                    integer, integer },  ReqSystemMsgNew.class);
        }
    }
    
    public static class ReqSystemMsgRead extends MessageMicro< ReqSystemMsgRead> {
        static final FieldMap __fieldMap__;

        public final PBEnumField checktype = PBField.initEnum(1);

        public final PBUInt64Field latest_friend_seq = PBField.initUInt64(0L);

        public final PBUInt64Field latest_group_seq = PBField.initUInt64(0L);

        public final PBUInt32Field type = PBField.initUInt32(0);

        public final PBUInt32Field uint32_req_msg_type = PBField.initUInt32(0);

        static {
            Long long_ = Long.valueOf(0L);
            Integer integer = Integer.valueOf(0);
            __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "latest_friend_seq", "latest_group_seq", "type", "checktype", "uint32_req_msg_type" }, new Object[] { long_, long_, integer, Integer.valueOf(1), integer },  ReqSystemMsgRead.class);
        }
    }

    public static class RspHead extends MessageMicro< RspHead> {
        static final FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "msg_fail" }, new Object[] { Integer.valueOf(0), "" },  RspHead.class);

        public final PBStringField msg_fail = PBField.initString("");

        public final PBInt32Field result = PBField.initInt32(0);
    }

    public static class RspNextSystemMsg extends MessageMicro< RspNextSystemMsg> {
        static final FieldMap __fieldMap__;

        public final PBStringField bytes_game_nick = PBField.initString("");

        public final PBBytesField bytes_undecid_for_qim = PBField.initBytes(ByteStringMicro.EMPTY);

        public final PBEnumField checktype = PBField.initEnum(1);

        public final PBUInt64Field following_friend_seq = PBField.initUInt64(0L);

        public final PBUInt64Field following_group_seq = PBField.initUInt64(0L);

        public  RspHead head = new  RspHead();

        public final PBRepeatMessageField< StructMsg> msgs = PBField.initRepeatMessage( StructMsg.class);

        public final PBUInt32Field uint32_un_read_count3 = PBField.initUInt32(0);

        static {
            Long long_ = Long.valueOf(0L);
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 802, 810, 816 }, new String[] { "head", "msgs", "following_friend_seq", "following_group_seq", "checktype", "bytes_game_nick", "bytes_undecid_for_qim", "uint32_un_read_count3" }, new Object[] { null, null, long_, long_, Integer.valueOf(1), "", byteStringMicro, Integer.valueOf(0) },  RspNextSystemMsg.class);
        }
    }

    public static class RspSystemMsgAction extends MessageMicro< RspSystemMsgAction> {
        static final FieldMap __fieldMap__;

        public  RspHead head = new  RspHead();

        public final PBStringField msg_detail = PBField.initString("");

        public final PBStringField msg_invalid_decided = PBField.initString("");

        public final PBUInt32Field remark_result = PBField.initUInt32(0);

        public final PBUInt32Field type = PBField.initUInt32(0);

        static {
            Integer integer = Integer.valueOf(0);
            __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 42, 48 }, new String[] { "head", "msg_detail", "type", "msg_invalid_decided", "remark_result" }, new Object[] { null, "", integer, "", integer },  RspSystemMsgAction.class);
        }
    }

    public static class RspSystemMsgNew extends MessageMicro< RspSystemMsgNew> {
        static final FieldMap __fieldMap__;

        public final PBStringField bytes_game_nick = PBField.initString("");

        public final PBBytesField bytes_undecid_for_qim = PBField.initBytes(ByteStringMicro.EMPTY);

        public final PBEnumField checktype = PBField.initEnum(1);

        public final PBUInt64Field following_friend_seq = PBField.initUInt64(0L);

        public final PBUInt64Field following_group_seq = PBField.initUInt64(0L);

        public final PBRepeatMessageField< StructMsg> friendmsgs = PBField.initRepeatMessage( StructMsg.class);

        public final PBRepeatMessageField< StructMsg> groupmsgs = PBField.initRepeatMessage( StructMsg.class);

        public final PBStringField grp_msg_display = PBField.initString("");

        public  RspHead head = new  RspHead();

        public final PBUInt64Field latest_friend_seq = PBField.initUInt64(0L);

        public final PBUInt64Field latest_group_seq = PBField.initUInt64(0L);

        public final PBStringField msg_display = PBField.initString("");

        public  StructMsg msg_ribbon_friend = new  StructMsg();

        public  StructMsg msg_ribbon_group = new  StructMsg();

        public final PBUInt32Field uint32_has_suspicious_flag = PBField.initUInt32(0);

        public final PBUInt32Field uint32_over = PBField.initUInt32(0);

        public final PBUInt32Field uint32_un_read_count3 = PBField.initUInt32(0);

        public final PBUInt32Field unread_friend_count = PBField.initUInt32(0);

        public final PBUInt32Field unread_group_count = PBField.initUInt32(0);

        static {
            Integer integer = Integer.valueOf(0);
            Long long_ = Long.valueOf(0L);
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[] {
                    10, 16, 24, 32, 40, 48, 56, 74, 82, 90,
                    98, 106, 114, 120, 160, 802, 810, 816, 824 }, new String[] {
                    "head", "unread_friend_count", "unread_group_count", "latest_friend_seq", "latest_group_seq", "following_friend_seq", "following_group_seq", "friendmsgs", "groupmsgs", "msg_ribbon_friend",
                    "msg_ribbon_group", "msg_display", "grp_msg_display", "uint32_over", "checktype", "bytes_game_nick", "bytes_undecid_for_qim", "uint32_un_read_count3", "uint32_has_suspicious_flag" }, new Object[] {
                    null, integer, integer, long_, long_, long_, long_, null, null, null,
                    null, "", "", integer, Integer.valueOf(1), "", byteStringMicro, integer, integer },  RspSystemMsgNew.class);
        }
    }

    public static class RspSystemMsgRead extends MessageMicro< RspSystemMsgRead> {
        static final FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "head", "type", "checktype" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(1) },  RspSystemMsgRead.class);

        public final PBEnumField checktype = PBField.initEnum(1);

        public  RspHead head = new  RspHead();

        public final PBUInt32Field type = PBField.initUInt32(0);
    }

    public static class StructMsg extends MessageMicro< StructMsg> {
        static final FieldMap __fieldMap__;

        public  SystemMsg msg = new  SystemMsg();

        public final PBUInt64Field msg_seq = PBField.initUInt64(0L);

        public final PBUInt64Field msg_time = PBField.initUInt64(0L);

        public final PBEnumField msg_type = PBField.initEnum(1);

        public final PBUInt64Field req_uin = PBField.initUInt64(0L);

        public final PBUInt32Field uint32_unread_flag = PBField.initUInt32(0);

        public final PBUInt32Field version = PBField.initUInt32(0);

        static {
            Integer integer = Integer.valueOf(0);
            Long long_ = Long.valueOf(0L);
            __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 402 }, new String[] { "version", "msg_type", "msg_seq", "msg_time", "req_uin", "uint32_unread_flag", "msg" }, new Object[] { integer, Integer.valueOf(1), long_, long_, long_, integer, null },  StructMsg.class);
        }
    }

    public static class SystemMsg extends MessageMicro< SystemMsg> {
        static final FieldMap __fieldMap__;

        public final PBUInt64Field action_uin = PBField.initUInt64(0L);

        public final PBStringField action_uin_nick;

        public final PBBytesField action_uin_qq_nick;

        public final PBBytesField action_uin_remark;

        public final PBRepeatMessageField< SystemMsgAction> actions = PBField.initRepeatMessage( SystemMsgAction.class);

        public final PBUInt64Field actor_uin = PBField.initUInt64(0L);

        public final PBStringField actor_uin_nick;

        public final PBBytesField bytes_addtion;

        public final PBBytesField bytes_game_msg;

        public final PBBytesField bytes_game_nick;

        public final PBBytesField bytes_name_more;

        public final PBBytesField bytes_source_desc;

        public final PBBytesField bytes_transparent_group_notify;

        public final PBBytesField bytes_warning_tips;

        public final PBUInt32Field card_switch;

        public final PBUInt64Field clone_uin = PBField.initUInt64(0L);

        public final PBStringField clone_uin_nick;

        public final PBBytesField eim_group_id_name;

        public  FriendInfo friend_info = new  FriendInfo();

        public final PBUInt64Field group_code = PBField.initUInt64(0L);

        public final PBUInt32Field group_ext_flag;

        public  GroupInfo group_info = new  GroupInfo();

        public final PBUInt32Field group_inviter_role = PBField.initUInt32(0);

        public final PBUInt32Field group_msg_type = PBField.initUInt32(0);

        public final PBStringField group_name;

        public final PBStringField msg_actor_describe = PBField.initString("");

        public final PBStringField msg_additional = PBField.initString("");

        public final PBStringField msg_additional_list = PBField.initString("");

        public final PBStringField msg_decided = PBField.initString("");

        public final PBStringField msg_describe = PBField.initString("");

        public final PBStringField msg_detail;

        public  MsgInviteExt msg_invite_extinfo = new  MsgInviteExt();

        public  MsgPayGroupExt msg_pay_group_extinfo = new  MsgPayGroupExt();

        public final PBStringField msg_qna;

        public final PBStringField msg_source = PBField.initString("");

        public final PBStringField msg_title = PBField.initString("");

        public final PBBytesField pic_url;

        public final PBUInt32Field relation = PBField.initUInt32(0);

        public final PBUInt32Field req_uin_age;

        public final PBBytesField req_uin_business_card;

        public final PBInt32Field req_uin_faceid;

        public final PBUInt32Field req_uin_gender;

        public final PBStringField req_uin_nick;

        public final PBBytesField req_uin_pre_remark;

        public final PBUInt32Field reqsubtype = PBField.initUInt32(0);

        public final PBUInt32Field src_id = PBField.initUInt32(0);

        public final PBUInt32Field sub_src_id = PBField.initUInt32(0);

        public final PBUInt32Field sub_type = PBField.initUInt32(0);

        public final PBStringField uid;

        public final PBUInt32Field uint32_c2c_invite_join_group_flag;

        public final PBUInt32Field uint32_doubt_flag;

        public final PBUInt32Field uint32_group_flagext3;

        public final PBUInt32Field uint32_source_flag = PBField.initUInt32(0);

        public final PBUInt64Field uint64_discuss_uin = PBField.initUInt64(0L);

        public final PBUInt64Field uint64_eim_group_id = PBField.initUInt64(0L);

        public final PBUInt64Field uint64_group_owner_uin;

        static {
            Integer integer = Integer.valueOf(0);
            Long long_ = Long.valueOf(0L);
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[] {
                    8, 18, 26, 34, 42, 50, 56, 64, 74, 80,
                    88, 96, 104, 114, 122, 128, 138, 146, 152, 160,
                    168, 176, 184, 194, 202, 208, 218, 226, 232, 240,
                    248, 258, 266, 274, 282, 400, 410, 418, 426, 434,
                    442, 456, 466, 474, 482, 490, 506, 514, 522, 530,
                    536, 544, 552, 808, 866, 882 }, new String[] {
                    "sub_type", "msg_title", "msg_describe", "msg_additional", "msg_source", "msg_decided", "src_id", "sub_src_id", "actions", "group_code",
                    "action_uin", "group_msg_type", "group_inviter_role", "friend_info", "group_info", "actor_uin", "msg_actor_describe", "msg_additional_list", "relation", "reqsubtype",
                    "clone_uin", "uint64_discuss_uin", "uint64_eim_group_id", "msg_invite_extinfo", "msg_pay_group_extinfo", "uint32_source_flag", "bytes_game_nick", "bytes_game_msg", "uint32_group_flagext3", "uint64_group_owner_uin",
                    "uint32_doubt_flag", "bytes_warning_tips", "bytes_name_more", "bytes_addtion", "bytes_transparent_group_notify", "req_uin_faceid", "req_uin_nick", "group_name", "action_uin_nick", "msg_qna",
                    "msg_detail", "group_ext_flag", "actor_uin_nick", "pic_url", "clone_uin_nick", "req_uin_business_card", "eim_group_id_name", "req_uin_pre_remark", "action_uin_qq_nick", "action_uin_remark",
                    "req_uin_gender", "req_uin_age", "uint32_c2c_invite_join_group_flag", "card_switch", "bytes_source_desc", "uid" }, new Object[] {
                    integer, "", "", "", "", "", integer, integer, null, long_,
                    long_, integer, integer, null, null, long_, "", "", integer, integer,
                    long_, long_, long_, null, null, integer, byteStringMicro, byteStringMicro, integer, long_,
                    integer, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, integer, "", "", "", "",
                    "", integer, "", byteStringMicro, "", byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro,
                    integer, integer, integer, integer, byteStringMicro, "" },  SystemMsg.class);
        }

        public  SystemMsg() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_game_nick = PBField.initBytes(byteStringMicro);
            this.bytes_game_msg = PBField.initBytes(byteStringMicro);
            this.uint32_group_flagext3 = PBField.initUInt32(0);
            this.uint64_group_owner_uin = PBField.initUInt64(0L);
            this.uint32_doubt_flag = PBField.initUInt32(0);
            this.bytes_warning_tips = PBField.initBytes(byteStringMicro);
            this.bytes_name_more = PBField.initBytes(byteStringMicro);
            this.bytes_addtion = PBField.initBytes(byteStringMicro);
            this.bytes_transparent_group_notify = PBField.initBytes(byteStringMicro);
            this.req_uin_faceid = PBField.initInt32(0);
            this.req_uin_nick = PBField.initString("");
            this.group_name = PBField.initString("");
            this.action_uin_nick = PBField.initString("");
            this.msg_qna = PBField.initString("");
            this.msg_detail = PBField.initString("");
            this.group_ext_flag = PBField.initUInt32(0);
            this.actor_uin_nick = PBField.initString("");
            this.pic_url = PBField.initBytes(byteStringMicro);
            this.clone_uin_nick = PBField.initString("");
            this.req_uin_business_card = PBField.initBytes(byteStringMicro);
            this.eim_group_id_name = PBField.initBytes(byteStringMicro);
            this.req_uin_pre_remark = PBField.initBytes(byteStringMicro);
            this.action_uin_qq_nick = PBField.initBytes(byteStringMicro);
            this.action_uin_remark = PBField.initBytes(byteStringMicro);
            this.req_uin_gender = PBField.initUInt32(0);
            this.req_uin_age = PBField.initUInt32(0);
            this.uint32_c2c_invite_join_group_flag = PBField.initUInt32(0);
            this.card_switch = PBField.initUInt32(0);
            this.bytes_source_desc = PBField.initBytes(byteStringMicro);
            this.uid = PBField.initString("");
        }
    }

    public static class SystemMsgAction extends MessageMicro< SystemMsgAction> {
        static final FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "name", "result", "action", "action_info", "detail_name" }, new Object[] { "", "", Integer.valueOf(0), null, "" },  SystemMsgAction.class);

        public final PBUInt32Field action = PBField.initUInt32(0);

        public  SystemMsgActionInfo action_info = new  SystemMsgActionInfo();

        public final PBStringField detail_name = PBField.initString("");

        public final PBStringField name = PBField.initString("");

        public final PBStringField result = PBField.initString("");
    }

    public static class SystemMsgActionInfo extends MessageMicro< SystemMsgActionInfo> {
        static final FieldMap __fieldMap__;

        public  AddFrdSNInfo addFrdSNInfo = new  AddFrdSNInfo();

        public final PBBoolField blacklist = PBField.initBool(false);

        public final PBUInt64Field group_code = PBField.initUInt64(0L);

        public final PBUInt32Field group_id = PBField.initUInt32(0);

        public final PBStringField msg = PBField.initString("");

        public final PBStringField remark = PBField.initString("");

        public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);

        public final PBEnumField type = PBField.initEnum(1);

        public final PBUInt32Field uint32_req_msg_type = PBField.initUInt32(0);

        static {
            Integer integer = Integer.valueOf(0);
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 402, 408, 418, 424, 434, 440 }, new String[] { "type", "group_code", "sig", "msg", "group_id", "remark", "blacklist", "addFrdSNInfo", "uint32_req_msg_type" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), byteStringMicro, "", integer, "", bool, null, integer },  SystemMsgActionInfo.class);
        }
    }
}
