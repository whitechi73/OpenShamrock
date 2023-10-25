package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class SSOLoginMerge {
    public static final class BusiBuffData extends MessageMicro<BusiBuffData> {
        public final PBRepeatMessageField<BusiBuffItem> BusiBuffVec = PBField.initRepeatMessage(BusiBuffItem.class);
        public final PBUInt32Field MaxRespSizeHint = PBField.initUInt32(0);
    }

    public static final class BusiBuffItem extends MessageMicro<BusiBuffItem> {
        public final PBUInt32Field SeqNo = PBField.initUInt32(0);
        public final PBStringField ServiceCmd = PBField.initString("");
        public final PBUInt32Field BusiBuffLen = PBField.initUInt32(0);
        public final PBBytesField BusiBuff = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBoolField NeedResp = PBField.initBool(false);
        public SSOReserveField.SsoTrpcResponse trpc_rsp = new SSOReserveField.SsoTrpcResponse();
        public final PBRepeatMessageField<SSOReserveField.SsoMapEntry> trans_info = PBField.initRepeatMessage(SSOReserveField.SsoMapEntry.class);
        public final PBUInt32Field message_type = PBField.initUInt32(0);
    }
}
