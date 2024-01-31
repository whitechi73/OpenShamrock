package com.tencent.qqnt.kernel.nativeinterface;



public  final class RichTextEmojiContent {
    String id;
    String name;
    String type;
    String url;

    public RichTextEmojiContent() {
        this.id = "";
        this.type = "";
        this.name = "";
        this.url = "";
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "RichTextEmojiContent{id=" + this.id + ",type=" + this.type + ",name=" + this.name + ", url = " + this.url + ",}";
    }

    public RichTextEmojiContent(String str, String str2, String str3, String str4) {
        this.id = "";
        this.type = "";
        this.name = "";
        this.url = "";
        this.id = str;
        this.type = str2;
        this.name = str3;
        this.url = str4;
    }
}
