package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;


public interface IGuildSpeakableThresholdPermission extends Serializable {
    long getDirectMsgLimitTime();

    int getDirectMsgLimitType();

    long getGuildLimitTime();

    int getGuildLimitType();

    long getJoinTime();

    String getVerifyUrl();
}
