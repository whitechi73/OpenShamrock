package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProAVDevOptInfo;

public  class GGProAVDevOptInfo implements IGProAVDevOptInfo {
    public final GProAVDevOptInfo mInfo;

    public GGProAVDevOptInfo(GProAVDevOptInfo gProAVDevOptInfo) {
        this.mInfo = gProAVDevOptInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVDevOptInfo
    public int getCameraOpt() {
        return this.mInfo.getCameraOpt();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVDevOptInfo
    public int getMicOpt() {
        return this.mInfo.getMicOpt();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVDevOptInfo
    public int getScreenOpt() {
        return this.mInfo.getScreenOpt();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVDevOptInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
