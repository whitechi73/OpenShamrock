package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public final class ChannelStateElement {
    ArrayList<ChannStateItemInfo> channStateList;
    long channelId;
    int channelState;
    long channelStateReq;
    String firstMemberDisplayName;
    long firstMemberTinyid;
    long guildId;
    int guildState;
    int memberCount;
    int memberMax;
    long roomId;
    String roomTitle;
    long updateTime;

    public ChannelStateElement() {
        this.firstMemberDisplayName = "";
        this.roomTitle = "";
        this.channStateList = new ArrayList<>();
    }

    public ArrayList<ChannStateItemInfo> getChannStateList() {
        return this.channStateList;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getChannelState() {
        return this.channelState;
    }

    public long getChannelStateReq() {
        return this.channelStateReq;
    }

    public String getFirstMemberDisplayName() {
        return this.firstMemberDisplayName;
    }

    public long getFirstMemberTinyid() {
        return this.firstMemberTinyid;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getGuildState() {
        return this.guildState;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public int getMemberMax() {
        return this.memberMax;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public String getRoomTitle() {
        return this.roomTitle;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public String toString() {
        return "ChannelStateElement{guildId=" + this.guildId + ",channelId=" + this.channelId + ",memberCount=" + this.memberCount + ",memberMax=" + this.memberMax + ",firstMemberTinyid=" + this.firstMemberTinyid + ",firstMemberDisplayName=" + this.firstMemberDisplayName + ",guildState=" + this.guildState + ",channelState=" + this.channelState + ",channelStateReq=" + this.channelStateReq + ",updateTime=" + this.updateTime + ",roomId=" + this.roomId + ",roomTitle=" + this.roomTitle + ",channStateList=" + this.channStateList + ",}";
    }

    public ChannelStateElement(long j2, long j3, int i2, int i3, long j4, String str, int i4, int i5, long j5, long j6, long j7, String str2, ArrayList<ChannStateItemInfo> arrayList) {
        this.firstMemberDisplayName = "";
        this.roomTitle = "";
        this.channStateList = new ArrayList<>();
        this.guildId = j2;
        this.channelId = j3;
        this.memberCount = i2;
        this.memberMax = i3;
        this.firstMemberTinyid = j4;
        this.firstMemberDisplayName = str;
        this.guildState = i4;
        this.channelState = i5;
        this.channelStateReq = j5;
        this.updateTime = j6;
        this.roomId = j7;
        this.roomTitle = str2;
        this.channStateList = arrayList;
    }
}
