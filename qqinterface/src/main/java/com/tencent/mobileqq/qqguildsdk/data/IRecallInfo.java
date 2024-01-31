package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;


public  interface IRecallInfo extends Serializable {
    float getQualityScore();

    String getQuery();

    String getRecallName();

    float getRelevanceScore();

    float getScore();

    String getTraceId();
}
