package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProAtSetInfo {
    long guildId;
    int remainingAtAllCount;
    int remainingAtOnlCount;
    int remainingAtRoleCount;
    int totalAtAllCount;
    int totalAtOnlCount;
    int totalAtRoleCount;

    public GProAtSetInfo() {
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getRemainingAtAllCount() {
        return this.remainingAtAllCount;
    }

    public int getRemainingAtOnlCount() {
        return this.remainingAtOnlCount;
    }

    public int getRemainingAtRoleCount() {
        return this.remainingAtRoleCount;
    }

    public int getTotalAtAllCount() {
        return this.totalAtAllCount;
    }

    public int getTotalAtOnlCount() {
        return this.totalAtOnlCount;
    }

    public int getTotalAtRoleCount() {
        return this.totalAtRoleCount;
    }

    public String toString() {
        return "GProAtSetInfo{guildId=" + this.guildId + ",totalAtAllCount=" + this.totalAtAllCount + ",remainingAtAllCount=" + this.remainingAtAllCount + ",totalAtOnlCount=" + this.totalAtOnlCount + ",remainingAtOnlCount=" + this.remainingAtOnlCount + ",totalAtRoleCount=" + this.totalAtRoleCount + ",remainingAtRoleCount=" + this.remainingAtRoleCount + ",}";
    }

    public GProAtSetInfo(long j2, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.guildId = j2;
        this.totalAtAllCount = i2;
        this.remainingAtAllCount = i3;
        this.totalAtOnlCount = i4;
        this.remainingAtOnlCount = i5;
        this.totalAtRoleCount = i6;
        this.remainingAtRoleCount = i7;
    }
}
