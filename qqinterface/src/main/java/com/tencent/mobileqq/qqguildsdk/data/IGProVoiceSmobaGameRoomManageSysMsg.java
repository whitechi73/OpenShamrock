package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameBaseRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomStateInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameSmobaRoomInfo;

import java.io.Serializable;


public interface IGProVoiceSmobaGameRoomManageSysMsg extends Serializable {
    int getOperType();

    IGProVoiceSmobaGameBaseRoomInfo getRoomInfo();

    IGProVoiceSmobaGameSmobaRoomInfo getSmobaInfo();

    IGProVoiceSmobaGameRoomStateInfo getStateInfo();
}
