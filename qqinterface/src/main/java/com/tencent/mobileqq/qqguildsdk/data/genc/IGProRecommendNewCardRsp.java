package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProRecommendNewCardRsp extends Serializable {
    int getNextTs();

    boolean getUpdateFlag();

    String toString();
}
