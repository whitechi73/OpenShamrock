package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProAnchorMediaInfo {
    String serverPart;
    String sig;
    String streamParam;
    Long timeout;
    Long type;

    public GProAnchorMediaInfo() {
    }

    public String getServerPart() {
        return this.serverPart;
    }

    public String getSig() {
        return this.sig;
    }

    public String getStreamParam() {
        return this.streamParam;
    }

    public Long getTimeout() {
        return this.timeout;
    }

    public Long getType() {
        return this.type;
    }

    public String toString() {
        return "GProAnchorMediaInfo{sig=" + this.sig + ",timeout=" + this.timeout + ",type=" + this.type + ",serverPart=" + this.serverPart + ",streamParam=" + this.streamParam + ",}";
    }

    public GProAnchorMediaInfo(String str, Long l2, Long l3, String str2, String str3) {
        this.sig = str;
        this.timeout = l2;
        this.type = l3;
        this.serverPart = str2;
        this.streamParam = str3;
    }
}
