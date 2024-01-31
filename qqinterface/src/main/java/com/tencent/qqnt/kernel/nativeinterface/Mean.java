package com.tencent.qqnt.kernel.nativeinterface;


public  final class Mean {
    int flag;
    String words;

    public Mean() {
        this.words = "";
    }

    public int getFlag() {
        return this.flag;
    }

    public String getWords() {
        return this.words;
    }

    public String toString() {
        return "Mean{words=" + this.words + ",flag=" + this.flag + ",}";
    }

    public Mean(String str, int i2) {
        this.words = "";
        this.words = str;
        this.flag = i2;
    }
}
