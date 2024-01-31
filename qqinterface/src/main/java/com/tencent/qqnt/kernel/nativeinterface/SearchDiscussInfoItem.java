package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;



public final class SearchDiscussInfoItem {
    long discussCode;
    String discussName;
    ArrayList<SearchHitInfo> discussNameHits;

    public SearchDiscussInfoItem() {
        this.discussName = "";
        this.discussNameHits = new ArrayList<>();
    }

    public long getDiscussCode() {
        return this.discussCode;
    }

    public String getDiscussName() {
        return this.discussName;
    }

    public ArrayList<SearchHitInfo> getDiscussNameHits() {
        return this.discussNameHits;
    }

    public String toString() {
        return "SearchDiscussInfoItem{discussCode=" + this.discussCode + ",discussName=" + this.discussName + ",discussNameHits=" + this.discussNameHits + ",}";
    }

    public SearchDiscussInfoItem(long j2, String str, ArrayList<SearchHitInfo> arrayList) {
        this.discussName = "";
        this.discussNameHits = new ArrayList<>();
        this.discussCode = j2;
        this.discussName = str;
        this.discussNameHits = arrayList;
    }
}
