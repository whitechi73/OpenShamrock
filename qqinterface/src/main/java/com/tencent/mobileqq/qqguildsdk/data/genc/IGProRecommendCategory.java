package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProRecommendCategory extends Serializable {
    int getCategoryId();

    int getCategoryType();

    String getGroupId();

    boolean getHasMore();

    String getName();

    String getType();

    String toString();
}
