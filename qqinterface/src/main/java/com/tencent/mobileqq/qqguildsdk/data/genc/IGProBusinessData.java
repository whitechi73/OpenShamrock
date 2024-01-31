package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProBusinessData extends Serializable {
    byte[] getBusinessParam();

    int getBusinessType();

    String toString();
}
