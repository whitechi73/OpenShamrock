package msf.msgcomm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

import tencent.im.msg.im_msg_body;

public class msg_comm {
    public static class Msg extends MessageMicro<Msg> {
        public MsgHead msg_head = new MsgHead();
        public ContentHead content_head = new ContentHead();
        public im_msg_body.MsgBody msg_body = new im_msg_body.MsgBody();
        //public msg_comm$AppShareInfo appshare_info = new msg_comm$AppShareInfo();
    }

    public static class ContentHead extends MessageMicro<ContentHead> {
        public final PBUInt32Field pkg_num = PBField.initUInt32(0);
        public final PBUInt32Field pkg_index = PBField.initUInt32(0);
        public final PBUInt32Field div_seq = PBField.initUInt32(0);
        public final PBUInt32Field auto_reply = PBField.initUInt32(0);
    }

    public static class MutilTransHead extends MessageMicro<MutilTransHead> {
        public final PBUInt32Field status = PBField.initUInt32(0);
        public final PBUInt32Field msgId = PBField.initUInt32(0);
        public final PBUInt32Field friend_flag = PBField.initUInt32(0);
        public final PBStringField from_anno_id = PBField.initString("");
        public final PBStringField from_face_url = PBField.initString("");
    }


    public static class MsgHead extends MessageMicro<MsgHead> {
        public final PBUInt64Field from_uin = PBField.initUInt64(0);
        public final PBUInt64Field to_uin = PBField.initUInt64(0);
        public final PBUInt32Field msg_type = PBField.initUInt32(0);
        public final PBUInt32Field c2c_cmd = PBField.initUInt32(0);
        public final PBUInt32Field msg_seq = PBField.initUInt32(0);
        public final PBUInt32Field msg_time = PBField.initUInt32(0);
        public final PBUInt64Field msg_uid = PBField.initUInt64(0);
        //public msg_comm$C2CTmpMsgHead c2c_tmp_msg_head = new msg_comm$C2CTmpMsgHead();
        public GroupInfo group_info = new GroupInfo();
        public final PBUInt32Field from_appid = PBField.initUInt32(0);
        public final PBUInt32Field from_instid = PBField.initUInt32(0);
        public final PBUInt32Field user_active = PBField.initUInt32(0);
        //public msg_comm$DiscussInfo discuss_info = new msg_comm$DiscussInfo();
        public final PBStringField from_nick = PBField.initString("");
        public final PBUInt64Field auth_uin = PBField.initUInt64(0);
        public final PBStringField auth_nick = PBField.initString("");
        public final PBUInt32Field msg_flag = PBField.initUInt32(0);
        public final PBStringField auth_remark = PBField.initString("");
        public final PBStringField group_name = PBField.initString("");
        public MutilTransHead mutiltrans_head = new MutilTransHead();
        //public im_msg_head$InstCtrl msg_inst_ctrl = new im_msg_head$InstCtrl();
        public final PBUInt32Field public_account_group_send_flag = PBField.initUInt32(0);
        public final PBUInt32Field wseq_in_c2c_msghead = PBField.initUInt32(0);
        public final PBUInt64Field cpid = PBField.initUInt64(0);
        //public msg_comm$ExtGroupKeyInfo ext_group_key_info = new msg_comm$ExtGroupKeyInfo();
        public final PBStringField multi_compatible_text = PBField.initString("");
        public final PBUInt32Field auth_sex = PBField.initUInt32(0);
        public final PBBoolField is_src_msg = PBField.initBool(false);
    }

    public static class GroupInfo extends MessageMicro<GroupInfo> {
        public final PBBytesField group_card;
        public final PBUInt32Field group_card_type;
        public final PBUInt32Field group_level;
        public final PBBytesField group_name;
        public final PBBytesField group_rank;
        public final PBUInt64Field group_code = PBField.initUInt64(0);
        public final PBUInt32Field group_type = PBField.initUInt32(0);
        public final PBUInt64Field group_info_seq = PBField.initUInt64(0);

        public GroupInfo() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.group_card = PBField.initBytes(byteStringMicro);
            this.group_rank = PBField.initBytes(byteStringMicro);
            this.group_level = PBField.initUInt32(0);
            this.group_card_type = PBField.initUInt32(0);
            this.group_name = PBField.initBytes(byteStringMicro);
        }
    }
}
