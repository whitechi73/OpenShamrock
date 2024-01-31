package com.tencent.qqnt.kernel.nativeinterface;



public final class TempChatGameSession {
    long gameAppId;
    String nickname;
    String peerOpenId;
    String peerRoleId;
    long peerTinyId;
    Integer pushWindowFlag;
    Integer redPointSwitch;
    Integer sayHiType;
    String selfOpenId;
    String selfRoleId;
    long selfTinyId;

    public TempChatGameSession() {
        this.nickname = "";
        this.selfRoleId = "";
        this.selfOpenId = "";
        this.peerRoleId = "";
        this.peerOpenId = "";
    }

    public long getGameAppId() {
        return this.gameAppId;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getPeerOpenId() {
        return this.peerOpenId;
    }

    public String getPeerRoleId() {
        return this.peerRoleId;
    }

    public long getPeerTinyId() {
        return this.peerTinyId;
    }

    public Integer getPushWindowFlag() {
        return this.pushWindowFlag;
    }

    public Integer getRedPointSwitch() {
        return this.redPointSwitch;
    }

    public Integer getSayHiType() {
        return this.sayHiType;
    }

    public String getSelfOpenId() {
        return this.selfOpenId;
    }

    public String getSelfRoleId() {
        return this.selfRoleId;
    }

    public long getSelfTinyId() {
        return this.selfTinyId;
    }

    public String toString() {
        return "TempChatGameSession{gameAppId=" + this.gameAppId + ",nickname=" + this.nickname + ",selfTinyId=" + this.selfTinyId + ",selfRoleId=" + this.selfRoleId + ",selfOpenId=" + this.selfOpenId + ",peerTinyId=" + this.peerTinyId + ",peerRoleId=" + this.peerRoleId + ",peerOpenId=" + this.peerOpenId + ",pushWindowFlag=" + this.pushWindowFlag + ",sayHiType=" + this.sayHiType + ",redPointSwitch=" + this.redPointSwitch + ",}";
    }

    public TempChatGameSession(long j2, String str, long j3, String str2, String str3, long j4, String str4, String str5, Integer num, Integer num2, Integer num3) {
        this.nickname = "";
        this.selfRoleId = "";
        this.selfOpenId = "";
        this.peerRoleId = "";
        this.peerOpenId = "";
        this.gameAppId = j2;
        this.nickname = str;
        this.selfTinyId = j3;
        this.selfRoleId = str2;
        this.selfOpenId = str3;
        this.peerTinyId = j4;
        this.peerRoleId = str4;
        this.peerOpenId = str5;
        this.pushWindowFlag = num;
        this.sayHiType = num2;
        this.redPointSwitch = num3;
    }
}
