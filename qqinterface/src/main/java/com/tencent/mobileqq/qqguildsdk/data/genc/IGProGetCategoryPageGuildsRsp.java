package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProGetCategoryPageGuildsRsp extends Serializable {
    ArrayList<IGProRecommendCategory> getCategories();

    boolean getIsEnd();

    ArrayList<IGProRecommendItem> getItems();

    String getTraceId();

    String toString();
}
