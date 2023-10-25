package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProTopFeedAbstract {
    GProThumbnail thumbnail;
    String title;

    public GProTopFeedAbstract() {
        this.title = "";
        this.thumbnail = new GProThumbnail();
    }

    public GProThumbnail getThumbnail() {
        return this.thumbnail;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProTopFeedAbstract{title=" + this.title + ",thumbnail=" + this.thumbnail + ",}";
    }

    public GProTopFeedAbstract(String str, GProThumbnail gProThumbnail) {
        this.title = "";
        this.thumbnail = new GProThumbnail();
        this.title = str;
        this.thumbnail = gProThumbnail;
    }
}
