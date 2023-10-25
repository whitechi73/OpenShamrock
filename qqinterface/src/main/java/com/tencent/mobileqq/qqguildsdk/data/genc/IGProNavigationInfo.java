package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public interface IGProNavigationInfo extends Serializable {
    String getBubbleDesc();

    String getIconUrl();

    String getJumpUrl();

    int getJumpUrlType();

    boolean getShowBubble();

    String getTitle();

    String toString();
}
