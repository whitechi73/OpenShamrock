package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProAnchorSetRoomInfoReq {
    ArrayList<GProAnchorTlv> attrs;
    String machine;
    String programId;
    Long roomId;
    String source;
    GProLiveRoomRichTitle tags;

    public GProAnchorSetRoomInfoReq() {
        this.attrs = new ArrayList<>();
    }

    public ArrayList<GProAnchorTlv> getAttrs() {
        return this.attrs;
    }

    public String getMachine() {
        return this.machine;
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

    public GProLiveRoomRichTitle getTags() {
        return this.tags;
    }

    public String toString() {
        return "GProAnchorSetRoomInfoReq{roomId=" + this.roomId + ",attrs=" + this.attrs + ",programId=" + this.programId + ",tags=" + this.tags + ",source=" + this.source + ",machine=" + this.machine + ",}";
    }

    public GProAnchorSetRoomInfoReq(Long l2, ArrayList<GProAnchorTlv> arrayList, String str, GProLiveRoomRichTitle gProLiveRoomRichTitle, String str2, String str3) {
        this.attrs = new ArrayList<>();
        this.roomId = l2;
        this.attrs = arrayList;
        this.programId = str;
        this.tags = gProLiveRoomRichTitle;
        this.source = str2;
        this.machine = str3;
    }
}
