package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProGetSubjectGuildsRsp implements Serializable {
    int allCnt;
    byte[] cookies;
    ArrayList<GProRecommendItem> items;
    long serialVersionUID;
    String traceId;

    public GProGetSubjectGuildsRsp() {
        this.serialVersionUID = 1L;
        this.traceId = "";
        this.cookies = new byte[0];
        this.items = new ArrayList<>();
    }

    public int getAllCnt() {
        return this.allCnt;
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public ArrayList<GProRecommendItem> getItems() {
        return this.items;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String toString() {
        return "GProGetSubjectGuildsRsp{traceId=" + this.traceId + ",cookies=" + this.cookies + ",items=" + this.items + ",allCnt=" + this.allCnt + ",}";
    }

    public GProGetSubjectGuildsRsp(String str, byte[] bArr, ArrayList<GProRecommendItem> arrayList, int i2) {
        this.serialVersionUID = 1L;
        this.traceId = "";
        this.cookies = new byte[0];
        this.items = new ArrayList<>();
        this.traceId = str;
        this.cookies = bArr;
        this.items = arrayList;
        this.allCnt = i2;
    }
}
