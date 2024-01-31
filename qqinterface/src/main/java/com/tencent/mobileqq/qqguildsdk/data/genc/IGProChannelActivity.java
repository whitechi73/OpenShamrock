package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProChannelActivity extends Serializable {
    String getActivityId();

    String getImageUrl();

    String getJumpUrl();

    String toString();
}
