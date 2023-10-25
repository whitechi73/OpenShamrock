package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProSaveMsgReq implements Serializable {
    long adId;
    String content;
    long guildId;
    String headImage;
    String jumpText;
    String jumpUrl;
    long serialVersionUID;
    String title;

    public GProSaveMsgReq() {
        this.serialVersionUID = 1L;
        this.headImage = "";
        this.title = "";
        this.content = "";
        this.jumpText = "";
        this.jumpUrl = "";
    }

    public long getAdId() {
        return this.adId;
    }

    public String getContent() {
        return this.content;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getHeadImage() {
        return this.headImage;
    }

    public String getJumpText() {
        return this.jumpText;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProSaveMsgReq{adId=" + this.adId + ",headImage=" + this.headImage + ",title=" + this.title + ",content=" + this.content + ",jumpText=" + this.jumpText + ",jumpUrl=" + this.jumpUrl + ",guildId=" + this.guildId + ",}";
    }

    public GProSaveMsgReq(long j2, String str, String str2, String str3, String str4, String str5, long j3) {
        this.serialVersionUID = 1L;
        this.headImage = "";
        this.title = "";
        this.content = "";
        this.jumpText = "";
        this.jumpUrl = "";
        this.adId = j2;
        this.headImage = str;
        this.title = str2;
        this.content = str3;
        this.jumpText = str4;
        this.jumpUrl = str5;
        this.guildId = j3;
    }
}
