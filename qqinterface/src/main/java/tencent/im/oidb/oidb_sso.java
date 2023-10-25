package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class oidb_sso {
    public static class OIDBSSOPkg extends MessageMicro<OIDBSSOPkg> {
        public final PBUInt32Field uint32_command = PBField.initUInt32(0);
        public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_bodybuffer = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBStringField str_error_msg = PBField.initString("");
        public final PBStringField str_client_version = PBField.initString("");
        public final PBRepeatMessageField<MetaData> trpc_trans_info = PBField.initRepeatMessage(MetaData.class);
    }

    public static class MetaData extends MessageMicro<MetaData> {
        public final PBStringField key = PBField.initString("");
        public final PBStringField value = PBField.initString("");
    }
}
