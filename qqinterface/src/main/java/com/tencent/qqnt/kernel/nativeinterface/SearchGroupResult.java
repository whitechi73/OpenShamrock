package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;



public final class SearchGroupResult {
    int errorode;
    ArrayList<SearchRspGroupInfo> groupInfos;
    boolean isEnd;
    int nextPos;

    public SearchGroupResult() {
        this.groupInfos = new ArrayList<>();
    }

    public int getErrorode() {
        return this.errorode;
    }

    public ArrayList<SearchRspGroupInfo> getGroupInfos() {
        return this.groupInfos;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public int getNextPos() {
        return this.nextPos;
    }

    public String toString() {
        return "SearchGroupResult{errorode=" + this.errorode + ",groupInfos=" + this.groupInfos + ",isEnd=" + this.isEnd + ",nextPos=" + this.nextPos + ",}";
    }

    public SearchGroupResult(int i2, ArrayList<SearchRspGroupInfo> arrayList, boolean z, int i3) {
        this.groupInfos = new ArrayList<>();
        this.errorode = i2;
        this.groupInfos = arrayList;
        this.isEnd = z;
        this.nextPos = i3;
    }
}
