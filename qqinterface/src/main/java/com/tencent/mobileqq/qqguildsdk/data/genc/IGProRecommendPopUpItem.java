package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProRecommendPopUpItem extends Serializable {
    String getBannerLogo();

    String getBannerUrl();

    ArrayList<IGProRecommendItem> getItems();

    IGProSearchItem getSearchItem();

    String getTitle();

    String toString();
}
