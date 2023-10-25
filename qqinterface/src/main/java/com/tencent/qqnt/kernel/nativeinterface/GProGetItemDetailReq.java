package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProGetItemDetailReq {
    ArrayList<GProItemIdInfo> itemList;
    GProBottomTabSourceInfo source;
    String transBuffer;

    public GProGetItemDetailReq() {
        this.source = new GProBottomTabSourceInfo();
        this.itemList = new ArrayList<>();
        this.transBuffer = "";
    }

    public ArrayList<GProItemIdInfo> getItemList() {
        return this.itemList;
    }

    public GProBottomTabSourceInfo getSource() {
        return this.source;
    }

    public String getTransBuffer() {
        return this.transBuffer;
    }

    public String toString() {
        return "GProGetItemDetailReq{source=" + this.source + ",itemList=" + this.itemList + ",transBuffer=" + this.transBuffer + ",}";
    }

    public GProGetItemDetailReq(GProBottomTabSourceInfo gProBottomTabSourceInfo, ArrayList<GProItemIdInfo> arrayList, String str) {
        this.source = new GProBottomTabSourceInfo();
        this.itemList = new ArrayList<>();
        this.transBuffer = "";
        this.source = gProBottomTabSourceInfo;
        this.itemList = arrayList;
        this.transBuffer = str;
    }
}
