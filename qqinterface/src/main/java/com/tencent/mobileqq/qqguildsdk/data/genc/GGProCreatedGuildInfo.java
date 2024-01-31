package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProCreatedGuildInfo;

public  class GGProCreatedGuildInfo implements IGProCreatedGuildInfo {
    public final GProCreatedGuildInfo mInfo;

    public GGProCreatedGuildInfo(GProCreatedGuildInfo gProCreatedGuildInfo) {
        this.mInfo = gProCreatedGuildInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCreatedGuildInfo
    public long getCreateTime() {
        return this.mInfo.getCreateTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCreatedGuildInfo
    public String getFaceUrl() {
        return this.mInfo.getFaceUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCreatedGuildInfo
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCreatedGuildInfo
    public String getGuildName() {
        return this.mInfo.getGuildName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCreatedGuildInfo
    public long getGuildOwnerUin() {
        return this.mInfo.getGuildOwnerUin();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCreatedGuildInfo
    public long getMemberNum() {
        return this.mInfo.getMemberNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCreatedGuildInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
