package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProBottomTabExpReq {
    int businessType;
    GProBottomTabSourceInfo source;

    public GProBottomTabExpReq() {
        this.source = new GProBottomTabSourceInfo();
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public GProBottomTabSourceInfo getSource() {
        return this.source;
    }

    public String toString() {
        return "GProBottomTabExpReq{businessType=" + this.businessType + ",source=" + this.source + ",}";
    }

    public GProBottomTabExpReq(int i2, GProBottomTabSourceInfo gProBottomTabSourceInfo) {
        this.source = new GProBottomTabSourceInfo();
        this.businessType = i2;
        this.source = gProBottomTabSourceInfo;
    }
}
