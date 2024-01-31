package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProOnlineMemberInfo {
    String memberCnt;
    String memberTitle;
    ArrayList<String> onlineMemberAvatars;
    String onlineMemberCnt;

    public GProOnlineMemberInfo() {
        this.onlineMemberCnt = "";
        this.memberCnt = "";
        this.onlineMemberAvatars = new ArrayList<>();
        this.memberTitle = "";
    }

    public String getMemberCnt() {
        return this.memberCnt;
    }

    public String getMemberTitle() {
        return this.memberTitle;
    }

    public ArrayList<String> getOnlineMemberAvatars() {
        return this.onlineMemberAvatars;
    }

    public String getOnlineMemberCnt() {
        return this.onlineMemberCnt;
    }

    public String toString() {
        return "GProOnlineMemberInfo{onlineMemberCnt=" + this.onlineMemberCnt + ",memberCnt=" + this.memberCnt + ",onlineMemberAvatars=" + this.onlineMemberAvatars + ",memberTitle=" + this.memberTitle + ",}";
    }

    public GProOnlineMemberInfo(String str, String str2, ArrayList<String> arrayList, String str3) {
        this.onlineMemberCnt = "";
        this.memberCnt = "";
        this.onlineMemberAvatars = new ArrayList<>();
        this.memberTitle = "";
        this.onlineMemberCnt = str;
        this.memberCnt = str2;
        this.onlineMemberAvatars = arrayList;
        this.memberTitle = str3;
    }
}
