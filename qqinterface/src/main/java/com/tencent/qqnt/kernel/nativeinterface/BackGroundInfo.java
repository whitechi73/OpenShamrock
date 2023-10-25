package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public final class BackGroundInfo implements IKernelModel {
    int c2cUnreadCnt;
    int contactUnreadCnt;
    int groupUnreadCnt;
    ArrayList<Long> groupUnreadCodes;
    int guildPsvboxUnreadCnt;
    int guildUnreadCnt;
    int verifyUnreadCnt;

    public BackGroundInfo() {
        this.groupUnreadCodes = new ArrayList<>();
    }

    public int getC2cUnreadCnt() {
        return this.c2cUnreadCnt;
    }

    public int getContactUnreadCnt() {
        return this.contactUnreadCnt;
    }

    public int getGroupUnreadCnt() {
        return this.groupUnreadCnt;
    }

    public ArrayList<Long> getGroupUnreadCodes() {
        return this.groupUnreadCodes;
    }

    public int getGuildPsvboxUnreadCnt() {
        return this.guildPsvboxUnreadCnt;
    }

    public int getGuildUnreadCnt() {
        return this.guildUnreadCnt;
    }

    public int getVerifyUnreadCnt() {
        return this.verifyUnreadCnt;
    }

    public void setC2cUnreadCnt(int i2) {
        this.c2cUnreadCnt = i2;
    }

    public void setContactUnreadCnt(int i2) {
        this.contactUnreadCnt = i2;
    }

    public void setGroupUnreadCnt(int i2) {
        this.groupUnreadCnt = i2;
    }

    public void setGroupUnreadCodes(ArrayList<Long> arrayList) {
        this.groupUnreadCodes = arrayList;
    }

    public void setGuildPsvboxUnreadCnt(int i2) {
        this.guildPsvboxUnreadCnt = i2;
    }

    public void setGuildUnreadCnt(int i2) {
        this.guildUnreadCnt = i2;
    }

    public void setVerifyUnreadCnt(int i2) {
        this.verifyUnreadCnt = i2;
    }

    public String toString() {
        return "BackGroundInfo{c2cUnreadCnt=" + this.c2cUnreadCnt + ",groupUnreadCnt=" + this.groupUnreadCnt + ",guildUnreadCnt=" + this.guildUnreadCnt + ",guildPsvboxUnreadCnt=" + this.guildPsvboxUnreadCnt + ",verifyUnreadCnt=" + this.verifyUnreadCnt + ",contactUnreadCnt=" + this.contactUnreadCnt + ",groupUnreadCodes=" + this.groupUnreadCodes + ",}";
    }

    public BackGroundInfo(int i2, int i3, int i4, int i5, int i6, int i7, ArrayList<Long> arrayList) {
        this.groupUnreadCodes = new ArrayList<>();
        this.c2cUnreadCnt = i2;
        this.groupUnreadCnt = i3;
        this.guildUnreadCnt = i4;
        this.guildPsvboxUnreadCnt = i5;
        this.verifyUnreadCnt = i6;
        this.contactUnreadCnt = i7;
        this.groupUnreadCodes = arrayList;
    }
}