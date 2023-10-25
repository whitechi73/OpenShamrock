package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProFetchDiscoverRedReq {
    int businessType;
    byte[] cookies;
    int hitTabType;
    long seq;

    public GProFetchDiscoverRedReq() {
        this.cookies = new byte[0];
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public int getHitTabType() {
        return this.hitTabType;
    }

    public long getSeq() {
        return this.seq;
    }

    public String toString() {
        return "GProFetchDiscoverRedReq{seq=" + this.seq + ",businessType=" + this.businessType + ",hitTabType=" + this.hitTabType + ",cookies=" + this.cookies + ",}";
    }

    public GProFetchDiscoverRedReq(long j2, int i2, int i3, byte[] bArr) {
        this.cookies = new byte[0];
        this.seq = j2;
        this.businessType = i2;
        this.hitTabType = i3;
        this.cookies = bArr;
    }
}
