package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProGetDiscoverRecommendGuildsReq {
    int businessType;
    byte[] cookies;
    GProBottomTabSourceInfo source;
    int topN;

    public GProGetDiscoverRecommendGuildsReq() {
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

    public int getTopN() {
        return this.topN;
    }

    public String toString() {
        return "GProGetDiscoverRecommendGuildsReq{businessType=" + this.businessType + ",cookies=" + this.cookies + ",source=" + this.source + ",topN=" + this.topN + ",}";
    }

    public GProGetDiscoverRecommendGuildsReq(int i2, byte[] bArr, GProBottomTabSourceInfo gProBottomTabSourceInfo, int i3) {
        this.cookies = new byte[0];
        this.source = new GProBottomTabSourceInfo();
        this.businessType = i2;
        this.cookies = bArr;
        this.source = gProBottomTabSourceInfo;
        this.topN = i3;
    }
}
