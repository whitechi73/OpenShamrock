package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProGetCategoryGuildsRsp implements Serializable {
    byte[] cookies;
    boolean isEnd;
    ArrayList<GProRecommendItem> items;

    /* renamed from: msg  reason: collision with root package name */
    String f305533msg;
    long serialVersionUID;
    String traceId;

    public GProGetCategoryGuildsRsp() {
        this.serialVersionUID = 1L;
        this.traceId = "";
        this.items = new ArrayList<>();
        this.f305533msg = "";
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
        return this.f305533msg;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String toString() {
        return "GProGetCategoryGuildsRsp{traceId=" + this.traceId + ",items=" + this.items + ",msg=" + this.f305533msg + ",isEnd=" + this.isEnd + ",cookies=" + this.cookies + ",}";
    }

    public GProGetCategoryGuildsRsp(String str, ArrayList<GProRecommendItem> arrayList, String str2, boolean z, byte[] bArr) {
        this.serialVersionUID = 1L;
        this.traceId = "";
        this.items = new ArrayList<>();
        this.f305533msg = "";
        this.cookies = new byte[0];
        this.traceId = str;
        this.items = arrayList;
        this.f305533msg = str2;
        this.isEnd = z;
        this.cookies = bArr;
    }
}
