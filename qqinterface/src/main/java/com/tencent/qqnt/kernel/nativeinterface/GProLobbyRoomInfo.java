package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProLobbyRoomInfo implements Serializable {
    GProLobbyAppInfo lobbyAppInfo;
    GProLobbyStateInfo lobbyStateInfo;
    long serialVersionUID;

    public GProLobbyRoomInfo() {
        this.serialVersionUID = 1L;
        this.lobbyStateInfo = new GProLobbyStateInfo();
        this.lobbyAppInfo = new GProLobbyAppInfo();
    }

    public GProLobbyAppInfo getLobbyAppInfo() {
        return this.lobbyAppInfo;
    }

    public GProLobbyStateInfo getLobbyStateInfo() {
        return this.lobbyStateInfo;
    }

    public String toString() {
        return "GProLobbyRoomInfo{lobbyStateInfo=" + this.lobbyStateInfo + ",lobbyAppInfo=" + this.lobbyAppInfo + ",}";
    }

    public GProLobbyRoomInfo(GProLobbyStateInfo gProLobbyStateInfo, GProLobbyAppInfo gProLobbyAppInfo) {
        this.serialVersionUID = 1L;
        this.lobbyStateInfo = new GProLobbyStateInfo();
        this.lobbyAppInfo = new GProLobbyAppInfo();
        this.lobbyStateInfo = gProLobbyStateInfo;
        this.lobbyAppInfo = gProLobbyAppInfo;
    }
}
