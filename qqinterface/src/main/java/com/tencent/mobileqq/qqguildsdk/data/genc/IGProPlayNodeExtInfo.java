package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProPlayNodeExtInfo extends Serializable {
    long getCompereTinyid();

    boolean getEnableVolume();

    int getPauseDuration();

    int getPlayState();

    IGProPlayPushScene getPushScene();

    long getSourceNum();

    long getStartPlayTime();

    int getVolume();

    String toString();
}
