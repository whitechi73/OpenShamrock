package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProGetItemDetailRsp {
    byte[] cookies;
    boolean isEnd;
    ArrayList<GProRecommendItem> items;

    /* renamed from: msg  reason: collision with root package name */
    String f305535msg;
    int nextTs;
    String requestId;

    public GProGetItemDetailRsp() {
        this.requestId = "";
        this.items = new ArrayList<>();
        this.f305535msg = "";
        this.cookies = new byte[0];
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public ArrayList<GProRecommendItem> getItems() {
        return this.items;
    }

    public String getMsg() {
        return this.f305535msg;
    }

    public int getNextTs() {
        return this.nextTs;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String toString() {
        return "GProGetItemDetailRsp{requestId=" + this.requestId + ",items=" + this.items + ",msg=" + this.f305535msg + ",isEnd=" + this.isEnd + ",cookies=" + this.cookies + ",nextTs=" + this.nextTs + ",}";
    }

    public GProGetItemDetailRsp(String str, ArrayList<GProRecommendItem> arrayList, String str2, boolean z, byte[] bArr, int i2) {
        this.requestId = "";
        this.items = new ArrayList<>();
        this.f305535msg = "";
        this.cookies = new byte[0];
        this.requestId = str;
        this.items = arrayList;
        this.f305535msg = str2;
        this.isEnd = z;
        this.cookies = bArr;
        this.nextTs = i2;
    }
}
