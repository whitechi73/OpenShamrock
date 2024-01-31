package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProRealNameAuthInfo extends Serializable {
    int getResult();

    String getTipsContent();

    String getVerifyUrl();

    String toString();
}
