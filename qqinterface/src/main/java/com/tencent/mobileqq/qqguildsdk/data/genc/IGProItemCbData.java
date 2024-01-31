package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProItemCbData extends Serializable {
    byte[] getCbExtData();

    String getStatData();

    String toString();
}
