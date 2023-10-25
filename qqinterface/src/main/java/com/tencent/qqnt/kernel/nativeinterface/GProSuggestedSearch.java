package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class GProSuggestedSearch {
    ArrayList<String> contentList;
    String title;

    public GProSuggestedSearch() {
        this.title = "";
        this.contentList = new ArrayList<>();
    }

    public ArrayList<String> getContentList() {
        return this.contentList;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProSuggestedSearch{title=" + this.title + ",contentList=" + this.contentList + ",}";
    }

    public GProSuggestedSearch(String str, ArrayList<String> arrayList) {
        this.title = "";
        this.contentList = new ArrayList<>();
        this.title = str;
        this.contentList = arrayList;
    }
}
