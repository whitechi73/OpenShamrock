package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProAVReportReqInfo {
    GProAVCommonReqInfo commonInfo;
    long tinyId;
    GProUserDevState userDevState;

    public GProAVReportReqInfo() {
        this.commonInfo = new GProAVCommonReqInfo();
        this.userDevState = new GProUserDevState();
    }

    public GProAVCommonReqInfo getCommonInfo() {
        return this.commonInfo;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public GProUserDevState getUserDevState() {
        return this.userDevState;
    }

    public String toString() {
        return "GProAVReportReqInfo{commonInfo=" + this.commonInfo + ",tinyId=" + this.tinyId + ",userDevState=" + this.userDevState + ",}";
    }

    public GProAVReportReqInfo(GProAVCommonReqInfo gProAVCommonReqInfo, long j2, GProUserDevState gProUserDevState) {
        this.commonInfo = new GProAVCommonReqInfo();
        this.userDevState = new GProUserDevState();
        this.commonInfo = gProAVCommonReqInfo;
        this.tinyId = j2;
        this.userDevState = gProUserDevState;
    }
}
