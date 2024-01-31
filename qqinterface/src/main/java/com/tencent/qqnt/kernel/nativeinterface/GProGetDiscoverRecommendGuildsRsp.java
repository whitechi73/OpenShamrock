package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProGetDiscoverRecommendGuildsRsp {
    byte[] cookies;
    boolean isEnd;
    ArrayList<GProRecommendItem> items;

    /* renamed from: msg  reason: collision with root package name */
    String f305534msg;
    String requestId;

    public GProGetDiscoverRecommendGuildsRsp() {
        this.requestId = "";
        this.items = new ArrayList<>();
        this.f305534msg = "";
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
        return this.f305534msg;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String toString() {
        return "GProGetDiscoverRecommendGuildsRsp{requestId=" + this.requestId + ",items=" + this.items + ",msg=" + this.f305534msg + ",isEnd=" + this.isEnd + ",cookies=" + this.cookies + ",}";
    }

    public GProGetDiscoverRecommendGuildsRsp(String str, ArrayList<GProRecommendItem> arrayList, String str2, boolean z, byte[] bArr) {
        this.requestId = "";
        this.items = new ArrayList<>();
        this.f305534msg = "";
        this.cookies = new byte[0];
        this.requestId = str;
        this.items = arrayList;
        this.f305534msg = str2;
        this.isEnd = z;
        this.cookies = bArr;
    }
}
