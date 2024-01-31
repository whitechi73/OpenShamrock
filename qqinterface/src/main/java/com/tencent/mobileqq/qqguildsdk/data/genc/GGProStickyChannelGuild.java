package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProStickyChannelGuild;

public  class GGProStickyChannelGuild implements IGProStickyChannelGuild {
    public final GProStickyChannelGuild mInfo;

    public GGProStickyChannelGuild(GProStickyChannelGuild gProStickyChannelGuild) {
        this.mInfo = gProStickyChannelGuild;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProStickyChannelGuild
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProStickyChannelGuild
    public boolean getHasStickyChannel() {
        return this.mInfo.getHasStickyChannel();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProStickyChannelGuild
    public String toString() {
        return this.mInfo.toString();
    }
}
