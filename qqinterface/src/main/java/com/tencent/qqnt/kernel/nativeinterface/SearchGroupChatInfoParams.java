package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;


public final class SearchGroupChatInfoParams {
    SearchGroupChatInfoBusinessType businessType;
    ArrayList<String> filterMembersUid;
    int pageLimit;
    SearchGroupChatInfoSortType resultSortType;

    public SearchGroupChatInfoParams() {
        this.resultSortType = SearchGroupChatInfoSortType.values()[0];
        this.filterMembersUid = new ArrayList<>();
        this.businessType = SearchGroupChatInfoBusinessType.values()[0];
    }

    public SearchGroupChatInfoBusinessType getBusinessType() {
        return this.businessType;
    }

    public ArrayList<String> getFilterMembersUid() {
        return this.filterMembersUid;
    }

    public int getPageLimit() {
        return this.pageLimit;
    }

    public SearchGroupChatInfoSortType getResultSortType() {
        return this.resultSortType;
    }

    public String toString() {
        return "SearchGroupChatInfoParams{resultSortType=" + this.resultSortType + ",filterMembersUid=" + this.filterMembersUid + ",businessType=" + this.businessType + ",pageLimit=" + this.pageLimit + ",}";
    }

    public SearchGroupChatInfoParams(SearchGroupChatInfoSortType searchGroupChatInfoSortType, ArrayList<String> arrayList, SearchGroupChatInfoBusinessType searchGroupChatInfoBusinessType, int i2) {
        this.resultSortType = SearchGroupChatInfoSortType.values()[0];
        this.filterMembersUid = new ArrayList<>();
        this.businessType = SearchGroupChatInfoBusinessType.values()[0];
        this.resultSortType = searchGroupChatInfoSortType;
        this.filterMembersUid = arrayList;
        this.businessType = searchGroupChatInfoBusinessType;
        this.pageLimit = i2;
    }
}
