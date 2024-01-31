package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProLobbyAppAuthStatusRsp {
    String authCode;
    int authStatus;
    String openId;

    public GProLobbyAppAuthStatusRsp() {
        this.openId = "";
        this.authCode = "";
    }

    public String getAuthCode() {
        return this.authCode;
    }

    public int getAuthStatus() {
        return this.authStatus;
    }

    public String getOpenId() {
        return this.openId;
    }

    public String toString() {
        return "GProLobbyAppAuthStatusRsp{authStatus=" + this.authStatus + ",openId=" + this.openId + ",authCode=" + this.authCode + ",}";
    }

    public GProLobbyAppAuthStatusRsp(int i2, String str, String str2) {
        this.openId = "";
        this.authCode = "";
        this.authStatus = i2;
        this.openId = str;
        this.authCode = str2;
    }
}
