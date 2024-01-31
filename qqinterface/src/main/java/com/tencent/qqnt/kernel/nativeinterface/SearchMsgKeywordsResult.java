package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;



public final class SearchMsgKeywordsResult implements IKernelModel {
    boolean hasMore;
    ArrayList<SearchMsgItem> resultItems;
    int searchId;

    public SearchMsgKeywordsResult() {
        this.resultItems = new ArrayList<>();
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public ArrayList<SearchMsgItem> getResultItems() {
        return this.resultItems;
    }

    public int getSearchId() {
        return this.searchId;
    }

    public String toString() {
        return "SearchMsgKeywordsResult{searchId=" + this.searchId + ",hasMore=" + this.hasMore + ",resultItems=" + this.resultItems + ",}";
    }

    public SearchMsgKeywordsResult(int i2, boolean z, ArrayList<SearchMsgItem> arrayList) {
        this.resultItems = new ArrayList<>();
        this.searchId = i2;
        this.hasMore = z;
        this.resultItems = arrayList;
    }
}
