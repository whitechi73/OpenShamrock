package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProCreateLobbyRsp;

public  class GGProCreateLobbyRsp implements IGProCreateLobbyRsp {
    public final GProCreateLobbyRsp mInfo;

    public GGProCreateLobbyRsp(GProCreateLobbyRsp gProCreateLobbyRsp) {
        this.mInfo = gProCreateLobbyRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCreateLobbyRsp
    public IGProLobbyRoomInfo getLobbyRoomInfo() {
        return new GGProLobbyRoomInfo(this.mInfo.getLobbyRoomInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCreateLobbyRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
