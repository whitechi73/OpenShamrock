package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SearchDataLineChatInfo {
    String uid;

    public SearchDataLineChatInfo() {
        this.uid = "";
    }

    public String getUid() {
        return this.uid;
    }

    public String toString() {
        return "SearchDataLineChatInfo{uid=" + this.uid + ",}";
    }

    public SearchDataLineChatInfo(String str) {
        this.uid = "";
        this.uid = str;
    }
}
