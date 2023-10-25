package tencent.im.cs.group_file_common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class group_file_common {
    public static class FolderInfo extends MessageMicro<FolderInfo> {
        //static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 58, 64, 72, 82, 88}, new String[]{"str_folder_id", "str_parent_folder_id", "str_folder_name", "uint32_create_time", "uint32_modify_time", "uint64_create_uin", "str_creator_name", "uint32_total_file_count", "uint64_modify_uin", "str_modify_name", "uint64_used_space"}, new Object[]{"", "", "", 0, 0, 0L, "", 0, 0L, "", 0L}, group_file_common$FolderInfo.class);
        public final PBStringField str_folder_id = PBField.initString("");
        public final PBStringField str_parent_folder_id = PBField.initString("");
        public final PBStringField str_folder_name = PBField.initString("");
        public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_modify_time = PBField.initUInt32(0);
        public final PBUInt64Field uint64_create_uin = PBField.initUInt64(0);
        public final PBStringField str_creator_name = PBField.initString("");
        public final PBUInt32Field uint32_total_file_count = PBField.initUInt32(0);
        public final PBUInt64Field uint64_modify_uin = PBField.initUInt64(0);
        public final PBStringField str_modify_name = PBField.initString("");
        public final PBUInt64Field uint64_used_space = PBField.initUInt64(0);
    }

    public static class FileInfo extends MessageMicro<FileInfo> {
        //static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_file_blob_ext;
        public final PBBytesField bytes_md5;
        public final PBBytesField bytes_reserved_field;
        public final PBBytesField bytes_sha;
        public final PBBytesField bytes_sha3;
        public final PBStringField str_feed_id;
        public final PBStringField str_local_path;
        public final PBStringField str_parent_folder_id;
        public final PBStringField str_uploader_name;
        public final PBUInt32Field uint32_safe_type;
        public final PBUInt64Field uint64_owner_uin;
        public final PBUInt64Field uint64_uploader_uin;
        public final PBStringField str_file_id = PBField.initString("");
        public final PBStringField str_file_name = PBField.initString("");
        public final PBUInt64Field uint64_file_size = PBField.initUInt64(0);
        public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
        public final PBUInt64Field uint64_uploaded_size = PBField.initUInt64(0);
        public final PBUInt32Field uint32_upload_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_dead_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_modify_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_download_times = PBField.initUInt32(0);

        //static {
        //    ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        //    __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56, 64, 72, 82, 90, 98, 106, 114, 120, 130, 136, 162, 168, 178, 186}, new String[]{"str_file_id", "str_file_name", "uint64_file_size", "uint32_bus_id", "uint64_uploaded_size", "uint32_upload_time", "uint32_dead_time", "uint32_modify_time", "uint32_download_times", "bytes_sha", "bytes_sha3", "bytes_md5", "str_local_path", "str_uploader_name", "uint64_uploader_uin", "str_parent_folder_id", "uint32_safe_type", "bytes_file_blob_ext", "uint64_owner_uin", "str_feed_id", "bytes_reserved_field"}, new Object[]{"", "", 0L, 0, 0L, 0, 0, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, "", "", 0L, "", 0, byteStringMicro, 0L, "", byteStringMicro}, group_file_common$FileInfo.class);
        //}

        public FileInfo() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_sha = PBField.initBytes(byteStringMicro);
            this.bytes_sha3 = PBField.initBytes(byteStringMicro);
            this.bytes_md5 = PBField.initBytes(byteStringMicro);
            this.str_local_path = PBField.initString("");
            this.str_uploader_name = PBField.initString("");
            this.uint64_uploader_uin = PBField.initUInt64(0L);
            this.str_parent_folder_id = PBField.initString("");
            this.uint32_safe_type = PBField.initUInt32(0);
            this.bytes_file_blob_ext = PBField.initBytes(byteStringMicro);
            this.uint64_owner_uin = PBField.initUInt64(0L);
            this.str_feed_id = PBField.initString("");
            this.bytes_reserved_field = PBField.initBytes(byteStringMicro);
        }
    }
}
