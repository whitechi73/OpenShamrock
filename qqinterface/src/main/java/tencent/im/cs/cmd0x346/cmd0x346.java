package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class cmd0x346 {

    public static class ReqBody extends MessageMicro<ReqBody> {
        //static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170,
        //        SharedExtProcessor.CONFIG_ID, 816, 1600, 720002, 720010, 720018, 799994}, new String[]{
        //        "uint32_cmd",
        //        "uint32_seq",
        //        "msg_recv_list_query_req",
        //        "msg_send_list_query_req",
        //        "msg_renew_file_req",
        //        "msg_recall_file_req",
        //        "msg_apply_upload_req",
        //        "msg_apply_upload_hit_req",
         //       "msg_apply_forward_file_req",
         //       "msg_upload_succ_req",
         //       "msg_delete_file_req",
        //        "msg_download_succ_req",
        //        "msg_apply_download_abs_req",
        //        "msg_apply_download_req", // 14
         //       "msg_apply_list_download_req", "msg_file_query_req", "msg_apply_copy_from_req", "msg_apply_upload_req_v2", "msg_apply_upload_req_v3", "msg_apply_upload_hit_req_v2", "msg_apply_upload_hit_req_v3",
         //       "uint32_business_id", // 808
         //       "uint32_client_type", // 816
         //       "uint32_flag_support_mediaplatform",
        //        "msg_apply_copy_to_req", "msg_apply_clean_traffic_req", "msg_apply_get_traffic_req",
        //        "msg_extension_req"}, new Object[]{0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0, null, null, null, null}, ReqBody.class);

        public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
        public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
        //public RecvListQueryReq msg_recv_list_query_req = new RecvListQueryReq();
        //public SendListQueryReq msg_send_list_query_req = new SendListQueryReq();
        //public RenewFileReq msg_renew_file_req = new MessageMicro<RenewFileReq>() { // from class: tencent.im.cs.cmd0x346.RenewFileReq
        //    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint64_uin", "bytes_uuid", "uint32_add_ttl"}, new Object[]{0L, ByteStringMicro.EMPTY, 0}, RenewFileReq.class);
        //    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        //    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
        //    public final PBUInt32Field uint32_add_ttl = PBField.initUInt32(0);
        //};
        //public RecallFileReq msg_recall_file_req = new RecallFileReq();
        //public ApplyUploadReq msg_apply_upload_req = new ApplyUploadReq();
        //public ApplyUploadHitReq msg_apply_upload_hit_req = new MessageMicro<ApplyUploadHitReq>() { // from class: tencent.im.cs.cmd0x346.ApplyUploadHitReq
        //    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 160, 240, 322, 402, 482, PlayerResources.ViewId.GET_MORE_TOGGLE_AREA, 640}, new String[]{"uint64_sender_uin", "uint64_recver_uin", "uint64_file_size", "str_file_name", "bytes_10m_md5", "str_local_filepath", "uint32_danger_level", "uint64_total_space"}, new Object[]{0L, 0L, 0L, "", ByteStringMicro.EMPTY, "", 0, 0L}, ApplyUploadHitReq.class);
        //    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0);
        //    public final PBUInt64Field uint64_recver_uin = PBField.initUInt64(0);
        //    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0);
        //    public final PBStringField str_file_name = PBField.initString("");
        //    public final PBBytesField bytes_10m_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
        //    public final PBStringField str_local_filepath = PBField.initString("");
        //    public final PBUInt32Field uint32_danger_level = PBField.initUInt32(0);
        //    public final PBUInt64Field uint64_total_space = PBField.initUInt64(0);
        //};
        //public ApplyForwardFileReq msg_apply_forward_file_req = new ApplyForwardFileReq();
        //public UploadSuccReq msg_upload_succ_req = new UploadSuccReq();
        //public DeleteFileReq msg_delete_file_req = new DeleteFileReq();
        //public DownloadSuccReq msg_download_succ_req = new DownloadSuccReq();
        //public ApplyDownloadAbsReq msg_apply_download_abs_req = new ApplyDownloadAbsReq();
        public ApplyDownloadReq msg_apply_download_req = new ApplyDownloadReq();
        //public ApplyListDownloadReq msg_apply_list_download_req = new MessageMicro<ApplyListDownloadReq>() { // from class: tencent.im.cs.cmd0x346.ApplyListDownloadReq
        //    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 160, 240}, new String[]{"uint64_uin", "uint32_begin_index", "uint32_req_count"}, new Object[]{0L, 0, 0}, ApplyListDownloadReq.class);
        //    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        //    public final PBUInt32Field uint32_begin_index = PBField.initUInt32(0);
        //    public final PBUInt32Field uint32_req_count = PBField.initUInt32(0);
        //};
        //public FileQueryReq msg_file_query_req = new FileQueryReq();
        //public ApplyCopyFromReq msg_apply_copy_from_req = new MessageMicro<ApplyCopyFromReq>() { // from class: tencent.im.cs.cmd0x346.ApplyCopyFromReq
        //    static final MessageMicro.FieldMap __fieldMap__;
        //    public final PBBytesField bytes_file_md5;
        //    public final PBBytesField bytes_src_parentfolder;
        //    public final PBBytesField bytes_src_uuid;
        //    public final PBStringField str_file_name;
        //    public final PBUInt32Field uint32_danger_level;
        //    public final PBUInt64Field uint64_dst_uin;
        //    public final PBUInt64Field uint64_file_size;
        //    public final PBUInt64Field uint64_total_space;
        //    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0);
        //    public final PBUInt64Field uint64_src_group = PBField.initUInt64(0);
        //    public final PBUInt32Field uint32_src_svcid = PBField.initUInt32(0);

        //    static {
        //        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        //        __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 160, 240, 322, 402, 482, PlayerResources.ViewId.GET_MORE_TOGGLE_AREA, 640, QVipServiceAccountFolderProcessor.CMD, 800, x.CTRL_INDEX}, new String[]{"uint64_src_uin", "uint64_src_group", "uint32_src_svcid", "bytes_src_parentfolder", "bytes_src_uuid", "bytes_file_md5", "uint64_dst_uin", "uint64_file_size", "str_file_name", "uint32_danger_level", "uint64_total_space"}, new Object[]{0L, 0L, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0L, 0L, "", 0, 0L}, ApplyCopyFromReq.class);
        //    }

        //    {
        //        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        //        this.bytes_src_parentfolder = PBField.initBytes(byteStringMicro);
        //        this.bytes_src_uuid = PBField.initBytes(byteStringMicro);
        //        this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
        //        this.uint64_dst_uin = PBField.initUInt64(0L);
        //        this.uint64_file_size = PBField.initUInt64(0L);
        //        this.str_file_name = PBField.initString("");
        //        this.uint32_danger_level = PBField.initUInt32(0);
        //        this.uint64_total_space = PBField.initUInt64(0L);
        // /   }
        //};
        //public ApplyUploadReqV2 msg_apply_upload_req_v2 = new ApplyUploadReqV2();
        //public ApplyUploadReqV3 msg_apply_upload_req_v3 = new ApplyUploadReqV3();
        //public ApplyUploadHitReqV2 msg_apply_upload_hit_req_v2 = new ApplyUploadHitReqV2();
        //public ApplyUploadHitReqV3 msg_apply_upload_hit_req_v3 = new MessageMicro<ApplyUploadHitReqV3>() { // from class: tencent.im.cs.cmd0x346.ApplyUploadHitReqV3
        //    static final MessageMicro.FieldMap __fieldMap__;
        //    public final PBBytesField bytes_10m_md5;
        //    public final PBBytesField bytes_sha;
        //    public final PBStringField str_local_filepath;
        //    public final PBUInt32Field uint32_danger_level;
        //    public final PBUInt64Field uint64_total_space;
        //    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0);
        //   public final PBUInt64Field uint64_recver_uin = PBField.initUInt64(0);
        //    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0);
        //    public final PBStringField str_file_name = PBField.initString("");

        //    static {
        //        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        //        __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 160, 240, 322, 402, 482, 562, 640, 720}, new String[]{"uint64_sender_uin", "uint64_recver_uin", "uint64_file_size", "str_file_name", "bytes_10m_md5", "bytes_sha", "str_local_filepath", "uint32_danger_level", "uint64_total_space"}, new Object[]{0L, 0L, 0L, "", byteStringMicro, byteStringMicro, "", 0, 0L}, ApplyUploadHitReqV3.class);
        //    }

        //    {
        //        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        //        this.bytes_10m_md5 = PBField.initBytes(byteStringMicro);
        //        this.bytes_sha = PBField.initBytes(byteStringMicro);
        //        this.str_local_filepath = PBField.initString("");
        //        this.uint32_danger_level = PBField.initUInt32(0);
        //        this.uint64_total_space = PBField.initUInt64(0L);
        //    }
        //};
        //public ApplyCopyToReq msg_apply_copy_to_req = new ApplyCopyToReq();
        //public ApplyCleanTrafficReq msg_apply_clean_traffic_req = new MessageMicro<ApplyCleanTrafficReq>() { // from class: tencent.im.cs.cmd0x346.ApplyCleanTrafficReq
        //    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ApplyCleanTrafficReq.class);
        //};
        //public ApplyGetTrafficReq msg_apply_get_traffic_req = new MessageMicro<ApplyGetTrafficReq>() { // from class: tencent.im.cs.cmd0x346.ApplyGetTrafficReq
        //    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ApplyGetTrafficReq.class);
        //};
        public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_flag_support_mediaplatform = PBField.initUInt32(0);
        public ExtensionReq msg_extension_req = new ExtensionReq();
    }

    public static class ExtensionReq extends MessageMicro<ExtensionReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 162, 800, 720802, 721600, 722400, 723200, 724000, 724800, 725600, 726400, 727200, 728000, 728800}, new String[]{
                "uint64_id", "uint64_type", "str_dst_phonenum", "int32_phone_convert_type", "bytes_sig", "uint64_route_id", "msg_del_message_req",

                "uint32_download_url_type",

                "uint32_ptt_format", "uint32_is_need_inner_ip", "uint32_net_type", "uint32_voice_type", "uint32_file_type", "uint32_ptt_time", "uint32_bdh_cmdid", "uint32_req_transfer_type", "uint32_is_auto"}, new Object[]{0L, 0L, "", 0, ByteStringMicro.EMPTY, 0L, null, 0, 0, 0, 255, 0, 0, 0, 0, 0, 0},ExtensionReq.class);
        public final PBUInt64Field uint64_id = PBField.initUInt64(0);
        public final PBUInt64Field uint64_type = PBField.initUInt64(0);
        public final PBStringField str_dst_phonenum = PBField.initString("");
        public final PBInt32Field int32_phone_convert_type = PBField.initInt32(0);
        public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt64Field uint64_route_id = PBField.initUInt64(0);
        /*public cmd0x346$DelMessageReq msg_del_message_req = new MessageMicro<cmd0x346$DelMessageReq>() { // from class: tencent.im.cs.cmd0x346.cmd0x346$DelMessageReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 80, 160, 240}, new String[]{"uint64_uin_sender", "uint64_uin_receiver", "uint32_msg_time", "uint32_msg_random", "uint32_msg_seq_no"}, new Object[]{0L, 0L, 0, 0, 0}, cmd0x346$DelMessageReq.class);
            public final PBUInt64Field uint64_uin_sender = PBField.initUInt64(0);
            public final PBUInt64Field uint64_uin_receiver = PBField.initUInt64(0);
            public final PBUInt32Field uint32_msg_time = PBField.initUInt32(0);
            public final PBUInt32Field uint32_msg_random = PBField.initUInt32(0);
            public final PBUInt32Field uint32_msg_seq_no = PBField.initUInt32(0);
        };*/
        public final PBUInt32Field uint32_download_url_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_ptt_format = PBField.initUInt32(0);
        public final PBUInt32Field uint32_is_need_inner_ip = PBField.initUInt32(0);
        public final PBUInt32Field uint32_net_type = PBField.initUInt32(255);
        public final PBUInt32Field uint32_voice_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_ptt_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_bdh_cmdid = PBField.initUInt32(0);
        public final PBUInt32Field uint32_req_transfer_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_is_auto = PBField.initUInt32(0);
    }

    public static class ApplyDownloadReq extends MessageMicro<ApplyDownloadReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 162, 240, 400, 482, 4000, 4008, 4802}, new String[]{
                "uint64_uin", // 10
                "bytes_uuid", // 20
                "uint32_owner_type", // 30

                "uint32_filetype",  // 50

                "str_fileidcrc",  // 60

                "uint32_ext_uintype", "uint32_need_https_url", "str_fileid"}, new Object[]{0L, ByteStringMicro.EMPTY, 0, 0, "", 0, 0, ""}, ApplyDownloadReq.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_owner_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_filetype = PBField.initUInt32(0);
        public final PBStringField str_fileidcrc = PBField.initString("");
        public final PBUInt32Field uint32_ext_uintype = PBField.initUInt32(0);
        public final PBUInt32Field uint32_need_https_url = PBField.initUInt32(0);
        public final PBStringField str_fileid = PBField.initString("");
    }

    public static class RspBody extends MessageMicro<RspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 400, 720002, 720010, 720018, 799994}, new String[]{"uint32_cmd", "uint32_seq", "msg_recv_list_query_rsp", "msg_send_list_query_rsp", "msg_renew_file_rsp", "msg_recall_file_rsp", "msg_apply_upload_rsp", "msg_apply_upload_hit_rsp", "msg_apply_forward_file_rsp", "msg_upload_succ_rsp", "msg_delete_file_rsp", "msg_download_succ_rsp", "msg_apply_download_abs_rsp", "msg_apply_download_rsp", "msg_apply_list_download_rsp", "msg_file_query_rsp", "msg_apply_copy_from_rsp", "msg_apply_upload_rsp_v2", "msg_apply_upload_rsp_v3", "msg_apply_upload_hit_rsp_v2", "msg_apply_upload_hit_rsp_v3", "uint32_flag_use_media_platform", "msg_apply_copy_to_rsp", "msg_apply_clean_traffic_rsp", "msg_apply_get_traffic_rsp", "msg_extension_rsp"}, new Object[]{0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null}, RspBody.class);
        public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
        public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
        public ApplyDownloadRsp msg_apply_download_rsp = new ApplyDownloadRsp();
    }

    public static class ApplyDownloadRsp extends MessageMicro<ApplyDownloadRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 162, 242, 322, 402}, new String[]{"int32_ret_code", "str_ret_msg", "msg_download_info", "msg_file_info", "bytes_file_sha"}, new Object[]{0, "", null, null, ByteStringMicro.EMPTY}, ApplyDownloadRsp.class);
        public final PBInt32Field int32_ret_code = PBField.initInt32(0);
        public final PBStringField str_ret_msg = PBField.initString("");
        public DownloadInfo msg_download_info = new DownloadInfo();
        public FileInfo msg_file_info = new FileInfo();
        public final PBBytesField bytes_file_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    public static class DownloadInfo extends MessageMicro<DownloadInfo> {
        //static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_download_key;
        public final PBBytesField bytes_media_platform_download_key;
        public final PBRepeatField<String> rpt_str_downloadip_list;
        public final PBStringField str_cookie;
        public final PBStringField str_download_dns;
        public final PBStringField str_download_domain;
        public final PBStringField str_download_ip;
        public final PBStringField str_download_url;
        public final PBRepeatField<String> str_downloadipv6_list;
        public final PBStringField str_https_download_domain;
        public final PBUInt32Field uint32_https_port;
        public final PBUInt32Field uint32_port;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            //__fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 162, 242, 320, 402, 482, 562, 640, QVipServiceAccountFolderProcessor.CMD, 882, 962, 1042}, new String[]
            // {"bytes_download_key", "str_download_ip", "str_download_domain", "uint32_port", "str_download_url", "rpt_str_downloadip_list", "str_cookie", "uint32_https_port", "str_https_download_domain", "str_download_dns", "bytes_media_platform_download_key", "str_downloadipv6_list"}, new Object[]{byteStringMicro, "", "", 0, "", "", "", Integer.valueOf((int) WebSocketImpl.DEFAULT_WSS_PORT), "", "", byteStringMicro, ""}, cmd0x346$DownloadInfo.class);
        }

        public DownloadInfo() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_download_key = PBField.initBytes(byteStringMicro);
            this.str_download_ip = PBField.initString("");
            this.str_download_domain = PBField.initString("");
            this.uint32_port = PBField.initUInt32(0);
            this.str_download_url = PBField.initString("");
            PBStringField pBStringField = PBStringField.__repeatHelper__;
            this.rpt_str_downloadip_list = PBField.initRepeat(pBStringField);
            this.str_cookie = PBField.initString("");
            this.uint32_https_port = PBField.initUInt32(443);
            this.str_https_download_domain = PBField.initString("");
            this.str_download_dns = PBField.initString("");
            this.bytes_media_platform_download_key = PBField.initBytes(byteStringMicro);
            this.str_downloadipv6_list = PBField.initRepeat(pBStringField);
        }
    }

    public static class FileInfo extends MessageMicro<FileInfo> {
        //static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_10m_md5;
        public final PBBytesField bytes_3sha;
        public final PBBytesField bytes_md5;
        public final PBBytesField bytes_sha;
        public final PBBytesField bytes_uuid;
        public final PBStringField str_file_name;
        public final PBStringField str_fileidcrc;
        public final PBUInt32Field uint32_abs_file_type;
        public final PBUInt32Field uint32_client_type;
        public final PBUInt32Field uint32_expire_time;
        public final PBUInt64Field uint64_owner_uin;
        public final PBUInt64Field uint64_peer_uin;
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_danger_evel = PBField.initUInt32(0);
        public final PBUInt64Field uint64_file_size = PBField.initUInt64(0);
        public final PBUInt32Field uint32_life_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_upload_time = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            //__fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58, 720, 802, 810, x.CTRL_INDEX, 960, 968, 1040, gdt_analysis_event.EVENT_GET_SUBSCRIBER_ID, 1130, h.CTRL_INDEX}, new String[]{"uint64_uin", "uint32_danger_evel", "uint64_file_size", "uint32_life_time", "uint32_upload_time", "bytes_uuid", "str_file_name", "uint32_abs_file_type", "bytes_10m_md5", "bytes_sha", "uint32_client_type", "uint64_owner_uin", "uint64_peer_uin", "uint32_expire_time", "str_fileidcrc", "bytes_md5", "bytes_3sha"}, new Object[]{0L, 0, 0L, 0, 0, byteStringMicro, "", 0, byteStringMicro, byteStringMicro, 0, 0L, 0L, 0, "", byteStringMicro, byteStringMicro}, cmd0x346$FileInfo.class);
        }

        public FileInfo() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_uuid = PBField.initBytes(byteStringMicro);
            this.str_file_name = PBField.initString("");
            this.uint32_abs_file_type = PBField.initUInt32(0);
            this.bytes_10m_md5 = PBField.initBytes(byteStringMicro);
            this.bytes_sha = PBField.initBytes(byteStringMicro);
            this.uint32_client_type = PBField.initUInt32(0);
            this.uint64_owner_uin = PBField.initUInt64(0L);
            this.uint64_peer_uin = PBField.initUInt64(0L);
            this.uint32_expire_time = PBField.initUInt32(0);
            this.str_fileidcrc = PBField.initString("");
            this.bytes_md5 = PBField.initBytes(byteStringMicro);
            this.bytes_3sha = PBField.initBytes(byteStringMicro);
        }
    }
}
