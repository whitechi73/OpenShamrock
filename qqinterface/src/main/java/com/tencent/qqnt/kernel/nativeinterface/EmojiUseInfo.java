package com.tencent.qqnt.kernel.nativeinterface;


public  final class EmojiUseInfo {
    String emojiId;
    int emojiType;
    long updateTime;
    int usedCount;

    public EmojiUseInfo() {
        this.emojiId = "";
    }

    public String getEmojiId() {
        return this.emojiId;
    }

    public int getEmojiType() {
        return this.emojiType;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public int getUsedCount() {
        return this.usedCount;
    }

    public String toString() {
        return "EmojiUseInfo{updateTime=" + this.updateTime + ",usedCount=" + this.usedCount + ",emojiType=" + this.emojiType + ",emojiId=" + this.emojiId + ",}";
    }

    public EmojiUseInfo(long j2, int i2, int i3, String str) {
        this.emojiId = "";
        this.updateTime = j2;
        this.usedCount = i2;
        this.emojiType = i3;
        this.emojiId = str;
    }
}
