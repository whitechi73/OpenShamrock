package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProLiveRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveRoomInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProStickyChannel;


public class GGProStickyChannel implements IGProStickyChannel {
    public final GProStickyChannel mInfo;

    public GGProStickyChannel(GProStickyChannel gProStickyChannel) {
        this.mInfo = gProStickyChannel;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProStickyChannel
    public String getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProStickyChannel
    public int getChannelType() {
        return this.mInfo.getChannelType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProStickyChannel
    public long getCreateTime() {
        return this.mInfo.getCreateTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProStickyChannel
    public IGProStickyFeedChannel getFeedChannel() {
        return new GGProStickyFeedChannel(this.mInfo.getFeedChannel());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProStickyChannel
    public String getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProStickyChannel
    public IGProLiveRoomInfo getLiveChannel() {
        return new GGProLiveRoomInfo(this.mInfo.getLiveChannel());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProStickyChannel
    public IGProStickyTextChannel getTextChannel() {
        return new GGProStickyTextChannel(this.mInfo.getTextChannel());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProStickyChannel
    public long getUpdateTime() {
        return this.mInfo.getUpdateTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProStickyChannel
    public IAudioChannelMemberInfos getVoiceChannel() {
        return null;
        //return new ChannelMemberInfos(this.mInfo.getVoiceChannel());
    }
}
