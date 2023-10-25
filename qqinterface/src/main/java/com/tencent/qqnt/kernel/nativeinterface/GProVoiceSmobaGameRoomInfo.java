package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProVoiceSmobaGameRoomInfo {
    GProVoiceSmobaGameBaseRoomInfo roomInfo;
    GProVoiceSmobaGameSmobaRoomInfo smobaInfo;

    public GProVoiceSmobaGameRoomInfo() {
        this.roomInfo = new GProVoiceSmobaGameBaseRoomInfo();
        this.smobaInfo = new GProVoiceSmobaGameSmobaRoomInfo();
    }

    public GProVoiceSmobaGameBaseRoomInfo getRoomInfo() {
        return this.roomInfo;
    }

    public GProVoiceSmobaGameSmobaRoomInfo getSmobaInfo() {
        return this.smobaInfo;
    }

    public String toString() {
        return "GProVoiceSmobaGameRoomInfo{roomInfo=" + this.roomInfo + ",smobaInfo=" + this.smobaInfo + ",}";
    }

    public GProVoiceSmobaGameRoomInfo(GProVoiceSmobaGameBaseRoomInfo gProVoiceSmobaGameBaseRoomInfo, GProVoiceSmobaGameSmobaRoomInfo gProVoiceSmobaGameSmobaRoomInfo) {
        this.roomInfo = new GProVoiceSmobaGameBaseRoomInfo();
        this.smobaInfo = new GProVoiceSmobaGameSmobaRoomInfo();
        this.roomInfo = gProVoiceSmobaGameBaseRoomInfo;
        this.smobaInfo = gProVoiceSmobaGameSmobaRoomInfo;
    }
}
