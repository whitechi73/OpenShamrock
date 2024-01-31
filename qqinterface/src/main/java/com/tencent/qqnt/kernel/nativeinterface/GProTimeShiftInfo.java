package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProTimeShiftInfo {
    Long curPlaybackDuration;
    Long liveBeginTimeStamp;
    Long maxPlaybackDuration;
    Long playbackDistance;
    String url;

    public GProTimeShiftInfo() {
    }

    public Long getCurPlaybackDuration() {
        return this.curPlaybackDuration;
    }

    public Long getLiveBeginTimeStamp() {
        return this.liveBeginTimeStamp;
    }

    public Long getMaxPlaybackDuration() {
        return this.maxPlaybackDuration;
    }

    public Long getPlaybackDistance() {
        return this.playbackDistance;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProTimeShiftInfo{url=" + this.url + ",playbackDistance=" + this.playbackDistance + ",maxPlaybackDuration=" + this.maxPlaybackDuration + ",curPlaybackDuration=" + this.curPlaybackDuration + ",liveBeginTimeStamp=" + this.liveBeginTimeStamp + ",}";
    }

    public GProTimeShiftInfo(String str, Long l2, Long l3, Long l4, Long l5) {
        this.url = str;
        this.playbackDistance = l2;
        this.maxPlaybackDuration = l3;
        this.curPlaybackDuration = l4;
        this.liveBeginTimeStamp = l5;
    }
}
