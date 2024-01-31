package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProLobbyAppAuthStatusRsp;

public  class GGProLobbyAppAuthStatusRsp implements IGProLobbyAppAuthStatusRsp {
    public final GProLobbyAppAuthStatusRsp mInfo;

    public GGProLobbyAppAuthStatusRsp(GProLobbyAppAuthStatusRsp gProLobbyAppAuthStatusRsp) {
        this.mInfo = gProLobbyAppAuthStatusRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppAuthStatusRsp
    public String getAuthCode() {
        return this.mInfo.getAuthCode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppAuthStatusRsp
    public int getAuthStatus() {
        return this.mInfo.getAuthStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppAuthStatusRsp
    public String getOpenId() {
        return this.mInfo.getOpenId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppAuthStatusRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
