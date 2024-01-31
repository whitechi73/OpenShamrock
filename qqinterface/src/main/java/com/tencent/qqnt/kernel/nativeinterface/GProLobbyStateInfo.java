package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProLobbyStateInfo implements Serializable {
    String appId;
    long channelId;
    boolean disableVoiceAnimation;
    ArrayList<GProKVPair> extendDic;
    long guildId;
    long leaderTinyId;
    long lobbyId;
    int lobbyRoomCapacity;
    int lobbyRoomCurrUserNum;
    int lobbyRoomStatus;
    int lobbyType;
    long serialVersionUID;

    public GProLobbyStateInfo() {
        this.serialVersionUID = 1L;
        this.appId = "";
        this.extendDic = new ArrayList<>();
    }

    public String getAppId() {
        return this.appId;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public boolean getDisableVoiceAnimation() {
        return this.disableVoiceAnimation;
    }

    public ArrayList<GProKVPair> getExtendDic() {
        return this.extendDic;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getLeaderTinyId() {
        return this.leaderTinyId;
    }

    public long getLobbyId() {
        return this.lobbyId;
    }

    public int getLobbyRoomCapacity() {
        return this.lobbyRoomCapacity;
    }

    public int getLobbyRoomCurrUserNum() {
        return this.lobbyRoomCurrUserNum;
    }

    public int getLobbyRoomStatus() {
        return this.lobbyRoomStatus;
    }

    public int getLobbyType() {
        return this.lobbyType;
    }

    public String toString() {
        return "GProLobbyStateInfo{lobbyId=" + this.lobbyId + ",appId=" + this.appId + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",leaderTinyId=" + this.leaderTinyId + ",lobbyType=" + this.lobbyType + ",lobbyRoomCurrUserNum=" + this.lobbyRoomCurrUserNum + ",lobbyRoomCapacity=" + this.lobbyRoomCapacity + ",lobbyRoomStatus=" + this.lobbyRoomStatus + ",extendDic=" + this.extendDic + ",disableVoiceAnimation=" + this.disableVoiceAnimation + ",}";
    }

    public GProLobbyStateInfo(long j2, String str, long j3, long j4, long j5, int i2, int i3, int i4, int i5, ArrayList<GProKVPair> arrayList, boolean z) {
        this.serialVersionUID = 1L;
        this.appId = "";
        this.extendDic = new ArrayList<>();
        this.lobbyId = j2;
        this.appId = str;
        this.guildId = j3;
        this.channelId = j4;
        this.leaderTinyId = j5;
        this.lobbyType = i2;
        this.lobbyRoomCurrUserNum = i3;
        this.lobbyRoomCapacity = i4;
        this.lobbyRoomStatus = i5;
        this.extendDic = arrayList;
        this.disableVoiceAnimation = z;
    }
}
