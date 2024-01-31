package com.tencent.qqnt.kernel.nativeinterface;



public final class SearchRspGroupInfo {
    long groupCode;
    int privilege;
    GroupDetailInfo searchGroupInfo;

    public SearchRspGroupInfo() {
        this.searchGroupInfo = new GroupDetailInfo();
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getPrivilege() {
        return this.privilege;
    }

    public GroupDetailInfo getSearchGroupInfo() {
        return this.searchGroupInfo;
    }

    public String toString() {
        return "SearchRspGroupInfo{groupCode=" + this.groupCode + ",searchGroupInfo=" + this.searchGroupInfo + ",privilege=" + this.privilege + ",}";
    }

    public SearchRspGroupInfo(long j2, GroupDetailInfo groupDetailInfo, int i2) {
        this.searchGroupInfo = new GroupDetailInfo();
        this.groupCode = j2;
        this.searchGroupInfo = groupDetailInfo;
        this.privilege = i2;
    }
}
