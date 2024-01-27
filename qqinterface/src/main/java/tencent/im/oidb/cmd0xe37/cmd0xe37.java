package tencent.im.oidb.cmd0xe37;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public class cmd0xe37 {
    public static class Req0xe37 extends MessageMicro<Req0xe37> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_cmd_0x346_req_body"}, new Object[]{ByteStringMicro.EMPTY}, Req0xe37.class);
        public final PBBytesField bytes_cmd_0x346_req_body = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    public static class Resp0xe37 extends MessageMicro<Resp0xe37> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_cmd_0x346_rsp_body"}, new Object[]{ByteStringMicro.EMPTY}, Resp0xe37.class);
        public final PBBytesField bytes_cmd_0x346_rsp_body = PBField.initBytes(ByteStringMicro.EMPTY);
    }
}