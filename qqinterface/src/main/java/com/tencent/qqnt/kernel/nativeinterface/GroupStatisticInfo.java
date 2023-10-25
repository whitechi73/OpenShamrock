package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public final class GroupStatisticInfo {
    ArrayList<GroupStatisticDetailInfo> detailInfo;
    long maxCount;

    public GroupStatisticInfo() {
        this.detailInfo = new ArrayList<>();
    }

    public ArrayList<GroupStatisticDetailInfo> getDetailInfo() {
        return this.detailInfo;
    }

    public long getMaxCount() {
        return this.maxCount;
    }

    public String toString() {
        return "GroupStatisticInfo{maxCount=" + this.maxCount + ",detailInfo=" + this.detailInfo + ",}";
    }

    public GroupStatisticInfo(long j2, ArrayList<GroupStatisticDetailInfo> arrayList) {
        this.detailInfo = new ArrayList<>();
        this.maxCount = j2;
        this.detailInfo = arrayList;
    }
}