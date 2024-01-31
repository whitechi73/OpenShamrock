package com.tencent.qqnt.kernel.nativeinterface;


public  final class EmojiResourceInfo {
    String errMsg;
    String path;
    int result;
    int type;

    public EmojiResourceInfo() {
        this.errMsg = "";
        this.path = "";
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getPath() {
        return this.path;
    }

    public int getResult() {
        return this.result;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "EmojiResourceInfo{result=" + this.result + ",errMsg=" + this.errMsg + ",type=" + this.type + ",path=" + this.path + ",}";
    }

    public EmojiResourceInfo(int i2, String str, int i3, String str2) {
        this.errMsg = "";
        this.path = "";
        this.result = i2;
        this.errMsg = str;
        this.type = i3;
        this.path = str2;
    }
}
