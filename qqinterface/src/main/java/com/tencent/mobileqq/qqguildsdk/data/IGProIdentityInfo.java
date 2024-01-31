package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;

public  interface IGProIdentityInfo extends Serializable {
    int getIdentityType();

    byte[] getPlateData();

    int getType();

    String getValue();
}
