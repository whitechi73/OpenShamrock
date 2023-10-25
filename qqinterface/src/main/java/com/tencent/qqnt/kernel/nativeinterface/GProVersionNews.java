package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProVersionNews {
    String jumpFeedUrl;
    ArrayList<String> newsUrlList;
    String subtitle;
    String title;

    public GProVersionNews() {
        this.title = "";
        this.subtitle = "";
        this.newsUrlList = new ArrayList<>();
        this.jumpFeedUrl = "";
    }

    public String getJumpFeedUrl() {
        return this.jumpFeedUrl;
    }

    public ArrayList<String> getNewsUrlList() {
        return this.newsUrlList;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProVersionNews{title=" + this.title + ",subtitle=" + this.subtitle + ",newsUrlList=" + this.newsUrlList + ",jumpFeedUrl=" + this.jumpFeedUrl + ",}";
    }

    public GProVersionNews(String str, String str2, ArrayList<String> arrayList, String str3) {
        this.title = "";
        this.subtitle = "";
        this.newsUrlList = new ArrayList<>();
        this.jumpFeedUrl = "";
        this.title = str;
        this.subtitle = str2;
        this.newsUrlList = arrayList;
        this.jumpFeedUrl = str3;
    }
}
