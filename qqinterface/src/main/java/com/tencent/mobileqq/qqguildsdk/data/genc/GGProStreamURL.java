package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProStreamURL;

import java.io.Serializable;

public  class GGProStreamURL implements Serializable {
    public final GProStreamURL mInfo;

    public GGProStreamURL(GProStreamURL gProStreamURL) {
        this.mInfo = gProStreamURL;
    }

    public String getPlayUrl() {
        return this.mInfo.getPlayUrl();
    }

    public String getStreamName() {
        return this.mInfo.getStreamName();
    }

    public String toString() {
        return this.mInfo.toString();
    }
}
