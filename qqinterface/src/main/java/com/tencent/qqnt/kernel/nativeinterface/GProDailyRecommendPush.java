package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProDailyRecommendPush {
    String avatar;
    String jumpLink;
    String subTitle;
    String title;

    public GProDailyRecommendPush() {
        this.title = "";
        this.subTitle = "";
        this.jumpLink = "";
        this.avatar = "";
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getJumpLink() {
        return this.jumpLink;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProDailyRecommendPush{title=" + this.title + ",subTitle=" + this.subTitle + ",jumpLink=" + this.jumpLink + ",avatar=" + this.avatar + ",}";
    }

    public GProDailyRecommendPush(String str, String str2, String str3, String str4) {
        this.title = "";
        this.subTitle = "";
        this.jumpLink = "";
        this.avatar = "";
        this.title = str;
        this.subTitle = str2;
        this.jumpLink = str3;
        this.avatar = str4;
    }
}
