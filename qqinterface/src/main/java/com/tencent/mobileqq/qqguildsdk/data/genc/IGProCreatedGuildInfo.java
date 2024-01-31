package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProCreatedGuildInfo extends Serializable {
    long getCreateTime();

    String getFaceUrl();

    long getGuildId();

    String getGuildName();

    long getGuildOwnerUin();

    long getMemberNum();

    String toString();
}
