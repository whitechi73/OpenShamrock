package com.tencent.qqnt.kernel.nativeinterface;


public  final class EmojiAD {
    String desc;
    String url;

    public EmojiAD() {
        this.url = "";
        this.desc = "";
    }

    public String getDesc() {
        return this.desc;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "EmojiAD{url=" + this.url + ",desc=" + this.desc + ",}";
    }

    public EmojiAD(String str, String str2) {
        this.url = "";
        this.desc = "";
        this.url = str;
        this.desc = str2;
    }
}
