package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProMemberInfo;

public  class GGProMemberInfo implements IGProMemberInfo {
    public final GProMemberInfo mInfo;

    public GGProMemberInfo(GProMemberInfo gProMemberInfo) {
        this.mInfo = gProMemberInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfo
    public String getAvatarMeta() {
        return this.mInfo.getAvatarMeta();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfo
    public int getGender() {
        return this.mInfo.getGender();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfo
    public long getTinyId() {
        return this.mInfo.getTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
