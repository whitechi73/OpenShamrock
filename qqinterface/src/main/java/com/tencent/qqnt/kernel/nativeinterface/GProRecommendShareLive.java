package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProRecommendShareLive {
    String anchorIcon;
    long anchorId;
    ArrayList<String> audienceIcons;
    long channelId;
    long roomId;
    String roomName;
    String streamUrl;

    public GProRecommendShareLive() {
        this.anchorIcon = "";
        this.audienceIcons = new ArrayList<>();
        this.roomName = "";
        this.streamUrl = "";
    }

    public String getAnchorIcon() {
        return this.anchorIcon;
    }

    public long getAnchorId() {
        return this.anchorId;
    }

    public ArrayList<String> getAudienceIcons() {
        return this.audienceIcons;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public String getStreamUrl() {
        return this.streamUrl;
    }

    public String toString() {
        return "GProRecommendShareLive{anchorIcon=" + this.anchorIcon + ",audienceIcons=" + this.audienceIcons + ",anchorId=" + this.anchorId + ",channelId=" + this.channelId + ",roomName=" + this.roomName + ",roomId=" + this.roomId + ",streamUrl=" + this.streamUrl + ",}";
    }

    public GProRecommendShareLive(String str, ArrayList<String> arrayList, long j2, long j3, String str2, long j4, String str3) {
        this.anchorIcon = "";
        this.audienceIcons = new ArrayList<>();
        this.roomName = "";
        this.streamUrl = "";
        this.anchorIcon = str;
        this.audienceIcons = arrayList;
        this.anchorId = j2;
        this.channelId = j3;
        this.roomName = str2;
        this.roomId = j4;
        this.streamUrl = str3;
    }
}
