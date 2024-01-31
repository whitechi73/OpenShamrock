package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProVoiceInfo;

public  class GGProVoiceInfo implements IGProVoiceInfo {
    public final GProVoiceInfo mInfo;

    public GGProVoiceInfo(GProVoiceInfo gProVoiceInfo) {
        this.mInfo = gProVoiceInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceInfo
    public String getScreenPic() {
        return this.mInfo.getScreenPic();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceInfo
    public long getScreenShareTinyId() {
        return this.mInfo.getScreenShareTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceInfo
    public int getScreenState() {
        return this.mInfo.getScreenState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceInfo
    public long getScreenUpdateTime() {
        return this.mInfo.getScreenUpdateTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceInfo
    public int getVoiceState() {
        return this.mInfo.getVoiceState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
