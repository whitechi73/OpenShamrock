package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProHeartbeatReq implements Serializable {
    String authMeta;
    long channelDataVersion;
    long channelId;
    int channelType;
    long guildId;
    ArrayList<GProKVNode> kvInfoList;
    ArrayList<String> roomIdList;
    long serialVersionUID;
    int streamType;
    GProUserDevState userDevState;

    public GProHeartbeatReq() {
        this.serialVersionUID = 1L;
        this.authMeta = "";
        this.roomIdList = new ArrayList<>();
        this.userDevState = new GProUserDevState();
        this.kvInfoList = new ArrayList<>();
    }

    public String getAuthMeta() {
        return this.authMeta;
    }

    public long getChannelDataVersion() {
        return this.channelDataVersion;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public ArrayList<GProKVNode> getKvInfoList() {
        return this.kvInfoList;
    }

    public ArrayList<String> getRoomIdList() {
        return this.roomIdList;
    }

    public int getStreamType() {
        return this.streamType;
    }

    public GProUserDevState getUserDevState() {
        return this.userDevState;
    }

    public String toString() {
        return "GProHeartbeatReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",authMeta=" + this.authMeta + ",roomIdList=" + this.roomIdList + ",streamType=" + this.streamType + ",userDevState=" + this.userDevState + ",kvInfoList=" + this.kvInfoList + ",channelType=" + this.channelType + ",channelDataVersion=" + this.channelDataVersion + ",}";
    }

    public GProHeartbeatReq(long j2, long j3, String str, ArrayList<String> arrayList, int i2, GProUserDevState gProUserDevState, ArrayList<GProKVNode> arrayList2, int i3, long j4) {
        this.serialVersionUID = 1L;
        this.authMeta = "";
        this.roomIdList = new ArrayList<>();
        this.userDevState = new GProUserDevState();
        this.kvInfoList = new ArrayList<>();
        this.guildId = j2;
        this.channelId = j3;
        this.authMeta = str;
        this.roomIdList = arrayList;
        this.streamType = i2;
        this.userDevState = gProUserDevState;
        this.kvInfoList = arrayList2;
        this.channelType = i3;
        this.channelDataVersion = j4;
    }
}
