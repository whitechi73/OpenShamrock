package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProEnterRoomReply {
    String dispersionUrl;
    Boolean isBigRoom;
    GProLiveEnterRoomInfo roomInfo;
    GProAvInfo sdkInfo;
    Integer useDispersion;
    Integer userRole;

    public GProEnterRoomReply() {
    }

    public String getDispersionUrl() {
        return this.dispersionUrl;
    }

    public Boolean getIsBigRoom() {
        return this.isBigRoom;
    }

    public GProLiveEnterRoomInfo getRoomInfo() {
        return this.roomInfo;
    }

    public GProAvInfo getSdkInfo() {
        return this.sdkInfo;
    }

    public Integer getUseDispersion() {
        return this.useDispersion;
    }

    public Integer getUserRole() {
        return this.userRole;
    }

    public String toString() {
        return "GProEnterRoomReply{isBigRoom=" + this.isBigRoom + ",useDispersion=" + this.useDispersion + ",dispersionUrl=" + this.dispersionUrl + ",roomInfo=" + this.roomInfo + ",userRole=" + this.userRole + ",sdkInfo=" + this.sdkInfo + ",}";
    }

    public GProEnterRoomReply(Boolean bool, Integer num, String str, GProLiveEnterRoomInfo gProLiveEnterRoomInfo, Integer num2, GProAvInfo gProAvInfo) {
        this.isBigRoom = bool;
        this.useDispersion = num;
        this.dispersionUrl = str;
        this.roomInfo = gProLiveEnterRoomInfo;
        this.userRole = num2;
        this.sdkInfo = gProAvInfo;
    }
}
