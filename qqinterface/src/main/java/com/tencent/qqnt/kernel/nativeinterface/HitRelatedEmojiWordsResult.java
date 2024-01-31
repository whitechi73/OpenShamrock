package com.tencent.qqnt.kernel.nativeinterface;


public  final class HitRelatedEmojiWordsResult {
    boolean isHit;

    /* renamed from: msg  reason: collision with root package name */
    String f305542msg;
    int result;
    String word;

    public HitRelatedEmojiWordsResult() {
        this.f305542msg = "";
        this.word = "";
    }

    public boolean getIsHit() {
        return this.isHit;
    }

    public String getMsg() {
        return this.f305542msg;
    }

    public int getResult() {
        return this.result;
    }

    public String getWord() {
        return this.word;
    }

    public String toString() {
        return "HitRelatedEmojiWordsResult{result=" + this.result + ",msg=" + this.f305542msg + ",isHit=" + this.isHit + ",word=" + this.word + ",}";
    }

    public HitRelatedEmojiWordsResult(int i2, String str, boolean z, String str2) {
        this.f305542msg = "";
        this.word = "";
        this.result = i2;
        this.f305542msg = str;
        this.isHit = z;
        this.word = str2;
    }
}
