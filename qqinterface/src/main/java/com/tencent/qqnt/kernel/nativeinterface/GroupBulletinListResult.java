package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;


public  final class GroupBulletinListResult {
    ArrayList<GroupBulletinFeed> feeds;
    int gln;
    long groupCode;
    GroupBulletinGroupInfo groupInfo;
    ArrayList<GroupBulletinFeed> inst;
    long jointime;
    int nextIndex;
    ArrayList<GroupBulletinPublisherInfo> publisherInfos;
    int readOnly;
    int role;
    long serverTime;
    int srvCode;
    long svrt;
    int tst;

    public GroupBulletinListResult() {
        this.inst = new ArrayList<>();
        this.feeds = new ArrayList<>();
        this.groupInfo = new GroupBulletinGroupInfo();
        this.publisherInfos = new ArrayList<>();
    }

    public ArrayList<GroupBulletinFeed> getFeeds() {
        return this.feeds;
    }

    public int getGln() {
        return this.gln;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public GroupBulletinGroupInfo getGroupInfo() {
        return this.groupInfo;
    }

    public ArrayList<GroupBulletinFeed> getInst() {
        return this.inst;
    }

    public long getJointime() {
        return this.jointime;
    }

    public int getNextIndex() {
        return this.nextIndex;
    }

    public ArrayList<GroupBulletinPublisherInfo> getPublisherInfos() {
        return this.publisherInfos;
    }

    public int getReadOnly() {
        return this.readOnly;
    }

    public int getRole() {
        return this.role;
    }

    public long getServerTime() {
        return this.serverTime;
    }

    public int getSrvCode() {
        return this.srvCode;
    }

    public long getSvrt() {
        return this.svrt;
    }

    public int getTst() {
        return this.tst;
    }

    public String toString() {
        return "GroupBulletinListResult{groupCode=" + this.groupCode + ",srvCode=" + this.srvCode + ",readOnly=" + this.readOnly + ",role=" + this.role + ",inst=" + this.inst + ",feeds=" + this.feeds + ",groupInfo=" + this.groupInfo + ",gln=" + this.gln + ",tst=" + this.tst + ",publisherInfos=" + this.publisherInfos + ",serverTime=" + this.serverTime + ",svrt=" + this.svrt + ",nextIndex=" + this.nextIndex + ",jointime=" + this.jointime + ",}";
    }

    public GroupBulletinListResult(long j2, int i2, int i3, int i4, ArrayList<GroupBulletinFeed> arrayList, ArrayList<GroupBulletinFeed> arrayList2, GroupBulletinGroupInfo groupBulletinGroupInfo, int i5, int i6, ArrayList<GroupBulletinPublisherInfo> arrayList3, long j3, long j4, int i7, long j5) {
        this.inst = new ArrayList<>();
        this.feeds = new ArrayList<>();
        this.groupInfo = new GroupBulletinGroupInfo();
        this.publisherInfos = new ArrayList<>();
        this.groupCode = j2;
        this.srvCode = i2;
        this.readOnly = i3;
        this.role = i4;
        this.inst = arrayList;
        this.feeds = arrayList2;
        this.groupInfo = groupBulletinGroupInfo;
        this.gln = i5;
        this.tst = i6;
        this.publisherInfos = arrayList3;
        this.serverTime = j3;
        this.svrt = j4;
        this.nextIndex = i7;
        this.jointime = j5;
    }
}