package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProGetRecommendV2Req implements Serializable {
    String block;
    byte[] cookies;
    long serialVersionUID;
    GProBottomTabSourceInfo source;
    long subBlockId;

    public GProGetRecommendV2Req() {
        this.serialVersionUID = 1L;
        this.block = "";
        this.cookies = new byte[0];
        this.source = new GProBottomTabSourceInfo();
    }

    public String getBlock() {
        return this.block;
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public GProBottomTabSourceInfo getSource() {
        return this.source;
    }

    public long getSubBlockId() {
        return this.subBlockId;
    }

    public String toString() {
        return "GProGetRecommendV2Req{block=" + this.block + ",subBlockId=" + this.subBlockId + ",cookies=" + this.cookies + ",source=" + this.source + ",}";
    }

    public GProGetRecommendV2Req(String str, long j2, byte[] bArr, GProBottomTabSourceInfo gProBottomTabSourceInfo) {
        this.serialVersionUID = 1L;
        this.block = "";
        this.cookies = new byte[0];
        this.source = new GProBottomTabSourceInfo();
        this.block = str;
        this.subBlockId = j2;
        this.cookies = bArr;
        this.source = gProBottomTabSourceInfo;
    }
}
