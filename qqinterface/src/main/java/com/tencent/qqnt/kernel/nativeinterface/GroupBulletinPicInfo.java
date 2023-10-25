package com.tencent.qqnt.kernel.nativeinterface;

public final class GroupBulletinPicInfo {
    int height;
    String id;
    int width;

    public GroupBulletinPicInfo() {
        this.id = "";
    }

    public int getHeight() {
        return this.height;
    }

    public String getId() {
        return this.id;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "GroupBulletinPicInfo{id=" + this.id + ",width=" + this.width + ",height=" + this.height + ",}";
    }

    public GroupBulletinPicInfo(String str, int i2, int i3) {
        this.id = "";
        this.id = str;
        this.width = i2;
        this.height = i3;
    }
}