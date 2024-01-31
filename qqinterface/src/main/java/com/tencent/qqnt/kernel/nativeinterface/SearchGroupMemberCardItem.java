package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;



public final class SearchGroupMemberCardItem {
    String cardName;
    ArrayList<SearchHitInfo> cardNameHits;
    String uid;

    public SearchGroupMemberCardItem() {
        this.uid = "";
        this.cardName = "";
        this.cardNameHits = new ArrayList<>();
    }

    public String getCardName() {
        return this.cardName;
    }

    public ArrayList<SearchHitInfo> getCardNameHits() {
        return this.cardNameHits;
    }

    public String getUid() {
        return this.uid;
    }

    public String toString() {
        return "SearchGroupMemberCardItem{uid=" + this.uid + ",cardName=" + this.cardName + ",cardNameHits=" + this.cardNameHits + ",}";
    }

    public SearchGroupMemberCardItem(String str, String str2, ArrayList<SearchHitInfo> arrayList) {
        this.uid = "";
        this.cardName = "";
        this.cardNameHits = new ArrayList<>();
        this.uid = str;
        this.cardName = str2;
        this.cardNameHits = arrayList;
    }
}
