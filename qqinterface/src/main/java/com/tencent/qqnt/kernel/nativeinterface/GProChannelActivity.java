package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProChannelActivity {
    String activityId;
    String imageUrl;
    String jumpUrl;

    public GProChannelActivity() {
        this.activityId = "";
        this.imageUrl = "";
        this.jumpUrl = "";
    }

    public String getActivityId() {
        return this.activityId;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String toString() {
        return "GProChannelActivity{activityId=" + this.activityId + ",imageUrl=" + this.imageUrl + ",jumpUrl=" + this.jumpUrl + ",}";
    }

    public GProChannelActivity(String str, String str2, String str3) {
        this.activityId = "";
        this.imageUrl = "";
        this.jumpUrl = "";
        this.activityId = str;
        this.imageUrl = str2;
        this.jumpUrl = str3;
    }
}
