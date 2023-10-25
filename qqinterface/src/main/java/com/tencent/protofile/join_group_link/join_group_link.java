package com.tencent.protofile.join_group_link;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class join_group_link {
    public static class ReqBody extends MessageMicro<ReqBody> {
        public final PBBoolField get_ark = PBField.initBool(false);
        public final PBBytesField str_context = PBField.initBytes(null);
        public final PBBytesField str_url_param = PBField.initBytes(null);
        public final PBEnumField type = PBField.initEnum(1);
        public final PBUInt64Field group_code = PBField.initUInt64(0);
    }

    public static class RspBody extends MessageMicro<RspBody> {
        public final PBBytesField signed_ark;
        public final PBBytesField str_context;
        public final PBUInt32Field error_code = PBField.initUInt32(0);
        public final PBUInt64Field group_code = PBField.initUInt64(0);
        public final PBStringField url = PBField.initString("");

        public RspBody() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.str_context = PBField.initBytes(byteStringMicro);
            this.signed_ark = PBField.initBytes(byteStringMicro);
        }
    }
}
