package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public final class GroupBulletinFeedMsg {
    ArrayList<GroupBulletinPicInfo> pics;
    String text;
    String textFace;
    String title;

    public GroupBulletinFeedMsg() {
        this.text = "";
        this.textFace = "";
        this.pics = new ArrayList<>();
        this.title = "";
    }

    public ArrayList<GroupBulletinPicInfo> getPics() {
        return this.pics;
    }

    public String getText() {
        return this.text;
    }

    public String getTextFace() {
        return this.textFace;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GroupBulletinFeedMsg{text=" + this.text + ",textFace=" + this.textFace + ",pics=" + this.pics + ",title=" + this.title + ",}";
    }

    public GroupBulletinFeedMsg(String str, String str2, ArrayList<GroupBulletinPicInfo> arrayList, String str3) {
        this.text = "";
        this.textFace = "";
        this.pics = new ArrayList<>();
        this.title = "";
        this.text = str;
        this.textFace = str2;
        this.pics = arrayList;
        this.title = str3;
    }
}