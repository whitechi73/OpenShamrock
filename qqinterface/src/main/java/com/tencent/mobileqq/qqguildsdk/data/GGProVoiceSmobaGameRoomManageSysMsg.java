package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProVoiceSmobaGameBaseRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProVoiceSmobaGameRoomStateInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProVoiceSmobaGameSmobaRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameBaseRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomStateInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameSmobaRoomInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProVoiceSmobaGameRoomManageSysMsg;


public class GGProVoiceSmobaGameRoomManageSysMsg implements IGProVoiceSmobaGameRoomManageSysMsg {
    public final GProVoiceSmobaGameRoomManageSysMsg mInfo;

    public GGProVoiceSmobaGameRoomManageSysMsg(GProVoiceSmobaGameRoomManageSysMsg gProVoiceSmobaGameRoomManageSysMsg) {
        this.mInfo = gProVoiceSmobaGameRoomManageSysMsg;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProVoiceSmobaGameRoomManageSysMsg
    public int getOperType() {
        return this.mInfo.getOperType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProVoiceSmobaGameRoomManageSysMsg
    public IGProVoiceSmobaGameBaseRoomInfo getRoomInfo() {
        return new GGProVoiceSmobaGameBaseRoomInfo(this.mInfo.getRoomInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProVoiceSmobaGameRoomManageSysMsg
    public IGProVoiceSmobaGameSmobaRoomInfo getSmobaInfo() {
        return new GGProVoiceSmobaGameSmobaRoomInfo(this.mInfo.getSmobaInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProVoiceSmobaGameRoomManageSysMsg
    public IGProVoiceSmobaGameRoomStateInfo getStateInfo() {
        return new GGProVoiceSmobaGameRoomStateInfo(this.mInfo.getStateInfo());
    }
}
