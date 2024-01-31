package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;



public final class SearchGroupChatInfoResult {
    boolean hasMore;
    int resultId;
    ArrayList<SearchGroupItem> resultItems;
    int searchId;

    public SearchGroupChatInfoResult() {
        this.resultItems = new ArrayList<>();
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public int getResultId() {
        return this.resultId;
    }

    public ArrayList<SearchGroupItem> getResultItems() {
        return this.resultItems;
    }

    public int getSearchId() {
        return this.searchId;
    }

    public String toString() {
        return "SearchGroupChatInfoResult{searchId=" + this.searchId + ",resultId=" + this.resultId + ",hasMore=" + this.hasMore + ",resultItems=" + this.resultItems + ",}";
    }

    public SearchGroupChatInfoResult(int i2, int i3, boolean z, ArrayList<SearchGroupItem> arrayList) {
        this.resultItems = new ArrayList<>();
        this.searchId = i2;
        this.resultId = i3;
        this.hasMore = z;
        this.resultItems = arrayList;
    }
}
