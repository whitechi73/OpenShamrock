package com.tencent.biz.map.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class LbsSendInfo {
    public static class SendMessageReq extends MessageMicro<SendMessageReq> {
        public final PBUInt64Field uint64_peer_account = PBField.initUInt64(0);
        public final PBEnumField enum_relation_type = PBField.initEnum(0);
        public final PBStringField str_name = PBField.initString("");
        public final PBStringField str_address = PBField.initString("");
        public final PBStringField str_lat = PBField.initString("");
        public final PBStringField str_lng = PBField.initString("");
    }
}
