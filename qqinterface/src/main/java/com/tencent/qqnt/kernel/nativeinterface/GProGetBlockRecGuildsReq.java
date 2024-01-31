package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProGetBlockRecGuildsReq implements Serializable {
    String busiInfo;
    int businessType;
    byte[] cookies;
    long serialVersionUID;
    GProBottomTabSourceInfo source;
    GProTopRecommendInfo topRecommend;

    public GProGetBlockRecGuildsReq() {
        this.serialVersionUID = 1L;
        this.cookies = new byte[0];
        this.source = new GProBottomTabSourceInfo();
        this.topRecommend = new GProTopRecommendInfo();
        this.busiInfo = "";
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

    public GProBottomTabSourceInfo getSource() {
        return this.source;
    }

    public GProTopRecommendInfo getTopRecommend() {
        return this.topRecommend;
    }

    public String toString() {
        return "GProGetBlockRecGuildsReq{businessType=" + this.businessType + ",cookies=" + this.cookies + ",source=" + this.source + ",topRecommend=" + this.topRecommend + ",busiInfo=" + this.busiInfo + ",}";
    }

    public GProGetBlockRecGuildsReq(int i2, byte[] bArr, GProBottomTabSourceInfo gProBottomTabSourceInfo, GProTopRecommendInfo gProTopRecommendInfo, String str) {
        this.serialVersionUID = 1L;
        this.cookies = new byte[0];
        this.source = new GProBottomTabSourceInfo();
        this.topRecommend = new GProTopRecommendInfo();
        this.busiInfo = "";
        this.businessType = i2;
        this.cookies = bArr;
        this.source = gProBottomTabSourceInfo;
        this.topRecommend = gProTopRecommendInfo;
        this.busiInfo = str;
    }
}
