package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.GProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRole;
import com.tencent.qqnt.kernel.nativeinterface.GProUser;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProGuildMemberSearchResult implements IGProGuildMemberSearchResult {

    @Override
    public ArrayList<IGProUserInfo> getMembers() {
        return null;
    }

    @Override
    public long getNextPos() {
        return 0;
    }

    @Override
    public ArrayList<IGProGuildRoleInfo> getRoles() {
        return null;
    }
}
