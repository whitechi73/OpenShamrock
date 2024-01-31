package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecallInfo;

import java.io.Serializable;

public  class GGProRecallInfo implements Serializable {
    public final GProRecallInfo mInfo;

    public GGProRecallInfo(GProRecallInfo gProRecallInfo) {
        this.mInfo = gProRecallInfo;
    }

    public float getQualityScore() {
        return this.mInfo.getQualityScore();
    }

    public String getQuery() {
        return this.mInfo.getQuery();
    }

    public String getRecallName() {
        return this.mInfo.getRecallName();
    }

    public float getRelevanceScore() {
        return this.mInfo.getRelevanceScore();
    }

    public float getScore() {
        return this.mInfo.getScore();
    }

    public String getTraceId() {
        return this.mInfo.getTraceId();
    }

    public String toString() {
        return this.mInfo.toString();
    }
}
