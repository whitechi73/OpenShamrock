package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;



public final class SearchFileAssistantFileResult {
    boolean hasMore;
    int resultId;
    ArrayList<FileAssistantModel> resultItems;
    int searchId;

    public SearchFileAssistantFileResult() {
        this.resultItems = new ArrayList<>();
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public int getResultId() {
        return this.resultId;
    }

    public ArrayList<FileAssistantModel> getResultItems() {
        return this.resultItems;
    }

    public int getSearchId() {
        return this.searchId;
    }

    public String toString() {
        return "SearchFileAssistantFileResult{searchId=" + this.searchId + ",resultId=" + this.resultId + ",hasMore=" + this.hasMore + ",resultItems=" + this.resultItems + ",}";
    }

    public SearchFileAssistantFileResult(int i2, int i3, boolean z, ArrayList<FileAssistantModel> arrayList) {
        this.resultItems = new ArrayList<>();
        this.searchId = i2;
        this.resultId = i3;
        this.hasMore = z;
        this.resultItems = arrayList;
    }
}
