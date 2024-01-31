package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProLobbyRoomInfo extends Serializable {
    IGProLobbyAppInfo getLobbyAppInfo();

    IGProLobbyStateInfo getLobbyStateInfo();

    String toString();
}
