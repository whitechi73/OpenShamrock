package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class im_msg_body {
    public static class MsgBody extends MessageMicro<MsgBody> {
        public final PBBytesField msg_content;
        public final PBBytesField msg_encrypt_content;
        public RichText rich_text = new RichText();

        public MsgBody() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.msg_content = PBField.initBytes(byteStringMicro);
            this.msg_encrypt_content = PBField.initBytes(byteStringMicro);
        }
    }

    public static class RichText extends MessageMicro<RichText> {
        //public im_msg_body$Attr attr = new im_msg_body$Attr();
        public final PBRepeatMessageField<Elem> elems = PBField.initRepeatMessage(Elem.class);
        //public im_msg_body$NotOnlineFile not_online_file = new im_msg_body$NotOnlineFile();
        //public im_msg_body$Ptt ptt = new im_msg_body$Ptt();
        //public im_msg_body$TmpPtt tmp_ptt = new im_msg_body$TmpPtt();
        //public im_msg_body$Trans211TmpMsg trans_211_tmp_msg = new im_msg_body$Trans211TmpMsg();
    }

    public static class Elem extends MessageMicro<Elem> {
        public Text text = new Text();
        public GeneralFlags general_flags = new GeneralFlags();
    }

    public static class GeneralFlags extends MessageMicro<GeneralFlags> {
        public final PBBytesField babyq_guide_msg_cookie;
        public final PBBytesField bytes_pb_reserve;
        public final PBBytesField bytes_rp_id;
        public final PBBytesField bytes_rp_index;
        public final PBUInt32Field long_text_flag;
        public final PBBytesField long_text_resid;
        public final PBUInt32Field uin32_expert_flag;
        public final PBUInt32Field uint32_bubble_sub_id;
        public final PBUInt32Field uint32_glamour_level;
        public final PBUInt32Field uint32_group_type;
        public final PBUInt32Field uint32_member_level;
        public final PBUInt32Field uint32_olympic_torch;
        public final PBUInt32Field uint32_prp_fold;
        public final PBUInt32Field uint32_to_uin_flag;
        public final PBUInt64Field uint64_group_rank_seq;
        public final PBUInt64Field uint64_pendant_id;
        public final PBUInt32Field uint32_bubble_diy_text_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_group_flag_new = PBField.initUInt32(0);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);

        public GeneralFlags() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_rp_id = PBField.initBytes(byteStringMicro);
            this.uint32_prp_fold = PBField.initUInt32(0);
            this.long_text_flag = PBField.initUInt32(0);
            this.long_text_resid = PBField.initBytes(byteStringMicro);
            this.uint32_group_type = PBField.initUInt32(0);
            this.uint32_to_uin_flag = PBField.initUInt32(0);
            this.uint32_glamour_level = PBField.initUInt32(0);
            this.uint32_member_level = PBField.initUInt32(0);
            this.uint64_group_rank_seq = PBField.initUInt64(0L);
            this.uint32_olympic_torch = PBField.initUInt32(0);
            this.babyq_guide_msg_cookie = PBField.initBytes(byteStringMicro);
            this.uin32_expert_flag = PBField.initUInt32(0);
            this.uint32_bubble_sub_id = PBField.initUInt32(0);
            this.uint64_pendant_id = PBField.initUInt64(0L);
            this.bytes_rp_index = PBField.initBytes(byteStringMicro);
            this.bytes_pb_reserve = PBField.initBytes(byteStringMicro);
        }
    }

    public static class Text extends MessageMicro<Text> {
        public final PBBytesField attr_6_buf;
        public final PBBytesField attr_7_buf;
        public final PBBytesField buf;
        public final PBBytesField bytes_pb_reserve;
        public final PBStringField link;
        public final PBBytesField str;

        public Text() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.str = PBField.initBytes(byteStringMicro);
            this.link = PBField.initString("");
            this.attr_6_buf = PBField.initBytes(byteStringMicro);
            this.attr_7_buf = PBField.initBytes(byteStringMicro);
            this.buf = PBField.initBytes(byteStringMicro);
            this.bytes_pb_reserve = PBField.initBytes(byteStringMicro);
        }
    }
}
