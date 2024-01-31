package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProAVRoomAddUpInfo {
    GProAVDevOptInfo avDevOpt;
    int micVolume;
    String roomId;

    public GProAVRoomAddUpInfo() {
        this.roomId = "";
        this.avDevOpt = new GProAVDevOptInfo();
    }

    public GProAVDevOptInfo getAvDevOpt() {
        return this.avDevOpt;
    }

    public int getMicVolume() {
        return this.micVolume;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public String toString() {
        return "GProAVRoomAddUpInfo{roomId=" + this.roomId + ",avDevOpt=" + this.avDevOpt + ",micVolume=" + this.micVolume + ",}";
    }

    public GProAVRoomAddUpInfo(String str, GProAVDevOptInfo gProAVDevOptInfo, int i2) {
        this.roomId = "";
        this.avDevOpt = new GProAVDevOptInfo();
        this.roomId = str;
        this.avDevOpt = gProAVDevOptInfo;
        this.micVolume = i2;
    }
}
