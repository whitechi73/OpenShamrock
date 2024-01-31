package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProMemberInfo extends Serializable {
    String getAvatarMeta();

    int getGender();

    long getTinyId();

    String toString();
}
