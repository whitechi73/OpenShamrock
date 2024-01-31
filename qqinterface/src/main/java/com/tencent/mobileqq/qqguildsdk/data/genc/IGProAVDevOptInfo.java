package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProAVDevOptInfo extends Serializable {
    int getCameraOpt();

    int getMicOpt();

    int getScreenOpt();

    String toString();
}
