package tencent.im.oidb.cmd0xed3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class oidb_cmd0xed3 {
    public static class ReqBody extends MessageMicro<ReqBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"uint64_to_uin", "uint64_group_code", "uint32_msg_seq", "uint32_msg_rand", "uint64_aio_uin", "uint32_nudge_type"}, new Object[]{0L, 0L, 0, 0, 0L, 0}, ReqBody.class);
        public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
        public final PBUInt32Field uint32_msg_rand = PBField.initUInt32(0);
        public final PBUInt64Field uint64_aio_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_nudge_type = PBField.initUInt32(0);
    }


}
