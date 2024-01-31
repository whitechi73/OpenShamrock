package com.tencent.qqnt.kernel.nativeinterface;


public  final class EmojiMall {
    int emojiId;
    int packageId;

    public EmojiMall() {
    }

    public int getEmojiId() {
        return this.emojiId;
    }

    public int getPackageId() {
        return this.packageId;
    }

    public String toString() {
        return "EmojiMall{packageId=" + this.packageId + ",emojiId=" + this.emojiId + ",}";
    }

    public EmojiMall(int i2, int i3) {
        this.packageId = i2;
        this.emojiId = i3;
    }
}
