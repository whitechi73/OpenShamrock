package com.tencent.qqnt.kernel.nativeinterface;



public final class Visitor {
    byte[] busiData;
    int recomCount;
    int viewCount;
    String viewDesc;

    public Visitor() {
        this.busiData = new byte[0];
        this.viewDesc = "";
    }

    public byte[] getBusiData() {
        return this.busiData;
    }

    public int getRecomCount() {
        return this.recomCount;
    }

    public int getViewCount() {
        return this.viewCount;
    }

    public String getViewDesc() {
        return this.viewDesc;
    }

    public String toString() {
        return "Visitor{viewCount=" + this.viewCount + ",busiData=" + this.busiData + ",recomCount=" + this.recomCount + ",viewDesc=" + this.viewDesc + ",}";
    }

    public Visitor(int i2, byte[] bArr, int i3, String str) {
        this.busiData = new byte[0];
        this.viewDesc = "";
        this.viewCount = i2;
        this.busiData = bArr;
        this.recomCount = i3;
        this.viewDesc = str;
    }
}
