package moe.fuqiuluo.qqinterface.entries.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class WeiyunCommonMessage {
    public static class MsgHead extends MessageMicro<MsgHead> {
        public static final int ReqMsg = 1;
        public static final int RspMsg = 2;

        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66, 72, 80, 90, 112, 120, 808, 818, 826, 888, 896}, new String[]{"uin", "seq", "type", "cmd", "appid", "version", "nettype", "clientip", "encrypt", "keytype", "encryptkey", "major_version", "minor_version", "retcode", "retmsg", "promptmsg", "total_space", "used_space"}, new Object[]{0L, 0, 0, 0, 0, 0, 0, "", 0, 0, ByteStringMicro.EMPTY, 0, 0, 0, "", "", 0L, 0L}, MsgHead.class);

        public final PBInt64Field uin = PBField.initInt64(0);
        public final PBUInt32Field seq = PBField.initUInt32(0);
        public final PBUInt32Field type = PBField.initUInt32(0);
        public final PBUInt32Field cmd = PBField.initUInt32(0);
        public final PBInt32Field appid = PBField.initInt32(0);
        public final PBInt32Field version = PBField.initInt32(0);
        public final PBInt32Field nettype = PBField.initInt32(0);
        public final PBStringField clientip = PBField.initString("");
        public final PBInt32Field encrypt = PBField.initInt32(0);
        public final PBInt32Field keytype = PBField.initInt32(0);
        public final PBBytesField encryptkey = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBInt32Field major_version = PBField.initInt32(0);
        public final PBInt32Field minor_version = PBField.initInt32(0);
        public final PBInt32Field retcode = PBField.initInt32(0);
        public final PBStringField retmsg = PBField.initString("");
        public final PBStringField promptmsg = PBField.initString("");
        public final PBUInt64Field total_space = PBField.initUInt64(0);
        public final PBUInt64Field used_space = PBField.initUInt64(0);
    }

    public static class AddRichMediaCollectionMsgReq extends MessageMicro<AddRichMediaCollectionMsgReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"comm_info", "summary", "content", "need_share_url"}, new Object[]{null, null, null, Boolean.FALSE}, AddRichMediaCollectionMsgReq.class);
        public CollectCommonInfo comm_info = new CollectCommonInfo();
        public RichMediaSummary summary = new RichMediaSummary();
        public RichMediaContent content = new RichMediaContent();
        public final PBBoolField need_share_url = PBField.initBool(false);
    }

    public static class RichMediaContent extends MessageMicro<RichMediaContent> {
        static final MessageMicro.FieldMap __fieldMap__;
        public RichMedia rich_media = new RichMedia();
        public final PBBytesField raw_data = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatField<ByteStringMicro> biz_data_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
        public final PBRepeatMessageField<PicInfo> pic_list = PBField.initRepeatMessage(PicInfo.class);
        public final PBRepeatMessageField<FileInfo> file_list = PBField.initRepeatMessage(FileInfo.class);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"rich_media", "raw_data", "biz_data_list", "pic_list", "file_list"}, new Object[]{null, byteStringMicro, byteStringMicro, null, null}, RichMediaContent.class);
        }
    }

    public static class FileInfo extends MessageMicro<FileInfo> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt32Field category;
        public final PBBytesField md5;
        public final PBBytesField sha1;
        public final PBUInt32Field src = PBField.initUInt32(0);
        public final PBUInt64Field uid = PBField.initUInt64(0);
        public final PBUInt32Field bid = PBField.initUInt32(0);
        public final PBStringField fid = PBField.initString("");
        public final PBStringField name = PBField.initString("");
        public final PBUInt64Field size = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 58, 66, 72}, new String[]{"src", "uid", "bid", "fid", "name", "size", "md5", "sha1", "category"}, new Object[]{0, 0L, 0, "", "", 0L, byteStringMicro, byteStringMicro, 0}, FileInfo.class);
        }

        public FileInfo() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.md5 = PBField.initBytes(byteStringMicro);
            this.sha1 = PBField.initBytes(byteStringMicro);
            this.category = PBField.initUInt32(0);
        }
    }

    public static class RichMedia extends MessageMicro<RichMedia> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"sections"}, new Object[]{null}, RichMedia.class);
        public final PBRepeatMessageField<Section> sections = PBField.initRepeatMessage(Section.class);
    }

    public static class Section extends MessageMicro<Section> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"items"}, new Object[]{null}, Section.class);
        public final PBRepeatMessageField<Item> items = PBField.initRepeatMessage(Item.class);
    }

    public static class Item extends MessageMicro<Item> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"item_type", "parag", "anchor", "pic_info"}, new Object[]{0, null, null, null}, Item.class);
        public final PBUInt32Field item_type = PBField.initUInt32(0);
        public Paragraph parag = new Paragraph();
        public Anchor anchor = new Anchor();
        public PicInfo pic_info = new PicInfo();
    }

    public static class Anchor extends MessageMicro<Anchor> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"url", "desc"}, new Object[]{"", ""}, Anchor.class);
        public final PBStringField url = PBField.initString("");
        public final PBStringField desc = PBField.initString("");
    }

    public static class Paragraph extends MessageMicro<Paragraph> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"content", "style"}, new Object[]{"", null}, Paragraph.class);
        public final PBStringField content = PBField.initString("");
        public Style style = new Style();
    }

    public static class Style extends MessageMicro<Style> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"color", "font_family", "font_weight", "font_size"}, new Object[]{"#FFFFFF", "", "normal", ""}, Style.class);
        public final PBStringField color = PBField.initString("#FFFFFF");
        public final PBStringField font_family = PBField.initString("");
        public final PBStringField font_weight = PBField.initString("normal");
        public final PBStringField font_size = PBField.initString("");
    }

    public static class RichMediaSummary extends MessageMicro<RichMediaSummary> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 58, 64}, new String[]{"title", "sub_title", "brief", "pic_list", "content_type", "original_uri", "publisher", "rich_media_version"}, new Object[]{"", "", "", null, 0, "", "", 0}, RichMediaSummary.class);
        public final PBStringField title = PBField.initString("");
        public final PBStringField sub_title = PBField.initString("");
        public final PBStringField brief = PBField.initString("");
        public final PBRepeatMessageField<PicInfo> pic_list = PBField.initRepeatMessage(PicInfo.class);
        public final PBUInt32Field content_type = PBField.initUInt32(0);
        public final PBStringField original_uri = PBField.initString("");
        public final PBStringField publisher = PBField.initString("");
        public final PBUInt32Field rich_media_version = PBField.initUInt32(0);
    }

    public static class PicInfo extends MessageMicro<PicInfo> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt32Field height;
        public final PBBytesField md5;
        public final PBStringField name;
        public final PBStringField note;
        public Author owner;
        public final PBStringField pic_id;
        public final PBBytesField sha1;
        public final PBUInt32Field size;
        public final PBUInt32Field type;
        public final PBStringField uri = PBField.initString("");
        public final PBUInt32Field width;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56, 64, 72, 82, 90}, new String[]{"uri", "md5", "sha1", "name", "note", "width", "height", "size", "type", "owner", "pic_id"}, new Object[]{"", byteStringMicro, byteStringMicro, "", "", 0, 0, 0, 0, null, ""}, PicInfo.class);
        }

        public PicInfo() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.md5 = PBField.initBytes(byteStringMicro);
            this.sha1 = PBField.initBytes(byteStringMicro);
            this.name = PBField.initString("");
            this.note = PBField.initString("");
            this.width = PBField.initUInt32(0);
            this.height = PBField.initUInt32(0);
            this.size = PBField.initUInt32(0);
            this.type = PBField.initUInt32(0);
            this.owner = new Author();
            this.pic_id = PBField.initString("");
        }
    }

    public static final class CollectCommonInfo extends MessageMicro<CollectCommonInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 50, 58, 66, 72, 80, 4048, 4058}, new String[]{"bid", "category", "author", "create_time", "sequence", "biz_key", "biz_data_list", "share_url", "original_app_id", "custom_group_id", "modify_time", "qzone_ugc_key"}, new Object[]{0, 0, null, 0L, 0L, "", ByteStringMicro.EMPTY, "", 0, 0, 0L, ""}, CollectCommonInfo.class);
        public final PBUInt32Field bid = PBField.initUInt32(0);
        public final PBUInt32Field category = PBField.initUInt32(0);
        public Author author = new Author();
        public final PBUInt64Field create_time = PBField.initUInt64(0);
        public final PBUInt64Field sequence = PBField.initUInt64(0);
        public final PBStringField biz_key = PBField.initString("");
        public final PBRepeatField<ByteStringMicro> biz_data_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
        public final PBStringField share_url = PBField.initString("");
        public final PBUInt32Field original_app_id = PBField.initUInt32(0);
        public final PBUInt32Field custom_group_id = PBField.initUInt32(0);
        public final PBUInt64Field modify_time = PBField.initUInt64(0);
        public final PBStringField qzone_ugc_key = PBField.initString("");
    }

    public static final class Author extends MessageMicro<Author> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42}, new String[]{"type", "num_id", "str_id", "group_id", "group_name"}, new Object[]{0, 0L, "", 0L, ""}, Author.class);
        public final PBUInt32Field type = PBField.initUInt32(0);
        public final PBUInt64Field num_id = PBField.initUInt64(0);
        public final PBStringField str_id = PBField.initString("");
        public final PBUInt64Field group_id = PBField.initUInt64(0);
        public final PBStringField group_name = PBField.initString("");
    }

    public static class ReqMsgBody extends MessageMicro<ReqMsgBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{96010, 160002, 160010, 160018, 160026, 160034, 160042, 160050, 160058, 160066,
                160074, // 11
                160082, 160090, 160098, 160106, 160114, 160122, 160130, 160138, 160146, 160154, 160162, 160170, 160178, 160186, 160194, 160202, 160210, 160218, 160226}, new String[]{
                        "WeiyunShareAddReq_body",
                "GetCollectionListMsgReq_body",
                "GetCollectionContentMsgReq_body",
                "DelCollectionMsgReq_body",
                "AddTextCollectionMsgReq_body",
                "AddLinkCollectionMsgReq_body",
                "AddGalleryCollectionMsgReq_body",
                "AddAudioCollectionMsgReq_body",
                "AddFileCollectionMsgReq_body",
                "AddLocationCollectionMsgReq_body", // 10

                "AddRichMediaCollectionMsgReq_body", // 11

                "FastUploadResourceMsgReq_body", "GetCollectionCountByCatetoryMsgReq_body", "ModCollectionMsgReq_body", "GetCollectionFullInfoMsgReq_body", "ApplyDownloadFileMsgReq_body", "GetCollectionSummaryMsgReq_body", "GetCompatibleCollectionInfoMsgReq_body", "GetCollectorUserFileInfoReq_body", "GetFilePreviewInfoReq_body", "AddHighQualityAudioCollectionMsgReq_body", "GetCollectorUserInfoReq_body", "GetCustomGroupMsgReq_body", "AddCustomGroupMsgReq_body", "ModCustomGroupMsgReq_body", "DelCustomGroupMsgReq_body", "ModCollectionGroupMsgReq_body", "GetCollectionGroupListMsgReq_body", "BatchWeiyunShareAddReq_body", "AddVideoCollectionMsgReq_body"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, ReqMsgBody.class);
        //public WeiyunCommonMessage$WeiyunShareAddReq WeiyunShareAddReq_body = new WeiyunCommonMessage$WeiyunShareAddReq();
        //public WeiyunCommonMessage$GetCollectionListMsgReq GetCollectionListMsgReq_body = new WeiyunCommonMessage$GetCollectionListMsgReq();
        //public WeiyunCommonMessage$GetCollectionContentMsgReq GetCollectionContentMsgReq_body = new WeiyunCommonMessage$GetCollectionContentMsgReq();
        //public WeiyunCommonMessage$DelCollectionMsgReq DelCollectionMsgReq_body = new WeiyunCommonMessage$DelCollectionMsgReq();
        //public WeiyunCommonMessage$AddTextCollectionMsgReq AddTextCollectionMsgReq_body = new WeiyunCommonMessage$AddTextCollectionMsgReq();
        //public WeiyunCommonMessage$AddLinkCollectionMsgReq AddLinkCollectionMsgReq_body = new WeiyunCommonMessage$AddLinkCollectionMsgReq();
        //public WeiyunCommonMessage$AddGalleryCollectionMsgReq AddGalleryCollectionMsgReq_body = new WeiyunCommonMessage$AddGalleryCollectionMsgReq();
        //public WeiyunCommonMessage$AddAudioCollectionMsgReq AddAudioCollectionMsgReq_body = new WeiyunCommonMessage$AddAudioCollectionMsgReq();
        //public WeiyunCommonMessage$AddFileCollectionMsgReq AddFileCollectionMsgReq_body = new WeiyunCommonMessage$AddFileCollectionMsgReq();
        //public WeiyunCommonMessage$AddLocationCollectionMsgReq AddLocationCollectionMsgReq_body = new WeiyunCommonMessage$AddLocationCollectionMsgReq();
        public AddRichMediaCollectionMsgReq AddRichMediaCollectionMsgReq_body = new AddRichMediaCollectionMsgReq();
        //public WeiyunCommonMessage$FastUploadResourceMsgReq FastUploadResourceMsgReq_body = new WeiyunCommonMessage$FastUploadResourceMsgReq();
        //public WeiyunCommonMessage$GetCollectionCountByCatetoryMsgReq GetCollectionCountByCatetoryMsgReq_body = new MessageMicro<WeiyunCommonMessage$GetCollectionCountByCatetoryMsgReq>() { // from class: com.qqfav.protocal.WeiyunCommonMessage$GetCollectionCountByCatetoryMsgReq
        //    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"bid", "category_list"}, new Object[]{0, 0}, WeiyunCommonMessage$GetCollectionCountByCatetoryMsgReq.class);
        //    public final PBUInt32Field bid = PBField.initUInt32(0);
        //    public final PBRepeatField<Integer> category_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        //};
        //public WeiyunCommonMessage$ModCollectionMsgReq ModCollectionMsgReq_body = new WeiyunCommonMessage$ModCollectionMsgReq();
        //public WeiyunCommonMessage$GetCollectionFullInfoMsgReq GetCollectionFullInfoMsgReq_body = new MessageMicro<WeiyunCommonMessage$GetCollectionFullInfoMsgReq>() { // from class: com.qqfav.protocal.WeiyunCommonMessage$GetCollectionFullInfoMsgReq
        //    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"cid_list"}, new Object[]{""}, WeiyunCommonMessage$GetCollectionFullInfoMsgReq.class);
        //    public final PBRepeatField<String> cid_list = PBField.initRepeat(PBStringField.__repeatHelper__);
        //};
        //public WeiyunCommonMessage$ApplyDownloadFileMsgReq ApplyDownloadFileMsgReq_body = new WeiyunCommonMessage$ApplyDownloadFileMsgReq();
        //public WeiyunCommonMessage$GetCollectionSummaryMsgReq GetCollectionSummaryMsgReq_body = new WeiyunCommonMessage$GetCollectionSummaryMsgReq();
        //public WeiyunCommonMessage$GetCompatibleCollectionInfoMsgReq GetCompatibleCollectionInfoMsgReq_body = new WeiyunCommonMessage$GetCompatibleCollectionInfoMsgReq();
        //public WeiyunCommonMessage$GetCollectorUserFileInfoReq GetCollectorUserFileInfoReq_body = new WeiyunCommonMessage$GetCollectorUserFileInfoReq();
        //public WeiyunCommonMessage$GetFilePreviewInfoReq GetFilePreviewInfoReq_body = new WeiyunCommonMessage$GetFilePreviewInfoReq();
        //public WeiyunCommonMessage$AddAudioCollectionMsgReq AddHighQualityAudioCollectionMsgReq_body = new WeiyunCommonMessage$AddAudioCollectionMsgReq();
        //public WeiyunCommonMessage$GetCollectorUserInfoReq GetCollectorUserInfoReq_body = new WeiyunCommonMessage$GetCollectorUserInfoReq();
        //public WeiyunCommonMessage$GetCustomGroupMsgReq GetCustomGroupMsgReq_body = new WeiyunCommonMessage$GetCustomGroupMsgReq();
        //public WeiyunCommonMessage$AddCustomGroupMsgReq AddCustomGroupMsgReq_body = new WeiyunCommonMessage$AddCustomGroupMsgReq();
        //public WeiyunCommonMessage$ModCustomGroupMsgReq ModCustomGroupMsgReq_body = new WeiyunCommonMessage$ModCustomGroupMsgReq();
        //public WeiyunCommonMessage$DelCustomGroupMsgReq DelCustomGroupMsgReq_body = new WeiyunCommonMessage$DelCustomGroupMsgReq();
        //public WeiyunCommonMessage$ModCollectionGroupMsgReq ModCollectionGroupMsgReq_body = new WeiyunCommonMessage$ModCollectionGroupMsgReq();
        //public WeiyunCommonMessage$GetCollectionGroupListMsgReq GetCollectionGroupListMsgReq_body = new WeiyunCommonMessage$GetCollectionGroupListMsgReq();
        //public WeiyunCommonMessage$BatchWeiyunShareAddReq BatchWeiyunShareAddReq_body = new WeiyunCommonMessage$BatchWeiyunShareAddReq();
        //public WeiyunCommonMessage$AddVideoCollectionMsgReq AddVideoCollectionMsgReq_body = new WeiyunCommonMessage$AddVideoCollectionMsgReq();
    }
}
