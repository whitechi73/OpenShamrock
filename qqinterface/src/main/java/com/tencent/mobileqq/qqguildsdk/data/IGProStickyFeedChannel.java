package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProStickyFeedChannel extends Serializable {
    String getActiveMemberCount();

    ArrayList<IGProUserInfo> getActiveMemberList();

    String getFeedCount();

    ArrayList<IGProFeedSummary> getFeedSummaryList();
}
