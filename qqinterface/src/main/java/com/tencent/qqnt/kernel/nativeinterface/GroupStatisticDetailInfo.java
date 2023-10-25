package com.tencent.qqnt.kernel.nativeinterface;

public final class GroupStatisticDetailInfo {
    int count;
    String desc;

    public GroupStatisticDetailInfo() {
        this.desc = "";
    }

    public int getCount() {
        return this.count;
    }

    public String getDesc() {
        return this.desc;
    }

    public String toString() {
        return "GroupStatisticDetailInfo{desc=" + this.desc + ",count=" + this.count + ",}";
    }

    public GroupStatisticDetailInfo(String str, int i2) {
        this.desc = "";
        this.desc = str;
        this.count = i2;
    }
}