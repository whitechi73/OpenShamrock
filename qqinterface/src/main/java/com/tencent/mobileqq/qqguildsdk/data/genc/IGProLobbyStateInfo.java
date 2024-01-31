package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProLobbyStateInfo extends Serializable {
    String getAppId();

    long getChannelId();

    boolean getDisableVoiceAnimation();

    ArrayList<Object> getExtendDic();

    long getGuildId();

    long getLeaderTinyId();

    long getLobbyId();

    int getLobbyRoomCapacity();

    int getLobbyRoomCurrUserNum();

    int getLobbyRoomStatus();

    int getLobbyType();

    String toString();
}
