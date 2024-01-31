package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;
import java.util.List;

public  interface IGProClientIdentityByteInfo extends Serializable {
    int getClientId();

    List<IGProIdentityInfo> getIdentityList();
}
