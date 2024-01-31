package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;


public interface IGProGetRecommendMyV2Rsp extends Serializable {
    IGProGetAtMeMsgRsp getAtMeMsg();

    byte[] getCookies();

    IGProRecommendExtInfo getExtInfo();

    ArrayList<IGProRecommendItem> getRecommendList();

    String toString();
}
