package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;


public interface IGProGetRecommendHotRsp extends Serializable {
    byte[] getCookies();

    IGProRecommendExtInfo getExtInfo();

    ArrayList<IGProRecommendItem> getRecommendList();

    String toString();
}
