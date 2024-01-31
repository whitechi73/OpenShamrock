package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;



public final class SearchHistoryItem {
    ArrayList<SearchBuddyItem> buddyList;
    ArrayList<SearchFileItem> fileInfos;
    ArrayList<SearchGroupItem> groupInfos;
    int id;
    ArrayList<SearchMsgItem> msgs;
    SearchHistoryType type;

    public SearchHistoryItem() {
        this.type = SearchHistoryType.values()[0];
        this.buddyList = new ArrayList<>();
        this.groupInfos = new ArrayList<>();
        this.msgs = new ArrayList<>();
        this.fileInfos = new ArrayList<>();
    }

    public ArrayList<SearchBuddyItem> getBuddyList() {
        return this.buddyList;
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

    public ArrayList<SearchMsgItem> getMsgs() {
        return this.msgs;
    }

    public SearchHistoryType getType() {
        return this.type;
    }

    public String toString() {
        return "SearchHistoryItem{id=" + this.id + ",type=" + this.type + ",buddyList=" + this.buddyList + ",groupInfos=" + this.groupInfos + ",msgs=" + this.msgs + ",fileInfos=" + this.fileInfos + ",}";
    }

    public SearchHistoryItem(int i2, SearchHistoryType searchHistoryType, ArrayList<SearchBuddyItem> arrayList, ArrayList<SearchGroupItem> arrayList2, ArrayList<SearchMsgItem> arrayList3, ArrayList<SearchFileItem> arrayList4) {
        this.type = SearchHistoryType.values()[0];
        this.buddyList = new ArrayList<>();
        this.groupInfos = new ArrayList<>();
        this.msgs = new ArrayList<>();
        this.fileInfos = new ArrayList<>();
        this.id = i2;
        this.type = searchHistoryType;
        this.buddyList = arrayList;
        this.groupInfos = arrayList2;
        this.msgs = arrayList3;
        this.fileInfos = arrayList4;
    }
}
