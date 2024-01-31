package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProRecommendFeedShareInfo extends Serializable {
    String getShareLink();

    int getShareType();

    String toString();
}
