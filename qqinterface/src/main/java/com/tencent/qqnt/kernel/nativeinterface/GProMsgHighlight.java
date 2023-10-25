package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProMsgHighlight {
    String keyWord;
    long offset;

    public GProMsgHighlight() {
        this.keyWord = "";
    }

    public String getKeyWord() {
        return this.keyWord;
    }

    public long getOffset() {
        return this.offset;
    }

    public String toString() {
        return "GProMsgHighlight{offset=" + this.offset + ",keyWord=" + this.keyWord + ",}";
    }

    public GProMsgHighlight(long j2, String str) {
        this.keyWord = "";
        this.offset = j2;
        this.keyWord = str;
    }
}
