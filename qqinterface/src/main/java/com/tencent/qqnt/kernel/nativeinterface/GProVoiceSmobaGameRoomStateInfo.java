package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProVoiceSmobaGameRoomStateInfo implements Serializable {
    GProVoiceSmobaGameCaptainUserInfo captainInfo;
    long captainTinyId;
    long currentNum;
    GProVoiceSmobaGameGameStaticInfo gameInfo;
    long gameStartTime;
    long roomId;
    int roomState;
    int roomType;
    long serialVersionUID;

    public GProVoiceSmobaGameRoomStateInfo() {
        this.serialVersionUID = 1L;
        this.gameInfo = new GProVoiceSmobaGameGameStaticInfo();
        this.captainInfo = new GProVoiceSmobaGameCaptainUserInfo();
    }

    public GProVoiceSmobaGameCaptainUserInfo getCaptainInfo() {
        return this.captainInfo;
    }

    public long getCaptainTinyId() {
        return this.captainTinyId;
    }

    public long getCurrentNum() {
        return this.currentNum;
    }

    public GProVoiceSmobaGameGameStaticInfo getGameInfo() {
        return this.gameInfo;
    }

    public long getGameStartTime() {
        return this.gameStartTime;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public int getRoomState() {
        return this.roomState;
    }

    public int getRoomType() {
        return this.roomType;
    }

    public String toString() {
        return "GProVoiceSmobaGameRoomStateInfo{roomId=" + this.roomId + ",roomType=" + this.roomType + ",gameInfo=" + this.gameInfo + ",roomState=" + this.roomState + ",gameStartTime=" + this.gameStartTime + ",currentNum=" + this.currentNum + ",captainTinyId=" + this.captainTinyId + ",captainInfo=" + this.captainInfo + ",}";
    }

    public GProVoiceSmobaGameRoomStateInfo(long j2, int i2, GProVoiceSmobaGameGameStaticInfo gProVoiceSmobaGameGameStaticInfo, int i3, long j3, long j4, long j5, GProVoiceSmobaGameCaptainUserInfo gProVoiceSmobaGameCaptainUserInfo) {
        this.serialVersionUID = 1L;
        this.gameInfo = new GProVoiceSmobaGameGameStaticInfo();
        this.captainInfo = new GProVoiceSmobaGameCaptainUserInfo();
        this.roomId = j2;
        this.roomType = i2;
        this.gameInfo = gProVoiceSmobaGameGameStaticInfo;
        this.roomState = i3;
        this.gameStartTime = j3;
        this.currentNum = j4;
        this.captainTinyId = j5;
        this.captainInfo = gProVoiceSmobaGameCaptainUserInfo;
    }
}
