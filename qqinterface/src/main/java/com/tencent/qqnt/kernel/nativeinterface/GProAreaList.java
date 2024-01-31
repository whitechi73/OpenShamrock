package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProAreaList {
    ArrayList<GProArea> areas;
    byte[] cookie;
    boolean isEnd;
    int level;

    public GProAreaList() {
        this.areas = new ArrayList<>();
        this.cookie = new byte[0];
    }

    public ArrayList<GProArea> getAreas() {
        return this.areas;
    }

    public byte[] getCookie() {
        return this.cookie;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public int getLevel() {
        return this.level;
    }

    public String toString() {
        return "GProAreaList{level=" + this.level + ",areas=" + this.areas + ",cookie=" + this.cookie + ",isEnd=" + this.isEnd + ",}";
    }

    public GProAreaList(int i2, ArrayList<GProArea> arrayList, byte[] bArr, boolean z) {
        this.areas = new ArrayList<>();
        this.cookie = new byte[0];
        this.level = i2;
        this.areas = arrayList;
        this.cookie = bArr;
        this.isEnd = z;
    }
}
