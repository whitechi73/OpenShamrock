package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProSpeakPermissionInfo {
    Boolean sendLink;
    Boolean sendQrCode;
    Boolean sendRedPacket;

    public GProSpeakPermissionInfo() {
    }

    public Boolean getSendLink() {
        return this.sendLink;
    }

    public Boolean getSendQrCode() {
        return this.sendQrCode;
    }

    public Boolean getSendRedPacket() {
        return this.sendRedPacket;
    }

    public String toString() {
        return "GProSpeakPermissionInfo{sendRedPacket=" + this.sendRedPacket + ",sendLink=" + this.sendLink + ",sendQrCode=" + this.sendQrCode + ",}";
    }

    public GProSpeakPermissionInfo(Boolean bool, Boolean bool2, Boolean bool3) {
        this.sendRedPacket = bool;
        this.sendLink = bool2;
        this.sendQrCode = bool3;
    }
}
