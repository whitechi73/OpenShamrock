package com.tencent.qqnt.kernel.nativeinterface;

import java.util.HashMap;


public  final class EmojiNotifyInfo {
    EmojiDownloadType downloadType;
    String dynamicFacePath;
    String emojiId;
    String emojiPackageId;
    int emojiType;
    String errMsg;
    HashMap<String, String> extraData;
    String md5;
    String path;
    String resId;
    int result;

    public EmojiNotifyInfo() {
        this.errMsg = "";
        this.md5 = "";
        this.resId = "";
        this.path = "";
        this.extraData = new HashMap<>();
        this.emojiId = "";
        this.emojiPackageId = "";
        this.downloadType = EmojiDownloadType.values()[0];
    }

    public EmojiDownloadType getDownloadType() {
        return this.downloadType;
    }

    public String getDynamicFacePath() {
        return this.dynamicFacePath;
    }

    public String getEmojiId() {
        return this.emojiId;
    }

    public String getEmojiPackageId() {
        return this.emojiPackageId;
    }

    public int getEmojiType() {
        return this.emojiType;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public HashMap<String, String> getExtraData() {
        return this.extraData;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getPath() {
        return this.path;
    }

    public String getResId() {
        return this.resId;
    }

    public int getResult() {
        return this.result;
    }

    public String toString() {
        return "EmojiNotifyInfo{result=" + this.result + ",errMsg=" + this.errMsg + ",emojiType=" + this.emojiType + ",md5=" + this.md5 + ",resId=" + this.resId + ",path=" + this.path + ",extraData=" + this.extraData + ",emojiId=" + this.emojiId + ",emojiPackageId=" + this.emojiPackageId + ",downloadType=" + this.downloadType + ",dynamicFacePath=" + this.dynamicFacePath + ",}";
    }

    public EmojiNotifyInfo(int i2, String str, int i3, String str2, String str3, String str4, HashMap<String, String> hashMap, String str5, String str6, EmojiDownloadType emojiDownloadType, String str7) {
        this.errMsg = "";
        this.md5 = "";
        this.resId = "";
        this.path = "";
        this.extraData = new HashMap<>();
        this.emojiId = "";
        this.emojiPackageId = "";
        this.downloadType = EmojiDownloadType.values()[0];
        this.result = i2;
        this.errMsg = str;
        this.emojiType = i3;
        this.md5 = str2;
        this.resId = str3;
        this.path = str4;
        this.extraData = hashMap;
        this.emojiId = str5;
        this.emojiPackageId = str6;
        this.downloadType = emojiDownloadType;
        this.dynamicFacePath = str7;
    }
}
