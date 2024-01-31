package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProRecallInfo {
    float qualityScore;
    String query;
    String recallName;
    float relevanceScore;
    float score;
    String traceId;

    public GProRecallInfo() {
        this.query = "";
        this.recallName = "";
        this.traceId = "";
    }

    public float getQualityScore() {
        return this.qualityScore;
    }

    public String getQuery() {
        return this.query;
    }

    public String getRecallName() {
        return this.recallName;
    }

    public float getRelevanceScore() {
        return this.relevanceScore;
    }

    public float getScore() {
        return this.score;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String toString() {
        return "GProRecallInfo{query=" + this.query + ",recallName=" + this.recallName + ",relevanceScore=" + this.relevanceScore + ",qualityScore=" + this.qualityScore + ",score=" + this.score + ",traceId=" + this.traceId + ",}";
    }

    public GProRecallInfo(String str, String str2, float f2, float f3, float f4, String str3) {
        this.query = "";
        this.recallName = "";
        this.traceId = "";
        this.query = str;
        this.recallName = str2;
        this.relevanceScore = f2;
        this.qualityScore = f3;
        this.score = f4;
        this.traceId = str3;
    }
}
