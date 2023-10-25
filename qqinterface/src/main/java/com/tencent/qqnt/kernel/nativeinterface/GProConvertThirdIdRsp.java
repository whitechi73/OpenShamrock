package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProConvertThirdIdRsp {
    ArrayList<String> ids;
    ArrayList<String> stringIds;

    public GProConvertThirdIdRsp() {
        this.ids = new ArrayList<>();
        this.stringIds = new ArrayList<>();
    }

    public ArrayList<String> getIds() {
        return this.ids;
    }

    public ArrayList<String> getStringIds() {
        return this.stringIds;
    }

    public String toString() {
        return "GProConvertThirdIdRsp{ids=" + this.ids + ",stringIds=" + this.stringIds + ",}";
    }

    public GProConvertThirdIdRsp(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.ids = new ArrayList<>();
        this.stringIds = new ArrayList<>();
        this.ids = arrayList;
        this.stringIds = arrayList2;
    }
}
