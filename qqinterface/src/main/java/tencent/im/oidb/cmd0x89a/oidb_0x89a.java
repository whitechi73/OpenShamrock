package tencent.im.oidb.cmd0x89a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class oidb_0x89a {
    public static class ReqBody extends MessageMicro<ReqBody> {
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public groupinfo st_group_info = new groupinfo();
        public final PBUInt64Field uint64_original_operator_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_req_group_open_appid = PBField.initUInt32(0);
    }

    public static class groupinfo extends MessageMicro<groupinfo> {
        public final PBBytesField bytes_group_school_info;
        //public oidb_0x89a$GroupGeoInfo msg_group_geo_info;
        public final PBRepeatField<ByteStringMicro> rpt_string_group_tag;
        //public oidb_0x89a$GroupCardPrefix st_group_card_prefix;
        //public oidb_0x89a$GroupExInfoOnly st_group_ex_info;
        //public oidb_0x89a$GroupNewGuidelinesInfo st_group_newguidelines;
        public final PBBytesField string_certification_text;
        public final PBBytesField string_group_aio_skin_url;
        public final PBBytesField string_group_answer;
        public final PBBytesField string_group_board_skin_url;
        public final PBBytesField string_group_class_text;
        public final PBBytesField string_group_cover_skin_url;
        public final PBBytesField string_group_finger_memo;
        public final PBBytesField string_group_memo;
        public final PBBytesField string_group_name;
        public final PBBytesField string_group_question;
        public final PBBytesField string_group_rich_finger_memo;
        public final PBUInt32Field uint32_active_member_num;
        public final PBUInt32Field uint32_add_option;
        public final PBUInt32Field uint32_allow_member_invite;
        public final PBUInt32Field uint32_app_privilege_flag;
        public final PBUInt32Field uint32_app_privilege_mask;
        public final PBUInt32Field uint32_certification_type;
        public final PBUInt32Field uint32_group_class_ext;
        public final PBUInt32Field uint32_group_face;
        public final PBUInt32Field uint32_group_flagext3;
        public final PBUInt32Field uint32_group_flagext3_mask;
        public final PBUInt32Field uint32_group_flagext4;
        public final PBUInt32Field uint32_group_flagext4_mask;
        public final PBUInt32Field uint32_group_grade;
        public final PBUInt32Field uint32_group_open_appid;
        public final PBUInt32Field uint32_group_sec_level;
        public final PBUInt32Field uint32_group_sec_level_info;
        public final PBUInt32Field uint32_group_type_flag;
        public final PBUInt32Field uint32_hl_guild_appid;
        public final PBUInt32Field uint32_hl_guild_orgid;
        public final PBUInt32Field uint32_hl_guild_sub_type;
        public final PBUInt32Field uint32_msg_limit_frequency;
        public final PBUInt32Field uint32_no_code_finger_open_flag;
        public final PBUInt32Field uint32_no_finger_open_flag;
        public final PBUInt32Field uint32_shutup_time;
        public final PBUInt64Field uint64_root_id;
        public final PBUInt64Field uint64_subscription_uin;
        public final PBUInt32Field uint32_group_ext_adm_num = PBField.initUInt32(0);
        public final PBUInt32Field uint32_flag = PBField.initUInt32(0);

        public groupinfo() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.string_group_name = PBField.initBytes(byteStringMicro);
            this.string_group_memo = PBField.initBytes(byteStringMicro);
            this.string_group_finger_memo = PBField.initBytes(byteStringMicro);
            this.string_group_aio_skin_url = PBField.initBytes(byteStringMicro);
            this.string_group_board_skin_url = PBField.initBytes(byteStringMicro);
            this.string_group_cover_skin_url = PBField.initBytes(byteStringMicro);
            this.uint32_group_grade = PBField.initUInt32(0);
            this.uint32_active_member_num = PBField.initUInt32(0);
            this.uint32_certification_type = PBField.initUInt32(0);
            this.string_certification_text = PBField.initBytes(byteStringMicro);
            this.string_group_rich_finger_memo = PBField.initBytes(byteStringMicro);
            //this.st_group_newguidelines = new MessageMicro<oidb_0x89a$GroupNewGuidelinesInfo>() { // from class: tencent.im.oidb.cmd0x89a.oidb_0x89a$GroupNewGuidelinesInfo
            //    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"bool_enabled", "string_content"}, new Object[]{Boolean.FALSE, ByteStringMicro.EMPTY}, oidb_0x89a$GroupNewGuidelinesInfo.class);
            //    public final PBBoolField bool_enabled = PBField.initBool(false);
            //    public final PBBytesField string_content = PBField.initBytes(ByteStringMicro.EMPTY);
            //};
            this.uint32_group_face = PBField.initUInt32(0);
            this.uint32_add_option = PBField.initUInt32(0);
            this.uint32_shutup_time = PBField.initUInt32(0);
            this.uint32_group_type_flag = PBField.initUInt32(0);
            this.rpt_string_group_tag = PBField.initRepeat(PBBytesField.__repeatHelper__);
            //this.msg_group_geo_info = new oidb_0x89a$GroupGeoInfo();
            this.uint32_group_class_ext = PBField.initUInt32(0);
            this.string_group_class_text = PBField.initBytes(byteStringMicro);
            this.uint32_app_privilege_flag = PBField.initUInt32(0);
            this.uint32_app_privilege_mask = PBField.initUInt32(0);
            //this.st_group_ex_info = new MessageMicro<oidb_0x89a$GroupExInfoOnly>() { // from class: tencent.im.oidb.cmd0x89a.oidb_0x89a$GroupExInfoOnly
            //    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_tribe_id", "uint32_money_for_add_group"}, new Object[]{0, 0}, oidb_0x89a$GroupExInfoOnly.class);
            //    public final PBUInt32Field uint32_tribe_id = PBField.initUInt32(0);
            //    public final PBUInt32Field uint32_money_for_add_group = PBField.initUInt32(0);
            //};
            this.uint32_group_sec_level = PBField.initUInt32(0);
            this.uint32_group_sec_level_info = PBField.initUInt32(0);
            this.uint64_subscription_uin = PBField.initUInt64(0L);
            this.uint32_allow_member_invite = PBField.initUInt32(0);
            this.string_group_question = PBField.initBytes(byteStringMicro);
            this.string_group_answer = PBField.initBytes(byteStringMicro);
            this.uint32_group_flagext3 = PBField.initUInt32(0);
            this.uint32_group_flagext3_mask = PBField.initUInt32(0);
            this.uint32_group_open_appid = PBField.initUInt32(0);
            this.uint32_no_finger_open_flag = PBField.initUInt32(0);
            this.uint32_no_code_finger_open_flag = PBField.initUInt32(0);
            this.uint64_root_id = PBField.initUInt64(0L);
            this.uint32_msg_limit_frequency = PBField.initUInt32(0);
            this.uint32_hl_guild_appid = PBField.initUInt32(0);
            this.uint32_hl_guild_sub_type = PBField.initUInt32(0);
            this.uint32_hl_guild_orgid = PBField.initUInt32(0);
            this.uint32_group_flagext4 = PBField.initUInt32(0);
            this.uint32_group_flagext4_mask = PBField.initUInt32(0);
            this.bytes_group_school_info = PBField.initBytes(byteStringMicro);
            //this.st_group_card_prefix = new oidb_0x89a$GroupCardPrefix();
        }
    }
}
