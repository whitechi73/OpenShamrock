package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProGetRecommendV2Rsp extends Serializable {
    IGProBannerBlockList getBanners();

    byte[] getCookies();

    int getDiscoverType();

    IGProRecommendExtInfo getExtInfo();

    IGProPopBlockList getPopups();

    IGProRecommendV2TracksBlockList getTracks();

    String toString();
}
