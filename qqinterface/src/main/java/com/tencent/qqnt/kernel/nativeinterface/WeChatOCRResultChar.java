package com.tencent.qqnt.kernel.nativeinterface;

public final class WeChatOCRResultChar {
    WeChatOcrBox charBox;
    String charText;

    public WeChatOCRResultChar() {
        this.charText = "";
        this.charBox = new WeChatOcrBox();
    }

    public WeChatOcrBox getCharBox() {
        return this.charBox;
    }

    public String getCharText() {
        return this.charText;
    }

    public String toString() {
        return "WeChatOCRResultChar{charText=" + this.charText + ",charBox=" + this.charBox + ",}";
    }

    public WeChatOCRResultChar(String str, WeChatOcrBox weChatOcrBox) {
        this.charText = "";
        this.charBox = new WeChatOcrBox();
        this.charText = str;
        this.charBox = weChatOcrBox;
    }
}
