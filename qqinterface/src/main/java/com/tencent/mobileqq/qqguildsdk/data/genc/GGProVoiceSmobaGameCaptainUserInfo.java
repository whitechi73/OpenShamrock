package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProVoiceSmobaGameCaptainUserInfo;

public  class GGProVoiceSmobaGameCaptainUserInfo implements IGProVoiceSmobaGameCaptainUserInfo {
    public final GProVoiceSmobaGameCaptainUserInfo mInfo;

    public GGProVoiceSmobaGameCaptainUserInfo(GProVoiceSmobaGameCaptainUserInfo gProVoiceSmobaGameCaptainUserInfo) {
        this.mInfo = gProVoiceSmobaGameCaptainUserInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameCaptainUserInfo
    public String getAvatarMeta() {
        return this.mInfo.getAvatarMeta();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameCaptainUserInfo
    public String getNickName() {
        return this.mInfo.getNickName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameCaptainUserInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
