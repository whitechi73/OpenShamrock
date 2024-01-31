package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendChannel0x11bc;

public  class GGProRecommendChannel0x11bc implements IGProRecommendChannel0x11bc {
    public final GProRecommendChannel0x11bc mInfo;

    public GGProRecommendChannel0x11bc(GProRecommendChannel0x11bc gProRecommendChannel0x11bc) {
        this.mInfo = gProRecommendChannel0x11bc;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannel0x11bc
    public IGProChannelPresence getChannelPresence() {
        return new GGProChannelPresence(this.mInfo.getChannelPresence());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannel0x11bc
    public IGProEssenceChannel getEssenceInfo() {
        return new GGProEssenceChannel(this.mInfo.getEssenceInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannel0x11bc
    public int getRecommendType() {
        return this.mInfo.getRecommendType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannel0x11bc
    public String toString() {
        return this.mInfo.toString();
    }
}
