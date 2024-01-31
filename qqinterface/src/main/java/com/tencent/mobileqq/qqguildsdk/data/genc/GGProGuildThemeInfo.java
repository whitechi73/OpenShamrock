package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGuildThemeInfo;

import java.util.ArrayList;

public  class GGProGuildThemeInfo implements IGProGuildThemeInfo {
    public final GProGuildThemeInfo mInfo;

    public GGProGuildThemeInfo(GProGuildThemeInfo gProGuildThemeInfo) {
        this.mInfo = gProGuildThemeInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildThemeInfo
    public ArrayList<Integer> getOldThemeTypeList() {
        return this.mInfo.getOldThemeTypeList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildThemeInfo
    public String getSessionId() {
        return this.mInfo.getSessionId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildThemeInfo
    public String getThemeBgImg() {
        return this.mInfo.getThemeBgImg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildThemeInfo
    public byte[] getThemeColor() {
        return this.mInfo.getThemeColor();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildThemeInfo
    public String getThemeIcon() {
        return this.mInfo.getThemeIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildThemeInfo
    public String getThemeName() {
        return this.mInfo.getThemeName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildThemeInfo
    public int getThemeType() {
        return this.mInfo.getThemeType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildThemeInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
