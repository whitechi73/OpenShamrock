package com.tencent.qqnt.kernel.nativeinterface;


public  final class EmojiLikesUserInfo {
    String headUrl;
    String nickName;
    long tinyId;

    public EmojiLikesUserInfo() {
        this.nickName = "";
        this.headUrl = "";
    }

    public String getHeadUrl() {
        return this.headUrl;
    }

    public String getNickName() {
        return this.nickName;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "EmojiLikesUserInfo{tinyId=" + this.tinyId + ",nickName=" + this.nickName + ",headUrl=" + this.headUrl + ",}";
    }

    public EmojiLikesUserInfo(long j2, String str, String str2) {
        this.nickName = "";
        this.headUrl = "";
        this.tinyId = j2;
        this.nickName = str;
        this.headUrl = str2;
    }
}
