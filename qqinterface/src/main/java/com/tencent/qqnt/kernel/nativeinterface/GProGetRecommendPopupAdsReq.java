package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProGetRecommendPopupAdsReq implements Serializable {
    byte[] cookies;
    long serialVersionUID;
    GProBottomTabSourceInfo source;
    int tabType;

    public GProGetRecommendPopupAdsReq() {
        this.serialVersionUID = 1L;
        this.cookies = new byte[0];
        this.source = new GProBottomTabSourceInfo();
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
        return "GProGetRecommendPopupAdsReq{cookies=" + this.cookies + ",tabType=" + this.tabType + ",source=" + this.source + ",}";
    }

    public GProGetRecommendPopupAdsReq(byte[] bArr, int i2, GProBottomTabSourceInfo gProBottomTabSourceInfo) {
        this.serialVersionUID = 1L;
        this.cookies = new byte[0];
        this.source = new GProBottomTabSourceInfo();
        this.cookies = bArr;
        this.tabType = i2;
        this.source = gProBottomTabSourceInfo;
    }
}
