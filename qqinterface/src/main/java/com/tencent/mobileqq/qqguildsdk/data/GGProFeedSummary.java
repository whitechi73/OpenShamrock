package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProFeedSummary;
import com.tencent.qqnt.kernel.nativeinterface.GProFeedThumbnail;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProFeedSummary implements IGProFeedSummary {
    public final GProFeedSummary mInfo;

    public GGProFeedSummary(GProFeedSummary gProFeedSummary) {
        this.mInfo = gProFeedSummary;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProFeedSummary
    public String getFeedId() {
        return this.mInfo.getFeedId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProFeedSummary
    public ArrayList<IGProFeedThumbnail> getFeedThumbnails() {
        ArrayList<GProFeedThumbnail> feedThumbnails = this.mInfo.getFeedThumbnails();
        ArrayList<IGProFeedThumbnail> arrayList = new ArrayList<>();
        Iterator<GProFeedThumbnail> it = feedThumbnails.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProFeedThumbnail(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProFeedSummary
    public String getTitle() {
        return this.mInfo.getTitle();
    }
}
