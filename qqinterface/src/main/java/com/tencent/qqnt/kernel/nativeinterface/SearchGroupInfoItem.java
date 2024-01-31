package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;



public final class SearchGroupInfoItem {
    long groupCode;
    ArrayList<SearchHitInfo> groupCodeHits;
    String groupName;
    ArrayList<SearchHitInfo> groupNameHits;
    boolean hasModifyConfGroupFace;
    boolean hasModifyConfGroupName;
    boolean isConf;
    int memberCount;
    String remarkName;
    ArrayList<SearchHitInfo> remarkNameHits;

    public SearchGroupInfoItem() {
        this.groupCodeHits = new ArrayList<>();
        this.groupName = "";
        this.groupNameHits = new ArrayList<>();
        this.remarkName = "";
        this.remarkNameHits = new ArrayList<>();
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public ArrayList<SearchHitInfo> getGroupCodeHits() {
        return this.groupCodeHits;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public ArrayList<SearchHitInfo> getGroupNameHits() {
        return this.groupNameHits;
    }

    public boolean getHasModifyConfGroupFace() {
        return this.hasModifyConfGroupFace;
    }

    public boolean getHasModifyConfGroupName() {
        return this.hasModifyConfGroupName;
    }

    public boolean getIsConf() {
        return this.isConf;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public String getRemarkName() {
        return this.remarkName;
    }

    public ArrayList<SearchHitInfo> getRemarkNameHits() {
        return this.remarkNameHits;
    }

    public String toString() {
        return "SearchGroupInfoItem{groupCode=" + this.groupCode + ",groupCodeHits=" + this.groupCodeHits + ",memberCount=" + this.memberCount + ",isConf=" + this.isConf + ",hasModifyConfGroupFace=" + this.hasModifyConfGroupFace + ",hasModifyConfGroupName=" + this.hasModifyConfGroupName + ",groupName=" + this.groupName + ",groupNameHits=" + this.groupNameHits + ",remarkName=" + this.remarkName + ",remarkNameHits=" + this.remarkNameHits + ",}";
    }

    public SearchGroupInfoItem(long j2, ArrayList<SearchHitInfo> arrayList, int i2, boolean z, boolean z2, boolean z3, String str, ArrayList<SearchHitInfo> arrayList2, String str2, ArrayList<SearchHitInfo> arrayList3) {
        this.groupCodeHits = new ArrayList<>();
        this.groupName = "";
        this.groupNameHits = new ArrayList<>();
        this.remarkName = "";
        this.remarkNameHits = new ArrayList<>();
        this.groupCode = j2;
        this.groupCodeHits = arrayList;
        this.memberCount = i2;
        this.isConf = z;
        this.hasModifyConfGroupFace = z2;
        this.hasModifyConfGroupName = z3;
        this.groupName = str;
        this.groupNameHits = arrayList2;
        this.remarkName = str2;
        this.remarkNameHits = arrayList3;
    }
}
