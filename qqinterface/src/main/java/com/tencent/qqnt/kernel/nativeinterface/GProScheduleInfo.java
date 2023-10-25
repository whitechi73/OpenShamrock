package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProScheduleInfo {
    int acceptedNums;
    ArrayList<GProScheduleUser> acceptedUser;
    GProScheduleChannelInfo channelInfo;
    String content;
    long createTimeMs;
    GProScheduleUser creator;
    long endTimeMs;
    int inviteStatus;
    boolean isNotified;
    int rejectedNums;
    int reminderTimeType;
    long scheduleId;
    long startTimeMs;
    String title;

    public GProScheduleInfo() {
        this.title = "";
        this.content = "";
        this.channelInfo = new GProScheduleChannelInfo();
        this.creator = new GProScheduleUser();
        this.acceptedUser = new ArrayList<>();
    }

    public int getAcceptedNums() {
        return this.acceptedNums;
    }

    public ArrayList<GProScheduleUser> getAcceptedUser() {
        return this.acceptedUser;
    }

    public GProScheduleChannelInfo getChannelInfo() {
        return this.channelInfo;
    }

    public String getContent() {
        return this.content;
    }

    public long getCreateTimeMs() {
        return this.createTimeMs;
    }

    public GProScheduleUser getCreator() {
        return this.creator;
    }

    public long getEndTimeMs() {
        return this.endTimeMs;
    }

    public int getInviteStatus() {
        return this.inviteStatus;
    }

    public boolean getIsNotified() {
        return this.isNotified;
    }

    public int getRejectedNums() {
        return this.rejectedNums;
    }

    public int getReminderTimeType() {
        return this.reminderTimeType;
    }

    public long getScheduleId() {
        return this.scheduleId;
    }

    public long getStartTimeMs() {
        return this.startTimeMs;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProScheduleInfo{scheduleId=" + this.scheduleId + ",title=" + this.title + ",startTimeMs=" + this.startTimeMs + ",endTimeMs=" + this.endTimeMs + ",content=" + this.content + ",reminderTimeType=" + this.reminderTimeType + ",channelInfo=" + this.channelInfo + ",inviteStatus=" + this.inviteStatus + ",createTimeMs=" + this.createTimeMs + ",creator=" + this.creator + ",acceptedNums=" + this.acceptedNums + ",rejectedNums=" + this.rejectedNums + ",acceptedUser=" + this.acceptedUser + ",isNotified=" + this.isNotified + ",}";
    }

    public GProScheduleInfo(long j2, String str, long j3, long j4, String str2, int i2, GProScheduleChannelInfo gProScheduleChannelInfo, int i3, long j5, GProScheduleUser gProScheduleUser, int i4, int i5, ArrayList<GProScheduleUser> arrayList, boolean z) {
        this.title = "";
        this.content = "";
        this.channelInfo = new GProScheduleChannelInfo();
        this.creator = new GProScheduleUser();
        this.acceptedUser = new ArrayList<>();
        this.scheduleId = j2;
        this.title = str;
        this.startTimeMs = j3;
        this.endTimeMs = j4;
        this.content = str2;
        this.reminderTimeType = i2;
        this.channelInfo = gProScheduleChannelInfo;
        this.inviteStatus = i3;
        this.createTimeMs = j5;
        this.creator = gProScheduleUser;
        this.acceptedNums = i4;
        this.rejectedNums = i5;
        this.acceptedUser = arrayList;
        this.isNotified = z;
    }
}
