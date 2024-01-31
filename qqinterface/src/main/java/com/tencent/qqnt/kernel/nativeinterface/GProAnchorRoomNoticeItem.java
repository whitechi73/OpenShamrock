package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProAnchorRoomNoticeItem {
    Long anchorUid;
    String ext;
    String programId;
    ArrayList<GProAnchorRoomTag> romTags;
    String roomLogo11;
    Long roomLogo11Time;
    String roomLogo169;
    Long roomLogo169Time;
    String roomLogo34;
    Long roomLogo34Time;
    Long roomPlayEndTime;
    Long roomPlayStartTime3;
    String roomPrompt;
    String roomTitle;

    public GProAnchorRoomNoticeItem() {
        this.romTags = new ArrayList<>();
    }

    public Long getAnchorUid() {
        return this.anchorUid;
    }

    public String getExt() {
        return this.ext;
    }

    public String getProgramId() {
        return this.programId;
    }

    public ArrayList<GProAnchorRoomTag> getRomTags() {
        return this.romTags;
    }

    public String getRoomLogo11() {
        return this.roomLogo11;
    }

    public Long getRoomLogo11Time() {
        return this.roomLogo11Time;
    }

    public String getRoomLogo169() {
        return this.roomLogo169;
    }

    public Long getRoomLogo169Time() {
        return this.roomLogo169Time;
    }

    public String getRoomLogo34() {
        return this.roomLogo34;
    }

    public Long getRoomLogo34Time() {
        return this.roomLogo34Time;
    }

    public Long getRoomPlayEndTime() {
        return this.roomPlayEndTime;
    }

    public Long getRoomPlayStartTime3() {
        return this.roomPlayStartTime3;
    }

    public String getRoomPrompt() {
        return this.roomPrompt;
    }

    public String getRoomTitle() {
        return this.roomTitle;
    }

    public String toString() {
        return "GProAnchorRoomNoticeItem{programId=" + this.programId + ",anchorUid=" + this.anchorUid + ",roomPlayStartTime3=" + this.roomPlayStartTime3 + ",roomPlayEndTime=" + this.roomPlayEndTime + ",roomTitle=" + this.roomTitle + ",roomLogo11=" + this.roomLogo11 + ",roomLogo169=" + this.roomLogo169 + ",roomLogo34=" + this.roomLogo34 + ",roomLogo11Time=" + this.roomLogo11Time + ",roomLogo169Time=" + this.roomLogo169Time + ",roomLogo34Time=" + this.roomLogo34Time + ",romTags=" + this.romTags + ",roomPrompt=" + this.roomPrompt + ",ext=" + this.ext + ",}";
    }

    public GProAnchorRoomNoticeItem(String str, Long l2, Long l3, Long l4, String str2, String str3, String str4, String str5, Long l5, Long l6, Long l7, ArrayList<GProAnchorRoomTag> arrayList, String str6, String str7) {
        this.romTags = new ArrayList<>();
        this.programId = str;
        this.anchorUid = l2;
        this.roomPlayStartTime3 = l3;
        this.roomPlayEndTime = l4;
        this.roomTitle = str2;
        this.roomLogo11 = str3;
        this.roomLogo169 = str4;
        this.roomLogo34 = str5;
        this.roomLogo11Time = l5;
        this.roomLogo169Time = l6;
        this.roomLogo34Time = l7;
        this.romTags = arrayList;
        this.roomPrompt = str6;
        this.ext = str7;
    }
}
