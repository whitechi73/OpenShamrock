package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProApplicationChannelInfo extends Serializable {
    String getAppChannelIcon();

    String getAppChannelId();

    int getAppChannelJumpType();

    String getAppChannelJumpUrl();

    String getAppJumpSecret();

    int getAppQyyFlag();

    long getApplicationId();

    int getExternalUrlRequestStatus();

    String toString();
}
