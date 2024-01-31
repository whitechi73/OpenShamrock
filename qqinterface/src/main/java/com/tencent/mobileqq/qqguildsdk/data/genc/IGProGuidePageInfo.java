package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProGuidePageInfo extends Serializable {
    String getDesc();

    IGProImgPair getImages();

    String getTitle();

    String toString();
}
