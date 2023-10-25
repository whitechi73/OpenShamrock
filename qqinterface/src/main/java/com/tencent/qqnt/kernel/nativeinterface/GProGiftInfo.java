package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes22.dex */
public final class GProGiftInfo implements Serializable {
    int allComboCnt;
    boolean comboOver;
    long comboSeq;
    int effectLevel;
    int giftId;
    String giftName;
    int giftNum;
    long giftPrice;
    int giftType;
    int materialId;
    int sendType;
    long serialVersionUID;

    public GProGiftInfo() {
        this.serialVersionUID = 1L;
        this.giftName = "";
    }

    public int getAllComboCnt() {
        return this.allComboCnt;
    }

    public boolean getComboOver() {
        return this.comboOver;
    }

    public long getComboSeq() {
        return this.comboSeq;
    }

    public int getEffectLevel() {
        return this.effectLevel;
    }

    public int getGiftId() {
        return this.giftId;
    }

    public String getGiftName() {
        return this.giftName;
    }

    public int getGiftNum() {
        return this.giftNum;
    }

    public long getGiftPrice() {
        return this.giftPrice;
    }

    public int getGiftType() {
        return this.giftType;
    }

    public int getMaterialId() {
        return this.materialId;
    }

    public int getSendType() {
        return this.sendType;
    }

    public String toString() {
        return "GProGiftInfo{giftType=" + this.giftType + ",giftId=" + this.giftId + ",giftName=" + this.giftName + ",giftNum=" + this.giftNum + ",sendType=" + this.sendType + ",comboSeq=" + this.comboSeq + ",comboOver=" + this.comboOver + ",allComboCnt=" + this.allComboCnt + ",materialId=" + this.materialId + ",effectLevel=" + this.effectLevel + ",giftPrice=" + this.giftPrice + ",}";
    }

    public GProGiftInfo(int i2, int i3, String str, int i4, int i5, long j2, boolean z, int i6, int i7, int i8, long j3) {
        this.serialVersionUID = 1L;
        this.giftName = "";
        this.giftType = i2;
        this.giftId = i3;
        this.giftName = str;
        this.giftNum = i4;
        this.sendType = i5;
        this.comboSeq = j2;
        this.comboOver = z;
        this.allComboCnt = i6;
        this.materialId = i7;
        this.effectLevel = i8;
        this.giftPrice = j3;
    }
}
