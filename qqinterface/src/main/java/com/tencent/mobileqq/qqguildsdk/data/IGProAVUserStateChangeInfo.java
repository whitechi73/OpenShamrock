package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;


public interface IGProAVUserStateChangeInfo extends Serializable {
    String getChannelId();

    String getGuildId();

    IGProAVShowMsgInfo getIGProAVShowMsgInfo();

    String getMsg();

    long getTinyId();

    //ej getUserCtlInfo();
}
