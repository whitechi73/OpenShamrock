package com.tencent.qqnt.kernel.nativeinterface;


public  final class DownloadRelateEmojiResultInfo {
    int clickNum;
    String eId;
    int eIdHeight;
    int eIdIsAPNG;
    String eIdName;
    int eIdWeight;
    int emojiId;
    String encryptKey;
    int epId;
    int exposeNum;
    boolean isMarkFace;
    String md5;

    /* renamed from: msg  reason: collision with root package name */
    String f305529msg;
    String path;
    RecommentEmojiType recommentEmojiType;
    String resId;
    int result;
    String uin;
    String url;
    String word;

    public DownloadRelateEmojiResultInfo() {
        this.f305529msg = "";
        this.path = "";
        this.recommentEmojiType = RecommentEmojiType.values()[0];
        this.resId = "";
        this.uin = "";
        this.url = "";
        this.eId = "";
        this.eIdName = "";
        this.encryptKey = "";
        this.md5 = "";
        this.word = "";
    }

    public int getClickNum() {
        return this.clickNum;
    }

    public String getEId() {
        return this.eId;
    }

    public int getEIdHeight() {
        return this.eIdHeight;
    }

    public int getEIdIsAPNG() {
        return this.eIdIsAPNG;
    }

    public String getEIdName() {
        return this.eIdName;
    }

    public int getEIdWeight() {
        return this.eIdWeight;
    }

    public int getEmojiId() {
        return this.emojiId;
    }

    public String getEncryptKey() {
        return this.encryptKey;
    }

    public int getEpId() {
        return this.epId;
    }

    public int getExposeNum() {
        return this.exposeNum;
    }

    public boolean getIsMarkFace() {
        return this.isMarkFace;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getMsg() {
        return this.f305529msg;
    }

    public String getPath() {
        return this.path;
    }

    public RecommentEmojiType getRecommentEmojiType() {
        return this.recommentEmojiType;
    }

    public String getResId() {
        return this.resId;
    }

    public int getResult() {
        return this.result;
    }

    public String getUin() {
        return this.uin;
    }

    public String getUrl() {
        return this.url;
    }

    public String getWord() {
        return this.word;
    }

    public String toString() {
        return "DownloadRelateEmojiResultInfo{result=" + this.result + ",msg=" + this.f305529msg + ",path=" + this.path + ",recommentEmojiType=" + this.recommentEmojiType + ",emojiId=" + this.emojiId + ",resId=" + this.resId + ",uin=" + this.uin + ", url = " + this.url + ",isMarkFace=" + this.isMarkFace + ",exposeNum=" + this.exposeNum + ",clickNum=" + this.clickNum + ",epId=" + this.epId + ",eId=" + this.eId + ",eIdName=" + this.eIdName + ",encryptKey=" + this.encryptKey + ",eIdWeight=" + this.eIdWeight + ",eIdHeight=" + this.eIdHeight + ",eIdIsAPNG=" + this.eIdIsAPNG + ",md5=" + this.md5 + ",word=" + this.word + ",}";
    }

    public DownloadRelateEmojiResultInfo(int i2, String str, String str2, RecommentEmojiType recommentEmojiType, int i3, String str3, String str4, String str5, boolean z, int i4, int i5, int i6, String str6, String str7, String str8, int i7, int i8, int i9, String str9, String str10) {
        this.f305529msg = "";
        this.path = "";
        this.recommentEmojiType = RecommentEmojiType.values()[0];
        this.resId = "";
        this.uin = "";
        this.url = "";
        this.eId = "";
        this.eIdName = "";
        this.encryptKey = "";
        this.md5 = "";
        this.word = "";
        this.result = i2;
        this.f305529msg = str;
        this.path = str2;
        this.recommentEmojiType = recommentEmojiType;
        this.emojiId = i3;
        this.resId = str3;
        this.uin = str4;
        this.url = str5;
        this.isMarkFace = z;
        this.exposeNum = i4;
        this.clickNum = i5;
        this.epId = i6;
        this.eId = str6;
        this.eIdName = str7;
        this.encryptKey = str8;
        this.eIdWeight = i7;
        this.eIdHeight = i8;
        this.eIdIsAPNG = i9;
        this.md5 = str9;
        this.word = str10;
    }
}
