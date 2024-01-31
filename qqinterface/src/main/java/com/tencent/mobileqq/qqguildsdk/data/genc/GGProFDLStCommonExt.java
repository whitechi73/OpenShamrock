package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProFDLEntry;
import com.tencent.qqnt.kernel.nativeinterface.GProFDLStCommonExt;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProFDLStCommonExt implements IGProFDLStCommonExt {
    public final GProFDLStCommonExt mInfo;

    public GGProFDLStCommonExt(GProFDLStCommonExt gProFDLStCommonExt) {
        this.mInfo = gProFDLStCommonExt;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFDLStCommonExt
    public ArrayList<Object> getMapInfo() {
        ArrayList<GProFDLEntry> mapInfo = this.mInfo.getMapInfo();
        ArrayList<Object> arrayList = new ArrayList<>();
        Iterator<GProFDLEntry> it = mapInfo.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProFDLEntry(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFDLStCommonExt
    public String toString() {
        return this.mInfo.toString();
    }
}
