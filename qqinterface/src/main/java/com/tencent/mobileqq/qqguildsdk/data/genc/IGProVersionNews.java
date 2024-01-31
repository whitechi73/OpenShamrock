package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProVersionNews extends Serializable {
    String getJumpFeedUrl();

    ArrayList<String> getNewsUrlList();

    String getSubtitle();

    String getTitle();

    String toString();
}
