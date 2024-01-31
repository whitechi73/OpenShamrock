package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;



public final class SearchFileKeywordsResult {
    boolean hasMore;
    ArrayList<SearchFileItem> resultItems;
    int searchId;

    public SearchFileKeywordsResult() {
        this.resultItems = new ArrayList<>();
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public ArrayList<SearchFileItem> getResultItems() {
        return this.resultItems;
    }

    public int getSearchId() {
        return this.searchId;
    }

    public String toString() {
        return "SearchFileKeywordsResult{searchId=" + this.searchId + ",hasMore=" + this.hasMore + ",resultItems=" + this.resultItems + ",}";
    }

    public SearchFileKeywordsResult(int i2, boolean z, ArrayList<SearchFileItem> arrayList) {
        this.resultItems = new ArrayList<>();
        this.searchId = i2;
        this.hasMore = z;
        this.resultItems = arrayList;
    }
}
