package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProBusinessNode implements Serializable {
    long dataVersion;
    long expiresMs;
    GProLobbyRoomInfo lobbyRoomInfo;
    int mutexType;
    byte[] nodeData;
    int nodeType;
    GProPlayInfo playInfo;
    GProVoiceSmobaGameRoomStateInfo roomStateInfo;
    GProVoiceInfo screenShareInfo;
    long serialVersionUID;
    GProWorldChannelPresence worldPresence;

    public GProBusinessNode() {
        this.serialVersionUID = 1L;
        this.nodeData = new byte[0];
        this.roomStateInfo = new GProVoiceSmobaGameRoomStateInfo();
        this.screenShareInfo = new GProVoiceInfo();
        this.worldPresence = new GProWorldChannelPresence();
        this.playInfo = new GProPlayInfo();
        this.lobbyRoomInfo = new GProLobbyRoomInfo();
    }

    public long getDataVersion() {
        return this.dataVersion;
    }

    public long getExpiresMs() {
        return this.expiresMs;
    }

    public GProLobbyRoomInfo getLobbyRoomInfo() {
        return this.lobbyRoomInfo;
    }

    public int getMutexType() {
        return this.mutexType;
    }

    public byte[] getNodeData() {
        return this.nodeData;
    }

    public int getNodeType() {
        return this.nodeType;
    }

    public GProPlayInfo getPlayInfo() {
        return this.playInfo;
    }

    public GProVoiceSmobaGameRoomStateInfo getRoomStateInfo() {
        return this.roomStateInfo;
    }

    public GProVoiceInfo getScreenShareInfo() {
        return this.screenShareInfo;
    }

    public GProWorldChannelPresence getWorldPresence() {
        return this.worldPresence;
    }

    public String toString() {
        return "GProBusinessNode{mutexType=" + this.mutexType + ",nodeType=" + this.nodeType + ",nodeData=" + this.nodeData + ",dataVersion=" + this.dataVersion + ",expiresMs=" + this.expiresMs + ",roomStateInfo=" + this.roomStateInfo + ",screenShareInfo=" + this.screenShareInfo + ",worldPresence=" + this.worldPresence + ",playInfo=" + this.playInfo + ",lobbyRoomInfo=" + this.lobbyRoomInfo + ",}";
    }

    public GProBusinessNode(int i2, int i3, byte[] bArr, long j2, long j3, GProVoiceSmobaGameRoomStateInfo gProVoiceSmobaGameRoomStateInfo, GProVoiceInfo gProVoiceInfo, GProWorldChannelPresence gProWorldChannelPresence, GProPlayInfo gProPlayInfo, GProLobbyRoomInfo gProLobbyRoomInfo) {
        this.serialVersionUID = 1L;
        this.nodeData = new byte[0];
        this.roomStateInfo = new GProVoiceSmobaGameRoomStateInfo();
        this.screenShareInfo = new GProVoiceInfo();
        this.worldPresence = new GProWorldChannelPresence();
        this.playInfo = new GProPlayInfo();
        this.lobbyRoomInfo = new GProLobbyRoomInfo();
        this.mutexType = i2;
        this.nodeType = i3;
        this.nodeData = bArr;
        this.dataVersion = j2;
        this.expiresMs = j3;
        this.roomStateInfo = gProVoiceSmobaGameRoomStateInfo;
        this.screenShareInfo = gProVoiceInfo;
        this.worldPresence = gProWorldChannelPresence;
        this.playInfo = gProPlayInfo;
        this.lobbyRoomInfo = gProLobbyRoomInfo;
    }
}
