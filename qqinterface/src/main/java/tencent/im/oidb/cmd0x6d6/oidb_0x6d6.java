package tencent.im.oidb.cmd0x6d6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6d6 {
    public static class ReqBody extends MessageMicro<ReqBody> {
        public UploadFileReqBody upload_file_req = new UploadFileReqBody();
        public ResendReqBody resend_file_req = new ResendReqBody();
        public DownloadFileReqBody download_file_req = new DownloadFileReqBody();
        public DeleteFileReqBody delete_file_req = new DeleteFileReqBody();
        public RenameFileReqBody rename_file_req = new RenameFileReqBody();
        public MoveFileReqBody move_file_req = new MoveFileReqBody();
    }

    public static class RspBody extends MessageMicro<RspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"upload_file_rsp", "resend_file_rsp", "download_file_rsp", "delete_file_rsp", "rename_file_rsp", "move_file_rsp"}, new Object[]{null, null, null, null, null, null}, RspBody.class);
        public UploadFileRspBody upload_file_rsp = new UploadFileRspBody();
        public ResendRspBody resend_file_rsp = new ResendRspBody();
        public DownloadFileRspBody download_file_rsp = new DownloadFileRspBody();
        public DeleteFileRspBody delete_file_rsp = new DeleteFileRspBody();
        public RenameFileRspBody rename_file_rsp = new RenameFileRspBody();
        public MoveFileRspBody move_file_rsp = new MoveFileRspBody();
    }

    public static class ResendRspBody extends MessageMicro<ResendRspBody> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_check_key;
        public final PBBytesField bytes_file_key;
        public final PBInt32Field int32_ret_code = PBField.initInt32(0);
        public final PBStringField str_ret_msg = PBField.initString("");
        public final PBStringField str_client_wording = PBField.initString("");
        public final PBStringField str_upload_ip = PBField.initString("");

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"int32_ret_code", "str_ret_msg", "str_client_wording", "str_upload_ip", "bytes_file_key", "bytes_check_key"}, new Object[]{0, "", "", "", byteStringMicro, byteStringMicro}, ResendRspBody.class);
        }

        public ResendRspBody() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_file_key = PBField.initBytes(byteStringMicro);
            this.bytes_check_key = PBField.initBytes(byteStringMicro);
        }
    }

    public static class DeleteFileRspBody extends MessageMicro<DeleteFileRspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"int32_ret_code", "str_ret_msg", "str_client_wording"}, new Object[]{0, "", ""}, DeleteFileRspBody.class);
        public final PBInt32Field int32_ret_code = PBField.initInt32(0);
        public final PBStringField str_ret_msg = PBField.initString("");
        public final PBStringField str_client_wording = PBField.initString("");
    }

    public static class MoveFileRspBody extends MessageMicro<MoveFileRspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"int32_ret_code", "str_ret_msg", "str_client_wording", "str_parent_folder_id"}, new Object[]{0, "", "", ""}, MoveFileRspBody.class);
        public final PBInt32Field int32_ret_code = PBField.initInt32(0);
        public final PBStringField str_ret_msg = PBField.initString("");
        public final PBStringField str_client_wording = PBField.initString("");
        public final PBStringField str_parent_folder_id = PBField.initString("");
    }

    public static class DownloadFileRspBody extends MessageMicro<DownloadFileRspBody> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_cookie_val;
        public final PBBytesField bytes_download_url;
        public final PBBytesField bytes_md5;
        public final PBBytesField bytes_sha;
        public final PBBytesField bytes_sha3;
        public final PBBytesField str_download_dns;
        public final PBStringField str_download_dns_https;
        public final PBStringField str_save_file_name;
        public final PBUInt32Field uint32_preview_port;
        public final PBUInt32Field uint32_preview_port_https;
        public final PBInt32Field int32_ret_code = PBField.initInt32(0);
        public final PBStringField str_ret_msg = PBField.initString("");
        public final PBStringField str_client_wording = PBField.initString("");
        public final PBStringField str_download_ip = PBField.initString("");

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 96, 106, 112}, new String[]{"int32_ret_code", "str_ret_msg", "str_client_wording", "str_download_ip", "str_download_dns", "bytes_download_url", "bytes_sha", "bytes_sha3", "bytes_md5", "bytes_cookie_val", "str_save_file_name", "uint32_preview_port", "str_download_dns_https", "uint32_preview_port_https"}, new Object[]{0, "", "", "", byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, "", 0, "", 0}, DownloadFileRspBody.class);
        }

        public DownloadFileRspBody() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.str_download_dns = PBField.initBytes(byteStringMicro);
            this.bytes_download_url = PBField.initBytes(byteStringMicro);
            this.bytes_sha = PBField.initBytes(byteStringMicro);
            this.bytes_sha3 = PBField.initBytes(byteStringMicro);
            this.bytes_md5 = PBField.initBytes(byteStringMicro);
            this.bytes_cookie_val = PBField.initBytes(byteStringMicro);
            this.str_save_file_name = PBField.initString("");
            this.uint32_preview_port = PBField.initUInt32(0);
            this.str_download_dns_https = PBField.initString("");
            this.uint32_preview_port_https = PBField.initUInt32(0);
        }
    }

    public static class UploadFileRspBody extends MessageMicro<UploadFileRspBody> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBoolField bool_file_exist;
        public final PBBytesField bytes_check_key;
        public final PBBytesField bytes_file_key;
        public final PBRepeatField<String> str_upload_ip_lan_v4;
        public final PBRepeatField<String> str_upload_ip_lan_v6;
        public final PBUInt32Field uint32_upload_port;
        public final PBInt32Field int32_ret_code = PBField.initInt32(0);
        public final PBStringField str_ret_msg = PBField.initString("");
        public final PBStringField str_client_wording = PBField.initString("");
        public final PBStringField str_upload_ip = PBField.initString("");
        public final PBStringField str_server_dns = PBField.initString("");
        public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
        public final PBStringField str_file_id = PBField.initString("");

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48, 58, 66, 74, 80, 98, 106, 112}, new String[]{"int32_ret_code", "str_ret_msg", "str_client_wording", "str_upload_ip", "str_server_dns", "uint32_bus_id", "str_file_id", "bytes_file_key", "bytes_check_key", "bool_file_exist", "str_upload_ip_lan_v4", "str_upload_ip_lan_v6", "uint32_upload_port"}, new Object[]{0, "", "", "", "", 0, "", byteStringMicro, byteStringMicro, Boolean.FALSE, "", "", 0}, UploadFileRspBody.class);
        }

        public UploadFileRspBody() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_file_key = PBField.initBytes(byteStringMicro);
            this.bytes_check_key = PBField.initBytes(byteStringMicro);
            this.bool_file_exist = PBField.initBool(false);
            PBStringField pBStringField = PBStringField.__repeatHelper__;
            this.str_upload_ip_lan_v4 = PBField.initRepeat(pBStringField);
            this.str_upload_ip_lan_v6 = PBField.initRepeat(pBStringField);
            this.uint32_upload_port = PBField.initUInt32(0);
        }
    }

    public static class RenameFileRspBody extends MessageMicro<RenameFileRspBody> {
        public final PBInt32Field int32_ret_code = PBField.initInt32(0);
        public final PBStringField str_ret_msg = PBField.initString("");
        public final PBStringField str_client_wording = PBField.initString("");
    }

    public static class ResendReqBody extends MessageMicro<ResendReqBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"uint64_group_code", "uint32_app_id", "uint32_bus_id", "str_file_id", "bytes_sha"}, new Object[]{0L, 0, 0, "", ByteStringMicro.EMPTY}, ResendReqBody.class);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
        public final PBStringField str_file_id = PBField.initString("");
        public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    public static class DownloadFileReqBody extends MessageMicro<DownloadFileReqBody> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
        public final PBStringField str_file_id = PBField.initString("");
        public final PBBoolField bool_thumbnail_req = PBField.initBool(false);
        public final PBUInt32Field uint32_url_type = PBField.initUInt32(0);
        public final PBBoolField bool_preview_req = PBField.initBool(false);
        public final PBUInt32Field uint32_src = PBField.initUInt32(0);

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 56, 64}, new String[]{"uint64_group_code", "uint32_app_id", "uint32_bus_id", "str_file_id", "bool_thumbnail_req", "uint32_url_type", "bool_preview_req", "uint32_src"}, new Object[]{0L, 0, 0, "", bool, 0, bool, 0}, DownloadFileReqBody.class);
        }
    }

    public static class DeleteFileReqBody extends MessageMicro<DeleteFileReqBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 56}, new String[]{"uint64_group_code", "uint32_app_id", "uint32_bus_id", "str_parent_folder_id", "str_file_id", "uint32_msgdb_seq", "uint32_msg_rand"}, new Object[]{0L, 0, 0, "", "", 0, 0}, DeleteFileReqBody.class);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
        public final PBStringField str_parent_folder_id = PBField.initString("");
        public final PBStringField str_file_id = PBField.initString("");
        public final PBUInt32Field uint32_msgdb_seq = PBField.initUInt32(0);
        public final PBUInt32Field uint32_msg_rand = PBField.initUInt32(0);
    }

    public static class MoveFileReqBody extends MessageMicro<MoveFileReqBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50}, new String[]{"uint64_group_code", "uint32_app_id", "uint32_bus_id", "str_file_id", "str_parent_folder_id", "str_dest_folder_id"}, new Object[]{0L, 0, 0, "", "", ""}, MoveFileReqBody.class);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
        public final PBStringField str_file_id = PBField.initString("");
        public final PBStringField str_parent_folder_id = PBField.initString("");
        public final PBStringField str_dest_folder_id = PBField.initString("");
    }

    public static class UploadFileReqBody extends MessageMicro<UploadFileReqBody> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBoolField bool_support_multi_upload;
        public final PBBytesField bytes_md5;
        public final PBBytesField bytes_sha;
        public final PBBytesField bytes_sha3;
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_entrance = PBField.initUInt32(0);
        public final PBStringField str_parent_folder_id = PBField.initString("");
        public final PBStringField str_file_name = PBField.initString("");
        public final PBStringField str_local_path = PBField.initString("");
        public final PBUInt64Field uint64_file_size = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 64, 74, 82, 90, 120}, new String[]{"uint64_group_code", "uint32_app_id", "uint32_bus_id", "uint32_entrance", "str_parent_folder_id", "str_file_name", "str_local_path", "uint64_file_size", "bytes_sha", "bytes_sha3", "bytes_md5", "bool_support_multi_upload"}, new Object[]{0L, 0, 0, 0, "", "", "", 0L, byteStringMicro, byteStringMicro, byteStringMicro, Boolean.FALSE}, UploadFileReqBody.class);
        }

        public UploadFileReqBody() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_sha = PBField.initBytes(byteStringMicro);
            this.bytes_sha3 = PBField.initBytes(byteStringMicro);
            this.bytes_md5 = PBField.initBytes(byteStringMicro);
            this.bool_support_multi_upload = PBField.initBool(false);
        }
    }

    public static class RenameFileReqBody extends MessageMicro<RenameFileReqBody> {
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
        public final PBStringField str_file_id = PBField.initString("");
        public final PBStringField str_parent_folder_id = PBField.initString("");
        public final PBStringField str_new_file_name = PBField.initString("");
    }
}