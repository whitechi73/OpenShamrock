package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;



public final class SearchResultGroup {
    long groupMask;
    String groupName;
    ArrayList<String> highlightWords;
    String moreName;
    String moreUrl;
    ArrayList<SearchResultItem> resultItem;
    int totalCount;

    public SearchResultGroup() {
        this.resultItem = new ArrayList<>();
        this.groupName = "";
        this.moreUrl = "";
        this.moreName = "";
        this.highlightWords = new ArrayList<>();
    }

    public long getGroupMask() {
        return this.groupMask;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public ArrayList<String> getHighlightWords() {
        return this.highlightWords;
    }

    public String getMoreName() {
        return this.moreName;
    }

    public String getMoreUrl() {
        return this.moreUrl;
    }

    public ArrayList<SearchResultItem> getResultItem() {
        return this.resultItem;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public String toString() {
        return "SearchResultGroup{groupMask=" + this.groupMask + ",resultItem=" + this.resultItem + ",groupName=" + this.groupName + ",totalCount=" + this.totalCount + ",moreUrl=" + this.moreUrl + ",moreName=" + this.moreName + ",highlightWords=" + this.highlightWords + ",}";
    }

    public SearchResultGroup(long j2, ArrayList<SearchResultItem> arrayList, String str, int i2, String str2, String str3, ArrayList<String> arrayList2) {
        this.resultItem = new ArrayList<>();
        this.groupName = "";
        this.moreUrl = "";
        this.moreName = "";
        this.highlightWords = new ArrayList<>();
        this.groupMask = j2;
        this.resultItem = arrayList;
        this.groupName = str;
        this.totalCount = i2;
        this.moreUrl = str2;
        this.moreName = str3;
        this.highlightWords = arrayList2;
    }
}
