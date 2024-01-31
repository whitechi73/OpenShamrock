package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProVoiceInfo extends Serializable {
    String getScreenPic();

    long getScreenShareTinyId();

    int getScreenState();

    long getScreenUpdateTime();

    int getVoiceState();

    String toString();
}
