package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProRecommendCoverInfo extends Serializable {
    String getImageUrl();

    String getStreamUrl();

    int getType();

    String toString();
}
