package tencent.im.oidb.cmd0x8fc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class Oidb_0x8fc {
    public static final class ReqBody extends MessageMicro<ReqBody> {
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBUInt32Field uint32_show_flag = PBField.initUInt32(0);
        public final PBRepeatMessageField<MemberInfo> rpt_mem_level_info = PBField.initRepeatMessage(MemberInfo.class);
        public final PBRepeatMessageField<LevelName> rpt_level_name = PBField.initRepeatMessage(LevelName.class);
        public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_office_mode = PBField.initUInt32(0);
        public final PBUInt32Field uint32_group_open_appid = PBField.initUInt32(0);
        public ClientInfo msg_client_info = new ClientInfo();
        public final PBBytesField bytes_auth_key = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatMessageField<LevelName> rpt_level_name_new = PBField.initRepeatMessage(LevelName.class);
    }

    public static class ClientInfo extends MessageMicro<ClientInfo> {
        public final PBUInt32Field uint32_implat = PBField.initUInt32(0);
        public final PBStringField string_clientver = PBField.initString("");
    }


    public static class LevelName extends MessageMicro<LevelName> {
         public final PBUInt32Field uint32_level = PBField.initUInt32(0);
        public final PBStringField str_name = PBField.initString("");
    }

    public static class MemberInfo extends MessageMicro<MemberInfo> {
        public final PBBytesField bytes_comm_rich_card_name;
        public final PBBytesField bytes_email;
        public final PBBytesField bytes_group_honor;
        public final PBBytesField bytes_job;
        public final PBBytesField bytes_phone;
        public final PBBytesField bytes_remark;
        public final PBBytesField bytes_special_title;
        public final PBBytesField bytes_uin_name;
        public final PBBytesField member_card_name;
        public final PBRepeatMessageField<CardNameElem> rpt_rich_card_name;
        public final PBUInt32Field uint32_cmduin_flag_ex3_grocery;
        public final PBUInt32Field uint32_cmduin_flag_ex3_mask;
        public final PBUInt32Field uint32_gender;
        public final PBUInt32Field uint32_ringtone_id;
        public final PBUInt32Field uint32_special_title_expire_time;
        public final PBUInt32Field uint32_tribe_level;
        public final PBUInt32Field uint32_tribe_point;
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_point = PBField.initUInt32(0);
        public final PBUInt32Field uint32_active_day = PBField.initUInt32(0);
        public final PBUInt32Field uint32_level = PBField.initUInt32(0);

        public MemberInfo() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_special_title = PBField.initBytes(byteStringMicro);
            this.uint32_special_title_expire_time = PBField.initUInt32(0);
            this.bytes_uin_name = PBField.initBytes(byteStringMicro);
            this.member_card_name = PBField.initBytes(byteStringMicro);
            this.bytes_phone = PBField.initBytes(byteStringMicro);
            this.bytes_email = PBField.initBytes(byteStringMicro);
            this.bytes_remark = PBField.initBytes(byteStringMicro);
            this.uint32_gender = PBField.initUInt32(0);
            this.bytes_job = PBField.initBytes(byteStringMicro);
            this.uint32_tribe_level = PBField.initUInt32(0);
            this.uint32_tribe_point = PBField.initUInt32(0);
            this.rpt_rich_card_name = PBField.initRepeatMessage(CardNameElem.class);
            this.bytes_comm_rich_card_name = PBField.initBytes(byteStringMicro);
            this.uint32_ringtone_id = PBField.initUInt32(0);
            this.bytes_group_honor = PBField.initBytes(byteStringMicro);
            this.uint32_cmduin_flag_ex3_grocery = PBField.initUInt32(0);
            this.uint32_cmduin_flag_ex3_mask = PBField.initUInt32(0);
        }
    }

    public static class CardNameElem extends MessageMicro<CardNameElem> {
        public static final int CARD_TYPE_TEXT = 1;
        public static final int CARD_TYPE_XC = 2;

        public final PBEnumField enum_card_type = PBField.initEnum(1);
        public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
    }
}
