package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProScheduleSearchInfo {
    int acceptedNums;
    long channelId;
    String channelName;
    String content;
    GProSearchUser creator;
    long endTimeMs;
    String guildHeadUrl;
    long guildId;
    String guildName;
    int inviteStatus;
    String joinGuildSig;
    GProRecallInfo recallInfo;
    long scheduleId;
    long startTimeMs;
    ArrayList<String> tags;
    String title;

    public GProScheduleSearchInfo() {
        this.title = "";
        this.content = "";
        this.creator = new GProSearchUser();
        this.guildName = "";
        this.guildHeadUrl = "";
        this.joinGuildSig = "";
        this.channelName = "";
        this.tags = new ArrayList<>();
        this.recallInfo = new GProRecallInfo();
    }

    public int getAcceptedNums() {
        return this.acceptedNums;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public String getContent() {
        return this.content;
    }

    public GProSearchUser getCreator() {
        return this.creator;
    }

    public long getEndTimeMs() {
        return this.endTimeMs;
    }

    public String getGuildHeadUrl() {
        return this.guildHeadUrl;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public int getInviteStatus() {
        return this.inviteStatus;
    }

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public GProRecallInfo getRecallInfo() {
        return this.recallInfo;
    }

    public long getScheduleId() {
        return this.scheduleId;
    }

    public long getStartTimeMs() {
        return this.startTimeMs;
    }

    public ArrayList<String> getTags() {
        return this.tags;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProScheduleSearchInfo{scheduleId=" + this.scheduleId + ",title=" + this.title + ",startTimeMs=" + this.startTimeMs + ",endTimeMs=" + this.endTimeMs + ",content=" + this.content + ",creator=" + this.creator + ",acceptedNums=" + this.acceptedNums + ",guildId=" + this.guildId + ",guildName=" + this.guildName + ",guildHeadUrl=" + this.guildHeadUrl + ",channelId=" + this.channelId + ",joinGuildSig=" + this.joinGuildSig + ",channelName=" + this.channelName + ",tags=" + this.tags + ",recallInfo=" + this.recallInfo + ",inviteStatus=" + this.inviteStatus + ",}";
    }

    public GProScheduleSearchInfo(long j2, String str, long j3, long j4, String str2, GProSearchUser gProSearchUser, int i2, long j5, String str3, String str4, long j6, String str5, String str6, ArrayList<String> arrayList, GProRecallInfo gProRecallInfo, int i3) {
        this.title = "";
        this.content = "";
        this.creator = new GProSearchUser();
        this.guildName = "";
        this.guildHeadUrl = "";
        this.joinGuildSig = "";
        this.channelName = "";
        this.tags = new ArrayList<>();
        this.recallInfo = new GProRecallInfo();
        this.scheduleId = j2;
        this.title = str;
        this.startTimeMs = j3;
        this.endTimeMs = j4;
        this.content = str2;
        this.creator = gProSearchUser;
        this.acceptedNums = i2;
        this.guildId = j5;
        this.guildName = str3;
        this.guildHeadUrl = str4;
        this.channelId = j6;
        this.joinGuildSig = str5;
        this.channelName = str6;
        this.tags = arrayList;
        this.recallInfo = gProRecallInfo;
        this.inviteStatus = i3;
    }
}
