package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProGetRecommendPopupAdsRsp implements Serializable {
    ArrayList<GProRecommendPopupAdsInfo> adsInfoList;
    byte[] cookies;
    int nextTs;
    long serialVersionUID;

    public GProGetRecommendPopupAdsRsp() {
        this.serialVersionUID = 1L;
        this.adsInfoList = new ArrayList<>();
        this.cookies = new byte[0];
    }

    public ArrayList<GProRecommendPopupAdsInfo> getAdsInfoList() {
        return this.adsInfoList;
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public int getNextTs() {
        return this.nextTs;
    }

    public String toString() {
        return "GProGetRecommendPopupAdsRsp{adsInfoList=" + this.adsInfoList + ",nextTs=" + this.nextTs + ",cookies=" + this.cookies + ",}";
    }

    public GProGetRecommendPopupAdsRsp(ArrayList<GProRecommendPopupAdsInfo> arrayList, int i2, byte[] bArr) {
        this.serialVersionUID = 1L;
        this.adsInfoList = new ArrayList<>();
        this.cookies = new byte[0];
        this.adsInfoList = arrayList;
        this.nextTs = i2;
        this.cookies = bArr;
    }
}
