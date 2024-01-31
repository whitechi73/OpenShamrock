package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProVoiceSmobaGameRoomStateInfo;

public  class GGProVoiceSmobaGameRoomStateInfo implements IGProVoiceSmobaGameRoomStateInfo {
    public final GProVoiceSmobaGameRoomStateInfo mInfo;

    public GGProVoiceSmobaGameRoomStateInfo(GProVoiceSmobaGameRoomStateInfo gProVoiceSmobaGameRoomStateInfo) {
        this.mInfo = gProVoiceSmobaGameRoomStateInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomStateInfo
    public IGProVoiceSmobaGameCaptainUserInfo getCaptainInfo() {
        return new GGProVoiceSmobaGameCaptainUserInfo(this.mInfo.getCaptainInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomStateInfo
    public long getCaptainTinyId() {
        return this.mInfo.getCaptainTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomStateInfo
    public long getCurrentNum() {
        return this.mInfo.getCurrentNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomStateInfo
    public IGProVoiceSmobaGameGameStaticInfo getGameInfo() {
        return new GGProVoiceSmobaGameGameStaticInfo(this.mInfo.getGameInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomStateInfo
    public long getGameStartTime() {
        return this.mInfo.getGameStartTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomStateInfo
    public long getRoomId() {
        return this.mInfo.getRoomId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomStateInfo
    public int getRoomState() {
        return this.mInfo.getRoomState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomStateInfo
    public int getRoomType() {
        return this.mInfo.getRoomType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomStateInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
