package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProVoiceSmobaGameBaseRoomInfo;

public  class GGProVoiceSmobaGameBaseRoomInfo implements IGProVoiceSmobaGameBaseRoomInfo {
    public final GProVoiceSmobaGameBaseRoomInfo mInfo;

    public GGProVoiceSmobaGameBaseRoomInfo(GProVoiceSmobaGameBaseRoomInfo gProVoiceSmobaGameBaseRoomInfo) {
        this.mInfo = gProVoiceSmobaGameBaseRoomInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameBaseRoomInfo
    public long getCaptainTinyId() {
        return this.mInfo.getCaptainTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameBaseRoomInfo
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameBaseRoomInfo
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameBaseRoomInfo
    public long getRoomId() {
        return this.mInfo.getRoomId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameBaseRoomInfo
    public int getRoomType() {
        return this.mInfo.getRoomType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameBaseRoomInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
