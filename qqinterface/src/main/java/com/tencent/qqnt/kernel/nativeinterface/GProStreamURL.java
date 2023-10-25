package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProStreamURL implements Serializable {
    String playUrl;
    long serialVersionUID;
    String streamName;

    public GProStreamURL() {
        this.serialVersionUID = 1L;
        this.streamName = "";
        this.playUrl = "";
    }

    public String getPlayUrl() {
        return this.playUrl;
    }

    public String getStreamName() {
        return this.streamName;
    }

    public String toString() {
        return "GProStreamURL{streamName=" + this.streamName + ",playUrl=" + this.playUrl + ",}";
    }

    public GProStreamURL(String str, String str2) {
        this.serialVersionUID = 1L;
        this.streamName = "";
        this.playUrl = "";
        this.streamName = str;
        this.playUrl = str2;
    }
}
