package com.tencent.qqnt.kernel.nativeinterface;


public  final class EmojiReaction {
    long cnt;
    String emojiId;
    long emojiType;
    boolean isClicked;
    boolean isDefaultEmoji;

    public EmojiReaction() {
        this.emojiId = "";
    }

    public long getCnt() {
        return this.cnt;
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

    public boolean getIsDefaultEmoji() {
        return this.isDefaultEmoji;
    }

    public String toString() {
        return "EmojiReaction{emojiId=" + this.emojiId + ",emojiType=" + this.emojiType + ",cnt=" + this.cnt + ",isClicked=" + this.isClicked + ",isDefaultEmoji=" + this.isDefaultEmoji + ",}";
    }

    public EmojiReaction(String str, long j2, long j3, boolean z, boolean z2) {
        this.emojiId = "";
        this.emojiId = str;
        this.emojiType = j2;
        this.cnt = j3;
        this.isClicked = z;
        this.isDefaultEmoji = z2;
    }
}
