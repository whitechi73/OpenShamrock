package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProTextMedalInfo extends Serializable {
    int getColorBg();

    int getColorText();

    long getExpireTime();

    String getName();

    String toString();
}
