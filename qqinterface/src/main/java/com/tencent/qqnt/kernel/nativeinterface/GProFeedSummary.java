package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProFeedSummary implements Serializable {
    String feedId;
    ArrayList<GProFeedThumbnail> feedThumbnails;
    long serialVersionUID;
    String title;

    public GProFeedSummary() {
        this.serialVersionUID = 1L;
        this.feedId = "";
        this.title = "";
        this.feedThumbnails = new ArrayList<>();
    }

    public String getFeedId() {
        return this.feedId;
    }

    public ArrayList<GProFeedThumbnail> getFeedThumbnails() {
        return this.feedThumbnails;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProFeedSummary{feedId=" + this.feedId + ",title=" + this.title + ",feedThumbnails=" + this.feedThumbnails + ",}";
    }

    public GProFeedSummary(String str, String str2, ArrayList<GProFeedThumbnail> arrayList) {
        this.serialVersionUID = 1L;
        this.feedId = "";
        this.title = "";
        this.feedThumbnails = new ArrayList<>();
        this.feedId = str;
        this.title = str2;
        this.feedThumbnails = arrayList;
    }
}
