package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.qqnt.kernel.nativeinterface.GProAudioLiveUserListRsp;

public  class GGProAudioLiveUserListRsp implements IGProAudioLiveUserListRsp {
    public final GProAudioLiveUserListRsp mInfo;

    public GGProAudioLiveUserListRsp(GProAudioLiveUserListRsp gProAudioLiveUserListRsp) {
        this.mInfo = gProAudioLiveUserListRsp;
    }

    @Override
    public IAudioChannelMemberInfos getChannelMemberInfo() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAudioLiveUserListRsp
    public IGProChannelUserNum getChannelUserNum() {
        return new GGProChannelUserNum(this.mInfo.getChannelUserNum());
    }

    @Override
    public IAudioChannelMemberInfos getHandUpMemberInfo() {
        return null;
    }


    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAudioLiveUserListRsp
    public boolean getIsEndPage() {
        return this.mInfo.getIsEndPage();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAudioLiveUserListRsp
    public long getNextReadInterval() {
        return this.mInfo.getNextReadInterval();
    }

    @Override
    public IAudioChannelMemberInfos getSpeakOrderMemberInfo() {
        return null;
    }


    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAudioLiveUserListRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
