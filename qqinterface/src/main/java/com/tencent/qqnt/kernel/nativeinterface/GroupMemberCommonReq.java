package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public class GroupMemberCommonReq {
    public long groupCode;
    public int sourceType;
    public String startUin = "";
    public String identifyFlag = "";
    public ArrayList<Long> uinList = new ArrayList<>();
    public MemberCommonInfoFilter memberCommonFilter = new MemberCommonInfoFilter();
    public String memberNum = "";
    public String filterMethod = "";
    public String onlineFlag = "";
    public String realSpecialTitleFlag = "";

    public String getFilterMethod() {
        return this.filterMethod;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getIdentifyFlag() {
        return this.identifyFlag;
    }

    public MemberCommonInfoFilter getMemberCommonFilter() {
        return this.memberCommonFilter;
    }

    public String getMemberNum() {
        return this.memberNum;
    }

    public String getOnlineFlag() {
        return this.onlineFlag;
    }

    public String getRealSpecialTitleFlag() {
        return this.realSpecialTitleFlag;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public String getStartUin() {
        return this.startUin;
    }

    public ArrayList<Long> getUinList() {
        return this.uinList;
    }

    public void setFilterMethod(String str) {
        this.filterMethod = str;
    }

    public void setGroupCode(long j2) {
        this.groupCode = j2;
    }

    public void setIdentifyFlag(String str) {
        this.identifyFlag = str;
    }

    public void setMemberCommonFilter(MemberCommonInfoFilter memberCommonInfoFilter) {
        this.memberCommonFilter = memberCommonInfoFilter;
    }

    public void setMemberNum(String str) {
        this.memberNum = str;
    }

    public void setOnlineFlag(String str) {
        this.onlineFlag = str;
    }

    public void setRealSpecialTitleFlag(String str) {
        this.realSpecialTitleFlag = str;
    }

    public void setSourceType(int i2) {
        this.sourceType = i2;
    }

    public void setStartUin(String str) {
        this.startUin = str;
    }

    public void setUinList(ArrayList<Long> arrayList) {
        this.uinList = arrayList;
    }

    public String toString() {
        return "GroupMemberCommonReq{groupCode=" + this.groupCode + ",startUin=" + this.startUin + ",identifyFlag=" + this.identifyFlag + ",uinList=" + this.uinList + ",memberCommonFilter=" + this.memberCommonFilter + ",memberNum=" + this.memberNum + ",filterMethod=" + this.filterMethod + ",onlineFlag=" + this.onlineFlag + ",realSpecialTitleFlag=" + this.realSpecialTitleFlag + ",sourceType=" + this.sourceType + ",}";
    }

}
