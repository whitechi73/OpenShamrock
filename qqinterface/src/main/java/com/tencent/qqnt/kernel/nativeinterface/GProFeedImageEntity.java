package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProFeedImageEntity {
    int height;
    String url;
    int width;

    public GProFeedImageEntity() {
        this.url = "";
    }

    public int getHeight() {
        return this.height;
    }

    public String getUrl() {
        return this.url;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "GProFeedImageEntity{url=" + this.url + ",width=" + this.width + ",height=" + this.height + ",}";
    }

    public GProFeedImageEntity(String str, int i2, int i3) {
        this.url = "";
        this.url = str;
        this.width = i2;
        this.height = i3;
    }
}
