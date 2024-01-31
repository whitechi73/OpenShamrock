package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProGetRecommendPopupAdsRsp extends Serializable {
    ArrayList<IGProRecommendPopupAdsInfo> getAdsInfoList();

    byte[] getCookies();

    int getNextTs();

    String toString();
}
