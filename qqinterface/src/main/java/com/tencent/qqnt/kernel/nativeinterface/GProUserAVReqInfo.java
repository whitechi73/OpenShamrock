package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProUserAVReqInfo {
    GProAVCommonReqInfo commonInfo;
    GProAVDevOptInfo devOpt;
    long tinyId;

    public GProUserAVReqInfo() {
        this.commonInfo = new GProAVCommonReqInfo();
        this.devOpt = new GProAVDevOptInfo();
    }

    public GProAVCommonReqInfo getCommonInfo() {
        return this.commonInfo;
    }

    public GProAVDevOptInfo getDevOpt() {
        return this.devOpt;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProUserAVReqInfo{commonInfo=" + this.commonInfo + ",tinyId=" + this.tinyId + ",devOpt=" + this.devOpt + ",}";
    }

    public GProUserAVReqInfo(GProAVCommonReqInfo gProAVCommonReqInfo, long j2, GProAVDevOptInfo gProAVDevOptInfo) {
        this.commonInfo = new GProAVCommonReqInfo();
        this.devOpt = new GProAVDevOptInfo();
        this.commonInfo = gProAVCommonReqInfo;
        this.tinyId = j2;
        this.devOpt = gProAVDevOptInfo;
    }
}
