package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProGetPopupInfoRsp implements Serializable {
    String buttonText;
    String footText;
    String gifUrl;
    String imgUrl;
    long serialVersionUID;
    String title;

    public GProGetPopupInfoRsp() {
        this.serialVersionUID = 1L;
        this.title = "";
        this.imgUrl = "";
        this.gifUrl = "";
        this.buttonText = "";
        this.footText = "";
    }

    public String getButtonText() {
        return this.buttonText;
    }

    public String getFootText() {
        return this.footText;
    }

    public String getGifUrl() {
        return this.gifUrl;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProGetPopupInfoRsp{title=" + this.title + ",imgUrl=" + this.imgUrl + ",gifUrl=" + this.gifUrl + ",buttonText=" + this.buttonText + ",footText=" + this.footText + ",}";
    }

    public GProGetPopupInfoRsp(String str, String str2, String str3, String str4, String str5) {
        this.serialVersionUID = 1L;
        this.title = "";
        this.imgUrl = "";
        this.gifUrl = "";
        this.buttonText = "";
        this.footText = "";
        this.title = str;
        this.imgUrl = str2;
        this.gifUrl = str3;
        this.buttonText = str4;
        this.footText = str5;
    }
}
