package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProGuildActiveValue {
    int guildTodayAddActive;
    int myTodayActive;
    long totalGuildActive;

    public GProGuildActiveValue() {
    }

    public int getGuildTodayAddActive() {
        return this.guildTodayAddActive;
    }

    public int getMyTodayActive() {
        return this.myTodayActive;
    }

    public long getTotalGuildActive() {
        return this.totalGuildActive;
    }

    public String toString() {
        return "GProGuildActiveValue{totalGuildActive=" + this.totalGuildActive + ",guildTodayAddActive=" + this.guildTodayAddActive + ",myTodayActive=" + this.myTodayActive + ",}";
    }

    public GProGuildActiveValue(long j2, int i2, int i3) {
        this.totalGuildActive = j2;
        this.guildTodayAddActive = i2;
        this.myTodayActive = i3;
    }
}
