package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;

public  interface IGProMsgSummary extends Serializable {
    String getAvatar();

    long getMsgSeq();

    byte[] getRichText();

    long getTinyId();
}
