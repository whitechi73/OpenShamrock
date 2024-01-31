package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProGetInvitationGuildRsp implements Serializable {
    byte[] cookies;
    GProRecommendItem item;
    int nextTs;
    long serialVersionUID;
    String traceId;

    public GProGetInvitationGuildRsp() {
        this.serialVersionUID = 1L;
        this.traceId = "";
        this.cookies = new byte[0];
        this.item = new GProRecommendItem();
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public GProRecommendItem getItem() {
        return this.item;
    }

    public int getNextTs() {
        return this.nextTs;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String toString() {
        return "GProGetInvitationGuildRsp{traceId=" + this.traceId + ",cookies=" + this.cookies + ",item=" + this.item + ",nextTs=" + this.nextTs + ",}";
    }

    public GProGetInvitationGuildRsp(String str, byte[] bArr, GProRecommendItem gProRecommendItem, int i2) {
        this.serialVersionUID = 1L;
        this.traceId = "";
        this.cookies = new byte[0];
        this.item = new GProRecommendItem();
        this.traceId = str;
        this.cookies = bArr;
        this.item = gProRecommendItem;
        this.nextTs = i2;
    }
}
