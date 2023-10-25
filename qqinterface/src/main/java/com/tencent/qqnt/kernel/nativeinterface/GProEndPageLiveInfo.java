package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProEndPageLiveInfo {
    GProLiveMetrics liveMetrics;
    GProEndPageLiveTime liveTime;
    int roomId;

    public GProEndPageLiveInfo() {
        this.liveMetrics = new GProLiveMetrics();
        this.liveTime = new GProEndPageLiveTime();
    }

    public GProLiveMetrics getLiveMetrics() {
        return this.liveMetrics;
    }

    public GProEndPageLiveTime getLiveTime() {
        return this.liveTime;
    }

    public int getRoomId() {
        return this.roomId;
    }

    public String toString() {
        return "GProEndPageLiveInfo{roomId=" + this.roomId + ",liveMetrics=" + this.liveMetrics + ",liveTime=" + this.liveTime + ",}";
    }

    public GProEndPageLiveInfo(int i2, GProLiveMetrics gProLiveMetrics, GProEndPageLiveTime gProEndPageLiveTime) {
        this.liveMetrics = new GProLiveMetrics();
        this.liveTime = new GProEndPageLiveTime();
        this.roomId = i2;
        this.liveMetrics = gProLiveMetrics;
        this.liveTime = gProEndPageLiveTime;
    }
}
