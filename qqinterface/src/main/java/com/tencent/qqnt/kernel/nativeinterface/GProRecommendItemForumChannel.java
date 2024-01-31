package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProRecommendItemForumChannel {
    int endColor;
    int hotFeedNum;
    String hotIcon;
    int hotValue;
    String hotValueTitle;
    int index;
    String inviteCode;
    int startColor;
    int type;

    public GProRecommendItemForumChannel() {
        this.hotValueTitle = "";
        this.hotIcon = "";
        this.inviteCode = "";
    }

    public int getEndColor() {
        return this.endColor;
    }

    public int getHotFeedNum() {
        return this.hotFeedNum;
    }

    public String getHotIcon() {
        return this.hotIcon;
    }

    public int getHotValue() {
        return this.hotValue;
    }

    public String getHotValueTitle() {
        return this.hotValueTitle;
    }

    public int getIndex() {
        return this.index;
    }

    public String getInviteCode() {
        return this.inviteCode;
    }

    public int getStartColor() {
        return this.startColor;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProRecommendItemForumChannel{hotFeedNum=" + this.hotFeedNum + ",index=" + this.index + ",hotValue=" + this.hotValue + ",hotValueTitle=" + this.hotValueTitle + ",type=" + this.type + ",startColor=" + this.startColor + ",endColor=" + this.endColor + ",hotIcon=" + this.hotIcon + ",inviteCode=" + this.inviteCode + ",}";
    }

    public GProRecommendItemForumChannel(int i2, int i3, int i4, String str, int i5, int i6, int i7, String str2, String str3) {
        this.hotValueTitle = "";
        this.hotIcon = "";
        this.inviteCode = "";
        this.hotFeedNum = i2;
        this.index = i3;
        this.hotValue = i4;
        this.hotValueTitle = str;
        this.type = i5;
        this.startColor = i6;
        this.endColor = i7;
        this.hotIcon = str2;
        this.inviteCode = str3;
    }
}
