package tencent.im.group;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class group_member_info {
    public static class CustomEntry extends MessageMicro<tencent.im.group.group_member_info.CustomEntry> {
        static final FieldMap __fieldMap__;

        public final PBBoolField bool_clicked;

        public final PBBytesField str_name;

        public final PBBytesField str_url;

        public final PBBytesField str_value;

        public final PBUInt64Field uint64_report_id;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40 }, new String[] { "str_name", "str_value", "bool_clicked", "str_url", "uint64_report_id" }, new Object[] { byteStringMicro, byteStringMicro, bool, byteStringMicro, Long.valueOf(0L) }, tencent.im.group.group_member_info.CustomEntry.class);
        }

        public CustomEntry() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.str_name = PBField.initBytes(byteStringMicro);
            this.str_value = PBField.initBytes(byteStringMicro);
            this.bool_clicked = PBField.initBool(false);
            this.str_url = PBField.initBytes(byteStringMicro);
            this.uint64_report_id = PBField.initUInt64(0L);
        }
    }

    public static class ErrorInfo extends MessageMicro<tencent.im.group.group_member_info.ErrorInfo> {
        static final FieldMap __fieldMap__;

        public final PBUInt32Field error_code = PBField.initUInt32(0);

        public final PBBytesField error_desc = PBField.initBytes(ByteStringMicro.EMPTY);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "error_code", "error_desc" }, new Object[] { Integer.valueOf(0), byteStringMicro }, tencent.im.group.group_member_info.ErrorInfo.class);
        }
    }

    public static class FlowersEntry extends MessageMicro<tencent.im.group.group_member_info.FlowersEntry> {
        static final FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_flower_count" }, new Object[] { Long.valueOf(0L) }, tencent.im.group.group_member_info.FlowersEntry.class);

        public final PBUInt64Field uint64_flower_count = PBField.initUInt64(0L);
    }

    public static class GBarInfo extends MessageMicro<tencent.im.group.group_member_info.GBarInfo> {
        static final FieldMap __fieldMap__;

        public final PBBytesField bytes_gbar_name;

        public final PBBytesField str_head_portrait;

        public final PBUInt32Field uint32_gbar_id = PBField.initUInt32(0);

        public final PBUInt32Field uint32_uin_lev = PBField.initUInt32(0);

        static {
            Integer integer = Integer.valueOf(0);
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_gbar_id", "uint32_uin_lev", "str_head_portrait", "bytes_gbar_name" }, new Object[] { integer, integer, byteStringMicro, byteStringMicro }, tencent.im.group.group_member_info.GBarInfo.class);
        }

        public GBarInfo() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.str_head_portrait = PBField.initBytes(byteStringMicro);
            this.bytes_gbar_name = PBField.initBytes(byteStringMicro);
        }
    }

    public static class MemberGameInfo extends MessageMicro<tencent.im.group.group_member_info.MemberGameInfo> {
        static final FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "str_game_name", "str_level_name", "str_level_icon", "str_game_font_color", "str_game_background_color", "str_game_url", "str_desc_info" }, new Object[] { "", "", "", "", "", "", "" }, tencent.im.group.group_member_info.MemberGameInfo.class);

        public final PBRepeatField<String> str_desc_info = PBField.initRepeat(PBField.initString(""));

        public final PBStringField str_game_background_color = PBField.initString("");

        public final PBStringField str_game_font_color = PBField.initString("");

        public final PBStringField str_game_name = PBField.initString("");

        public final PBStringField str_game_url = PBField.initString("");

        public final PBStringField str_level_icon = PBField.initString("");

        public final PBStringField str_level_name = PBField.initString("");
    }


    public static class MemberInfo extends MessageMicro<tencent.im.group.group_member_info.MemberInfo> {
        public static final int CONCERN_TYPE_CONCERN = 1;

        public static final int CONCERN_TYPE_GENERAL = 0;

        public static final int CONCERN_TYPE_HATE = 2;

        static final FieldMap __fieldMap__;

        public final PBBoolField bool_is_allow_mod_card;

        public final PBBoolField bool_is_concerned;

        public final PBBoolField bool_is_friend;

        public final PBBoolField bool_is_super_qq;

        public final PBBoolField bool_is_super_vip;

        public final PBBoolField bool_is_vip;

        public final PBBoolField bool_is_year_vip;

        public final PBBoolField bool_location_shared;

        public final PBBytesField bytes_group_honor;

        public final PBBytesField bytes_job;

        public final PBBytesField bytes_phone_num;

        public final PBBytesField bytes_special_title;

        public final PBUInt32Field medal_id;

        public tencent.im.group.group_member_info.FlowersEntry msg_flower_entry;

        public tencent.im.group.group_member_info.MemberGameInfo msg_game_info;

        public group_member_info.TeamEntry msg_team_entry;

//  public group_member_info.RspGroupCardGetStory qqstory_infocard;

        public final PBRepeatMessageField<tencent.im.group.group_member_info.CustomEntry> rpt_msg_custom_enties;

        public final PBRepeatMessageField<tencent.im.group.group_member_info.GBarInfo> rpt_msg_gbar_concerned;

        public final PBBytesField str_card;

        public final PBBytesField str_errmsg;

        public final PBBytesField str_gbar_title;

        public final PBBytesField str_gbar_url;

        public final PBBytesField str_lev;

        public final PBBytesField str_location;

        public final PBBytesField str_nick;

        public final PBBytesField str_remark;

        public final PBUInt32Field uint32_age;

        public final PBUInt32Field uint32_concern_type;

        public final PBUInt32Field uint32_credit;

        public final PBUInt32Field uint32_gbar_cnt;

        public final PBUInt32Field uint32_group_honor_bit;

        public final PBUInt32Field uint32_level;

        public final PBUInt32Field uint32_result = PBField.initUInt32(0);

        public final PBUInt32Field uint32_role;

        public final PBUInt32Field uint32_sex;

        public final PBUInt32Field uint32_special_title_expire_time;

        public final PBUInt32Field uint32_vip_lev;

        public final PBUInt64Field uint64_distance;

        public final PBUInt64Field uint64_join;

        public final PBUInt64Field uint64_last_speak;

        public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);

        static {
            Long long_ = Long.valueOf(0L);
            Integer integer = Integer.valueOf(0);
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[] {
                    8, 16, 26, 32, 42, 48, 56, 66, 72, 82,
                    90, 96, 106, 112, 120, 130, 138, 146, 154, 160,
                    168, 176, 184, 192, 200, 208, 216, 224, 232, 240,
                    250, 256, 266, 274, 282, 290, 296, 306, 312, 322,
                    330, 336 }, new String[] {
                    "uint64_uin", "uint32_result", "str_errmsg", "bool_is_friend", "str_remark", "bool_is_concerned", "uint32_credit", "str_card", "uint32_sex", "str_location",
                    "str_nick", "uint32_age", "str_lev", "uint64_join", "uint64_last_speak", "rpt_msg_custom_enties", "rpt_msg_gbar_concerned", "str_gbar_title", "str_gbar_url", "uint32_gbar_cnt",
                    "bool_is_allow_mod_card", "bool_is_vip", "bool_is_year_vip", "bool_is_super_vip", "bool_is_super_qq", "uint32_vip_lev", "uint32_role", "bool_location_shared", "uint64_distance", "uint32_concern_type",
                    "bytes_special_title", "uint32_special_title_expire_time", "msg_flower_entry", "msg_team_entry", "bytes_phone_num", "bytes_job", "medal_id", "qqstory_infocard", "uint32_level", "msg_game_info",
                    "bytes_group_honor", "uint32_group_honor_bit" }, new Object[] {
                    long_, integer, byteStringMicro, bool, byteStringMicro, bool, integer, byteStringMicro, integer, byteStringMicro,
                    byteStringMicro, integer, byteStringMicro, long_, long_, null, null, byteStringMicro, byteStringMicro, integer,
                    bool, bool, bool, bool, bool, integer, integer, bool, long_, integer,
                    byteStringMicro, integer, null, null, byteStringMicro, byteStringMicro, integer, null, integer, null,
                    byteStringMicro, integer }, tencent.im.group.group_member_info.MemberInfo.class);
        }

        public MemberInfo() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.str_errmsg = PBField.initBytes(byteStringMicro);
            this.bool_is_friend = PBField.initBool(false);
            this.str_remark = PBField.initBytes(byteStringMicro);
            this.bool_is_concerned = PBField.initBool(false);
            this.uint32_credit = PBField.initUInt32(0);
            this.str_card = PBField.initBytes(byteStringMicro);
            this.uint32_sex = PBField.initUInt32(0);
            this.str_location = PBField.initBytes(byteStringMicro);
            this.str_nick = PBField.initBytes(byteStringMicro);
            this.uint32_age = PBField.initUInt32(0);
            this.str_lev = PBField.initBytes(byteStringMicro);
            this.uint64_join = PBField.initUInt64(0L);
            this.uint64_last_speak = PBField.initUInt64(0L);
            this.rpt_msg_custom_enties = PBField.initRepeatMessage(tencent.im.group.group_member_info.CustomEntry.class);
            this.rpt_msg_gbar_concerned = PBField.initRepeatMessage(tencent.im.group.group_member_info.GBarInfo.class);
            this.str_gbar_title = PBField.initBytes(byteStringMicro);
            this.str_gbar_url = PBField.initBytes(byteStringMicro);
            this.uint32_gbar_cnt = PBField.initUInt32(0);
            this.bool_is_allow_mod_card = PBField.initBool(false);
            this.bool_is_vip = PBField.initBool(false);
            this.bool_is_year_vip = PBField.initBool(false);
            this.bool_is_super_vip = PBField.initBool(false);
            this.bool_is_super_qq = PBField.initBool(false);
            this.uint32_vip_lev = PBField.initUInt32(0);
            this.uint32_role = PBField.initUInt32(0);
            this.bool_location_shared = PBField.initBool(false);
            this.uint64_distance = PBField.initUInt64(0L);
            this.uint32_concern_type = PBField.initUInt32(0);
            this.bytes_special_title = PBField.initBytes(byteStringMicro);
            this.uint32_special_title_expire_time = PBField.initUInt32(0);
            this.msg_flower_entry = new tencent.im.group.group_member_info.FlowersEntry();
            this.msg_team_entry = new group_member_info.TeamEntry();
            this.bytes_phone_num = PBField.initBytes(byteStringMicro);
            this.bytes_job = PBField.initBytes(byteStringMicro);
            this.medal_id = PBField.initUInt32(0);
//    this.qqstory_infocard = new group_member_info.RspGroupCardGetStory();
            this.uint32_level = PBField.initUInt32(0);
            this.msg_game_info = new tencent.im.group.group_member_info.MemberGameInfo();
            this.bytes_group_honor = PBField.initBytes(byteStringMicro);
            this.uint32_group_honor_bit = PBField.initUInt32(0);
        }
    }

    public static class ReqBody extends MessageMicro<tencent.im.group.group_member_info.ReqBody> {
        static final FieldMap __fieldMap__;

        public final PBBoolField bool_new_client = PBField.initBool(false);

        public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);

        public final PBUInt32Field uint32_rich_card_name_ver = PBField.initUInt32(0);

        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);

        public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);

        static {
            Long long_ = Long.valueOf(0L);
            Integer integer = Integer.valueOf(0);
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_group_code", "uint64_uin", "bool_new_client", "uint32_client_type", "uint32_rich_card_name_ver" }, new Object[] { long_, long_, bool, integer, integer }, tencent.im.group.group_member_info.ReqBody.class);
        }
    }

    public static class RspBody extends MessageMicro<RspBody> {
        static final FieldMap __fieldMap__;

        public final PBBoolField bool_self_location_shared = PBField.initBool(false);

        public MemberInfo msg_meminfo = new MemberInfo();

        public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);

        public final PBUInt32Field uint32_self_role = PBField.initUInt32(0);

        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);

        static {
            Integer integer = Integer.valueOf(0);
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "uint64_group_code", "uint32_self_role", "msg_meminfo", "bool_self_location_shared", "uint32_group_type" }, new Object[] { Long.valueOf(0L), integer, null, bool, integer }, tencent.im.group.group_member_info.RspBody.class);
        }
    }

    public static class TeamEntry extends MessageMicro<TeamEntry> {
        static final FieldMap __fieldMap__;

        public final PBRepeatField<Long> rpt_uint64_depid;

        public final PBRepeatField<Long> rpt_uint64_self_depid;

        static {
            Long long_ = Long.valueOf(0L);
            __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "rpt_uint64_depid", "rpt_uint64_self_depid" }, new Object[] { long_, long_ }, tencent.im.group.group_member_info.TeamEntry.class);
        }

        public TeamEntry() {
            PBUInt64Field pBUInt64Field = (PBUInt64Field) PBUInt64Field.__repeatHelper__;
            this.rpt_uint64_depid = PBField.initRepeat((PBField)pBUInt64Field);
            this.rpt_uint64_self_depid = PBField.initRepeat((PBField)pBUInt64Field);
        }
    }
}
