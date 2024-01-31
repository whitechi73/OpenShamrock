package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProStickyFeedChannel implements Serializable {
    String activeMemberCount;
    ArrayList<GProUser> activeMemberList;
    String feedCount;
    ArrayList<GProFeedSummary> feedSummaryList;
    long serialVersionUID;

    public GProStickyFeedChannel() {
        this.serialVersionUID = 1L;
        this.feedCount = "";
        this.feedSummaryList = new ArrayList<>();
        this.activeMemberCount = "";
        this.activeMemberList = new ArrayList<>();
    }

    public String getActiveMemberCount() {
        return this.activeMemberCount;
    }

    public ArrayList<GProUser> getActiveMemberList() {
        return this.activeMemberList;
    }

    public String getFeedCount() {
        return this.feedCount;
    }

    public ArrayList<GProFeedSummary> getFeedSummaryList() {
        return this.feedSummaryList;
    }

    public String toString() {
        return "GProStickyFeedChannel{feedCount=" + this.feedCount + ",feedSummaryList=" + this.feedSummaryList + ",activeMemberCount=" + this.activeMemberCount + ",activeMemberList=" + this.activeMemberList + ",}";
    }

    public GProStickyFeedChannel(String str, ArrayList<GProFeedSummary> arrayList, String str2, ArrayList<GProUser> arrayList2) {
        this.serialVersionUID = 1L;
        this.feedCount = "";
        this.feedSummaryList = new ArrayList<>();
        this.activeMemberCount = "";
        this.activeMemberList = new ArrayList<>();
        this.feedCount = str;
        this.feedSummaryList = arrayList;
        this.activeMemberCount = str2;
        this.activeMemberList = arrayList2;
    }
}
