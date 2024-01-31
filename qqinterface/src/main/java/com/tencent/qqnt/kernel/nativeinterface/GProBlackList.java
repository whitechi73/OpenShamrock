package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProBlackList {
    int listId;
    String listName;
    ArrayList<GProBlackUserInfo> memberList;

    public GProBlackList() {
        this.listName = "";
        this.memberList = new ArrayList<>();
    }

    public int getListId() {
        return this.listId;
    }

    public String getListName() {
        return this.listName;
    }

    public ArrayList<GProBlackUserInfo> getMemberList() {
        return this.memberList;
    }

    public String toString() {
        return "GProBlackList{listId=" + this.listId + ",listName=" + this.listName + ",memberList=" + this.memberList + ",}";
    }

    public GProBlackList(int i2, String str, ArrayList<GProBlackUserInfo> arrayList) {
        this.listName = "";
        this.memberList = new ArrayList<>();
        this.listId = i2;
        this.listName = str;
        this.memberList = arrayList;
    }
}
