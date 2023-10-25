package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProEndPageLiveTime {
    long endTime;
    long startTime;
    long timeLong;

    public GProEndPageLiveTime() {
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getTimeLong() {
        return this.timeLong;
    }

    public String toString() {
        return "GProEndPageLiveTime{startTime=" + this.startTime + ",endTime=" + this.endTime + ",timeLong=" + this.timeLong + ",}";
    }

    public GProEndPageLiveTime(long j2, long j3, long j4) {
        this.startTime = j2;
        this.endTime = j3;
        this.timeLong = j4;
    }
}
