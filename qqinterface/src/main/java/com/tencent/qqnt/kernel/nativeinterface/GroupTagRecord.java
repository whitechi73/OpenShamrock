package com.tencent.qqnt.kernel.nativeinterface;


public  final class GroupTagRecord {
    int badNum;
    String fromUid;
    int goodNum;
    long groupCode;
    long setTime;
    String tagId;
    int tagLen;
    String tagValue;

    public GroupTagRecord() {
        this.fromUid = "";
        this.tagId = "";
        this.tagValue = "";
    }

    public int getBadNum() {
        return this.badNum;
    }

    public String getFromUid() {
        return this.fromUid;
    }

    public int getGoodNum() {
        return this.goodNum;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public long getSetTime() {
        return this.setTime;
    }

    public String getTagId() {
        return this.tagId;
    }

    public int getTagLen() {
        return this.tagLen;
    }

    public String getTagValue() {
        return this.tagValue;
    }

    public String toString() {
        return "GroupTagRecord{fromUid=" + this.fromUid + ",groupCode=" + this.groupCode + ",tagId=" + this.tagId + ",setTime=" + this.setTime + ",goodNum=" + this.goodNum + ",badNum=" + this.badNum + ",tagLen=" + this.tagLen + ",tagValue=" + this.tagValue + ",}";
    }

    public GroupTagRecord(String str, long j2, String str2, long j3, int i2, int i3, int i4, String str3) {
        this.fromUid = "";
        this.tagId = "";
        this.tagValue = "";
        this.fromUid = str;
        this.groupCode = j2;
        this.tagId = str2;
        this.setTime = j3;
        this.goodNum = i2;
        this.badNum = i3;
        this.tagLen = i4;
        this.tagValue = str3;
    }
}
