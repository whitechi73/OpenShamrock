package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProLobbyRoomInfo;

public  class GGProLobbyRoomInfo implements IGProLobbyRoomInfo {
    public final GProLobbyRoomInfo mInfo;

    public GGProLobbyRoomInfo(GProLobbyRoomInfo gProLobbyRoomInfo) {
        this.mInfo = gProLobbyRoomInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyRoomInfo
    public IGProLobbyAppInfo getLobbyAppInfo() {
        return new GGProLobbyAppInfo(this.mInfo.getLobbyAppInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyRoomInfo
    public IGProLobbyStateInfo getLobbyStateInfo() {
        return new GGProLobbyStateInfo(this.mInfo.getLobbyStateInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyRoomInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
