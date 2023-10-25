package com.tencent.qqnt.kernel.nativeinterface;

public final class GroupBulletinFeed {
    int cn;
    String feedId;
    int fn;
    int isAllConfirm;
    int isRead;

    /* renamed from: msg  reason: collision with root package name */
    GroupBulletinFeedMsg f305541msg;
    int pinned;
    long publishTime;
    int readNum;
    GroupBulletinFeedSetting settings;
    int type;
    long uin;
    int vn;

    public GroupBulletinFeed() {
        this.feedId = "";
        this.f305541msg = new GroupBulletinFeedMsg();
        this.settings = new GroupBulletinFeedSetting();
    }

    public int getCn() {
        return this.cn;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public int getFn() {
        return this.fn;
    }

    public int getIsAllConfirm() {
        return this.isAllConfirm;
    }

    public int getIsRead() {
        return this.isRead;
    }

    public GroupBulletinFeedMsg getMsg() {
        return this.f305541msg;
    }

    public int getPinned() {
        return this.pinned;
    }

    public long getPublishTime() {
        return this.publishTime;
    }

    public int getReadNum() {
        return this.readNum;
    }

    public GroupBulletinFeedSetting getSettings() {
        return this.settings;
    }

    public int getType() {
        return this.type;
    }

    public long getUin() {
        return this.uin;
    }

    public int getVn() {
        return this.vn;
    }

    public String toString() {
        return "GroupBulletinFeed{uin=" + this.uin + ",feedId=" + this.feedId + ",publishTime=" + this.publishTime + ",msg=" + this.f305541msg + ",type=" + this.type + ",fn=" + this.fn + ",cn=" + this.cn + ",vn=" + this.vn + ",settings=" + this.settings + ",pinned=" + this.pinned + ",readNum=" + this.readNum + ",isRead=" + this.isRead + ",isAllConfirm=" + this.isAllConfirm + ",}";
    }

    public GroupBulletinFeed(long j2, String str, long j3, GroupBulletinFeedMsg groupBulletinFeedMsg, int i2, int i3, int i4, int i5, GroupBulletinFeedSetting groupBulletinFeedSetting, int i6, int i7, int i8, int i9) {
        this.feedId = "";
        this.f305541msg = new GroupBulletinFeedMsg();
        this.settings = new GroupBulletinFeedSetting();
        this.uin = j2;
        this.feedId = str;
        this.publishTime = j3;
        this.f305541msg = groupBulletinFeedMsg;
        this.type = i2;
        this.fn = i3;
        this.cn = i4;
        this.vn = i5;
        this.settings = groupBulletinFeedSetting;
        this.pinned = i6;
        this.readNum = i7;
        this.isRead = i8;
        this.isAllConfirm = i9;
    }
}