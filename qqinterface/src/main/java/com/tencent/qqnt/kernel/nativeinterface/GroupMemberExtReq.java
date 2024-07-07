package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public class GroupMemberExtReq {
    public long groupCode;
    public int sourceType;
    public String beginUin = "";
    public String dataTime = "";
    public ArrayList<Long> uinList = new ArrayList<>();
    public MemberExtInfoFilter memberExtFilter = new MemberExtInfoFilter();
    public String seq = "";
    public String uinNum = "";
    public String groupType = "";
    public String richCardNameVer = "";

    public String getBeginUin() {
        return this.beginUin;
    }

    public String getDataTime() {
        return this.dataTime;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getGroupType() {
        return this.groupType;
    }

    public MemberExtInfoFilter getMemberExtFilter() {
        return this.memberExtFilter;
    }

    public String getRichCardNameVer() {
        return this.richCardNameVer;
    }

    public String getSeq() {
        return this.seq;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public ArrayList<Long> getUinList() {
        return this.uinList;
    }

    public String getUinNum() {
        return this.uinNum;
    }

    public void setBeginUin(String str) {
        this.beginUin = str;
    }

    public void setDataTime(String str) {
        this.dataTime = str;
    }

    public void setGroupCode(long j2) {
        this.groupCode = j2;
    }

    public void setGroupType(String str) {
        this.groupType = str;
    }

    public void setMemberExtFilter(MemberExtInfoFilter memberExtInfoFilter) {
        this.memberExtFilter = memberExtInfoFilter;
    }

    public void setRichCardNameVer(String str) {
        this.richCardNameVer = str;
    }

    public void setSeq(String str) {
        this.seq = str;
    }

    public void setSourceType(int i2) {
        this.sourceType = i2;
    }

    public void setUinList(ArrayList<Long> arrayList) {
        this.uinList = arrayList;
    }

    public void setUinNum(String str) {
        this.uinNum = str;
    }

    public String toString() {
        return "GroupMemberExtReq{groupCode=" + this.groupCode + ",beginUin=" + this.beginUin + ",dataTime=" + this.dataTime + ",uinList=" + this.uinList + ",memberExtFilter=" + this.memberExtFilter + ",seq=" + this.seq + ",uinNum=" + this.uinNum + ",groupType=" + this.groupType + ",richCardNameVer=" + this.richCardNameVer + ",sourceType=" + this.sourceType + ",}";
    }

}
