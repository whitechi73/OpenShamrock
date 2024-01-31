package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProRecommendChannel0x11bc extends Serializable {
    IGProChannelPresence getChannelPresence();

    IGProEssenceChannel getEssenceInfo();

    int getRecommendType();

    String toString();
}
