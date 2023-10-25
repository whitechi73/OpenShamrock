package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProStreamInfo implements Serializable {
    long serialVersionUID;
    int streamType;
    ArrayList<GProStreamURL> streamUrlList;

    public GProStreamInfo() {
        this.serialVersionUID = 1L;
        this.streamUrlList = new ArrayList<>();
    }

    public int getStreamType() {
        return this.streamType;
    }

    public ArrayList<GProStreamURL> getStreamUrlList() {
        return this.streamUrlList;
    }

    public String toString() {
        return "GProStreamInfo{streamType=" + this.streamType + ",streamUrlList=" + this.streamUrlList + ",}";
    }

    public GProStreamInfo(int i2, ArrayList<GProStreamURL> arrayList) {
        this.serialVersionUID = 1L;
        this.streamUrlList = new ArrayList<>();
        this.streamType = i2;
        this.streamUrlList = arrayList;
    }
}
