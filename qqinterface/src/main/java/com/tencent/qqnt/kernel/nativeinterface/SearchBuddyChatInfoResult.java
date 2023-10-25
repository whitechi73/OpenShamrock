package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class SearchBuddyChatInfoResult {
    boolean hasMore;
    ArrayList<SearchBuddyItem> resultItems;
    int searchId;

    public SearchBuddyChatInfoResult() {
        this.resultItems = new ArrayList<>();
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public ArrayList<SearchBuddyItem> getResultItems() {
        return this.resultItems;
    }

    public int getSearchId() {
        return this.searchId;
    }

    public String toString() {
        return "SearchBuddyChatInfoResult{searchId=" + this.searchId + ",hasMore=" + this.hasMore + ",resultItems=" + this.resultItems + ",}";
    }

    public SearchBuddyChatInfoResult(int i2, boolean z, ArrayList<SearchBuddyItem> arrayList) {
        this.resultItems = new ArrayList<>();
        this.searchId = i2;
        this.hasMore = z;
        this.resultItems = arrayList;
    }
}
