package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProTopFeed extends Serializable {
    long getCreateTime();

    IGProTopFeedAbstract getFeedAbstract();

    String getFeedId();

    long getOperatorTinyId();

    long getTopTimestamp();

    String getUserId();

    String toString();
}
