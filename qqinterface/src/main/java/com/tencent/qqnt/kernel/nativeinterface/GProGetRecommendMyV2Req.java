package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProGetRecommendMyV2Req {
    byte[] adReq;
    String busiInfo;
    int businessType;
    byte[] cookies;
    int direction;
    boolean existRecommend;
    int refreshNum;
    GProBottomTabSourceInfo source;

    public GProGetRecommendMyV2Req() {
        this.source = new GProBottomTabSourceInfo();
        this.cookies = new byte[0];
        this.busiInfo = "";
        this.adReq = new byte[0];
    }

    public byte[] getAdReq() {
        return this.adReq;
    }

    public String getBusiInfo() {
        return this.busiInfo;
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public int getDirection() {
        return this.direction;
    }

    public boolean getExistRecommend() {
        return this.existRecommend;
    }

    public int getRefreshNum() {
        return this.refreshNum;
    }

    public GProBottomTabSourceInfo getSource() {
        return this.source;
    }

    public String toString() {
        return "GProGetRecommendMyV2Req{businessType=" + this.businessType + ",direction=" + this.direction + ",refreshNum=" + this.refreshNum + ",source=" + this.source + ",cookies=" + this.cookies + ",existRecommend=" + this.existRecommend + ",busiInfo=" + this.busiInfo + ",adReq=" + this.adReq + ",}";
    }

    public GProGetRecommendMyV2Req(int i2, int i3, int i4, GProBottomTabSourceInfo gProBottomTabSourceInfo, byte[] bArr, boolean z, String str, byte[] bArr2) {
        this.source = new GProBottomTabSourceInfo();
        this.cookies = new byte[0];
        this.busiInfo = "";
        this.adReq = new byte[0];
        this.businessType = i2;
        this.direction = i3;
        this.refreshNum = i4;
        this.source = gProBottomTabSourceInfo;
        this.cookies = bArr;
        this.existRecommend = z;
        this.busiInfo = str;
        this.adReq = bArr2;
    }
}
