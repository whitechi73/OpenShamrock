package tencent.im.oidb.cmd0x11b2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class oidb_0x11b2 {
    public static class BusinessCardV3Req extends MessageMicro<BusinessCardV3Req> {
        public final PBUInt64Field uin = PBField.initUInt64(0);
        public final PBStringField phone = PBField.initString("");
        public final PBStringField jump_url = PBField.initString("");
    }

    public static class BusinessCardV3Rsp extends MessageMicro<BusinessCardV3Rsp> {
        public final PBStringField signed_ark_msg = PBField.initString("");
    }
}
