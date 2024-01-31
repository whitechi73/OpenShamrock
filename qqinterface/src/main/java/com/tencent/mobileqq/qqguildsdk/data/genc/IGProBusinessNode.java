package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProBusinessNode extends Serializable {
    long getDataVersion();

    long getExpiresMs();

    IGProLobbyRoomInfo getLobbyRoomInfo();

    int getMutexType();

    byte[] getNodeData();

    int getNodeType();

    IGProPlayInfo getPlayInfo();

    IGProVoiceSmobaGameRoomStateInfo getRoomStateInfo();

    IGProVoiceInfo getScreenShareInfo();

    String toString();
}
