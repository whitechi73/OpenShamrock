package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProGuildThemeInfo implements Serializable {
    ArrayList<Integer> oldThemeTypeList;
    long serialVersionUID;
    String sessionId;
    String themeBgImg;
    byte[] themeColor;
    String themeIcon;
    String themeName;
    int themeType;

    public GProGuildThemeInfo() {
        this.serialVersionUID = 1L;
        this.oldThemeTypeList = new ArrayList<>();
        this.themeName = "";
        this.themeIcon = "";
        this.themeColor = new byte[0];
        this.themeBgImg = "";
        this.sessionId = "";
    }

    public ArrayList<Integer> getOldThemeTypeList() {
        return this.oldThemeTypeList;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getThemeBgImg() {
        return this.themeBgImg;
    }

    public byte[] getThemeColor() {
        return this.themeColor;
    }

    public String getThemeIcon() {
        return this.themeIcon;
    }

    public String getThemeName() {
        return this.themeName;
    }

    public int getThemeType() {
        return this.themeType;
    }

    public String toString() {
        return "GProGuildThemeInfo{themeType=" + this.themeType + ",oldThemeTypeList=" + this.oldThemeTypeList + ",themeName=" + this.themeName + ",themeIcon=" + this.themeIcon + ",themeColor=" + this.themeColor + ",themeBgImg=" + this.themeBgImg + ",sessionId=" + this.sessionId + ",}";
    }

    public GProGuildThemeInfo(int i2, ArrayList<Integer> arrayList, String str, String str2, byte[] bArr, String str3, String str4) {
        this.serialVersionUID = 1L;
        this.oldThemeTypeList = new ArrayList<>();
        this.themeName = "";
        this.themeIcon = "";
        this.themeColor = new byte[0];
        this.themeBgImg = "";
        this.sessionId = "";
        this.themeType = i2;
        this.oldThemeTypeList = arrayList;
        this.themeName = str;
        this.themeIcon = str2;
        this.themeColor = bArr;
        this.themeBgImg = str3;
        this.sessionId = str4;
    }
}
