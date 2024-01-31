package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProCreateLobbyRsp extends Serializable {
    IGProLobbyRoomInfo getLobbyRoomInfo();

    String toString();
}
