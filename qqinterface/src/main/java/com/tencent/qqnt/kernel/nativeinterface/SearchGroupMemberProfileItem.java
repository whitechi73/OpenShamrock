package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;


public final class SearchGroupMemberProfileItem {
    String nick;
    ArrayList<SearchHitInfo> nickHits;
    String remark;
    ArrayList<SearchHitInfo> remarkHits;
    String uid;
    long uin;
    ArrayList<SearchHitInfo> uinHits;

    public SearchGroupMemberProfileItem() {
        this.uid = "";
        this.uinHits = new ArrayList<>();
        this.nick = "";
        this.nickHits = new ArrayList<>();
        this.remark = "";
        this.remarkHits = new ArrayList<>();
    }

    public String getNick() {
        return this.nick;
    }

    public ArrayList<SearchHitInfo> getNickHits() {
        return this.nickHits;
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
        return "SearchGroupMemberProfileItem{uid=" + this.uid + ",uin=" + this.uin + ",uinHits=" + this.uinHits + ",nick=" + this.nick + ",nickHits=" + this.nickHits + ",remark=" + this.remark + ",remarkHits=" + this.remarkHits + ",}";
    }

    public SearchGroupMemberProfileItem(String str, long j2, ArrayList<SearchHitInfo> arrayList, String str2, ArrayList<SearchHitInfo> arrayList2, String str3, ArrayList<SearchHitInfo> arrayList3) {
        this.uid = "";
        this.uinHits = new ArrayList<>();
        this.nick = "";
        this.nickHits = new ArrayList<>();
        this.remark = "";
        this.remarkHits = new ArrayList<>();
        this.uid = str;
        this.uin = j2;
        this.uinHits = arrayList;
        this.nick = str2;
        this.nickHits = arrayList2;
        this.remark = str3;
        this.remarkHits = arrayList3;
    }
}
