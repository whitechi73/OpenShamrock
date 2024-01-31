package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProVoiceSmobaGameRoomStateInfo extends Serializable {
    IGProVoiceSmobaGameCaptainUserInfo getCaptainInfo();

    long getCaptainTinyId();

    long getCurrentNum();

    IGProVoiceSmobaGameGameStaticInfo getGameInfo();

    long getGameStartTime();

    long getRoomId();

    int getRoomState();

    int getRoomType();

    String toString();
}
