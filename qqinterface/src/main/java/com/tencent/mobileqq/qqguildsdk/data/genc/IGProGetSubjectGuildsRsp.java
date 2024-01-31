package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProGetSubjectGuildsRsp extends Serializable {
    int getAllCnt();

    byte[] getCookies();

    ArrayList<IGProRecommendItem> getItems();

    String getTraceId();

    String toString();
}
