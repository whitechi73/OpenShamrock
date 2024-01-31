package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProRecommendPopupAdsInfo extends Serializable {
    ArrayList<IGProBlockBaseInfo> getList();

    int getTabType();

    String toString();
}
