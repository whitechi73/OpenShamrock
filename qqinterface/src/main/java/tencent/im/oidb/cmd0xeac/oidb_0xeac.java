package tencent.im.oidb.cmd0xeac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class oidb_0xeac {
    public static class ReqBody extends MessageMicro<ReqBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"group_code", "msg_seq", "msg_random"}, new Object[]{0L, 0, 0}, ReqBody.class);
        public final PBUInt64Field group_code = PBField.initUInt64(0);
        public final PBUInt32Field msg_seq = PBField.initUInt32(0);
        public final PBUInt32Field msg_random = PBField.initUInt32(0);
    }

    public static class RspBody extends MessageMicro<RspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 80}, new String[]{"wording", "digest_uin", "digest_time", "msg", "error_code"}, new Object[]{"", 0L, 0, null, 0}, RspBody.class);
        public final PBStringField wording = PBField.initString("");
        public final PBUInt64Field digest_uin = PBField.initUInt64(0);
        public final PBUInt32Field digest_time = PBField.initUInt32(0);

        /* renamed from: msg  reason: collision with root package name */
        public DigestMsg f340993msg = new DigestMsg();
        public final PBUInt32Field error_code = PBField.initUInt32(0);
    }

    public static class DigestMsg extends MessageMicro<DigestMsg> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112}, new String[]{"group_code", "msg_seq", "msg_random", "msg_content", "text_size", "pic_size", "video_size", "sender_uin", "sender_time", "add_digest_uin", "add_digest_time", "start_time", "latest_msg_seq", "op_type"}, new Object[]{0L, 0, 0, null, 0L, 0L, 0L, 0L, 0, 0L, 0, 0, 0, 0}, DigestMsg.class);
        public final PBUInt64Field group_code = PBField.initUInt64(0);
        public final PBUInt32Field msg_seq = PBField.initUInt32(0);
        public final PBUInt32Field msg_random = PBField.initUInt32(0);
        //public final PBRepeatMessageField<MsgElem> msg_content = PBField.initRepeatMessage(MsgElem.class);
        public final PBUInt64Field text_size = PBField.initUInt64(0);
        public final PBUInt64Field pic_size = PBField.initUInt64(0);
        public final PBUInt64Field video_size = PBField.initUInt64(0);
        public final PBUInt64Field sender_uin = PBField.initUInt64(0);
        public final PBUInt32Field sender_time = PBField.initUInt32(0);
        public final PBUInt64Field add_digest_uin = PBField.initUInt64(0);
        public final PBUInt32Field add_digest_time = PBField.initUInt32(0);
        public final PBUInt32Field start_time = PBField.initUInt32(0);
        public final PBUInt32Field latest_msg_seq = PBField.initUInt32(0);
        public final PBUInt32Field op_type = PBField.initUInt32(0);
    }
}
