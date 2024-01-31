package com.tencent.qqnt.kernel.nativeinterface;



public final class SmallYellowFaceInfo {
    String buf;
    String compatibleText;
    int index;
    String text;

    public SmallYellowFaceInfo() {
    }

    public String getBuf() {
        return this.buf;
    }

    public String getCompatibleText() {
        return this.compatibleText;
    }

    public int getIndex() {
        return this.index;
    }

    public String getText() {
        return this.text;
    }

    public void setBuf(String str) {
        this.buf = str;
    }

    public void setCompatibleText(String str) {
        this.compatibleText = str;
    }

    public void setIndex(int i2) {
        this.index = i2;
    }

    public void setText(String str) {
        this.text = str;
    }

    public String toString() {
        return "SmallYellowFaceInfo{index=" + this.index + ",text=" + this.text + ",compatibleText=" + this.compatibleText + ",buf=" + this.buf + ",}";
    }

    public SmallYellowFaceInfo(int i2, String str, String str2, String str3) {
        this.index = i2;
        this.text = str;
        this.compatibleText = str2;
        this.buf = str3;
    }
}
