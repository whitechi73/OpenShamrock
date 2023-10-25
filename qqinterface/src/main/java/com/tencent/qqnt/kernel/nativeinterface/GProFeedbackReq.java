package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProFeedbackReq {
    GProItemCbData callback;
    String contentType;
    String feedId;
    String feedbackType;
    String scene;

    public GProFeedbackReq() {
        this.scene = "";
        this.feedbackType = "";
        this.feedId = "";
        this.contentType = "";
        this.callback = new GProItemCbData();
    }

    public GProItemCbData getCallback() {
        return this.callback;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public String getFeedbackType() {
        return this.feedbackType;
    }

    public String getScene() {
        return this.scene;
    }

    public String toString() {
        return "GProFeedbackReq{scene=" + this.scene + ",feedbackType=" + this.feedbackType + ",feedId=" + this.feedId + ",contentType=" + this.contentType + ",callback=" + this.callback + ",}";
    }

    public GProFeedbackReq(String str, String str2, String str3, String str4, GProItemCbData gProItemCbData) {
        this.scene = "";
        this.feedbackType = "";
        this.feedId = "";
        this.contentType = "";
        this.callback = new GProItemCbData();
        this.scene = str;
        this.feedbackType = str2;
        this.feedId = str3;
        this.contentType = str4;
        this.callback = gProItemCbData;
    }
}
