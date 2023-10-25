package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProRecommendNewCardReq {
    int businessType;
    byte[] cookies;
    GProBottomTabSourceInfo source;
    int tabType;

    public GProRecommendNewCardReq() {
        this.cookies = new byte[0];
        this.source = new GProBottomTabSourceInfo();
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public GProBottomTabSourceInfo getSource() {
        return this.source;
    }

    public int getTabType() {
        return this.tabType;
    }

    public String toString() {
        return "GProRecommendNewCardReq{businessType=" + this.businessType + ",cookies=" + this.cookies + ",source=" + this.source + ",tabType=" + this.tabType + ",}";
    }

    public GProRecommendNewCardReq(int i2, byte[] bArr, GProBottomTabSourceInfo gProBottomTabSourceInfo, int i3) {
        this.cookies = new byte[0];
        this.source = new GProBottomTabSourceInfo();
        this.businessType = i2;
        this.cookies = bArr;
        this.source = gProBottomTabSourceInfo;
        this.tabType = i3;
    }
}
