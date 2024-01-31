package com.tencent.qqnt.kernel.nativeinterface;


public  final class MsgEmojiLikes {
    String emojiId;
    long emojiType;
    boolean isClicked;
    long likesCnt;

    public MsgEmojiLikes() {
        this.emojiId = "";
    }

    public String getEmojiId() {
        return this.emojiId;
    }

    public long getEmojiType() {
        return this.emojiType;
    }

    public boolean getIsClicked() {
        return this.isClicked;
    }

    public long getLikesCnt() {
        return this.likesCnt;
    }

    public String toString() {
        return "MsgEmojiLikes{emojiId=" + this.emojiId + ",emojiType=" + this.emojiType + ",likesCnt=" + this.likesCnt + ",isClicked=" + this.isClicked + ",}";
    }

    public MsgEmojiLikes(String str, long j2, long j3, boolean z) {
        this.emojiId = "";
        this.emojiId = str;
        this.emojiType = j2;
        this.likesCnt = j3;
        this.isClicked = z;
    }
}
