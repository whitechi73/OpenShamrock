package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProNavigationInfo implements Serializable {
    String bubbleDesc;
    String iconUrl;
    String jumpUrl;
    int jumpUrlType;
    long serialVersionUID;
    boolean showBubble;
    String title;

    public GProNavigationInfo() {
        this.serialVersionUID = 1L;
        this.iconUrl = "";
        this.title = "";
        this.jumpUrl = "";
        this.bubbleDesc = "";
    }

    public String getBubbleDesc() {
        return this.bubbleDesc;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public int getJumpUrlType() {
        return this.jumpUrlType;
    }

    public boolean getShowBubble() {
        return this.showBubble;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProNavigationInfo{iconUrl=" + this.iconUrl + ",title=" + this.title + ",jumpUrl=" + this.jumpUrl + ",jumpUrlType=" + this.jumpUrlType + ",showBubble=" + this.showBubble + ",bubbleDesc=" + this.bubbleDesc + ",}";
    }

    public GProNavigationInfo(String str, String str2, String str3, int i2, boolean z, String str4) {
        this.serialVersionUID = 1L;
        this.iconUrl = "";
        this.title = "";
        this.jumpUrl = "";
        this.bubbleDesc = "";
        this.iconUrl = str;
        this.title = str2;
        this.jumpUrl = str3;
        this.jumpUrlType = i2;
        this.showBubble = z;
        this.bubbleDesc = str4;
    }
}
