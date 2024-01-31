package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProWorldChannelInfos {
    String channelCover;
    String channelId;
    int channelMemberCount;
    int channelMemberMax;
    String guildId;
    ArrayList<GProUser> memberList;

    public GProWorldChannelInfos() {
        this.guildId = "";
        this.channelId = "";
        this.memberList = new ArrayList<>();
        this.channelCover = "";
    }

    public String getChannelCover() {
        return this.channelCover;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public int getChannelMemberCount() {
        return this.channelMemberCount;
    }

    public int getChannelMemberMax() {
        return this.channelMemberMax;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public ArrayList<GProUser> getMemberList() {
        return this.memberList;
    }

    public String toString() {
        return "GProWorldChannelInfos{guildId=" + this.guildId + ",channelId=" + this.channelId + ",channelMemberMax=" + this.channelMemberMax + ",channelMemberCount=" + this.channelMemberCount + ",memberList=" + this.memberList + ",channelCover=" + this.channelCover + ",}";
    }

    public GProWorldChannelInfos(String str, String str2, int i2, int i3, ArrayList<GProUser> arrayList, String str3) {
        this.guildId = "";
        this.channelId = "";
        this.memberList = new ArrayList<>();
        this.channelCover = "";
        this.guildId = str;
        this.channelId = str2;
        this.channelMemberMax = i2;
        this.channelMemberCount = i3;
        this.memberList = arrayList;
        this.channelCover = str3;
    }
}
