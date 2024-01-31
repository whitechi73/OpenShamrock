package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProAppChnnPreInfo {
    long appid;
    long channelId;
    ArrayList<GProChannelPresenceInfo> chnnPreList;
    String chnnPreSeq;
    long guildId;
    GProJoinCondition joinCondition;
    int jumpType;
    String jumpUrl;
    int nextTimeStamp;
    int result;
    String text;

    public GProAppChnnPreInfo() {
        this.jumpUrl = "";
        this.text = "";
        this.chnnPreList = new ArrayList<>();
        this.chnnPreSeq = "";
        this.joinCondition = new GProJoinCondition();
    }

    public long getAppid() {
        return this.appid;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public ArrayList<GProChannelPresenceInfo> getChnnPreList() {
        return this.chnnPreList;
    }

    public String getChnnPreSeq() {
        return this.chnnPreSeq;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public GProJoinCondition getJoinCondition() {
        return this.joinCondition;
    }

    public int getJumpType() {
        return this.jumpType;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public int getNextTimeStamp() {
        return this.nextTimeStamp;
    }

    public int getResult() {
        return this.result;
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return "GProAppChnnPreInfo{guildId=" + this.guildId + ",channelId=" + this.channelId + ",appid=" + this.appid + ",result=" + this.result + ",jumpUrl=" + this.jumpUrl + ",jumpType=" + this.jumpType + ",text=" + this.text + ",chnnPreList=" + this.chnnPreList + ",chnnPreSeq=" + this.chnnPreSeq + ",nextTimeStamp=" + this.nextTimeStamp + ",joinCondition=" + this.joinCondition + ",}";
    }

    public GProAppChnnPreInfo(long j2, long j3, long j4, int i2, String str, int i3, String str2, ArrayList<GProChannelPresenceInfo> arrayList, String str3, int i4, GProJoinCondition gProJoinCondition) {
        this.jumpUrl = "";
        this.text = "";
        this.chnnPreList = new ArrayList<>();
        this.chnnPreSeq = "";
        this.joinCondition = new GProJoinCondition();
        this.guildId = j2;
        this.channelId = j3;
        this.appid = j4;
        this.result = i2;
        this.jumpUrl = str;
        this.jumpType = i3;
        this.text = str2;
        this.chnnPreList = arrayList;
        this.chnnPreSeq = str3;
        this.nextTimeStamp = i4;
        this.joinCondition = gProJoinCondition;
    }
}
