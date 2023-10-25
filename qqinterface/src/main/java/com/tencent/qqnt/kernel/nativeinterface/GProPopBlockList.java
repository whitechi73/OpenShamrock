package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProPopBlockList implements Serializable {
    String blockName;
    ArrayList<GProBlockBaseInfo> list;
    int nextTs;
    long serialVersionUID;

    public GProPopBlockList() {
        this.serialVersionUID = 1L;
        this.blockName = "";
        this.list = new ArrayList<>();
    }

    public String getBlockName() {
        return this.blockName;
    }

    public ArrayList<GProBlockBaseInfo> getList() {
        return this.list;
    }

    public int getNextTs() {
        return this.nextTs;
    }

    public String toString() {
        return "GProPopBlockList{blockName=" + this.blockName + ",list=" + this.list + ",nextTs=" + this.nextTs + ",}";
    }

    public GProPopBlockList(String str, ArrayList<GProBlockBaseInfo> arrayList, int i2) {
        this.serialVersionUID = 1L;
        this.blockName = "";
        this.list = new ArrayList<>();
        this.blockName = str;
        this.list = arrayList;
        this.nextTs = i2;
    }
}
