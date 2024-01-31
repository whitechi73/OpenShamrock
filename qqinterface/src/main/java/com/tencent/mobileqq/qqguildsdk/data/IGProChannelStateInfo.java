package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;


public interface IGProChannelStateInfo extends Serializable {
    int getChannelState();

    int getStatePriority();
}
