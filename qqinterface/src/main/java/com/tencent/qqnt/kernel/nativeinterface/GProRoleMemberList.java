package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildRole;

import java.util.ArrayList;

public  final class GProRoleMemberList {
    ArrayList<GProUser> members;
    GProGuildRole role;

    public GProRoleMemberList() {
        this.role = new GProGuildRole();
        this.members = new ArrayList<>();
    }

    public ArrayList<GProUser> getMembers() {
        return this.members;
    }

    public GProGuildRole getRole() {
        return this.role;
    }

    public String toString() {
        return "GProRoleMemberList{role=" + this.role + ",members=" + this.members + ",}";
    }

    public GProRoleMemberList(GProGuildRole gProGuildRole, ArrayList<GProUser> arrayList) {
        this.role = gProGuildRole;
        this.members = arrayList;
    }
}
