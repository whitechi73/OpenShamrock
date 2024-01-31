package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProGetRecommendHotReq implements Serializable {
    byte[] adReq;
    String busiInfo;
    byte[] cookies;
    int direction;
    int refreshNum;
    long serialVersionUID;
    GProBottomTabSourceInfo source;

    public GProGetRecommendHotReq() {
        this.serialVersionUID = 1L;
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

    public byte[] getCookies() {
        return this.cookies;
    }

    public int getDirection() {
        return this.direction;
    }

    public int getRefreshNum() {
        return this.refreshNum;
    }

    public GProBottomTabSourceInfo getSource() {
        return this.source;
    }

    public String toString() {
        return "GProGetRecommendHotReq{source=" + this.source + ",cookies=" + this.cookies + ",direction=" + this.direction + ",refreshNum=" + this.refreshNum + ",busiInfo=" + this.busiInfo + ",adReq=" + this.adReq + ",}";
    }

    public GProGetRecommendHotReq(GProBottomTabSourceInfo gProBottomTabSourceInfo, byte[] bArr, int i2, int i3, String str, byte[] bArr2) {
        this.serialVersionUID = 1L;
        this.source = new GProBottomTabSourceInfo();
        this.cookies = new byte[0];
        this.busiInfo = "";
        this.adReq = new byte[0];
        this.source = gProBottomTabSourceInfo;
        this.cookies = bArr;
        this.direction = i2;
        this.refreshNum = i3;
        this.busiInfo = str;
        this.adReq = bArr2;
    }
}
