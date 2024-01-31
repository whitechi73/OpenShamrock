package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProAssociativeWords {
    GProRecallInfo recallInfo;
    String term;

    public GProAssociativeWords() {
        this.term = "";
        this.recallInfo = new GProRecallInfo();
    }

    public GProRecallInfo getRecallInfo() {
        return this.recallInfo;
    }

    public String getTerm() {
        return this.term;
    }

    public String toString() {
        return "GProAssociativeWords{term=" + this.term + ",recallInfo=" + this.recallInfo + ",}";
    }

    public GProAssociativeWords(String str, GProRecallInfo gProRecallInfo) {
        this.term = "";
        this.recallInfo = new GProRecallInfo();
        this.term = str;
        this.recallInfo = gProRecallInfo;
    }
}
