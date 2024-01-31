package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProMedal;


public class GGProMedal implements IGProMedal {
    public final GProMedal mInfo;

    public GGProMedal(GProMedal gProMedal) {
        this.mInfo = gProMedal;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedal
    public String getDesc() {
        return this.mInfo.getDesc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedal
    public long getEndTime() {
        return this.mInfo.getEndTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedal
    public long getStartTime() {
        return this.mInfo.getStartTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedal
    public String getUrl() {
        return this.mInfo.getUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedal
    public String toString() {
        return this.mInfo.toString();
    }
}
