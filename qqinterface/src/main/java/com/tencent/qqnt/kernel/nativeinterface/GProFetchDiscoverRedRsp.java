package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProFetchDiscoverRedRsp {
    int businessType;
    byte[] cookies;
    GProDiscoverStatus discoverStatus;
    int flag;
    int pointType;
    long seq;

    public GProFetchDiscoverRedRsp() {
        this.discoverStatus = new GProDiscoverStatus();
        this.cookies = new byte[0];
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public GProDiscoverStatus getDiscoverStatus() {
        return this.discoverStatus;
    }

    public int getFlag() {
        return this.flag;
    }

    public int getPointType() {
        return this.pointType;
    }

    public long getSeq() {
        return this.seq;
    }

    public String toString() {
        return "GProFetchDiscoverRedRsp{flag=" + this.flag + ",seq=" + this.seq + ",businessType=" + this.businessType + ",discoverStatus=" + this.discoverStatus + ",cookies=" + this.cookies + ",pointType=" + this.pointType + ",}";
    }

    public GProFetchDiscoverRedRsp(int i2, long j2, int i3, GProDiscoverStatus gProDiscoverStatus, byte[] bArr, int i4) {
        this.discoverStatus = new GProDiscoverStatus();
        this.cookies = new byte[0];
        this.flag = i2;
        this.seq = j2;
        this.businessType = i3;
        this.discoverStatus = gProDiscoverStatus;
        this.cookies = bArr;
        this.pointType = i4;
    }
}
