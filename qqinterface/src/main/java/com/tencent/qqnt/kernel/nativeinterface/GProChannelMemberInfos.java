package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProChannelMemberInfos implements Serializable {
    GProAVChannelConfig channelConfig;
    String channelId;
    int channelMemberCount;
    int channelMemberMax;
    ArrayList<GProChannelStateItemInfo> channelStateList;
    int channelStatus;
    String guildId;
    ArrayList<GProUser> memberList;
    long serialVersionUID;

    public GProChannelMemberInfos() {
        this.serialVersionUID = 1L;
        this.guildId = "";
        this.channelId = "";
        this.memberList = new ArrayList<>();
        this.channelStateList = new ArrayList<>();
        this.channelConfig = new GProAVChannelConfig();
    }

    public GProAVChannelConfig getChannelConfig() {
        return this.channelConfig;
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

    public ArrayList<GProChannelStateItemInfo> getChannelStateList() {
        return this.channelStateList;
    }

    public int getChannelStatus() {
        return this.channelStatus;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public ArrayList<GProUser> getMemberList() {
        return this.memberList;
    }

    public String toString() {
        return "GProChannelMemberInfos{guildId=" + this.guildId + ",channelId=" + this.channelId + ",channelMemberMax=" + this.channelMemberMax + ",channelMemberCount=" + this.channelMemberCount + ",memberList=" + this.memberList + ",channelStatus=" + this.channelStatus + ",channelStateList=" + this.channelStateList + ",channelConfig=" + this.channelConfig + ",}";
    }

    public GProChannelMemberInfos(String str, String str2, int i2, int i3, ArrayList<GProUser> arrayList, int i4, ArrayList<GProChannelStateItemInfo> arrayList2, GProAVChannelConfig gProAVChannelConfig) {
        this.serialVersionUID = 1L;
        this.guildId = "";
        this.channelId = "";
        this.memberList = new ArrayList<>();
        this.channelStateList = new ArrayList<>();
        this.channelConfig = new GProAVChannelConfig();
        this.guildId = str;
        this.channelId = str2;
        this.channelMemberMax = i2;
        this.channelMemberCount = i3;
        this.memberList = arrayList;
        this.channelStatus = i4;
        this.channelStateList = arrayList2;
        this.channelConfig = gProAVChannelConfig;
    }
}
