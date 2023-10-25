package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProGetRecommendTagListReq {
    int businessType;
    byte[] cookies;
    String groupId;
    GProBottomTabSourceInfo source;
    String type;

    public GProGetRecommendTagListReq() {
        this.groupId = "";
        this.type = "";
        this.source = new GProBottomTabSourceInfo();
        this.cookies = new byte[0];
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public GProBottomTabSourceInfo getSource() {
        return this.source;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        return "GProGetRecommendTagListReq{businessType=" + this.businessType + ",groupId=" + this.groupId + ",type=" + this.type + ",source=" + this.source + ",cookies=" + this.cookies + ",}";
    }

    public GProGetRecommendTagListReq(int i2, String str, String str2, GProBottomTabSourceInfo gProBottomTabSourceInfo, byte[] bArr) {
        this.groupId = "";
        this.type = "";
        this.source = new GProBottomTabSourceInfo();
        this.cookies = new byte[0];
        this.businessType = i2;
        this.groupId = str;
        this.type = str2;
        this.source = gProBottomTabSourceInfo;
        this.cookies = bArr;
    }
}
