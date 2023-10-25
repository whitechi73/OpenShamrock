package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProHotSearchWord {
    String icon;
    String link;
    int type;
    String word;

    public GProHotSearchWord() {
        this.word = "";
        this.icon = "";
        this.link = "";
    }

    public String getIcon() {
        return this.icon;
    }

    public String getLink() {
        return this.link;
    }

    public int getType() {
        return this.type;
    }

    public String getWord() {
        return this.word;
    }

    public String toString() {
        return "GProHotSearchWord{type=" + this.type + ",word=" + this.word + ",icon=" + this.icon + ",link=" + this.link + ",}";
    }

    public GProHotSearchWord(int i2, String str, String str2, String str3) {
        this.word = "";
        this.icon = "";
        this.link = "";
        this.type = i2;
        this.word = str;
        this.icon = str2;
        this.link = str3;
    }
}
