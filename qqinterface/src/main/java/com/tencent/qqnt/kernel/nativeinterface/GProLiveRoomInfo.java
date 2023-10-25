package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProLiveRoomInfo implements Serializable {
    GProAnchorInfo anchorInfo;
    String closeTips;
    int closeType;
    int liveType;
    int platform;
    GProProgramInfo programInfo;
    long queryId;
    GProRoomInfo roomInfo;
    long serialVersionUID;
    GProLiveStreamInfo streamInfo;

    public GProLiveRoomInfo() {
        this.serialVersionUID = 1L;
        this.anchorInfo = new GProAnchorInfo();
        this.roomInfo = new GProRoomInfo();
        this.streamInfo = new GProLiveStreamInfo();
        this.programInfo = new GProProgramInfo();
        this.closeTips = "";
    }

    public GProAnchorInfo getAnchorInfo() {
        return this.anchorInfo;
    }

    public String getCloseTips() {
        return this.closeTips;
    }

    public int getCloseType() {
        return this.closeType;
    }

    public int getLiveType() {
        return this.liveType;
    }

    public int getPlatform() {
        return this.platform;
    }

    public GProProgramInfo getProgramInfo() {
        return this.programInfo;
    }

    public long getQueryId() {
        return this.queryId;
    }

    public GProRoomInfo getRoomInfo() {
        return this.roomInfo;
    }

    public GProLiveStreamInfo getStreamInfo() {
        return this.streamInfo;
    }

    public String toString() {
        return "GProLiveRoomInfo{queryId=" + this.queryId + ",anchorInfo=" + this.anchorInfo + ",roomInfo=" + this.roomInfo + ",streamInfo=" + this.streamInfo + ",liveType=" + this.liveType + ",platform=" + this.platform + ",programInfo=" + this.programInfo + ",closeType=" + this.closeType + ",closeTips=" + this.closeTips + ",}";
    }

    public GProLiveRoomInfo(long j2, GProAnchorInfo gProAnchorInfo, GProRoomInfo gProRoomInfo, GProLiveStreamInfo gProLiveStreamInfo, int i2, int i3, GProProgramInfo gProProgramInfo, int i4, String str) {
        this.serialVersionUID = 1L;
        this.anchorInfo = new GProAnchorInfo();
        this.roomInfo = new GProRoomInfo();
        this.streamInfo = new GProLiveStreamInfo();
        this.programInfo = new GProProgramInfo();
        this.closeTips = "";
        this.queryId = j2;
        this.anchorInfo = gProAnchorInfo;
        this.roomInfo = gProRoomInfo;
        this.streamInfo = gProLiveStreamInfo;
        this.liveType = i2;
        this.platform = i3;
        this.programInfo = gProProgramInfo;
        this.closeType = i4;
        this.closeTips = str;
    }
}
