package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;


public interface IGProMedalInfo extends Serializable {
    long getExpireTime();

    String getIconUrl();

    String getName();

    IGProOfficialMedalInfoExt getOfficialMedalInfoExt();

    String toString();
}
