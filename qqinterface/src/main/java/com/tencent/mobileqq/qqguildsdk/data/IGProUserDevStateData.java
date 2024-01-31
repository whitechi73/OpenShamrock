package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;

public  interface IGProUserDevStateData extends Serializable {
    int getCameraState();

    int getMicState();

    int getNetworkQuality();

    int getScreenState();

    int getSysMicBusy();

    void setCameraState(int i2);

    void setMicState(int i2);

    void setNetworkQuality(int i2);

    void setScreenState(int i2);

    void setSysMicBusy(int i2);
}
