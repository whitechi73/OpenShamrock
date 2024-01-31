package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProSwitchLobbyReq {
    GProCreateLobbyReq createLobbyReq;
    long originLobbyId;

    public GProSwitchLobbyReq() {
        this.createLobbyReq = new GProCreateLobbyReq();
    }

    public GProCreateLobbyReq getCreateLobbyReq() {
        return this.createLobbyReq;
    }

    public long getOriginLobbyId() {
        return this.originLobbyId;
    }

    public String toString() {
        return "GProSwitchLobbyReq{originLobbyId=" + this.originLobbyId + ",createLobbyReq=" + this.createLobbyReq + ",}";
    }

    public GProSwitchLobbyReq(long j2, GProCreateLobbyReq gProCreateLobbyReq) {
        this.createLobbyReq = new GProCreateLobbyReq();
        this.originLobbyId = j2;
        this.createLobbyReq = gProCreateLobbyReq;
    }
}
