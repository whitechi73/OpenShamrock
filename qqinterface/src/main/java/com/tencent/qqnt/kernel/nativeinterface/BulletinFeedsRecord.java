package com.tencent.qqnt.kernel.nativeinterface;

public final class BulletinFeedsRecord {
    int createTime;
    int feedsFlag;
    String feedsId;
    BulletinFeedsMsg feedsMsg;
    int feedsType;
    String fromUid;
    long groupCode;
    int modifyTime;
    int setTop;

    public BulletinFeedsRecord() {
        this.fromUid = "";
        this.feedsId = "";
        this.feedsMsg = new BulletinFeedsMsg();
    }

    public int getCreateTime() {
        return this.createTime;
    }

    public int getFeedsFlag() {
        return this.feedsFlag;
    }

    public String getFeedsId() {
        return this.feedsId;
    }

    public BulletinFeedsMsg getFeedsMsg() {
        return this.feedsMsg;
    }

    public int getFeedsType() {
        return this.feedsType;
    }

    public String getFromUid() {
        return this.fromUid;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getModifyTime() {
        return this.modifyTime;
    }

    public int getSetTop() {
        return this.setTop;
    }

    public String toString() {
        return "BulletinFeedsRecord{groupCode=" + this.groupCode + ",fromUid=" + this.fromUid + ",feedsType=" + this.feedsType + ",feedsId=" + this.feedsId + ",feedsFlag=" + this.feedsFlag + ",createTime=" + this.createTime + ",modifyTime=" + this.modifyTime + ",feedsMsg=" + this.feedsMsg + ",setTop=" + this.setTop + ",}";
    }

    public BulletinFeedsRecord(long j2, String str, int i2, String str2, int i3, int i4, int i5, BulletinFeedsMsg bulletinFeedsMsg, int i6) {
        this.fromUid = "";
        this.feedsId = "";
        this.feedsMsg = new BulletinFeedsMsg();
        this.groupCode = j2;
        this.fromUid = str;
        this.feedsType = i2;
        this.feedsId = str2;
        this.feedsFlag = i3;
        this.createTime = i4;
        this.modifyTime = i5;
        this.feedsMsg = bulletinFeedsMsg;
        this.setTop = i6;
    }
}