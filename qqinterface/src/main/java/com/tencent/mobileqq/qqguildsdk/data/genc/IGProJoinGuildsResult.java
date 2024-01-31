package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;

import java.io.Serializable;


public interface IGProJoinGuildsResult extends Serializable {
    long getGuildId();

    IGProGuildInfo getGuildInfo();

    IGProGuildInit getGuildInit();

    int getIsOpenTab();

    int getQqMsgInList();

    int getResultCode();

    IGProSecurityResult getSecResult();

    String toString();
}
