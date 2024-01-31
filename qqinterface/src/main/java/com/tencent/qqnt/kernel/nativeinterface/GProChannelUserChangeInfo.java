package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProChannelUserChangeInfo implements Serializable {
    ArrayList<GProUser> changeUserList;
    long channelId;
    GProChannelUserNum channelUserNum;
    long guildId;
    long serialVersionUID;

    public GProChannelUserChangeInfo() {
        this.serialVersionUID = 1L;
        this.changeUserList = new ArrayList<>();
        this.channelUserNum = new GProChannelUserNum();
    }

    public ArrayList<GProUser> getChangeUserList() {
        return this.changeUserList;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public GProChannelUserNum getChannelUserNum() {
        return this.channelUserNum;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProChannelUserChangeInfo{guildId=" + this.guildId + ",channelId=" + this.channelId + ",changeUserList=" + this.changeUserList + ",channelUserNum=" + this.channelUserNum + ",}";
    }

    public GProChannelUserChangeInfo(long j2, long j3, ArrayList<GProUser> arrayList, GProChannelUserNum gProChannelUserNum) {
        this.serialVersionUID = 1L;
        this.changeUserList = new ArrayList<>();
        this.channelUserNum = new GProChannelUserNum();
        this.guildId = j2;
        this.channelId = j3;
        this.changeUserList = arrayList;
        this.channelUserNum = gProChannelUserNum;
    }
}
