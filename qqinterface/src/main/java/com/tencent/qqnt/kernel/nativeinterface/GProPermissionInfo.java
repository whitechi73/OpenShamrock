package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProPermissionInfo {
    ArrayList<Integer> childIds;
    int rootId;

    public GProPermissionInfo() {
        this.childIds = new ArrayList<>();
    }

    public ArrayList<Integer> getChildIds() {
        return this.childIds;
    }

    public int getRootId() {
        return this.rootId;
    }

    public String toString() {
        return "GProPermissionInfo{rootId=" + this.rootId + ",childIds=" + this.childIds + ",}";
    }

    public GProPermissionInfo(int i2, ArrayList<Integer> arrayList) {
        this.childIds = new ArrayList<>();
        this.rootId = i2;
        this.childIds = arrayList;
    }
}
