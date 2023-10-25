package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProGetAtMeMsgRsp implements Serializable {
    GProRecommendExtInfo extInfo;
    ArrayList<GProRecommendChannelInfo> msgList;
    int nextTs;
    long serialVersionUID;

    public GProGetAtMeMsgRsp() {
        this.serialVersionUID = 1L;
        this.msgList = new ArrayList<>();
        this.extInfo = new GProRecommendExtInfo();
    }

    public GProRecommendExtInfo getExtInfo() {
        return this.extInfo;
    }

    public ArrayList<GProRecommendChannelInfo> getMsgList() {
        return this.msgList;
    }

    public int getNextTs() {
        return this.nextTs;
    }

    public String toString() {
        return "GProGetAtMeMsgRsp{msgList=" + this.msgList + ",nextTs=" + this.nextTs + ",extInfo=" + this.extInfo + ",}";
    }

    public GProGetAtMeMsgRsp(ArrayList<GProRecommendChannelInfo> arrayList, int i2, GProRecommendExtInfo gProRecommendExtInfo) {
        this.serialVersionUID = 1L;
        this.msgList = new ArrayList<>();
        this.extInfo = new GProRecommendExtInfo();
        this.msgList = arrayList;
        this.nextTs = i2;
        this.extInfo = gProRecommendExtInfo;
    }
}
