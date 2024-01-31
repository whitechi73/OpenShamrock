package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendVoiceChannel;

public  class GGProRecommendVoiceChannel implements IGProRecommendVoiceChannel {
    public final GProRecommendVoiceChannel mInfo;

    public GGProRecommendVoiceChannel(GProRecommendVoiceChannel gProRecommendVoiceChannel) {
        this.mInfo = gProRecommendVoiceChannel;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendVoiceChannel
    public IGProRecommendCoverInfo getCover() {
        return new GGProRecommendCoverInfo(this.mInfo.getCover());
    }

    @Override
    public IAudioChannelMemberInfos getVoiceChannel() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendVoiceChannel
    public String toString() {
        return this.mInfo.toString();
    }
}
