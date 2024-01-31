package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProAdminAVReqInfo {
    GProAVDevOptInfo avDevOptInfo;
    GProAVCommonReqInfo commonInfo;
    long tinyId;

    public GProAdminAVReqInfo() {
        this.commonInfo = new GProAVCommonReqInfo();
        this.avDevOptInfo = new GProAVDevOptInfo();
    }

    public GProAVDevOptInfo getAvDevOptInfo() {
        return this.avDevOptInfo;
    }

    public GProAVCommonReqInfo getCommonInfo() {
        return this.commonInfo;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProAdminAVReqInfo{commonInfo=" + this.commonInfo + ",tinyId=" + this.tinyId + ",avDevOptInfo=" + this.avDevOptInfo + ",}";
    }

    public GProAdminAVReqInfo(GProAVCommonReqInfo gProAVCommonReqInfo, long j2, GProAVDevOptInfo gProAVDevOptInfo) {
        this.commonInfo = new GProAVCommonReqInfo();
        this.avDevOptInfo = new GProAVDevOptInfo();
        this.commonInfo = gProAVCommonReqInfo;
        this.tinyId = j2;
        this.avDevOptInfo = gProAVDevOptInfo;
    }
}
