package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProGetBlockRecGuildsRsp implements Serializable {
    GProGetRecommendV2Rsp banner;
    byte[] cookies;
    boolean isEnd;

    /* renamed from: msg  reason: collision with root package name */
    String f305532msg;
    ArrayList<GProBlockInfo> recBlockInfo;
    long serialVersionUID;
    String traceId;

    public GProGetBlockRecGuildsRsp() {
        this.serialVersionUID = 1L;
        this.traceId = "";
        this.recBlockInfo = new ArrayList<>();
        this.f305532msg = "";
        this.cookies = new byte[0];
        this.banner = new GProGetRecommendV2Rsp();
    }

    public GProGetRecommendV2Rsp getBanner() {
        return this.banner;
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public String getMsg() {
        return this.f305532msg;
    }

    public ArrayList<GProBlockInfo> getRecBlockInfo() {
        return this.recBlockInfo;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String toString() {
        return "GProGetBlockRecGuildsRsp{traceId=" + this.traceId + ",recBlockInfo=" + this.recBlockInfo + ",msg=" + this.f305532msg + ",isEnd=" + this.isEnd + ",cookies=" + this.cookies + ",banner=" + this.banner + ",}";
    }

    public GProGetBlockRecGuildsRsp(String str, ArrayList<GProBlockInfo> arrayList, String str2, boolean z, byte[] bArr, GProGetRecommendV2Rsp gProGetRecommendV2Rsp) {
        this.serialVersionUID = 1L;
        this.traceId = "";
        this.recBlockInfo = new ArrayList<>();
        this.f305532msg = "";
        this.cookies = new byte[0];
        this.banner = new GProGetRecommendV2Rsp();
        this.traceId = str;
        this.recBlockInfo = arrayList;
        this.f305532msg = str2;
        this.isEnd = z;
        this.cookies = bArr;
        this.banner = gProGetRecommendV2Rsp;
    }
}
