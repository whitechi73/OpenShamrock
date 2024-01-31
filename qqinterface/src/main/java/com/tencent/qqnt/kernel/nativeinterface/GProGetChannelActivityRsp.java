package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProGetChannelActivityRsp {
    ArrayList<GProChannelActivity> channelActivities;
    int closeOption;
    long guildId;
    boolean isShow;

    public GProGetChannelActivityRsp() {
        this.channelActivities = new ArrayList<>();
    }

    public ArrayList<GProChannelActivity> getChannelActivities() {
        return this.channelActivities;
    }

    public int getCloseOption() {
        return this.closeOption;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public boolean getIsShow() {
        return this.isShow;
    }

    public String toString() {
        return "GProGetChannelActivityRsp{guildId=" + this.guildId + ",channelActivities=" + this.channelActivities + ",isShow=" + this.isShow + ",closeOption=" + this.closeOption + ",}";
    }

    public GProGetChannelActivityRsp(long j2, ArrayList<GProChannelActivity> arrayList, boolean z, int i2) {
        this.channelActivities = new ArrayList<>();
        this.guildId = j2;
        this.channelActivities = arrayList;
        this.isShow = z;
        this.closeOption = i2;
    }
}
