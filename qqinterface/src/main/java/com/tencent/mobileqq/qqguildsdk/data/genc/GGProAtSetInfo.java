package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProAtSetInfo;

public  class GGProAtSetInfo implements IGProAtSetInfo {
    public final GProAtSetInfo mInfo;

    public GGProAtSetInfo(GProAtSetInfo gProAtSetInfo) {
        this.mInfo = gProAtSetInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAtSetInfo
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAtSetInfo
    public int getRemainingAtAllCount() {
        return this.mInfo.getRemainingAtAllCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAtSetInfo
    public int getRemainingAtOnlCount() {
        return this.mInfo.getRemainingAtOnlCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAtSetInfo
    public int getRemainingAtRoleCount() {
        return this.mInfo.getRemainingAtRoleCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAtSetInfo
    public int getTotalAtAllCount() {
        return this.mInfo.getTotalAtAllCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAtSetInfo
    public int getTotalAtOnlCount() {
        return this.mInfo.getTotalAtOnlCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAtSetInfo
    public int getTotalAtRoleCount() {
        return this.mInfo.getTotalAtRoleCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAtSetInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
