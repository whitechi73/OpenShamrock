package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProGetRtmpPushUrlRsp {
    int expireTs;
    int result;
    String rmtpUrl;
    String serverPart;
    String streamParam;

    public GProGetRtmpPushUrlRsp() {
        this.rmtpUrl = "";
        this.serverPart = "";
        this.streamParam = "";
    }

    public int getExpireTs() {
        return this.expireTs;
    }

    public int getResult() {
        return this.result;
    }

    public String getRmtpUrl() {
        return this.rmtpUrl;
    }

    public String getServerPart() {
        return this.serverPart;
    }

    public String getStreamParam() {
        return this.streamParam;
    }

    public String toString() {
        return "GProGetRtmpPushUrlRsp{result=" + this.result + ",rmtpUrl=" + this.rmtpUrl + ",serverPart=" + this.serverPart + ",streamParam=" + this.streamParam + ",expireTs=" + this.expireTs + ",}";
    }

    public GProGetRtmpPushUrlRsp(int i2, String str, String str2, String str3, int i3) {
        this.rmtpUrl = "";
        this.serverPart = "";
        this.streamParam = "";
        this.result = i2;
        this.rmtpUrl = str;
        this.serverPart = str2;
        this.streamParam = str3;
        this.expireTs = i3;
    }
}
