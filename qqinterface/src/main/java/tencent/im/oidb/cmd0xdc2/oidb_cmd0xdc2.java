package tencent.im.oidb.cmd0xdc2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77;

public class oidb_cmd0xdc2 {

    public static class ReqBody extends MessageMicro<ReqBody> {
        public oidb_cmd0xb77.ReqBody msg_body = new oidb_cmd0xb77.ReqBody();
        public final PBRepeatMessageField<BatchSendReq> batch_send_req = PBField.initRepeatMessage(BatchSendReq.class);
    }

    public static class BatchSendReq extends MessageMicro<BatchSendReq> {
       public final PBUInt32Field send_type = PBField.initUInt32(0);
        public final PBUInt64Field recv_uin = PBField.initUInt64(0);
        public final PBStringField recv_openid = PBField.initString("");
        public oidb_cmd0xb77.ImageInfo image_info = new oidb_cmd0xb77.ImageInfo();
        public final PBUInt64Field recv_guild_id = PBField.initUInt64(0);
    }

}
