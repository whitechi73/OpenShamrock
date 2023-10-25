package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProSearchMemberAndRoleResult {
    boolean fromSrv;
    String keyWord;
    ArrayList<GProUser> memberList;
    ArrayList<GProGuildRole> roleList;

    public GProSearchMemberAndRoleResult() {
        this.keyWord = "";
        this.memberList = new ArrayList<>();
        this.roleList = new ArrayList<>();
    }

    public boolean getFromSrv() {
        return this.fromSrv;
    }

    public String getKeyWord() {
        return this.keyWord;
    }

    public ArrayList<GProUser> getMemberList() {
        return this.memberList;
    }

    public ArrayList<GProGuildRole> getRoleList() {
        return this.roleList;
    }

    public String toString() {
        return "GProSearchMemberAndRoleResult{keyWord=" + this.keyWord + ",fromSrv=" + this.fromSrv + ",memberList=" + this.memberList + ",roleList=" + this.roleList + ",}";
    }

    public GProSearchMemberAndRoleResult(String str, boolean z, ArrayList<GProUser> arrayList, ArrayList<GProGuildRole> arrayList2) {
        this.keyWord = "";
        this.memberList = new ArrayList<>();
        this.roleList = new ArrayList<>();
        this.keyWord = str;
        this.fromSrv = z;
        this.memberList = arrayList;
        this.roleList = arrayList2;
    }
}
