package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProRecommendMyFeed extends Serializable {
    byte[] getData();

    IGProPosterInfo getPoster();

    IGProRecommendFeedShareInfo getShareInfo();

    String toString();
}
