package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProCreateGuildGuideInfo {
    long guildId;
    int skipStatus;
    ArrayList<GProTaskInfo> taskList;

    public GProCreateGuildGuideInfo() {
        this.taskList = new ArrayList<>();
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getSkipStatus() {
        return this.skipStatus;
    }

    public ArrayList<GProTaskInfo> getTaskList() {
        return this.taskList;
    }

    public String toString() {
        return "GProCreateGuildGuideInfo{guildId=" + this.guildId + ",skipStatus=" + this.skipStatus + ",taskList=" + this.taskList + ",}";
    }

    public GProCreateGuildGuideInfo(long j2, int i2, ArrayList<GProTaskInfo> arrayList) {
        this.taskList = new ArrayList<>();
        this.guildId = j2;
        this.skipStatus = i2;
        this.taskList = arrayList;
    }
}
