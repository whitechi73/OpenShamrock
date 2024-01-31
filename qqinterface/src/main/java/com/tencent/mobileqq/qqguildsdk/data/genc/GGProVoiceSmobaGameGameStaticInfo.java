package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProVoiceSmobaGameGameStaticInfo;

import java.util.ArrayList;

public  class GGProVoiceSmobaGameGameStaticInfo implements IGProVoiceSmobaGameGameStaticInfo {
    public final GProVoiceSmobaGameGameStaticInfo mInfo;

    public GGProVoiceSmobaGameGameStaticInfo(GProVoiceSmobaGameGameStaticInfo gProVoiceSmobaGameGameStaticInfo) {
        this.mInfo = gProVoiceSmobaGameGameStaticInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameGameStaticInfo
    public String getCoverUrl() {
        return this.mInfo.getCoverUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameGameStaticInfo
    public String getGameMode() {
        return this.mInfo.getGameMode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameGameStaticInfo
    public String getGameName() {
        return this.mInfo.getGameName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameGameStaticInfo
    public ArrayList<String> getGradeNames() {
        return this.mInfo.getGradeNames();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameGameStaticInfo
    public String getIconUrl() {
        return this.mInfo.getIconUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameGameStaticInfo
    public long getMaxNum() {
        return this.mInfo.getMaxNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameGameStaticInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
