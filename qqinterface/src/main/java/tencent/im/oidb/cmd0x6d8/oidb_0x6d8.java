package tencent.im.oidb.cmd0x6d8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

import tencent.im.cs.group_file_common.group_file_common;

public class oidb_0x6d8 {
    public static class ReqBody extends MessageMicro<ReqBody> {
        //static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"file_info_req", "file_list_info_req", "group_file_cnt_req", "group_space_req", "file_preview_req"}, new Object[]{null, null, null, null, null}, oidb_0x6d8$ReqBody.class);
        public GetFileInfoReqBody file_info_req = new GetFileInfoReqBody();
        public GetFileListReqBody file_list_info_req = new GetFileListReqBody();
        public GetFileCountReqBody group_file_cnt_req = new GetFileCountReqBody();
        public GetSpaceReqBody group_space_req = new GetSpaceReqBody();
        //public oidb_0x6d8$GetFilePreviewReqBody file_preview_req = new oidb_0x6d8$GetFilePreviewReqBody();
    }

    public static class GetFileInfoRspBody extends MessageMicro<GetFileInfoRspBody> {
        //static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"int32_ret_code", "str_ret_msg", "str_client_wording", "file_info"}, new Object[]{0, "", "", null}, oidb_0x6d8$GetFileInfoRspBody.class);
        public final PBInt32Field int32_ret_code = PBField.initInt32(0);
        public final PBStringField str_ret_msg = PBField.initString("");
        public final PBStringField str_client_wording = PBField.initString("");
        public group_file_common.FileInfo file_info = new group_file_common.FileInfo();
    }

    public static class GetFileListReqBody extends MessageMicro<GetFileListReqBody> {
        public static final int SORT_BY_DOWNLOAD = 6;
        public static final int SORT_BY_FILENAME = 4;
        public static final int SORT_BY_FILESIZE = 5;
        public static final int SORT_BY_FILETYPE = 2;
        public static final int SORT_BY_TIMESTAMP = 1;
        public static final int SORT_BY_UPLOADER = 3;
        //static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50, 56, 64, 72, 80, 88, 96, 104, 114, 120, 128, 136, 144}, new String[]{"uint64_group_code", "uint32_app_id", "str_folder_id", "start_timestamp", "uint32_file_count", "max_timestamp", "uint32_all_file_count", "uint32_req_from", "uint32_sort_by", "uint32_filter_code", "uint64_uin", "uint32_field_flag", "uint32_start_index", "bytes_context", "uint32_client_version", "uint32_white_list", "uint32_sort_order", "uint32_show_onlinedoc_folder"}, new Object[]{0L, 0, "", null, 0, null, 0, 0, 0, 0, 0L, 16777215, 0, ByteStringMicro.EMPTY, 0, 0, 0, 0}, oidb_0x6d8$GetFileListReqBody.class);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
        public final PBStringField str_folder_id = PBField.initString("");
        public FileTimeStamp start_timestamp = new FileTimeStamp();
        public final PBUInt32Field uint32_file_count = PBField.initUInt32(0);
        public FileTimeStamp max_timestamp = new FileTimeStamp();
        public final PBUInt32Field uint32_all_file_count = PBField.initUInt32(0);
        public final PBUInt32Field uint32_req_from = PBField.initUInt32(0);
        public final PBUInt32Field uint32_sort_by = PBField.initUInt32(0);
        public final PBUInt32Field uint32_filter_code = PBField.initUInt32(0);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_field_flag = PBField.initUInt32(16777215);
        public final PBUInt32Field uint32_start_index = PBField.initUInt32(0);
        public final PBBytesField bytes_context = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_client_version = PBField.initUInt32(0);
        public final PBUInt32Field uint32_white_list = PBField.initUInt32(0);
        public final PBUInt32Field uint32_sort_order = PBField.initUInt32(0);
        public final PBUInt32Field uint32_show_onlinedoc_folder = PBField.initUInt32(0);
    }

    public static class FileTimeStamp extends MessageMicro<FileTimeStamp> {
        //static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_upload_time", "str_file_id"}, new Object[]{0, ""}, oidb_0x6d8$FileTimeStamp.class);
        public final PBUInt32Field uint32_upload_time = PBField.initUInt32(0);
        public final PBStringField str_file_id = PBField.initString("");
    }

    public static final class GetFileCountReqBody extends MessageMicro<GetFileCountReqBody> {
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    }

    public static class RspBody extends MessageMicro<RspBody> {
        //static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"file_info_rsp", "file_list_info_rsp", "group_file_cnt_rsp", "group_space_rsp", "file_preview_rsp"}, new Object[]{null, null, null, null, null}, oidb_0x6d8$RspBody.class);
        public GetFileInfoRspBody file_info_rsp = new GetFileInfoRspBody();
        public GetFileListRspBody file_list_info_rsp = new GetFileListRspBody(); // 2
        public GetFileCountRspBody group_file_cnt_rsp = new GetFileCountRspBody(); // 3
        public GetSpaceRspBody group_space_rsp = new GetSpaceRspBody(); // 4
        //public oidb_0x6d8$GetFilePreviewRspBody file_preview_rsp = new oidb_0x6d8$GetFilePreviewRspBody();
    }

    public static class GetSpaceRspBody extends MessageMicro<GetSpaceRspBody> {
        //static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48}, new String[]{"int32_ret_code", "str_ret_msg", "str_client_wording", "uint64_total_space", "uint64_used_space", "bool_all_upload"}, new Object[]{0, "", "", 0L, 0L, Boolean.FALSE}, oidb_0x6d8$GetSpaceRspBody.class);
        public final PBInt32Field int32_ret_code = PBField.initInt32(0);
        public final PBStringField str_ret_msg = PBField.initString("");
        public final PBStringField str_client_wording = PBField.initString("");
        public final PBUInt64Field uint64_total_space = PBField.initUInt64(0);
        public final PBUInt64Field uint64_used_space = PBField.initUInt64(0);
        public final PBBoolField bool_all_upload = PBField.initBool(false);
    }

    public static class GetFileCountRspBody extends MessageMicro<GetFileCountRspBody> {
        public final PBInt32Field int32_ret_code = PBField.initInt32(0);
        public final PBStringField str_ret_msg = PBField.initString("");
        public final PBStringField str_client_wording = PBField.initString("");
        public final PBUInt32Field uint32_all_file_count = PBField.initUInt32(0);
        public final PBBoolField bool_file_too_many = PBField.initBool(false);
        public final PBUInt32Field uint32_limit_count = PBField.initUInt32(0);
        public final PBBoolField bool_is_full = PBField.initBool(false);
    }

    public static class GetSpaceReqBody extends MessageMicro<GetSpaceReqBody> {
        //static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_group_code", "uint32_app_id"}, new Object[]{0L, 0}, oidb_0x6d8$GetSpaceReqBody.class);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    }

    public static class GetFileListRspBody extends MessageMicro<GetFileListRspBody> {
        public static final int TYPE_FILE = 1;
        public static final int TYPE_FOLDER = 2;

        public final PBInt32Field int32_ret_code = PBField.initInt32(0);
        public final PBStringField str_ret_msg = PBField.initString("");
        public final PBStringField str_client_wording = PBField.initString("");
        public final PBBoolField bool_is_end = PBField.initBool(false);
        public final PBRepeatMessageField<Item> rpt_item_list = PBField.initRepeatMessage(Item.class);
        public FileTimeStamp msg_max_timestamp = new FileTimeStamp();
        public final PBUInt32Field uint32_all_file_count = PBField.initUInt32(0);
        public final PBUInt32Field uint32_filter_code = PBField.initUInt32(0);
        public final PBBoolField bool_safe_check_flag = PBField.initBool(false);
        public final PBUInt32Field uint32_safe_check_res = PBField.initUInt32(0);
        public final PBUInt32Field uint32_next_index = PBField.initUInt32(0);
        public final PBBytesField bytes_context = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_role = PBField.initUInt32(0);
        public final PBUInt32Field uint32_open_flag = PBField.initUInt32(0);

        public static final class Item extends MessageMicro<Item> {
            //static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_type", "folder_info", "file_info"}, new Object[]{0, null, null}, Item.class);
            public final PBUInt32Field uint32_type = PBField.initUInt32(0);
            public group_file_common.FolderInfo folder_info = new group_file_common.FolderInfo();
            public group_file_common.FileInfo file_info = new group_file_common.FileInfo();
        }

        //static {
        //    Boolean bool = Boolean.FALSE;
        //    __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 56, 64, 88, 96, 104, 114, 120, 128}, new String[]{"int32_ret_code", "str_ret_msg", "str_client_wording", "bool_is_end",
        //            "rpt_item_list",
        //            "msg_max_timestamp",
        //            "uint32_all_file_count", //7
        //            "uint32_filter_code",
        //            "bool_safe_check_flag", // 9
        //            "uint32_safe_check_res", "uint32_next_index", "bytes_context",
         //           "uint32_role",  // 13
         //           "uint32_open_flag"}, new Object[]{0, "", "", bool, null, null, 0, 0, bool, 0, 0, ByteStringMicro.EMPTY, 0, 0}, oidb_0x6d8$GetFileListRspBody.class);
        //}
    }

    public static final class GetFileInfoReqBody extends MessageMicro<GetFileInfoReqBody> {
        //static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40}, new String[]{"uint64_group_code", "uint32_app_id", "uint32_bus_id", "str_file_id", "uint32_field_flag"}, new Object[]{0L, 0, 0, "", 16777215}, oidb_0x6d8$GetFileInfoReqBody.class);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
        public final PBStringField str_file_id = PBField.initString("");
        public final PBUInt32Field uint32_field_flag = PBField.initUInt32(16777215);
    }
}
