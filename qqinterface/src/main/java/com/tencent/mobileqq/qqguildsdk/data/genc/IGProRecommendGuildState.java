package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProRecommendGuildState extends Serializable {
    String getDesc();

    ArrayList<String> getIconUrls();

    int getState();

    String toString();
}
