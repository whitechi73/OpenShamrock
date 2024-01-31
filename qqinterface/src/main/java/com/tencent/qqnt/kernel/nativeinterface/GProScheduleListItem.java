package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProScheduleListItem {
    GProScheduleInfo schedule;
    int seq;
    int totalDays;

    public GProScheduleListItem() {
        this.schedule = new GProScheduleInfo();
    }

    public GProScheduleInfo getSchedule() {
        return this.schedule;
    }

    public int getSeq() {
        return this.seq;
    }

    public int getTotalDays() {
        return this.totalDays;
    }

    public String toString() {
        return "GProScheduleListItem{schedule=" + this.schedule + ",seq=" + this.seq + ",totalDays=" + this.totalDays + ",}";
    }

    public GProScheduleListItem(GProScheduleInfo gProScheduleInfo, int i2, int i3) {
        this.schedule = new GProScheduleInfo();
        this.schedule = gProScheduleInfo;
        this.seq = i2;
        this.totalDays = i3;
    }
}
