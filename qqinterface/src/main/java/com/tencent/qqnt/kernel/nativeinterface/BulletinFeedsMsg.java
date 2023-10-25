package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public final class BulletinFeedsMsg {
    ArrayList<BulletinFeedsContent> feedsContents;
    int feedsType;

    public BulletinFeedsMsg() {
        this.feedsContents = new ArrayList<>();
    }

    public ArrayList<BulletinFeedsContent> getFeedsContents() {
        return this.feedsContents;
    }

    public int getFeedsType() {
        return this.feedsType;
    }

    public String toString() {
        return "BulletinFeedsMsg{feedsType=" + this.feedsType + ",feedsContents=" + this.feedsContents + ",}";
    }

    public BulletinFeedsMsg(int i2, ArrayList<BulletinFeedsContent> arrayList) {
        this.feedsContents = new ArrayList<>();
        this.feedsType = i2;
        this.feedsContents = arrayList;
    }
}