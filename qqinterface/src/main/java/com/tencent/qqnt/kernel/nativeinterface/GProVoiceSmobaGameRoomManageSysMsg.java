package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProVoiceSmobaGameRoomManageSysMsg {
    int operType;
    GProVoiceSmobaGameBaseRoomInfo roomInfo;
    GProVoiceSmobaGameSmobaRoomInfo smobaInfo;
    GProVoiceSmobaGameRoomStateInfo stateInfo;

    public GProVoiceSmobaGameRoomManageSysMsg() {
        this.roomInfo = new GProVoiceSmobaGameBaseRoomInfo();
        this.smobaInfo = new GProVoiceSmobaGameSmobaRoomInfo();
        this.stateInfo = new GProVoiceSmobaGameRoomStateInfo();
    }

    public int getOperType() {
        return this.operType;
    }

    public GProVoiceSmobaGameBaseRoomInfo getRoomInfo() {
        return this.roomInfo;
    }

    public GProVoiceSmobaGameSmobaRoomInfo getSmobaInfo() {
        return this.smobaInfo;
    }

    public GProVoiceSmobaGameRoomStateInfo getStateInfo() {
        return this.stateInfo;
    }

    public String toString() {
        return "GProVoiceSmobaGameRoomManageSysMsg{roomInfo=" + this.roomInfo + ",smobaInfo=" + this.smobaInfo + ",stateInfo=" + this.stateInfo + ",operType=" + this.operType + ",}";
    }

    public GProVoiceSmobaGameRoomManageSysMsg(GProVoiceSmobaGameBaseRoomInfo gProVoiceSmobaGameBaseRoomInfo, GProVoiceSmobaGameSmobaRoomInfo gProVoiceSmobaGameSmobaRoomInfo, GProVoiceSmobaGameRoomStateInfo gProVoiceSmobaGameRoomStateInfo, int i2) {
        this.roomInfo = new GProVoiceSmobaGameBaseRoomInfo();
        this.smobaInfo = new GProVoiceSmobaGameSmobaRoomInfo();
        this.stateInfo = new GProVoiceSmobaGameRoomStateInfo();
        this.roomInfo = gProVoiceSmobaGameBaseRoomInfo;
        this.smobaInfo = gProVoiceSmobaGameSmobaRoomInfo;
        this.stateInfo = gProVoiceSmobaGameRoomStateInfo;
        this.operType = i2;
    }
}
