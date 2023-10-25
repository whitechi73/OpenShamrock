package tencent.im.oidb.cmd0xb77;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class oidb_cmd0xb77 {
    public static class ReqBody extends MessageMicro<ReqBody> {
        public final PBUInt64Field appid = PBField.initUInt64(0);
        public final PBUInt32Field app_type = PBField.initUInt32(0);
        public final PBUInt32Field msg_style = PBField.initUInt32(0);
        public final PBUInt64Field sender_uin = PBField.initUInt64(0);
        public ClientInfo client_info = new ClientInfo();
        public final PBStringField text_msg = PBField.initString("");
        public ExtInfo ext_info = new ExtInfo();
        public final PBUInt32Field send_type = PBField.initUInt32(0);
        public RichMsgBody rich_msg_body = new RichMsgBody();
        public ArkMsgBody ark_msg_body = new ArkMsgBody();
        public final PBUInt64Field recv_uin = PBField.initUInt64(0);
        public final PBStringField recv_openid = PBField.initString("");
        //public oidb_cmd0xb77$ArkV1MsgBody arkv1_msg_body = new oidb_cmd0xb77$ArkV1MsgBody();
        //public oidb_cmd0xb77$ArkJsonBody ark_json_body = new oidb_cmd0xb77$ArkJsonBody();
        //public oidb_cmd0xb77$XmlMsgBody xml_msg_body = new MessageMicro<oidb_cmd0xb77$XmlMsgBody>() { // from class: tencent.im.oidb.cmd0xb77.oidb_cmd0xb77$XmlMsgBody
        //    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{88, 98}, new String[]{"service_id", "xml"}, new Object[]{0, ""}, oidb_cmd0xb77$XmlMsgBody.class);
        //    public final PBUInt32Field service_id = PBField.initUInt32(0);
        //    public final PBStringField xml = PBField.initString("");
        //};
        //public oidb_cmd0xb77$MiniAppMsgBody mini_app_msg_body = new oidb_cmd0xb77$MiniAppMsgBody();
        public final PBUInt64Field recv_guild_id = PBField.initUInt64(0);
    }

    public static class ArkMsgBody extends MessageMicro<ArkMsgBody> {
        public final PBStringField app = PBField.initString("");
        public final PBStringField view = PBField.initString("");
        public final PBStringField prompt = PBField.initString("");
        public final PBStringField ver = PBField.initString("");
        public final PBStringField desc = PBField.initString("");
        public final PBUInt32Field feature_id = PBField.initUInt32(0);
        public final PBStringField meta = PBField.initString("");
        public final PBStringField meta_url1 = PBField.initString("");
        public final PBStringField meta_url2 = PBField.initString("");
        public final PBStringField meta_url3 = PBField.initString("");
        public final PBStringField meta_text1 = PBField.initString("");
        public final PBStringField meta_text2 = PBField.initString("");
        public final PBStringField meta_text3 = PBField.initString("");
        public final PBStringField config = PBField.initString("");
    }

    public static class RichMsgBody extends MessageMicro<RichMsgBody> {
        public final PBBoolField using_ark = PBField.initBool(false);
        public final PBStringField title = PBField.initString("");
        public final PBStringField summary = PBField.initString("");
        public final PBStringField brief = PBField.initString("");
        public final PBStringField url = PBField.initString("");
        public final PBStringField picture_url = PBField.initString("");
        public final PBStringField action = PBField.initString("");
        public final PBStringField music_url = PBField.initString("");
        public ImageInfo image_info = new ImageInfo();
    }

    public static class ExtInfo extends MessageMicro<ExtInfo> {
        public final PBBytesField message_ext = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField tag_name = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatField<Integer> rpt_custom_featureid = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        public final PBStringField apns_wording = PBField.initString("");
        public final PBUInt32Field uint32_group_savedb_flag = PBField.initUInt32(0);
        public final PBUInt32Field receiver_appid = PBField.initUInt32(0);
        public final PBUInt64Field msg_seq = PBField.initUInt64(0);
    }

    public static class ClientInfo extends MessageMicro<ClientInfo> {
        public final PBUInt32Field platform = PBField.initUInt32(0);
        public final PBStringField sdk_version = PBField.initString("");
        public final PBStringField android_package_name = PBField.initString("");
        public final PBStringField android_signature = PBField.initString("");
        public final PBStringField ios_bundle_id = PBField.initString("");
        public final PBStringField pc_sign = PBField.initString("");
    }

    public static class ImageInfo extends MessageMicro<ImageInfo> {
        public final PBStringField md5 = PBField.initString("");
        public final PBStringField uuid = PBField.initString("");
        public final PBUInt32Field img_type = PBField.initUInt32(0);
        public final PBUInt32Field file_size = PBField.initUInt32(0);
        public final PBUInt32Field width = PBField.initUInt32(0);
        public final PBUInt32Field height = PBField.initUInt32(0);
        public final PBUInt32Field original = PBField.initUInt32(0);
        public final PBUInt32Field file_id = PBField.initUInt32(0);
        public final PBUInt32Field server_ip = PBField.initUInt32(0);
        public final PBUInt32Field server_port = PBField.initUInt32(0);
    }


}
