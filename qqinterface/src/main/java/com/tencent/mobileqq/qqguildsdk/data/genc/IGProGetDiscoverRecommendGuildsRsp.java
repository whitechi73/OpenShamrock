package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProGetDiscoverRecommendGuildsRsp extends Serializable {
    byte[] getCookies();

    boolean getIsEnd();

    ArrayList<IGProRecommendItem> getItems();

    String getMsg();

    String getRequestId();

    String toString();
}
