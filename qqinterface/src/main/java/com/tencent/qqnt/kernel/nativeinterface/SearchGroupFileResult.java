package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;



public final class SearchGroupFileResult {
    boolean isEnd;
    ArrayList<SearchGroupFileItem> item;
    int ownerMatchCount;
    int reqId;
    GroupFileCommonResult result;
    String syncCookie;
    int totalMatchCount;

    public SearchGroupFileResult() {
        this.result = new GroupFileCommonResult();
        this.syncCookie = "";
        this.item = new ArrayList<>();
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public ArrayList<SearchGroupFileItem> getItem() {
        return this.item;
    }

    public int getOwnerMatchCount() {
        return this.ownerMatchCount;
    }

    public int getReqId() {
        return this.reqId;
    }

    public GroupFileCommonResult getResult() {
        return this.result;
    }

    public String getSyncCookie() {
        return this.syncCookie;
    }

    public int getTotalMatchCount() {
        return this.totalMatchCount;
    }

    public String toString() {
        return "SearchGroupFileResult{result=" + this.result + ",syncCookie=" + this.syncCookie + ",totalMatchCount=" + this.totalMatchCount + ",ownerMatchCount=" + this.ownerMatchCount + ",isEnd=" + this.isEnd + ",reqId=" + this.reqId + ",item=" + this.item + ",}";
    }

    public SearchGroupFileResult(GroupFileCommonResult groupFileCommonResult, String str, int i2, int i3, boolean z, int i4, ArrayList<SearchGroupFileItem> arrayList) {
        this.result = new GroupFileCommonResult();
        this.syncCookie = "";
        this.item = new ArrayList<>();
        this.result = groupFileCommonResult;
        this.syncCookie = str;
        this.totalMatchCount = i2;
        this.ownerMatchCount = i3;
        this.isEnd = z;
        this.reqId = i4;
        this.item = arrayList;
    }
}
