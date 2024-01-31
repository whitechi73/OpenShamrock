package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProGetRecommendQuickJoinRsp extends Serializable {
    ArrayList<IGProRecommendQuickJoinItem> getRecommendQuickJoinItems();

    String toString();
}
