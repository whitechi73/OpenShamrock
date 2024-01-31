package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProAudienceInfo;

public  class GGProAudienceInfo implements IGProAudienceInfo {
    public final GProAudienceInfo mInfo;

    public GGProAudienceInfo(GProAudienceInfo gProAudienceInfo) {
        this.mInfo = gProAudienceInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAudienceInfo
    public String getAvatarMeta() {
        return this.mInfo.getAvatarMeta();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAudienceInfo
    public String getIcon() {
        return this.mInfo.getIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAudienceInfo
    public long getUin() {
        return this.mInfo.getUin();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAudienceInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
