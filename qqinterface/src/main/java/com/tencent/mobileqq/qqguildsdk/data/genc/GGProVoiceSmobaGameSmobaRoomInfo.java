package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProVoiceSmobaGameSmobaRoomInfo;

import java.util.ArrayList;

public  class GGProVoiceSmobaGameSmobaRoomInfo implements IGProVoiceSmobaGameSmobaRoomInfo {
    public final GProVoiceSmobaGameSmobaRoomInfo mInfo;

    public GGProVoiceSmobaGameSmobaRoomInfo(GProVoiceSmobaGameSmobaRoomInfo gProVoiceSmobaGameSmobaRoomInfo) {
        this.mInfo = gProVoiceSmobaGameSmobaRoomInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameSmobaRoomInfo
    public int getGameMode() {
        return this.mInfo.getGameMode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameSmobaRoomInfo
    public ArrayList<Integer> getGradeList() {
        return this.mInfo.getGradeList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameSmobaRoomInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
