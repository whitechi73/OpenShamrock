package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProUserLiveRoomInfo {
    String coverUrl;
    String title;

    public GProUserLiveRoomInfo() {
        this.title = "";
        this.coverUrl = "";
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProUserLiveRoomInfo{title=" + this.title + ",coverUrl=" + this.coverUrl + ",}";
    }

    public GProUserLiveRoomInfo(String str, String str2) {
        this.title = "";
        this.coverUrl = "";
        this.title = str;
        this.coverUrl = str2;
    }
}
