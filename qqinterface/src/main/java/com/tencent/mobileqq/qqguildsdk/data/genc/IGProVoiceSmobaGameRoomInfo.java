package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProVoiceSmobaGameRoomInfo extends Serializable {
    IGProVoiceSmobaGameBaseRoomInfo getRoomInfo();

    IGProVoiceSmobaGameSmobaRoomInfo getSmobaInfo();

    String toString();
}
