package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProSearchCond {
    ArrayList<Long> channelIds;
    ArrayList<Long> fromTinyIds;
    ArrayList<GProMsgTimeRange> timeRanges;

    public GProSearchCond() {
        this.channelIds = new ArrayList<>();
        this.fromTinyIds = new ArrayList<>();
        this.timeRanges = new ArrayList<>();
    }

    public ArrayList<Long> getChannelIds() {
        return this.channelIds;
    }

    public ArrayList<Long> getFromTinyIds() {
        return this.fromTinyIds;
    }

    public ArrayList<GProMsgTimeRange> getTimeRanges() {
        return this.timeRanges;
    }

    public String toString() {
        return "GProSearchCond{channelIds=" + this.channelIds + ",fromTinyIds=" + this.fromTinyIds + ",timeRanges=" + this.timeRanges + ",}";
    }

    public GProSearchCond(ArrayList<Long> arrayList, ArrayList<Long> arrayList2, ArrayList<GProMsgTimeRange> arrayList3) {
        this.channelIds = new ArrayList<>();
        this.fromTinyIds = new ArrayList<>();
        this.timeRanges = new ArrayList<>();
        this.channelIds = arrayList;
        this.fromTinyIds = arrayList2;
        this.timeRanges = arrayList3;
    }
}
