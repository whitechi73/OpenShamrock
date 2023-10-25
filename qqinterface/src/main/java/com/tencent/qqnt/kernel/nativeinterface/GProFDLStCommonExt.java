package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class GProFDLStCommonExt {
    ArrayList<GProFDLEntry> mapInfo;

    public GProFDLStCommonExt() {
        this.mapInfo = new ArrayList<>();
    }

    public ArrayList<GProFDLEntry> getMapInfo() {
        return this.mapInfo;
    }

    public String toString() {
        return "GProFDLStCommonExt{mapInfo=" + this.mapInfo + ",}";
    }

    public GProFDLStCommonExt(ArrayList<GProFDLEntry> arrayList) {
        this.mapInfo = new ArrayList<>();
        this.mapInfo = arrayList;
    }
}
