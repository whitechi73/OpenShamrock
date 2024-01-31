package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;


public interface IGProClientIdentityInfo extends Serializable {
    String getClientId();

    String getDesc();

    IGProClientIdentityByteInfo getIdentityBytes();
}
