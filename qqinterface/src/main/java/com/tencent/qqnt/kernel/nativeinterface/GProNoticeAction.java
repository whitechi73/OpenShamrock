package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProNoticeAction {
    String actionId;
    int style;
    String title;

    public GProNoticeAction() {
        this.title = "";
        this.actionId = "";
    }

    public String getActionId() {
        return this.actionId;
    }

    public int getStyle() {
        return this.style;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProNoticeAction{style=" + this.style + ",title=" + this.title + ",actionId=" + this.actionId + ",}";
    }

    public GProNoticeAction(int i2, String str, String str2) {
        this.title = "";
        this.actionId = "";
        this.style = i2;
        this.title = str;
        this.actionId = str2;
    }
}
