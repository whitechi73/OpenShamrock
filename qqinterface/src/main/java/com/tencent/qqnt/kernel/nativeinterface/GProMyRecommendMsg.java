package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProMyRecommendMsg implements Serializable {
    int businessType;
    GProDiscoverStatus discoverStatus;
    int flag;
    int pointType;
    long serialVersionUID;

    public GProMyRecommendMsg() {
        this.serialVersionUID = 1L;
        this.discoverStatus = new GProDiscoverStatus();
    }

    public int getBusinessType() {
        return this.businessType;
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

    public String toString() {
        return "GProMyRecommendMsg{flag=" + this.flag + ",businessType=" + this.businessType + ",discoverStatus=" + this.discoverStatus + ",pointType=" + this.pointType + ",}";
    }

    public GProMyRecommendMsg(int i2, int i3, GProDiscoverStatus gProDiscoverStatus, int i4) {
        this.serialVersionUID = 1L;
        this.discoverStatus = new GProDiscoverStatus();
        this.flag = i2;
        this.businessType = i3;
        this.discoverStatus = gProDiscoverStatus;
        this.pointType = i4;
    }
}
