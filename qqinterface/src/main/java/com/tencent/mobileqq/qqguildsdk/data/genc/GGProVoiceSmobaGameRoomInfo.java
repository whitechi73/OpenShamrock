package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProVoiceSmobaGameRoomInfo;

public  class GGProVoiceSmobaGameRoomInfo implements IGProVoiceSmobaGameRoomInfo {
    public final GProVoiceSmobaGameRoomInfo mInfo;

    public GGProVoiceSmobaGameRoomInfo(GProVoiceSmobaGameRoomInfo gProVoiceSmobaGameRoomInfo) {
        this.mInfo = gProVoiceSmobaGameRoomInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomInfo
    public IGProVoiceSmobaGameBaseRoomInfo getRoomInfo() {
        return new GGProVoiceSmobaGameBaseRoomInfo(this.mInfo.getRoomInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomInfo
    public IGProVoiceSmobaGameSmobaRoomInfo getSmobaInfo() {
        return new GGProVoiceSmobaGameSmobaRoomInfo(this.mInfo.getSmobaInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
