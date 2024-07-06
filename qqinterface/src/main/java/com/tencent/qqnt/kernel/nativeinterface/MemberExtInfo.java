package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public class MemberExtInfo {
    public int activeDay;
    public int cmdUinFlagExt3Grocery;
    public int level;
    public int point;
    public long specialTitleExpireTime;
    public long uin;
    public String strName = "";
    public String nickName = "";
    public String specialTitle = "";
    public byte[] msgNeedField = new byte[0];
    public ArrayList<MemberIcon> memberIconList = new ArrayList<>();

    public int getActiveDay() {
        return this.activeDay;
    }

    public int getCmdUinFlagExt3Grocery() {
        return this.cmdUinFlagExt3Grocery;
    }

    public int getLevel() {
        return this.level;
    }

    public ArrayList<MemberIcon> getMemberIconList() {
        return this.memberIconList;
    }

    public byte[] getMsgNeedField() {
        return this.msgNeedField;
    }

    public String getNickName() {
        return this.nickName;
    }

    public int getPoint() {
        return this.point;
    }

    public String getSpecialTitle() {
        return this.specialTitle;
    }

    public long getSpecialTitleExpireTime() {
        return this.specialTitleExpireTime;
    }

    public String getStrName() {
        return this.strName;
    }

    public long getUin() {
        return this.uin;
    }

    public void setActiveDay(int i2) {
        this.activeDay = i2;
    }

    public void setCmdUinFlagExt3Grocery(int i2) {
        this.cmdUinFlagExt3Grocery = i2;
    }

    public void setLevel(int i2) {
        this.level = i2;
    }

    public void setMemberIconList(ArrayList<MemberIcon> arrayList) {
        this.memberIconList = arrayList;
    }

    public void setMsgNeedField(byte[] bArr) {
        this.msgNeedField = bArr;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setPoint(int i2) {
        this.point = i2;
    }

    public void setSpecialTitle(String str) {
        this.specialTitle = str;
    }

    public void setSpecialTitleExpireTime(long j2) {
        this.specialTitleExpireTime = j2;
    }

    public void setStrName(String str) {
        this.strName = str;
    }

    public void setUin(long j2) {
        this.uin = j2;
    }

    public String toString() {
        return "MemberExtInfo{uin=" + this.uin + ",point=" + this.point + ",activeDay=" + this.activeDay + ",level=" + this.level + ",strName=" + this.strName + ",nickName=" + this.nickName + ",specialTitle=" + this.specialTitle + ",specialTitleExpireTime=" + this.specialTitleExpireTime + ",msgNeedField=" + this.msgNeedField + ",cmdUinFlagExt3Grocery=" + this.cmdUinFlagExt3Grocery + ",memberIconList=" + this.memberIconList + ",}";
    }

}
