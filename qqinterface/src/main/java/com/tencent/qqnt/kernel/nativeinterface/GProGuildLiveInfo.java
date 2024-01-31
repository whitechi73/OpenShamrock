package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProGuildLiveInfo {
    GProAnchorInfo anchorInfo;
    String errMsg;
    int liveType;
    int platform;
    long queryId;
    int queryIdType;
    int resultCode;
    GProRoomInfo roomInfo;
    GProLiveStreamInfo streamInfo;

    public GProGuildLiveInfo() {
        this.errMsg = "";
        this.anchorInfo = new GProAnchorInfo();
        this.roomInfo = new GProRoomInfo();
        this.streamInfo = new GProLiveStreamInfo();
    }

    public GProAnchorInfo getAnchorInfo() {
        return this.anchorInfo;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public int getLiveType() {
        return this.liveType;
    }

    public int getPlatform() {
        return this.platform;
    }

    public long getQueryId() {
        return this.queryId;
    }

    public int getQueryIdType() {
        return this.queryIdType;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public GProRoomInfo getRoomInfo() {
        return this.roomInfo;
    }

    public GProLiveStreamInfo getStreamInfo() {
        return this.streamInfo;
    }

    public String toString() {
        return "GProGuildLiveInfo{resultCode=" + this.resultCode + ",errMsg=" + this.errMsg + ",queryId=" + this.queryId + ",queryIdType=" + this.queryIdType + ",anchorInfo=" + this.anchorInfo + ",roomInfo=" + this.roomInfo + ",streamInfo=" + this.streamInfo + ",liveType=" + this.liveType + ",platform=" + this.platform + ",}";
    }

    public GProGuildLiveInfo(int i2, String str, long j2, int i3, GProAnchorInfo gProAnchorInfo, GProRoomInfo gProRoomInfo, GProLiveStreamInfo gProLiveStreamInfo, int i4, int i5) {
        this.errMsg = "";
        this.anchorInfo = new GProAnchorInfo();
        this.roomInfo = new GProRoomInfo();
        this.streamInfo = new GProLiveStreamInfo();
        this.resultCode = i2;
        this.errMsg = str;
        this.queryId = j2;
        this.queryIdType = i3;
        this.anchorInfo = gProAnchorInfo;
        this.roomInfo = gProRoomInfo;
        this.streamInfo = gProLiveStreamInfo;
        this.liveType = i4;
        this.platform = i5;
    }
}
