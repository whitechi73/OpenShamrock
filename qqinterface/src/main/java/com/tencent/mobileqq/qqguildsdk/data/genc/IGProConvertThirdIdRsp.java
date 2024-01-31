package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProConvertThirdIdRsp extends Serializable {
    ArrayList<String> getIds();

    ArrayList<String> getStringIds();

    String toString();
}
