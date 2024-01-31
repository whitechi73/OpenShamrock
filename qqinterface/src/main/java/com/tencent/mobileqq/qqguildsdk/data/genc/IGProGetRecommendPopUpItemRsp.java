package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProGetRecommendPopUpItemRsp extends Serializable {
    IGProRecommendExtInfo getExtInfo();

    IGProRecommendPopUpItem getItem();

    String toString();
}
