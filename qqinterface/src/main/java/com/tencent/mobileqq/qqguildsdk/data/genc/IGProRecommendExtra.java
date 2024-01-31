package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProRecommendExtra extends Serializable {
    ArrayList<IGProRecommendEntry> getBizData();

    IGProItemCbData getCallback();

    ArrayList<IGProRecommendEntry> getReports();

    ArrayList<IGProRecommendTag> getTags();

    String toString();
}
