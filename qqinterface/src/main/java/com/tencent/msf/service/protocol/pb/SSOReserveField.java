package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class SSOReserveField {
    public static final int SSO_APPID_INVAILD = -10117;
    public static final int SSO_CMD_NOT_CONFIGED = -10115;
    public static final int SSO_D2_ENCRYPTED = 1;
    public static final int SSO_D2_EXPIRED = -10001;
    public static final int SSO_D2_UIN_NOT_MATCH = -10006;
    public static final int SSO_DEFAULT = 0;
    public static final int SSO_DEFAULT_FLAG = 0;
    public static final int SSO_DYEING_MESSAGE = 1;
    public static final int SSO_EMPTY_KEY_ENCRYPTED = 2;
    public static final int SSO_FORCE_RESET_KEY = -10106;
    public static final int SSO_GRAY_MESSAGE = 8;
    public static final int SSO_INVALID_A2D2 = -10003;
    public static final int SSO_INVALID_A2_CONN = -10004;
    public static final int SSO_IPV4_STACK = 1;
    public static final int SSO_IPV6_STACK = 2;
    public static final int SSO_IP_DUAL_STACK = 3;
    public static final int SSO_IP_ORIGIN_DEFAULT = 0;
    public static final int SSO_IP_ORIGIN_DISPATCH_DOMAIN = 4;
    public static final int SSO_IP_ORIGIN_DISPATCH_IP = 3;
    public static final int SSO_IP_ORIGIN_HARDCODE_DOMAIN = 2;
    public static final int SSO_IP_ORIGIN_HARDCODE_IP = 1;
    public static final int SSO_IP_UNDEFINED = 0;
    public static final int SSO_LOGIN_MERGE_FAILED = -10107;
    public static final int SSO_MULTI_ENV_MESSAGE = 4;
    public static final int SSO_NEED_SIGNATURE_FLAG = 4;
    public static final int SSO_NO_WIFI_BSSID_FLAG = 1;
    public static final int SSO_NT_FUNC_MESSAGE = 32;
    public static final int SSO_PARSE_FAILED = -10118;
    public static final int SSO_POOR_NETWORK_FLAG = 2;
    public static final int SSO_PRESSURE_MESSAGE = 16;
    public static final int SSO_PROTO_V0 = 0;
    public static final int SSO_PROTO_V20 = 20;
    public static final int SSO_PROTO_V21 = 21;
    public static final int SSO_REQUIRE_A2D2 = -10008;
    public static final int SSO_REQUIRE_D2_ENCRYPTED = -10005;
    public static final int SSO_RS_NO_INSTANCE = -10116;
    public static final int SSO_SEC_SIGN_ALL = 1;
    public static final int SSO_SEC_SIGN_NONE = 0;
    public static final int SSO_SEC_SIGN_SOME = 2;
    public static final int SSO_SUB_CONN_FAILD = -10114;
    public static final int SSO_SUCCESS = 0;
    public static final int SSO_TRACE_MESSAGE = 2;
    public static final int SSO_UNDEFINED_NETWORK = 0;
    public static final int SSO_UNENCRYPTED = 0;
    public static final int SSO_UNENCRYPTED_VERIFY_D2 = 3;
    public static final int SSO_V20_DISABLED = -10119;
    public static final int SSO_VERIFY_CODE = -10000;
    public static final int SSO_VERIFY_TIMEOUT = -10007;
    public static final int SSO_WIFI_NETWORK = 1;
    public static final int SSO_WIFI_XG_NETWORK = 3;
    public static final int SSO_XG_NETWORK = 2;

    public static final class ReserveFields extends MessageMicro<ReserveFields> {
        public final PBBytesField client_ipcookie;
        public final PBStringField env;
        public final PBUInt32Field env_id;
        public final PBUInt32Field flag;
        public final PBUInt32Field imsi;
        public final PBUInt32Field ip_stack_type;
        public final PBUInt32Field locale_id;
        public final PBUInt32Field message_type;
        public final PBUInt32Field network_type;
        public final PBUInt32Field newconn_flag;
        public final PBUInt32Field nt_core_version;
        public final PBBytesField presure_token;
        public final PBBytesField qimei;
        public SsoSecureInfo sec_info;
        public final PBUInt32Field sec_sig_flag;
        public final PBUInt32Field sso_ip_origin;
        public final PBUInt32Field sso_route_cost;
        public final PBStringField trace_parent;
        public final PBRepeatMessageField<SsoMapEntry> trans_info;
        public SsoTrpcResponse trpc_rsp;

        public final PBStringField uid;

        public ReserveFields() {
            this.client_ipcookie = PBField.initBytes(ByteStringMicro.EMPTY);
            this.flag = PBField.initUInt32(0);
            this.env_id = PBField.initUInt32(0);
            this.locale_id = PBField.initUInt32(0);
            this.qimei = PBField.initBytes(ByteStringMicro.EMPTY);
            this.env = PBField.initString("");
            this.newconn_flag = PBField.initUInt32(0);
            this.trace_parent = PBField.initString("");
            this.uid = PBField.initString("");
            this.imsi = PBField.initUInt32(0);
            this.network_type = PBField.initUInt32(0);
            this.ip_stack_type = PBField.initUInt32(0);
            this.message_type = PBField.initUInt32(0);
            this.trpc_rsp = new SsoTrpcResponse();
            this.trans_info = PBField.initRepeatMessage(SsoMapEntry.class);
            this.sec_info = new SsoSecureInfo();
            this.sec_sig_flag = PBField.initUInt32(0);
            this.nt_core_version = PBField.initUInt32(0);
            this.sso_route_cost = PBField.initUInt32(0);
            this.sso_ip_origin = PBField.initUInt32(0);
            this.presure_token = PBField.initBytes(ByteStringMicro.EMPTY);
        }
    }

    public static final class SsoMapEntry extends MessageMicro<SsoMapEntry> {
        public final PBStringField key = PBField.initString("");
        public final PBBytesField value = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    public static final class SsoSecureInfo extends MessageMicro<SsoSecureInfo> {
        public final PBBytesField sec_device_token;
        public final PBBytesField sec_extra;
        public final PBBytesField sec_sig;

        public SsoSecureInfo() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.sec_sig = PBField.initBytes(byteStringMicro);
            this.sec_device_token = PBField.initBytes(byteStringMicro);
            this.sec_extra = PBField.initBytes(byteStringMicro);
        }
    }

    public static final class SsoTrpcResponse extends MessageMicro<SsoTrpcResponse> {
        public final PBInt32Field ret = PBField.initInt32(0);
        public final PBInt32Field func_ret = PBField.initInt32(0);
        public final PBBytesField error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    }

}
