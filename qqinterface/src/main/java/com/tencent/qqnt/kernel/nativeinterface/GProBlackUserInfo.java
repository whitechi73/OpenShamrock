package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProBlackUserInfo {
    String avatarUrl;
    String nickName;
    long tinyId;

    public GProBlackUserInfo() {
        this.nickName = "";
        this.avatarUrl = "";
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getNickName() {
        return this.nickName;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProBlackUserInfo{tinyId=" + this.tinyId + ",nickName=" + this.nickName + ",avatarUrl=" + this.avatarUrl + ",}";
    }

    public GProBlackUserInfo(long j2, String str, String str2) {
        this.nickName = "";
        this.avatarUrl = "";
        this.tinyId = j2;
        this.nickName = str;
        this.avatarUrl = str2;
    }
}
