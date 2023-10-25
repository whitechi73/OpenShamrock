package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProScheduleDate {
    long dateMs;
    int inviteStatus;

    public GProScheduleDate() {
    }

    public long getDateMs() {
        return this.dateMs;
    }

    public int getInviteStatus() {
        return this.inviteStatus;
    }

    public String toString() {
        return "GProScheduleDate{dateMs=" + this.dateMs + ",inviteStatus=" + this.inviteStatus + ",}";
    }

    public GProScheduleDate(long j2, int i2) {
        this.dateMs = j2;
        this.inviteStatus = i2;
    }
}
