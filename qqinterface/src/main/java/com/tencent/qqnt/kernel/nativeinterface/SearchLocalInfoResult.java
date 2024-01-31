package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;



public final class SearchLocalInfoResult {
    ArrayList<SearchBuddyItem> buddyList;
    ArrayList<SearchChatSummaryItem> chatsSummary;
    ArrayList<SearchFileItem> fileInfos;
    ArrayList<SearchGroupItem> groupInfos;
    int id;
    SearchLocalInfoType type;

    public SearchLocalInfoResult() {
        this.type = SearchLocalInfoType.values()[0];
        this.buddyList = new ArrayList<>();
        this.groupInfos = new ArrayList<>();
        this.chatsSummary = new ArrayList<>();
        this.fileInfos = new ArrayList<>();
    }

    public ArrayList<SearchBuddyItem> getBuddyList() {
        return this.buddyList;
    }

    public ArrayList<SearchChatSummaryItem> getChatsSummary() {
        return this.chatsSummary;
    }

    public ArrayList<SearchFileItem> getFileInfos() {
        return this.fileInfos;
    }

    public ArrayList<SearchGroupItem> getGroupInfos() {
        return this.groupInfos;
    }

    public int getId() {
        return this.id;
    }

    public SearchLocalInfoType getType() {
        return this.type;
    }

    public String toString() {
        return "SearchLocalInfoResult{id=" + this.id + ",type=" + this.type + ",buddyList=" + this.buddyList + ",groupInfos=" + this.groupInfos + ",chatsSummary=" + this.chatsSummary + ",fileInfos=" + this.fileInfos + ",}";
    }

    public SearchLocalInfoResult(int i2, SearchLocalInfoType searchLocalInfoType, ArrayList<SearchBuddyItem> arrayList, ArrayList<SearchGroupItem> arrayList2, ArrayList<SearchChatSummaryItem> arrayList3, ArrayList<SearchFileItem> arrayList4) {
        this.type = SearchLocalInfoType.values()[0];
        this.buddyList = new ArrayList<>();
        this.groupInfos = new ArrayList<>();
        this.chatsSummary = new ArrayList<>();
        this.fileInfos = new ArrayList<>();
        this.id = i2;
        this.type = searchLocalInfoType;
        this.buddyList = arrayList;
        this.groupInfos = arrayList2;
        this.chatsSummary = arrayList3;
        this.fileInfos = arrayList4;
    }
}
