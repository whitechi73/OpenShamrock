package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProGuildRole;
import com.tencent.qqnt.kernel.nativeinterface.GProUser;

import java.util.ArrayList;
import java.util.List;


public class GProRoleMemberListInfo implements IGProRoleMemberListInfo {
    public static final String TAG = "GProRoleMemberListInfo";
    private final GProGuildRoleInfo mRole;
    private final List<IGProUserInfo> mUserList = new ArrayList();

    public GProRoleMemberListInfo(GProGuildRole gProGuildRole, List<GProUser> list) {
        this.mRole = new GProGuildRoleInfo(gProGuildRole);
        for (GProUser gProUser : list) {
            this.mUserList.add(new GProUserInfo(gProUser));
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRoleMemberListInfo
    public List<IGProUserInfo> getMemberList() {
        return this.mUserList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRoleMemberListInfo
    public IGProGuildRoleInfo getRoleInfo() {
        return this.mRole;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRoleMemberListInfo
    public String toString() {
        return "GProRoleMemberListInfo{mRole=" + this.mRole + ", mUserListSize=" + this.mUserList.size() + '}';
    }
}
