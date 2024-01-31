package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProChannelPresenceItemInfo extends Serializable {
    int getJumpType();

    String getJumpUrl();

    String getText();

    String toString();
}
