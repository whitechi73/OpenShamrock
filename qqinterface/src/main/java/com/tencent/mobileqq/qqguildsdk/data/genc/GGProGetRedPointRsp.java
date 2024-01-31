package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGetRedPointRsp;

public  class GGProGetRedPointRsp implements IGProGetRedPointRsp {
    public final GProGetRedPointRsp mInfo;

    public GGProGetRedPointRsp(GProGetRedPointRsp gProGetRedPointRsp) {
        this.mInfo = gProGetRedPointRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRedPointRsp
    public String getAvatar() {
        return this.mInfo.getAvatar();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRedPointRsp
    public int getBusinessType() {
        return this.mInfo.getBusinessType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRedPointRsp
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRedPointRsp
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRedPointRsp
    public boolean getHasRedPoint() {
        return this.mInfo.getHasRedPoint();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRedPointRsp
    public String getIconUrl() {
        return this.mInfo.getIconUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRedPointRsp
    public boolean getIsJoinGuild() {
        return this.mInfo.getIsJoinGuild();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRedPointRsp
    public String getTransBuffer() {
        return this.mInfo.getTransBuffer();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRedPointRsp
    public int getWatchCycle() {
        return this.mInfo.getWatchCycle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRedPointRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
