package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProBottomTabSourceInfo {
    String bid;
    int bussiSource;
    int sceneId;

    public GProBottomTabSourceInfo() {
        this.bid = "";
    }

    public String getBid() {
        return this.bid;
    }

    public int getBussiSource() {
        return this.bussiSource;
    }

    public int getSceneId() {
        return this.sceneId;
    }

    public String toString() {
        return "GProBottomTabSourceInfo{sceneId=" + this.sceneId + ",bid=" + this.bid + ",bussiSource=" + this.bussiSource + ",}";
    }

    public GProBottomTabSourceInfo(int i2, String str, int i3) {
        this.bid = "";
        this.sceneId = i2;
        this.bid = str;
        this.bussiSource = i3;
    }
}
