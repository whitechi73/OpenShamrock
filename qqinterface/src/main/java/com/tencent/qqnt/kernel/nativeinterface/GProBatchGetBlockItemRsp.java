package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProBatchGetBlockItemRsp implements Serializable {
    byte[] cookies;
    boolean isEnd;
    ArrayList<GProBlockInfo> items;

    /* renamed from: msg  reason: collision with root package name */
    String f305531msg;
    long serialVersionUID;
    String traceId;

    public GProBatchGetBlockItemRsp() {
        this.serialVersionUID = 1L;
        this.traceId = "";
        this.items = new ArrayList<>();
        this.f305531msg = "";
        this.cookies = new byte[0];
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public ArrayList<GProBlockInfo> getItems() {
        return this.items;
    }

    public String getMsg() {
        return this.f305531msg;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String toString() {
        return "GProBatchGetBlockItemRsp{traceId=" + this.traceId + ",items=" + this.items + ",msg=" + this.f305531msg + ",isEnd=" + this.isEnd + ",cookies=" + this.cookies + ",}";
    }

    public GProBatchGetBlockItemRsp(String str, ArrayList<GProBlockInfo> arrayList, String str2, boolean z, byte[] bArr) {
        this.serialVersionUID = 1L;
        this.traceId = "";
        this.items = new ArrayList<>();
        this.f305531msg = "";
        this.cookies = new byte[0];
        this.traceId = str;
        this.items = arrayList;
        this.f305531msg = str2;
        this.isEnd = z;
        this.cookies = bArr;
    }
}
