package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProGetCategoryGuildsRsp extends Serializable {
    byte[] getCookies();

    boolean getIsEnd();

    ArrayList<IGProRecommendItem> getItems();

    String getMsg();

    String getTraceId();

    String toString();
}
