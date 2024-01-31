package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProUserPublishedFeedSummary;

import java.util.ArrayList;

public  class GProUserPublishedFeedSummaryInfo implements IGProUserPublishedFeedSummary {
    public final GProUserPublishedFeedSummary mInfo;

    public GProUserPublishedFeedSummaryInfo(GProUserPublishedFeedSummary gProUserPublishedFeedSummary) {
        this.mInfo = gProUserPublishedFeedSummary;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserPublishedFeedSummary
    public ArrayList<byte[]> getFeedList() {
        return this.mInfo.getFeedList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserPublishedFeedSummary
    public String getPublishedCountStr() {
        return this.mInfo.getPublishedCountStr();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserPublishedFeedSummary
    public String toString() {
        return this.mInfo.toString();
    }
}
