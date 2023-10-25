package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes22.dex */
public final class GProUserFreeGiftInfoRsp implements Serializable {
    String checkContext;
    int countdownSecond;
    int currFreeGiftNum;
    int dayFreeGiftNum;
    ArrayList<Long> freeGiftIds;
    int gotFreeGiftNum;
    int maxFreeGiftNum;
    ArrayList<Integer> needCheckThemeTypes;
    long nextCheckTimeMS;
    int reminderFreeGiftNum;
    long serialVersionUID;

    public GProUserFreeGiftInfoRsp() {
        this.serialVersionUID = 1L;
        this.checkContext = "";
        this.needCheckThemeTypes = new ArrayList<>();
        this.freeGiftIds = new ArrayList<>();
    }

    public String getCheckContext() {
        return this.checkContext;
    }

    public int getCountdownSecond() {
        return this.countdownSecond;
    }

    public int getCurrFreeGiftNum() {
        return this.currFreeGiftNum;
    }

    public int getDayFreeGiftNum() {
        return this.dayFreeGiftNum;
    }

    public ArrayList<Long> getFreeGiftIds() {
        return this.freeGiftIds;
    }

    public int getGotFreeGiftNum() {
        return this.gotFreeGiftNum;
    }

    public int getMaxFreeGiftNum() {
        return this.maxFreeGiftNum;
    }

    public ArrayList<Integer> getNeedCheckThemeTypes() {
        return this.needCheckThemeTypes;
    }

    public long getNextCheckTimeMS() {
        return this.nextCheckTimeMS;
    }

    public int getReminderFreeGiftNum() {
        return this.reminderFreeGiftNum;
    }

    public String toString() {
        return "GProUserFreeGiftInfoRsp{checkContext=" + this.checkContext + ",maxFreeGiftNum=" + this.maxFreeGiftNum + ",currFreeGiftNum=" + this.currFreeGiftNum + ",dayFreeGiftNum=" + this.dayFreeGiftNum + ",gotFreeGiftNum=" + this.gotFreeGiftNum + ",nextCheckTimeMS=" + this.nextCheckTimeMS + ",countdownSecond=" + this.countdownSecond + ",reminderFreeGiftNum=" + this.reminderFreeGiftNum + ",needCheckThemeTypes=" + this.needCheckThemeTypes + ",freeGiftIds=" + this.freeGiftIds + ",}";
    }

    public GProUserFreeGiftInfoRsp(String str, int i2, int i3, int i4, int i5, long j2, int i6, int i7, ArrayList<Integer> arrayList, ArrayList<Long> arrayList2) {
        this.serialVersionUID = 1L;
        this.checkContext = "";
        this.needCheckThemeTypes = new ArrayList<>();
        this.freeGiftIds = new ArrayList<>();
        this.checkContext = str;
        this.maxFreeGiftNum = i2;
        this.currFreeGiftNum = i3;
        this.dayFreeGiftNum = i4;
        this.gotFreeGiftNum = i5;
        this.nextCheckTimeMS = j2;
        this.countdownSecond = i6;
        this.reminderFreeGiftNum = i7;
        this.needCheckThemeTypes = arrayList;
        this.freeGiftIds = arrayList2;
    }
}
