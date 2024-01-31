package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProGuildOnlineReportRsp {
    long nextReportInterval;

    public GProGuildOnlineReportRsp() {
    }

    public long getNextReportInterval() {
        return this.nextReportInterval;
    }

    public String toString() {
        return "GProGuildOnlineReportRsp{nextReportInterval=" + this.nextReportInterval + ",}";
    }

    public GProGuildOnlineReportRsp(long j2) {
        this.nextReportInterval = j2;
    }
}
