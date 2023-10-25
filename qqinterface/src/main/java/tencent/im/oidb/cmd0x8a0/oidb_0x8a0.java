package tencent.im.oidb.cmd0x8a0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class oidb_0x8a0 {
    public static class ReqBody extends MessageMicro<ReqBody> {
        public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0);
        public final PBRepeatMessageField<KickMemberInfo> rpt_msg_kick_list = PBField.initRepeatMessage(KickMemberInfo.class);
        public final PBRepeatField<Long> rpt_kick_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        public final PBUInt32Field uint32_kick_flag = PBField.initUInt32(0);
        public final PBBytesField bytes_kick_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    public static class KickMemberInfo extends MessageMicro<KickMemberInfo> {
        public final PBUInt32Field opt_uint32_operate = PBField.initUInt32(0);
        public final PBUInt64Field opt_uint64_member_uin = PBField.initUInt64(0);
        public final PBUInt32Field opt_uint32_flag = PBField.initUInt32(0);
        public final PBBytesField opt_bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    }
}
