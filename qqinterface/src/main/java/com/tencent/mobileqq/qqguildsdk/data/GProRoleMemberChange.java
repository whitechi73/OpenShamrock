package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProRoleMemberChangeInfo;

import java.io.Serializable;
import java.util.List;


public class GProRoleMemberChange implements Serializable {
    private final GProRoleMemberChangeInfo mChangeInfo;

    public GProRoleMemberChange(GProRoleMemberChangeInfo gProRoleMemberChangeInfo) {
        this.mChangeInfo = gProRoleMemberChangeInfo;
    }

    public List<String> getAddMembers() {
        return null;
        //return com.tencent.mobileqq.qqguildsdk.util.b.V0(this.mChangeInfo.getAddMembers());
    }

    public List<String> getRemoveMembers() {
        return null;
        //return com.tencent.mobileqq.qqguildsdk.util.b.V0(this.mChangeInfo.getRemoveMembers());
    }

    public String getRoleId() {
        return null;
       // return com.tencent.mobileqq.qqguildsdk.util.b.U0(this.mChangeInfo.getRoleId());
    }
}
