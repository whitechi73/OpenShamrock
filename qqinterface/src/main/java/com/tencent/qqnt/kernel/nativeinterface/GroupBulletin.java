package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public final class GroupBulletin {
    ArrayList<BulletinFeedsRecord> feedsRecords;
    long groupCode;
    int lastModifyTime;
    int unreadNum;

    public GroupBulletin() {
        this.feedsRecords = new ArrayList<>();
    }

    public ArrayList<BulletinFeedsRecord> getFeedsRecords() {
        return this.feedsRecords;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getLastModifyTime() {
        return this.lastModifyTime;
    }

    public int getUnreadNum() {
        return this.unreadNum;
    }

    public String toString() {
        return "GroupBulletin{groupCode=" + this.groupCode + ",feedsRecords=" + this.feedsRecords + ",lastModifyTime=" + this.lastModifyTime + ",unreadNum=" + this.unreadNum + ",}";
    }

    public GroupBulletin(long j2, ArrayList<BulletinFeedsRecord> arrayList, int i2, int i3) {
        this.feedsRecords = new ArrayList<>();
        this.groupCode = j2;
        this.feedsRecords = arrayList;
        this.lastModifyTime = i2;
        this.unreadNum = i3;
    }
}