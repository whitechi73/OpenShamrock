package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProRecommendEntry extends Serializable {
    String getKey();

    byte[] getValue();

    String toString();
}
