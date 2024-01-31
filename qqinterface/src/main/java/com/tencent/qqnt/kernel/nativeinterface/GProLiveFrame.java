package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProLiveFrame {
    ArrayList<GProPlayAddress> address;
    Integer codecType;
    String definition;
    Integer level;

    public GProLiveFrame() {
        this.address = new ArrayList<>();
    }

    public ArrayList<GProPlayAddress> getAddress() {
        return this.address;
    }

    public Integer getCodecType() {
        return this.codecType;
    }

    public String getDefinition() {
        return this.definition;
    }

    public Integer getLevel() {
        return this.level;
    }

    public String toString() {
        return "GProLiveFrame{level=" + this.level + ",address=" + this.address + ",definition=" + this.definition + ",codecType=" + this.codecType + ",}";
    }

    public GProLiveFrame(Integer num, ArrayList<GProPlayAddress> arrayList, String str, Integer num2) {
        this.address = new ArrayList<>();
        this.level = num;
        this.address = arrayList;
        this.definition = str;
        this.codecType = num2;
    }
}
