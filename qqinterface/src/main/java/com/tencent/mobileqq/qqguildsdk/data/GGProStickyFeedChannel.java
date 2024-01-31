package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProFeedSummary;
import com.tencent.qqnt.kernel.nativeinterface.GProStickyFeedChannel;
import com.tencent.qqnt.kernel.nativeinterface.GProUser;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProStickyFeedChannel implements IGProStickyFeedChannel {
    public final GProStickyFeedChannel mInfo;

    public GGProStickyFeedChannel(GProStickyFeedChannel gProStickyFeedChannel) {
        this.mInfo = gProStickyFeedChannel;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProStickyFeedChannel
    public String getActiveMemberCount() {
        return this.mInfo.getActiveMemberCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProStickyFeedChannel
    public ArrayList<IGProUserInfo> getActiveMemberList() {
        ArrayList<GProUser> activeMemberList = this.mInfo.getActiveMemberList();
        ArrayList<IGProUserInfo> arrayList = new ArrayList<>();
        Iterator<GProUser> it = activeMemberList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GProUserInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProStickyFeedChannel
    public String getFeedCount() {
        return this.mInfo.getFeedCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProStickyFeedChannel
    public ArrayList<IGProFeedSummary> getFeedSummaryList() {
        ArrayList<GProFeedSummary> feedSummaryList = this.mInfo.getFeedSummaryList();
        ArrayList<IGProFeedSummary> arrayList = new ArrayList<>();
        Iterator<GProFeedSummary> it = feedSummaryList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProFeedSummary(it.next()));
        }
        return arrayList;
    }
}
