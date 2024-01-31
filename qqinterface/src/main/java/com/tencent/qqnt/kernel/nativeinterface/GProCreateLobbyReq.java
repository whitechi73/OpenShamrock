package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProCreateLobbyReq {
    String appId;
    int capacity;
    long channelId;
    ArrayList<GProKVPair> extendDic;
    long guildId;
    int lobbyType;

    public GProCreateLobbyReq() {
        this.appId = "";
        this.extendDic = new ArrayList<>();
    }

    public String getAppId() {
        return this.appId;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public ArrayList<GProKVPair> getExtendDic() {
        return this.extendDic;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getLobbyType() {
        return this.lobbyType;
    }

    public String toString() {
        return "GProCreateLobbyReq{appId=" + this.appId + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",lobbyType=" + this.lobbyType + ",capacity=" + this.capacity + ",extendDic=" + this.extendDic + ",}";
    }

    public GProCreateLobbyReq(String str, long j2, long j3, int i2, int i3, ArrayList<GProKVPair> arrayList) {
        this.appId = "";
        this.extendDic = new ArrayList<>();
        this.appId = str;
        this.guildId = j2;
        this.channelId = j3;
        this.lobbyType = i2;
        this.capacity = i3;
        this.extendDic = arrayList;
    }
}
