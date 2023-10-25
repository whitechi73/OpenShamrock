package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProCreateLobbyRsp {
    GProLobbyRoomInfo lobbyRoomInfo;

    public GProCreateLobbyRsp() {
        this.lobbyRoomInfo = new GProLobbyRoomInfo();
    }

    public GProLobbyRoomInfo getLobbyRoomInfo() {
        return this.lobbyRoomInfo;
    }

    public String toString() {
        return "GProCreateLobbyRsp{lobbyRoomInfo=" + this.lobbyRoomInfo + ",}";
    }

    public GProCreateLobbyRsp(GProLobbyRoomInfo gProLobbyRoomInfo) {
        this.lobbyRoomInfo = new GProLobbyRoomInfo();
        this.lobbyRoomInfo = gProLobbyRoomInfo;
    }
}
