package com.tencent.mobileqq.pskey.oidb.cmd0x102a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class oidb_cmd0x102a {
    public static class GetPSkeyRequest extends MessageMicro<GetPSkeyRequest> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"domains", "flag"}, new Object[]{"", 0}, GetPSkeyRequest.class);
        public final PBRepeatField<String> domains = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBUInt32Field flag = PBField.initUInt32(0);
    }

    public static class GetPSkeyResponse extends MessageMicro<GetPSkeyResponse> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"private_keys"}, new Object[]{null}, GetPSkeyResponse.class);
        public final PBRepeatMessageField<PSKey> private_keys = PBField.initRepeatMessage(PSKey.class);
    }
    
    public static class PSKey extends MessageMicro<PSKey> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40}, new String[]{"domain", "key", "key_expire", "uskey", "uskey_expire"}, new Object[]{"", "", 0L, "", 0L}, PSKey.class);
        public final PBStringField domain = PBField.initString("");
        public final PBStringField key = PBField.initString("");
        public final PBInt64Field key_expire = PBField.initInt64(0);
        public final PBStringField uskey = PBField.initString("");
        public final PBInt64Field uskey_expire = PBField.initInt64(0);
    }

}
