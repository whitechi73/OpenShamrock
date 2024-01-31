package com.tencent.qqnt.kernel.nativeinterface;



public  final class ImageUrl {
    byte[] busiData;
    int height;
    int levelType;
    String url;
    int width;

    public ImageUrl() {
        this.url = "";
    }

    public byte[] getBusiData() {
        return this.busiData;
    }

    public int getHeight() {
        return this.height;
    }

    public int getLevelType() {
        return this.levelType;
    }

    public String getUrl() {
        return this.url;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "ImageUrl{levelType=" + this.levelType + ", url = " + this.url + ",width=" + this.width + ",height=" + this.height + ",busiData=" + this.busiData + ",}";
    }

    public ImageUrl(int i2, String str, int i3, int i4, byte[] bArr) {
        this.url = "";
        this.levelType = i2;
        this.url = str;
        this.width = i3;
        this.height = i4;
        this.busiData = bArr;
    }
}
