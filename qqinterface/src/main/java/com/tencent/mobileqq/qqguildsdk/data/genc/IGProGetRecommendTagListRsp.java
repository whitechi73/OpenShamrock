package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProGetRecommendTagListRsp extends Serializable {
    byte[] getCookies();

    IGProRecommendExtInfo getExtInfo();

    ArrayList<IGProRecommendItem> getRecommendList();

    String toString();
}
