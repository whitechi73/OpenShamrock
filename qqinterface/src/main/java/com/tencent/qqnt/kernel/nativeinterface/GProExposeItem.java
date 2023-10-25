package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProExposeItem {
    GProItemCbData callback;
    String id;

    public GProExposeItem() {
        this.id = "";
        this.callback = new GProItemCbData();
    }

    public GProItemCbData getCallback() {
        return this.callback;
    }

    public String getId() {
        return this.id;
    }

    public String toString() {
        return "GProExposeItem{id=" + this.id + ",callback=" + this.callback + ",}";
    }

    public GProExposeItem(String str, GProItemCbData gProItemCbData) {
        this.id = "";
        this.callback = new GProItemCbData();
        this.id = str;
        this.callback = gProItemCbData;
    }
}
