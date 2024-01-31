package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProAVRoomCtrlOptInfo implements Serializable {
    GProAVDevOptInfo devOpt;
    boolean isCurrentRoom;
    int micVolume;
    int numRoomId;
    String privateMapKey;
    String roomId;
    int sdkAppId;
    long serialVersionUID;

    public GProAVRoomCtrlOptInfo() {
        this.serialVersionUID = 1L;
        this.roomId = "";
        this.devOpt = new GProAVDevOptInfo();
        this.privateMapKey = "";
    }

    public GProAVDevOptInfo getDevOpt() {
        return this.devOpt;
    }

    public boolean getIsCurrentRoom() {
        return this.isCurrentRoom;
    }

    public int getMicVolume() {
        return this.micVolume;
    }

    public int getNumRoomId() {
        return this.numRoomId;
    }

    public String getPrivateMapKey() {
        return this.privateMapKey;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public int getSdkAppId() {
        return this.sdkAppId;
    }

    public String toString() {
        return "GProAVRoomCtrlOptInfo{roomId=" + this.roomId + ",numRoomId=" + this.numRoomId + ",devOpt=" + this.devOpt + ",micVolume=" + this.micVolume + ",isCurrentRoom=" + this.isCurrentRoom + ",sdkAppId=" + this.sdkAppId + ",privateMapKey=" + this.privateMapKey + ",}";
    }

    public GProAVRoomCtrlOptInfo(String str, int i2, GProAVDevOptInfo gProAVDevOptInfo, int i3, boolean z, int i4, String str2) {
        this.serialVersionUID = 1L;
        this.roomId = "";
        this.devOpt = new GProAVDevOptInfo();
        this.privateMapKey = "";
        this.roomId = str;
        this.numRoomId = i2;
        this.devOpt = gProAVDevOptInfo;
        this.micVolume = i3;
        this.isCurrentRoom = z;
        this.sdkAppId = i4;
        this.privateMapKey = str2;
    }
}
