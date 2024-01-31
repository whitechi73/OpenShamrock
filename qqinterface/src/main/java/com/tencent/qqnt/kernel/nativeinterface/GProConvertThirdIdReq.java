package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProConvertThirdIdReq {
    long appId;
    ArrayList<String> ids;
    ArrayList<String> stringIds;
    int type;

    public GProConvertThirdIdReq() {
        this.ids = new ArrayList<>();
        this.stringIds = new ArrayList<>();
    }

    public long getAppId() {
        return this.appId;
    }

    public ArrayList<String> getIds() {
        return this.ids;
    }

    public ArrayList<String> getStringIds() {
        return this.stringIds;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProConvertThirdIdReq{type=" + this.type + ",ids=" + this.ids + ",appId=" + this.appId + ",stringIds=" + this.stringIds + ",}";
    }

    public GProConvertThirdIdReq(int i2, ArrayList<String> arrayList, long j2, ArrayList<String> arrayList2) {
        this.ids = new ArrayList<>();
        this.stringIds = new ArrayList<>();
        this.type = i2;
        this.ids = arrayList;
        this.appId = j2;
        this.stringIds = arrayList2;
    }
}
