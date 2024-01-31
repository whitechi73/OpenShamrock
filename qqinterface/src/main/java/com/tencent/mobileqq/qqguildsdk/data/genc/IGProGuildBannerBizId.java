package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProGuildBannerBizId extends Serializable {
    int getBannerType();

    long getChannelId();

    long getFeedCreateTime();

    long getFeedCreateTinyId();

    String getFeedId();

    long getMsgSeq();

    String getThirdRecommendId();

    String toString();
}
