package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProScheduleDayItem {
    long dateMs;
    ArrayList<GProScheduleListItem> scheduleListItems;

    public GProScheduleDayItem() {
        this.scheduleListItems = new ArrayList<>();
    }

    public long getDateMs() {
        return this.dateMs;
    }

    public ArrayList<GProScheduleListItem> getScheduleListItems() {
        return this.scheduleListItems;
    }

    public String toString() {
        return "GProScheduleDayItem{dateMs=" + this.dateMs + ",scheduleListItems=" + this.scheduleListItems + ",}";
    }

    public GProScheduleDayItem(long j2, ArrayList<GProScheduleListItem> arrayList) {
        this.scheduleListItems = new ArrayList<>();
        this.dateMs = j2;
        this.scheduleListItems = arrayList;
    }
}
