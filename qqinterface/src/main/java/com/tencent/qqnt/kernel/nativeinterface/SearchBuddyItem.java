package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;


public  final class SearchBuddyItem {
    String categoryName;
    int chatType;
    String nickname;
    ArrayList<SearchHitInfo> nicknameHits;
    String qid;
    ArrayList<SearchHitInfo> qidHits;
    String remark;
    ArrayList<SearchHitInfo> remarkHits;
    String uid;
    long uin;
    ArrayList<SearchHitInfo> uinHits;

    public SearchBuddyItem() {
        this.uid = "";
        this.qid = "";
        this.qidHits = new ArrayList<>();
        this.uinHits = new ArrayList<>();
        this.nickname = "";
        this.nicknameHits = new ArrayList<>();
        this.remark = "";
        this.remarkHits = new ArrayList<>();
        this.categoryName = "";
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public int getChatType() {
        return this.chatType;
    }

    public String getNickname() {
        return this.nickname;
    }

    public ArrayList<SearchHitInfo> getNicknameHits() {
        return this.nicknameHits;
    }

    public String getQid() {
        return this.qid;
    }

    public ArrayList<SearchHitInfo> getQidHits() {
        return this.qidHits;
    }

    public String getRemark() {
        return this.remark;
    }

    public ArrayList<SearchHitInfo> getRemarkHits() {
        return this.remarkHits;
    }

    public String getUid() {
        return this.uid;
    }

    public long getUin() {
        return this.uin;
    }

    public ArrayList<SearchHitInfo> getUinHits() {
        return this.uinHits;
    }

    public String toString() {
        return "SearchBuddyItem{chatType=" + this.chatType + ",uid=" + this.uid + ",qid=" + this.qid + ",qidHits=" + this.qidHits + ",uin=" + this.uin + ",uinHits=" + this.uinHits + ",nickname=" + this.nickname + ",nicknameHits=" + this.nicknameHits + ",remark=" + this.remark + ",remarkHits=" + this.remarkHits + ",categoryName=" + this.categoryName + ",}";
    }

    public SearchBuddyItem(int i2, String str, String str2, ArrayList<SearchHitInfo> arrayList, long j2, ArrayList<SearchHitInfo> arrayList2, String str3, ArrayList<SearchHitInfo> arrayList3, String str4, ArrayList<SearchHitInfo> arrayList4, String str5) {
        this.uid = "";
        this.qid = "";
        this.qidHits = new ArrayList<>();
        this.uinHits = new ArrayList<>();
        this.nickname = "";
        this.nicknameHits = new ArrayList<>();
        this.remark = "";
        this.remarkHits = new ArrayList<>();
        this.categoryName = "";
        this.chatType = i2;
        this.uid = str;
        this.qid = str2;
        this.qidHits = arrayList;
        this.uin = j2;
        this.uinHits = arrayList2;
        this.nickname = str3;
        this.nicknameHits = arrayList3;
        this.remark = str4;
        this.remarkHits = arrayList4;
        this.categoryName = str5;
    }
}
