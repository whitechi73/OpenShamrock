package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProGetRecommendV2Rsp implements Serializable {
    GProBannerBlockList banners;
    byte[] cookies;
    int discoverType;
    GProRecommendExtInfo extInfo;
    GProPopBlockList popups;
    long serialVersionUID;
    GProRecommendV2TracksBlockList tracks;

    public GProGetRecommendV2Rsp() {
        this.serialVersionUID = 1L;
        this.banners = new GProBannerBlockList();
        this.tracks = new GProRecommendV2TracksBlockList();
        this.extInfo = new GProRecommendExtInfo();
        this.cookies = new byte[0];
        this.popups = new GProPopBlockList();
    }

    public GProBannerBlockList getBanners() {
        return this.banners;
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public int getDiscoverType() {
        return this.discoverType;
    }

    public GProRecommendExtInfo getExtInfo() {
        return this.extInfo;
    }

    public GProPopBlockList getPopups() {
        return this.popups;
    }

    public GProRecommendV2TracksBlockList getTracks() {
        return this.tracks;
    }

    public String toString() {
        return "GProGetRecommendV2Rsp{discoverType=" + this.discoverType + ",banners=" + this.banners + ",tracks=" + this.tracks + ",extInfo=" + this.extInfo + ",cookies=" + this.cookies + ",popups=" + this.popups + ",}";
    }

    public GProGetRecommendV2Rsp(int i2, GProBannerBlockList gProBannerBlockList, GProRecommendV2TracksBlockList gProRecommendV2TracksBlockList, GProRecommendExtInfo gProRecommendExtInfo, byte[] bArr, GProPopBlockList gProPopBlockList) {
        this.serialVersionUID = 1L;
        this.banners = new GProBannerBlockList();
        this.tracks = new GProRecommendV2TracksBlockList();
        this.extInfo = new GProRecommendExtInfo();
        this.cookies = new byte[0];
        this.popups = new GProPopBlockList();
        this.discoverType = i2;
        this.banners = gProBannerBlockList;
        this.tracks = gProRecommendV2TracksBlockList;
        this.extInfo = gProRecommendExtInfo;
        this.cookies = bArr;
        this.popups = gProPopBlockList;
    }
}
