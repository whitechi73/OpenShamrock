package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProGuildListSortInfo {
    ArrayList<Long> sortList;
    ArrayList<Long> topList;

    public GProGuildListSortInfo() {
        this.sortList = new ArrayList<>();
        this.topList = new ArrayList<>();
    }

    public ArrayList<Long> getSortList() {
        return this.sortList;
    }

    public ArrayList<Long> getTopList() {
        return this.topList;
    }

    public String toString() {
        return "GProGuildListSortInfo{sortList=" + this.sortList + ",topList=" + this.topList + ",}";
    }

    public GProGuildListSortInfo(ArrayList<Long> arrayList, ArrayList<Long> arrayList2) {
        this.sortList = new ArrayList<>();
        this.topList = new ArrayList<>();
        this.sortList = arrayList;
        this.topList = arrayList2;
    }
}
