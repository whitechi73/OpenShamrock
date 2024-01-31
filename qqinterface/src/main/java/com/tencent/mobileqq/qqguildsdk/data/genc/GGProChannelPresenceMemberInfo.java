package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProChannelPresenceMemberInfo;

public  class GGProChannelPresenceMemberInfo implements IGProChannelPresenceMemberInfo {
    public final GProChannelPresenceMemberInfo mInfo;

    public GGProChannelPresenceMemberInfo(GProChannelPresenceMemberInfo gProChannelPresenceMemberInfo) {
        this.mInfo = gProChannelPresenceMemberInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelPresenceMemberInfo
    public String getBytesAvatarMeta() {
        return this.mInfo.getBytesAvatarMeta();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelPresenceMemberInfo
    public long getTinyId() {
        return this.mInfo.getTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelPresenceMemberInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
