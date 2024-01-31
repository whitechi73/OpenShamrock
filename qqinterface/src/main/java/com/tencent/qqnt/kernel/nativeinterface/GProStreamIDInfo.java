package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProStreamIDInfo {
    String auxStreamId;
    Boolean isSelfInfo;
    String mainStreamId;
    Long originRoomid;
    Long originUid;
    Long roomId;
    Long uid;

    public GProStreamIDInfo() {
    }

    public String getAuxStreamId() {
        return this.auxStreamId;
    }

    public Boolean getIsSelfInfo() {
        return this.isSelfInfo;
    }

    public String getMainStreamId() {
        return this.mainStreamId;
    }

    public Long getOriginRoomid() {
        return this.originRoomid;
    }

    public Long getOriginUid() {
        return this.originUid;
    }

    public Long getRoomId() {
        return this.roomId;
    }

    public Long getUid() {
        return this.uid;
    }

    public String toString() {
        return "GProStreamIDInfo{uid=" + this.uid + ",roomId=" + this.roomId + ",mainStreamId=" + this.mainStreamId + ",auxStreamId=" + this.auxStreamId + ",isSelfInfo=" + this.isSelfInfo + ",originUid=" + this.originUid + ",originRoomid=" + this.originRoomid + ",}";
    }

    public GProStreamIDInfo(Long l2, Long l3, String str, String str2, Boolean bool, Long l4, Long l5) {
        this.uid = l2;
        this.roomId = l3;
        this.mainStreamId = str;
        this.auxStreamId = str2;
        this.isSelfInfo = bool;
        this.originUid = l4;
        this.originRoomid = l5;
    }
}
