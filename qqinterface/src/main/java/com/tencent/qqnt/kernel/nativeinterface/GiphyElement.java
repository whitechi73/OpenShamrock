package com.tencent.qqnt.kernel.nativeinterface;

public final class GiphyElement {
    int height;
    String id;
    boolean isClip;
    int width;

    public GiphyElement() {
        this.id = "";
    }

    public int getHeight() {
        return this.height;
    }

    public String getId() {
        return this.id;
    }

    public boolean getIsClip() {
        return this.isClip;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "GiphyElement{id=" + this.id + ",isClip=" + this.isClip + ",width=" + this.width + ",height=" + this.height + ",}";
    }

    public GiphyElement(String str, boolean z, int i2, int i3) {
        this.id = "";
        this.id = str;
        this.isClip = z;
        this.width = i2;
        this.height = i3;
    }
}