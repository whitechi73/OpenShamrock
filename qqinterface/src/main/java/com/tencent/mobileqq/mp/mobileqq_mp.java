package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class mobileqq_mp {
    public static class RetInfo extends MessageMicro<RetInfo> {
        public final PBUInt32Field ret_code = PBField.initUInt32(0);
        public final PBStringField err_info = PBField.initString("");
    }
}
