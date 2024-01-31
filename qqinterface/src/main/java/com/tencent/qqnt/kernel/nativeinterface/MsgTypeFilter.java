package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;


public  final class MsgTypeFilter {
    ArrayList<Integer> subType;
    int type;

    public MsgTypeFilter() {
        this.subType = new ArrayList<>();
    }

    public ArrayList<Integer> getSubType() {
        return this.subType;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "MsgTypeFilter{type=" + this.type + ",subType=" + this.subType + ",}";
    }

    public MsgTypeFilter(int i2, ArrayList<Integer> arrayList) {
        this.subType = new ArrayList<>();
        this.type = i2;
        this.subType = arrayList;
    }
}
