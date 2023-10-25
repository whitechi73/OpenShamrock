package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProGetRecommendHotRsp implements Serializable {
    byte[] cookies;
    GProRecommendExtInfo extInfo;
    ArrayList<GProRecommendItem> recommendList;
    long serialVersionUID;

    public GProGetRecommendHotRsp() {
        this.serialVersionUID = 1L;
        this.recommendList = new ArrayList<>();
        this.extInfo = new GProRecommendExtInfo();
        this.cookies = new byte[0];
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public GProRecommendExtInfo getExtInfo() {
        return this.extInfo;
    }

    public ArrayList<GProRecommendItem> getRecommendList() {
        return this.recommendList;
    }

    public String toString() {
        return "GProGetRecommendHotRsp{recommendList=" + this.recommendList + ",extInfo=" + this.extInfo + ",cookies=" + this.cookies + ",}";
    }

    public GProGetRecommendHotRsp(ArrayList<GProRecommendItem> arrayList, GProRecommendExtInfo gProRecommendExtInfo, byte[] bArr) {
        this.serialVersionUID = 1L;
        this.recommendList = new ArrayList<>();
        this.extInfo = new GProRecommendExtInfo();
        this.cookies = new byte[0];
        this.recommendList = arrayList;
        this.extInfo = gProRecommendExtInfo;
        this.cookies = bArr;
    }
}
