package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProChannelPresenceItemInfo {
    int jumpType;
    String jumpUrl;
    String text;

    public GProChannelPresenceItemInfo() {
        this.text = "";
        this.jumpUrl = "";
    }

    public int getJumpType() {
        return this.jumpType;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return "GProChannelPresenceItemInfo{text=" + this.text + ",jumpUrl=" + this.jumpUrl + ",jumpType=" + this.jumpType + ",}";
    }

    public GProChannelPresenceItemInfo(String str, String str2, int i2) {
        this.text = "";
        this.jumpUrl = "";
        this.text = str;
        this.jumpUrl = str2;
        this.jumpType = i2;
    }
}
