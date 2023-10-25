package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProAnchorEnterRoomReq {
    String extData;
    String machine;
    Long openLiveType;
    String programId;
    Long roomId;
    String source;

    public GProAnchorEnterRoomReq() {
    }

    public String getExtData() {
        return this.extData;
    }

    public String getMachine() {
        return this.machine;
    }

    public Long getOpenLiveType() {
        return this.openLiveType;
    }

    public String getProgramId() {
        return this.programId;
    }

    public Long getRoomId() {
        return this.roomId;
    }

    public String getSource() {
        return this.source;
    }

    public String toString() {
        return "GProAnchorEnterRoomReq{roomId=" + this.roomId + ",source=" + this.source + ",programId=" + this.programId + ",machine=" + this.machine + ",openLiveType=" + this.openLiveType + ",extData=" + this.extData + ",}";
    }

    public GProAnchorEnterRoomReq(Long l2, String str, String str2, String str3, Long l3, String str4) {
        this.roomId = l2;
        this.source = str;
        this.programId = str2;
        this.machine = str3;
        this.openLiveType = l3;
        this.extData = str4;
    }
}
