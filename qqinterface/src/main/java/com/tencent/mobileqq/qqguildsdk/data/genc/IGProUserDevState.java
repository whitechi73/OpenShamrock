package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProUserDevState extends Serializable {
    int getCameraState();

    String getCurrentRoomId();

    int getMicState();

    int getNetworkQuality();

    int getScreenState();

    int getSysMicBusy();

    String toString();
}
