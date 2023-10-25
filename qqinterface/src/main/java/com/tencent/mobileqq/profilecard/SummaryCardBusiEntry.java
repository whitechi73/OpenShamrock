package com.tencent.mobileqq.profilecard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class SummaryCardBusiEntry {
    public static class comm  extends MessageMicro<comm> {
        public final PBUInt32Field ver = PBField.initUInt32(0);
        public final PBUInt32Field seq = PBField.initUInt32(0);
        public final PBUInt64Field fromuin = PBField.initUInt64(0);
        public final PBUInt64Field touin = PBField.initUInt64(0);
        public final PBUInt32Field service = PBField.initUInt32(0);
        public final PBUInt32Field session_type = PBField.initUInt32(0);
        public final PBBytesField session_key = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field client_ip = PBField.initUInt32(0);
        public ui display = new ui();
        public final PBInt32Field result = PBField.initInt32(0);
        public final PBStringField err_msg = PBField.initString("");
        public final PBUInt32Field platform = PBField.initUInt32(0);
        public final PBStringField qqver = PBField.initString("");
        public final PBInt32Field build = PBField.initInt32(0);
        public LoginSig msg_login_sig = new LoginSig();
        public final PBUInt32Field uint32_version = PBField.initUInt32(0);
        public uin_info msg_uin_info = new uin_info();
        public rich_ui msg_rich_display = new rich_ui();
    }

    public static class uin_info extends MessageMicro<uin_info> {
        public final PBInt64Field int64_longitude = PBField.initInt64(0);
        public final PBInt64Field int64_latitude = PBField.initInt64(0);
    }

    public static final class rich_ui extends MessageMicro<rich_ui> {
        public final PBStringField strName = PBField.initString("");
        public final PBStringField strServiceUrl = PBField.initString("");
        public final PBRepeatMessageField<ui_info> rptUiList = PBField.initRepeatMessage(ui_info.class);
    }


    public static final class ui_info extends MessageMicro<ui_info> {
        public final PBStringField strTitle = PBField.initString("");
        public final PBStringField strCoverUrl = PBField.initString("");
        public final PBStringField strJmpUrl = PBField.initString("");
        public final PBStringField strSubInfo = PBField.initString("");
        public final PBStringField strDesc = PBField.initString("");
        public final PBStringField strTitleIconUrl = PBField.initString("");
        public final PBRepeatMessageField<Label> rptGroupTagList = PBField.initRepeatMessage(Label.class);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    }

    public static final class Color extends MessageMicro<Color> {
        public final PBUInt32Field uint32_r = PBField.initUInt32(0);
        public final PBUInt32Field uint32_g = PBField.initUInt32(0);
        public final PBUInt32Field uint32_b = PBField.initUInt32(0);
    }

    public static final class Label extends MessageMicro<Label> {
        public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBEnumField enum_type = PBField.initEnum(1);
        public Color text_color = new Color();
        public Color edging_color = new Color();
        public final PBUInt32Field uint32_label_attr = PBField.initUInt32(0);
        public final PBUInt32Field uint32_label_type = PBField.initUInt32(0);
    }


    public static final class LoginSig extends MessageMicro<LoginSig> {
         public final PBUInt32Field uint32_type = PBField.initUInt32(0);
        public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    }

    public static final class ui extends MessageMicro<ui> {
        public final PBStringField url = PBField.initString("");
        public final PBStringField title = PBField.initString("");
        public final PBStringField content = PBField.initString("");
        public final PBStringField jump_url = PBField.initString("");
    }
}
