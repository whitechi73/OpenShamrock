package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProUserPublishedFeedSummary extends Serializable {
    ArrayList<byte[]> getFeedList();

    String getPublishedCountStr();

    String toString();
}
