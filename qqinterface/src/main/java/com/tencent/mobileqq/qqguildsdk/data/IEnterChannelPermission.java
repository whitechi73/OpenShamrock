package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;

public  interface IEnterChannelPermission extends Serializable {
    boolean getAllowEnter();

    boolean getAllowLive();

    String getDisallowLiveReason();

    String getDisallowReason();

    int getLiveType();

    String getLiveUrl();

    long getMsgSeq();
}
