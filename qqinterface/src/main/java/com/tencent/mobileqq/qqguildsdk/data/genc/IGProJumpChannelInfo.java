package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;


public interface IGProJumpChannelInfo extends Serializable {
    long getChannelId();

    boolean getIsSwitchOn();

    String toString();
}
