package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;



public final class SearchGroupItem {
    ArrayList<SearchDiscussInfoItem> discussInfo;
    long groupCode;
    SearchGroupInfoItem groupInfo;
    ArrayList<SearchGroupMemberCardItem> memberCard;
    ArrayList<SearchGroupMemberProfileItem> memberProfile;

    public SearchGroupItem() {
        this.discussInfo = new ArrayList<>();
        this.groupInfo = new SearchGroupInfoItem();
        this.memberProfile = new ArrayList<>();
        this.memberCard = new ArrayList<>();
    }

    public ArrayList<SearchDiscussInfoItem> getDiscussInfo() {
        return this.discussInfo;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public SearchGroupInfoItem getGroupInfo() {
        return this.groupInfo;
    }

    public ArrayList<SearchGroupMemberCardItem> getMemberCard() {
        return this.memberCard;
    }

    public ArrayList<SearchGroupMemberProfileItem> getMemberProfile() {
        return this.memberProfile;
    }

    public String toString() {
        return "SearchGroupItem{groupCode=" + this.groupCode + ",discussInfo=" + this.discussInfo + ",groupInfo=" + this.groupInfo + ",memberProfile=" + this.memberProfile + ",memberCard=" + this.memberCard + ",}";
    }

    public SearchGroupItem(long j2, ArrayList<SearchDiscussInfoItem> arrayList, SearchGroupInfoItem searchGroupInfoItem, ArrayList<SearchGroupMemberProfileItem> arrayList2, ArrayList<SearchGroupMemberCardItem> arrayList3) {
        this.discussInfo = new ArrayList<>();
        this.groupInfo = new SearchGroupInfoItem();
        this.memberProfile = new ArrayList<>();
        this.memberCard = new ArrayList<>();
        this.groupCode = j2;
        this.discussInfo = arrayList;
        this.groupInfo = searchGroupInfoItem;
        this.memberProfile = arrayList2;
        this.memberCard = arrayList3;
    }
}
