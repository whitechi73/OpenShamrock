package com.tencent.qqnt.kernel.nativeinterface;


public  final class EmojiDescInfo {
    String desc;
    int emojiId;
    String md5;
    String resId;

    public EmojiDescInfo() {
        this.resId = "";
        this.md5 = "";
        this.desc = "";
    }

    public String getDesc() {
        return this.desc;
    }

    public int getEmojiId() {
        return this.emojiId;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getResId() {
        return this.resId;
    }

    public String toString() {
        return "EmojiDescInfo{emojiId=" + this.emojiId + ",resId=" + this.resId + ",md5=" + this.md5 + ",desc=" + this.desc + ",}";
    }

    public EmojiDescInfo(int i2, String str, String str2, String str3) {
        this.resId = "";
        this.md5 = "";
        this.desc = "";
        this.emojiId = i2;
        this.resId = str;
        this.md5 = str2;
        this.desc = str3;
    }
}
