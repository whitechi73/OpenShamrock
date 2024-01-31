package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProRecommendMsg extends Serializable {
    String getAvatar();

    long getMsgSeq();

    String getNickName();

    byte[] getRichText();

    long getTinyid();

    String toString();
}
