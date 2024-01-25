package tencent.im.oidb.cmd0x787;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class oidb_0x787 {
    public static final class RspBody extends MessageMicro<RspBody> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_admin_name;
        public final PBBytesField bytes_owner_name;
        public final PBRepeatMessageField<LevelName> rpt_msg_level_name_new;
        public final PBUInt32Field uint32_level_name_seq;
        public final PBUInt32Field uint32_office_mode;
        public final PBUInt32Field uint32_seq;
        public final PBUInt32Field uint32_user_show_flag_new;
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBRepeatMessageField<MemberLevelInfo> rpt_msg_member_level_info = PBField.initRepeatMessage(MemberLevelInfo.class);
        public final PBRepeatMessageField<LevelName> rpt_msg_level_name = PBField.initRepeatMessage(LevelName.class);
        public final PBUInt64Field uint64_end_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_data_time = PBField.initUInt64(0);
        public final PBUInt32Field uint32_user_show_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_sys_show_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_time_to_update = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 56, 64, 74, 82, 88, 96, 104, 112, 122}, new String[]{"uint64_group_code", "rpt_msg_member_level_info", "rpt_msg_level_name", "uint64_end_uin", "uint64_data_time", "uint32_user_show_flag", "uint32_sys_show_flag", "uint32_time_to_update", "bytes_owner_name", "bytes_admin_name", "uint32_seq", "uint32_office_mode", "uint32_level_name_seq", "uint32_user_show_flag_new", "rpt_msg_level_name_new"}, new Object[]{0L, null, null, 0L, 0L, 0, 0, 0, byteStringMicro, byteStringMicro, 0, 0, 0, 0, null}, RspBody.class);
        }

        public RspBody() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_owner_name = PBField.initBytes(byteStringMicro);
            this.bytes_admin_name = PBField.initBytes(byteStringMicro);
            this.uint32_seq = PBField.initUInt32(0);
            this.uint32_office_mode = PBField.initUInt32(0);
            this.uint32_level_name_seq = PBField.initUInt32(0);
            this.uint32_user_show_flag_new = PBField.initUInt32(0);
            this.rpt_msg_level_name_new = PBField.initRepeatMessage(LevelName.class);
        }
    }

    public static final class LevelName extends MessageMicro<LevelName> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_level", "str_name"}, new Object[]{0, ByteStringMicro.EMPTY}, LevelName.class);
        public final PBUInt32Field uint32_level = PBField.initUInt32(0);
        public final PBBytesField str_name = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    public static final class MemberLevelInfo extends MessageMicro<MemberLevelInfo> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_email;
        public final PBBytesField bytes_group_honor;
        public final PBBytesField bytes_job;
        public final PBBytesField bytes_msg_need_field;
        public final PBBytesField bytes_nick_name;
        public final PBBytesField bytes_phone;
        public final PBBytesField bytes_remark;
        public final PBBytesField bytes_special_title;
        public final PBBytesField str_name;
        public final PBUInt32Field uint32_cmduin_flagex3_grocery;
        public final PBUInt32Field uint32_gender;
        public final PBUInt32Field uint32_glamour_level;
        public final PBUInt32Field uint32_global_group_level;
        public final PBUInt32Field uint32_global_group_point;
        public final PBUInt32Field uint32_membership;
        public final PBUInt32Field uint32_rich_card_name_ver;
        public final PBUInt32Field uint32_ringtone_id;
        public final PBUInt32Field uint32_special_title_expire_time;
        public final PBUInt32Field uint32_title_id;
        public final PBUInt32Field uint32_torchbearer_flag;
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_point = PBField.initUInt32(0);
        public final PBUInt32Field uint32_active_day = PBField.initUInt32(0);
        public final PBUInt32Field uint32_level = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 64, 74, 82, 90, 96, 106, 112, 120, 128, 136, 144, 152, 160, 170, 176, 186, 192}, new String[]{"uint64_uin", "uint32_point", "uint32_active_day", "uint32_level", "str_name", "bytes_nick_name", "bytes_special_title", "uint32_special_title_expire_time", "bytes_phone", "bytes_email", "bytes_remark", "uint32_gender", "bytes_job", "uint32_glamour_level", "uint32_torchbearer_flag", "uint32_global_group_level", "uint32_title_id", "uint32_global_group_point", "uint32_rich_card_name_ver", "uint32_ringtone_id", "bytes_group_honor", "uint32_membership", "bytes_msg_need_field", "uint32_cmduin_flagex3_grocery"}, new Object[]{0L, 0, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0, byteStringMicro, 0, 0, 0, 0, 0, 0, 0, byteStringMicro, 0, byteStringMicro, 0}, MemberLevelInfo.class);
        }

        public MemberLevelInfo() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.str_name = PBField.initBytes(byteStringMicro);
            this.bytes_nick_name = PBField.initBytes(byteStringMicro);
            this.bytes_special_title = PBField.initBytes(byteStringMicro);
            this.uint32_special_title_expire_time = PBField.initUInt32(0);
            this.bytes_phone = PBField.initBytes(byteStringMicro);
            this.bytes_email = PBField.initBytes(byteStringMicro);
            this.bytes_remark = PBField.initBytes(byteStringMicro);
            this.uint32_gender = PBField.initUInt32(0);
            this.bytes_job = PBField.initBytes(byteStringMicro);
            this.uint32_glamour_level = PBField.initUInt32(0);
            this.uint32_torchbearer_flag = PBField.initUInt32(0);
            this.uint32_global_group_level = PBField.initUInt32(0);
            this.uint32_title_id = PBField.initUInt32(0);
            this.uint32_global_group_point = PBField.initUInt32(0);
            this.uint32_rich_card_name_ver = PBField.initUInt32(0);
            this.uint32_ringtone_id = PBField.initUInt32(0);
            this.bytes_group_honor = PBField.initBytes(byteStringMicro);
            this.uint32_membership = PBField.initUInt32(0);
            this.bytes_msg_need_field = PBField.initBytes(byteStringMicro);
            this.uint32_cmduin_flagex3_grocery = PBField.initUInt32(0);
        }
    }
}
