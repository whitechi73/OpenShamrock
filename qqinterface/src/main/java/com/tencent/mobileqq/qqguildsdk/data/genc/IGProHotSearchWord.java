package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProHotSearchWord extends Serializable {
    String getIcon();

    String getLink();

    int getType();

    String getWord();

    String toString();
}
