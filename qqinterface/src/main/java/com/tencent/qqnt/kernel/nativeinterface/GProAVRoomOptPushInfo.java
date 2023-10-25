package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProAVRoomOptPushInfo {
    long channelId;
    String delRoomId;
    long guildId;
    int optType;
    GProAVRoomAddUpInfo roomAddUpInfo;
    GProAVShowMsgInfo showInfo;
    String switchRoomId;

    public GProAVRoomOptPushInfo() {
        this.showInfo = new GProAVShowMsgInfo();
        this.roomAddUpInfo = new GProAVRoomAddUpInfo();
        this.delRoomId = "";
        this.switchRoomId = "";
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getDelRoomId() {
        return this.delRoomId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getOptType() {
        return this.optType;
    }

    public GProAVRoomAddUpInfo getRoomAddUpInfo() {
        return this.roomAddUpInfo;
    }

    public GProAVShowMsgInfo getShowInfo() {
        return this.showInfo;
    }

    public String getSwitchRoomId() {
        return this.switchRoomId;
    }

    public String toString() {
        return "GProAVRoomOptPushInfo{optType=" + this.optType + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",showInfo=" + this.showInfo + ",roomAddUpInfo=" + this.roomAddUpInfo + ",delRoomId=" + this.delRoomId + ",switchRoomId=" + this.switchRoomId + ",}";
    }

    public GProAVRoomOptPushInfo(int i2, long j2, long j3, GProAVShowMsgInfo gProAVShowMsgInfo, GProAVRoomAddUpInfo gProAVRoomAddUpInfo, String str, String str2) {
        this.showInfo = new GProAVShowMsgInfo();
        this.roomAddUpInfo = new GProAVRoomAddUpInfo();
        this.delRoomId = "";
        this.switchRoomId = "";
        this.optType = i2;
        this.guildId = j2;
        this.channelId = j3;
        this.showInfo = gProAVShowMsgInfo;
        this.roomAddUpInfo = gProAVRoomAddUpInfo;
        this.delRoomId = str;
        this.switchRoomId = str2;
    }
}
