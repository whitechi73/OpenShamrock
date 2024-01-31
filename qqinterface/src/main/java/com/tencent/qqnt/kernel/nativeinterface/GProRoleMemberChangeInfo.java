package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProRoleMemberChangeInfo {
    ArrayList<Long> addMembers;
    ArrayList<Long> removeMembers;
    long roleId;

    public GProRoleMemberChangeInfo() {
        this.addMembers = new ArrayList<>();
        this.removeMembers = new ArrayList<>();
    }

    public ArrayList<Long> getAddMembers() {
        return this.addMembers;
    }

    public ArrayList<Long> getRemoveMembers() {
        return this.removeMembers;
    }

    public long getRoleId() {
        return this.roleId;
    }

    public String toString() {
        return "GProRoleMemberChangeInfo{roleId=" + this.roleId + ",addMembers=" + this.addMembers + ",removeMembers=" + this.removeMembers + ",}";
    }

    public GProRoleMemberChangeInfo(long j2, ArrayList<Long> arrayList, ArrayList<Long> arrayList2) {
        this.addMembers = new ArrayList<>();
        this.removeMembers = new ArrayList<>();
        this.roleId = j2;
        this.addMembers = arrayList;
        this.removeMembers = arrayList2;
    }
}
