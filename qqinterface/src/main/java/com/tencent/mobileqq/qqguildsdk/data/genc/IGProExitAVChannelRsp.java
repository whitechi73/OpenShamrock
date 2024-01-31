package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProExitAVChannelRsp extends Serializable {
    long getChannelId();

    long getGuildId();

    String toString();
}
