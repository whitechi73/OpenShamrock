package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;



public final class SearchChatsKeywordsResult {
    boolean hasMore;
    ArrayList<SearchChatSummaryItem> resultItems;
    int searchId;

    public SearchChatsKeywordsResult() {
        this.resultItems = new ArrayList<>();
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public ArrayList<SearchChatSummaryItem> getResultItems() {
        return this.resultItems;
    }

    public int getSearchId() {
        return this.searchId;
    }

    public String toString() {
        return "SearchChatsKeywordsResult{searchId=" + this.searchId + ",hasMore=" + this.hasMore + ",resultItems=" + this.resultItems + ",}";
    }

    public SearchChatsKeywordsResult(int i2, boolean z, ArrayList<SearchChatSummaryItem> arrayList) {
        this.resultItems = new ArrayList<>();
        this.searchId = i2;
        this.hasMore = z;
        this.resultItems = arrayList;
    }
}
