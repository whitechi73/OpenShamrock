package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProAnchorTrtcInfo {
    String businessInfo;
    String sig;
    GProStreamIDInfo streamInfo;
    Long timeout;
    String trtcStr;

    public GProAnchorTrtcInfo() {
    }

    public String getBusinessInfo() {
        return this.businessInfo;
    }

    public String getSig() {
        return this.sig;
    }

    public GProStreamIDInfo getStreamInfo() {
        return this.streamInfo;
    }

    public Long getTimeout() {
        return this.timeout;
    }

    public String getTrtcStr() {
        return this.trtcStr;
    }

    public String toString() {
        return "GProAnchorTrtcInfo{sig=" + this.sig + ",timeout=" + this.timeout + ",streamInfo=" + this.streamInfo + ",businessInfo=" + this.businessInfo + ",trtcStr=" + this.trtcStr + ",}";
    }

    public GProAnchorTrtcInfo(String str, Long l2, GProStreamIDInfo gProStreamIDInfo, String str2, String str3) {
        this.sig = str;
        this.timeout = l2;
        this.streamInfo = gProStreamIDInfo;
        this.businessInfo = str2;
        this.trtcStr = str3;
    }
}
