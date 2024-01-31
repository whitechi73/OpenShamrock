package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProGameModesResult {
    String id;
    String image;
    String name;

    public GProGameModesResult() {
        this.id = "";
        this.name = "";
        this.image = "";
    }

    public String getId() {
        return this.id;
    }

    public String getImage() {
        return this.image;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "GProGameModesResult{id=" + this.id + ",name=" + this.name + ",image=" + this.image + ",}";
    }

    public GProGameModesResult(String str, String str2, String str3) {
        this.id = "";
        this.name = "";
        this.image = "";
        this.id = str;
        this.name = str2;
        this.image = str3;
    }
}
