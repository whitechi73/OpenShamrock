package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProSpeakTimeCtl extends Serializable {
    int getQueueSpeakS();

    long getStartSpeakMs();

    long getStopSpeakMs();

    String toString();
}
